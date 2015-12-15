/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.weixin.util.LogManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Administrator
 */
public class HttpUtil {
    private static final Logger logger = LogManager.getLogger(HttpUtil.class);
    
    /**
     * 
     * @param url
     * @return 
     */
    public static String getUrl(String url){
        String result = "";
        try {
            //根据地址获取请求
            HttpGet request = new HttpGet(url);
            //获取当前客户端对象
            HttpClient httpClient = new DefaultHttpClient();
            //通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(request);
            
            //判断网络连接状态是否正常（0--200都是正常的）
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //需要看下http协议----------暂记
                result = EntityUtils.toString(response.getEntity());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    
    /**
     * //发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（get、post）
     * @param outputStr 提交的数据
     * @return 
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr){
        
        StringBuffer buffer = new StringBuffer();    
        try {
            //创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            //从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            
            URL url = new URL(requestUrl);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.setSSLSocketFactory(ssf);
              
            ///备注：需要详细看下 HttpsURLConnection 相关的方法
            httpsURLConnection.setDoOutput(true); // 以后就可以使用conn.getOutputStream().write()  
            httpsURLConnection.setDoInput(true); // 以后就可以使用conn.getInputStream().read(); 
            httpsURLConnection.setUseCaches(false); // post请求不能使用缓存
                    
            //设置请求方式
            httpsURLConnection.setRequestMethod(requestMethod);
            
            if("get".equalsIgnoreCase(requestMethod))
                httpsURLConnection.connect();
            
            //当有数据需要提交时
            if(null != outputStr){
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                //注意编码方式，防止中文乱码
                outputStream.write(outputStr.getBytes("utf-8"));
                outputStream.close();
                
            }
            
            //将返回的输入流转换成字符串
            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String str = null;
            while((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            
            //释放资源
            inputStream.close();
            inputStream = null;
            
            httpsURLConnection.disconnect();
            
            return buffer.toString();
            
        }catch (ConnectException ce){
            ce.printStackTrace();
            logger.severe("Weixin server connection timed out.");
        } 
        catch (Exception e) {
            e.printStackTrace();
            logger.severe("https request error:{}"+e.getMessage());
        } 
        
        return null;
    }
    
    
    
}
