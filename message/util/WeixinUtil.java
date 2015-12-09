package com.message.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.message.button.AccessToken;
import com.message.button.Menu;
import com.message.response.UsersInfo;

public class WeixinUtil {

	private static Logger log = Logger.getLogger(WeixinUtil.class);
	
	// ��ȡaccess_token�Ľӿڵ�ַ��GET�� ��200����/�죩
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// �˵�������POST�� ��100����/�죩
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//��ע�û��б�
	public static String user_list_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	//��ȡ�û���Ϣ
	public static String user_info_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//���û�������Ϣ
	public static String response_user_info = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	/**
	 * ����https���󲢻�ȡ���
	 * 
	 * @param requestUrl
	 *            �����ַ
	 * @param requestMethod
	 *            ����ʽ��GET��POST��
	 * @param outputStr
	 *            �ύ������
	 * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// ������SSLContext�����еõ�SSLSocketFactory����
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// ��������ʽ��GET/POST��
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// ����������Ҫ�ύʱ
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// ע������ʽ����ֹ��������
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// �����ص�������ת�����ַ���
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// �ͷ���Դ
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			 log.error("Weixin server connection timed out.");
			ce.printStackTrace();
		} catch (Exception e) {
			 log.error("https request error:{}", e);
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod) {
		
		return httpRequest(requestUrl, requestMethod, null);
	}

	/**
	 * ��ȡaccess_token
	 * 
	 * @param appid ƾ֤
	 * @param appsecret ��Կ
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// �������ɹ�
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				accessToken = null;
				// ��ȡtokenʧ��
				log.error("��ȡtokenʧ�� errcode:{} errmsg:{}");
			}
		}
		
		
		return accessToken;
	}

	/**
	 * �����˵�
	 * 
	 * @param menu �˵�ʵ��
	 * @param accessToken ��Ч��access_token
	 * @return 0��ʾ�ɹ�������ֵ��ʾʧ��
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// ƴװ�����˵���url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// ���˵�����ת����json�ַ���
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// ���ýӿڴ����˵�
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("�����˵�ʧ�� errcode :"+jsonObject.getInt("errcode")+"MSG : "+jsonObject.getString("errmsg"));
			}
		}

		return result;
	}
	
	
	/**
	 * ��ĳһ���û�������Ϣ
	 *
	 */
	public static int sendInfoForUser(UsersInfo info, String accessToken) {
		int result = 0;

		// ƴװ�����˵���url
		String url = response_user_info.replace("ACCESS_TOKEN", accessToken);
		System.out.println(url);
		// ���˵�����ת����json�ַ���
		String jsonUsers = JSONObject.fromObject(info).toString();
		
		// ���ýӿڴ����˵�
		JSONObject jsonObject = httpRequest(url, "POST", jsonUsers);
		
		System.out.println(jsonObject);

//		if (null != jsonObject) {
//			if (0 != jsonObject.getInt("errcode")) {
//				result = jsonObject.getInt("errcode");
//				log.error("��Ϣ����ʧ��");
//			}
//		}

		return result;
	}
	
	/*****
	 * ��ȡ��ע�û��б�
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	
	public static JSONObject getFocusUsersList(String accessToken) {
		int result = 0;

		// ƴװ�����˵���url
		String url = user_list_url.replace("ACCESS_TOKEN", accessToken);
		
		// ���ýӿڴ����˵�
		JSONObject jsonObject = httpRequest(url, "GET");

//		if (null != jsonObject) {
//			if (0 != jsonObject.getInt("errcode")) {
//				result = jsonObject.getInt("errcode");
//				log.error("��Ա�б��ȡʧ��");
//			}
//		}

		return jsonObject;
	}
	
	
	/*****
	 * �����û���openid��ȡ�û���Ϣ
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	
	public static JSONObject getUserById(String accessToken, String openId) {
		int result = 0;

		// ƴװ�����˵���url
		String url = user_info_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		
		System.out.println(url);
		
		// ���ýӿڴ����˵�
		JSONObject jsonObject = httpRequest(url, "GET");
		
		System.out.println(jsonObject);

//		if (null != jsonObject) {
//			if (0 != jsonObject.getInt("errcode")) {
//				result = jsonObject.getInt("errcode");
//				log.error("��Ա�б��ȡʧ��");
//			}
//		}

		return jsonObject;
	}
	
}
