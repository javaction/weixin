/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.weixin.message.bean.ImageMessage;
import com.weixin.message.bean.Item;
import com.weixin.message.bean.MusicMessage;
import com.weixin.message.bean.Music;
import com.weixin.message.bean.NewsMessage;
import com.weixin.message.bean.TextMessage;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 消息工具类
 * @author Administrator
 * 
 * 需要根据文档中的接收和发送消息类型来实现messageUtil的所有类型，两种情况（接收、发送）的需要区分开
 */
public class MessageUtil {
    //
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    
    /**
     * 返回消息类型：图片  //test1
     */
  //  public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    
    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

      
    /**
     *  解析微信发来的请求（XML文件）
     * @param request
     * @return
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
    public static Map<String,String> parseXml(HttpServletRequest request) throws Exception{
        
        //将解析结果存储到hashMap中
        Map<String,String> map = new HashMap<String, String>();
        
        //从request中取得输入流
        InputStream inputStream = request.getInputStream();
        //读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);
        //得到xml根元素  
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        
        //遍历所有子节点
        for(Element e : elementList){
            map.put(e.getName(), e.getText());
        }
        
        //释放资源
        inputStream.close();
        inputStream = null;
        
        return map;
    }
        
    /**
     * 文本消息对象转换成xml
     * @param textMessage 文本消息对象 XStream是一个java对象和xml相互转换的工具
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage){
        xstream.alias("xml", textMessage.getClass());
        
        return xstream.toXML(textMessage);
    }
        
    /**
     *  test1
     * 图片消息转换成xml
     * @param imageMessage
     * @return 
     */
    public static String imageMessageToXml(ImageMessage imageMessage){
        xstream.alias("xml", imageMessage.getClass());
        
        return xstream.toXML(imageMessage);
    }
    
    
    //此处还有其他的将 各种类型的消息 转换成对应的xml数据的方法
    /**
     * 将 图文消息 转换成 xml
     * @param newsMessage
     * @return 
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        
        xstream.alias("xml", newsMessage.getClass());
        //注意：将对应的类在xml文件中对应正确的标签
        xstream.alias("item", new Item().getClass());
        return xstream.toXML(newsMessage);
    }
    
    /**
     * 将 音乐消息 转换成 xml
     * @param musicMessage
     * @return 
     */
    public static String musicMessageToXml(MusicMessage musicMessage){
        
        xstream.alias("xml", musicMessage.getClass());
       // xstream.alias("Music", new Music().getClass());
        return xstream.toXML(musicMessage);
    }
    
    /**
     * 获取点播歌曲的提示信息，用于回复音乐消息时候的提示
     * @return 
     */
    public static String getMusicCue(){
        StringBuilder sb = new StringBuilder();
        sb.append("歌曲点播").append("\n");
        sb.append("回复\t歌曲+歌曲名称").append("\n");
        sb.append("如：歌曲兄妹").append("\n");
        sb.append("也可以如：歌曲兄妹@陈奕迅").append("\n");
        sb.append("回复‘？’返回主菜单选项");
        //sb.append("--*--*--*--*--*--*--*");
        
        return sb.toString();
    }
    
    
    /**
     * 扩展xstream，使其支持CDATA块
     */
    private static XStream xstream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter creatWriter(Writer out){
            return new PrettyPrintWriter(out){   
                //对所有的xml节点都增加CDATA标志
                boolean cdata = true;
                
                @SuppressWarnings("unchecked")
                public void startNode(String nameString,Class clazz){
                    super.startNode(nameString, clazz);
                }
                
                protected void writeText(QuickWriter writer, String text){
                    if(cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else{
                        writer.write(text);
                    }
                    
                }
            }; //return 
            
        }
        
    });
    
    
    
    
    
    
        
        
        
   
        
        
}
