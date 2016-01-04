/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.Music;
import com.weixin.util.LogManager;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *  百度音乐搜索API操作类
 * @author Administrator
 */
public class BaiduMusicService {
    private static final Logger logger = LogManager.getLogger(BaiduMusicService.class);
    /**
     * 根据名称和作者搜索音乐
     * @param musicTitle
     * @param musicAuthor
     * @return 
     */
    public static Music searchMucic(String musicTitle ,String musicAuthor){
        //百度音乐搜索地址
        String requestUrl = "http://box.zhangmen.baidu.com/x?op=12&count=1&title={TITLE}$${AUTHOR}$$$$";
        //对音乐名称、作者进行url编码
        requestUrl = requestUrl.replace("{TITLE}", urlEncodeUTF8(musicTitle));
        requestUrl = requestUrl.replace("{AUTHOR}", urlEncodeUTF8(musicAuthor));
        //处理名称、作者中间的空格
        requestUrl = requestUrl.replaceAll("\\+", "%20");
        
        //查询并获取返回结果
        InputStream inputStream = httpRequest(requestUrl); 
        //从返回结果中解析出MUSIC
        Music music = ParseMusic(inputStream);
        
        //如果music 不为null，设置标题和描述
        if(null!=music){
            music.setTitle(musicTitle);
            //如果作者不为空,将描述设置为作者
            if(!"".equals(musicAuthor)){
                music.setDescription(musicAuthor);
                
            }else{
                music.setDescription("歌手：正则");
                
            }   
            
        }
        
        return music;
    }
    
    /**
     * utf-8编码
     * @return 
     */
    public static String urlEncodeUTF8(String source){
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "UTF-8");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * 发送http请求取得返回输入流
     * @param requestUrl
     * @return 
     */
    public  static InputStream httpRequest(String requestUrl){
        InputStream inputStream = null;
        
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            
            //获取返回的输入流
            inputStream = httpURLConnection.getInputStream();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return inputStream;
    }
    
    
    /**
     * 解析音乐参数
     * @param inputStream 百度音乐搜索api中返回的输入流
     * @return 
     */
    @SuppressWarnings("unchecked")
    public static Music ParseMusic(InputStream inputStream){
        Music music = null;
        try {
            //使用dom4j解析xml
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            //得到xml根元素
            Element root = document.getRootElement();
            // count 表示搜索到的歌曲数
            String count = root.element("count").getText();            
            //当搜索到的歌曲数大于 0 时候
            if(!"0".equals(count)){
                //普通品质
                List<Element> urlList = root.elements("url");
                //高品质
                List<Element> durlList = root.elements("durl");
                
                //普通品质的encode 、decode
                String urlEncode = urlList.get(0).element("encode").getText();
                String urlDecode = urlList.get(0).element("decode").getText();
                //普通品质音乐的url
                String url = urlEncode.substring(0, urlEncode.lastIndexOf("/") + 1) + urlDecode;
                if (-1 != urlDecode.lastIndexOf("&"))
                        url = urlEncode.substring(0, urlEncode.lastIndexOf("/") + 1) + urlDecode.substring(0, urlDecode.lastIndexOf("&"));

                // 默认情况下，高音质音乐的URL 等于 普通品质音乐的URL
                String durl = url;

                // 判断高品质节点是否存在
                Element durlElement = durlList.get(0).element("encode");
                if (null != durlElement) {
                    // 高品质的encode、decode
                    String durlEncode = durlList.get(0).element("encode").getText();
                    String durlDecode = durlList.get(0).element("decode").getText();
                    // 高品质音乐的URL
                    durl = durlEncode.substring(0, durlEncode.lastIndexOf("/") + 1) + durlDecode;
                    if (-1 != durlDecode.lastIndexOf("&"))
                        durl = durlEncode.substring(0, durlEncode.lastIndexOf("/") + 1) + durlDecode.substring(0, durlDecode.lastIndexOf("&"));
                }
                
                music = new Music();
                
                //设置普通品质音乐链接
                music.setMusicUrl(url);
                //设置高品质音乐链接
                music.setHQMusicUrl(durl);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return music;
    }
    
    
    //test method
    public static void main(String agrsString[]){
        
        Music music = searchMucic("兄妹", "陈奕迅");
        System.out.println("音乐名称："+music.getTitle());
        System.out.println("音乐描述："+music.getDescription());
        System.out.println("普通链接："+music.getMusicUrl());
        System.out.println("高品链接："+music.getHQMusicUrl());
       
        System.out.println("---歌曲名称转换为utf-8----:"+urlEncodeUTF8("兄妹"));
        System.out.println("-----歌手-----"+urlEncodeUTF8("陈奕迅"));
    }
    
  //  曲名称转换为utf-8----:   %E5%85%84%E5%A6%B9
   //---歌手-----   %E9%99%88%E5%A5%95%E8%BF%85

}
