/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.ImageMessage;
import com.weixin.message.bean.TextMessage;
import com.weixin.message.util.MessageUtil;
import com.weixin.util.LogManager;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class CrazyService {
    private static final Logger logger = LogManager.getLogger(CrazyService.class);
    public static String processRequest(HttpServletRequest request){
        
        String respMessage = null;
        try {
            //默认返回的文本消息内容
            String respContent = "请求处理异常，请稍后重试";
            
            //xml请求解析
            Map<String,String> requestMap = MessageUtil.parseXml(request);
            
            //发送方账号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            
            //开发者微信号（公众账号）
            String toUserName = requestMap.get("ToUserName");
            
            //消息类型
            String msgType = requestMap.get("MsgType");
            
            String content = requestMap.get("Content");
            
            //回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(toUserName);
            textMessage.setFromUserName(fromUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setMsgId(0);
            
            //回复图片消息
//            ImageMessage imageMessage = new ImageMessage();
//            imageMessage.setToUserName(toUserName);
//            imageMessage.setFromUserName(fromUserName);
//            imageMessage.setCreateTime(new Date().getTime());
//            imageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
//            imageMessage.setMsgId(0);
            
            
            
            //文本消息
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
//                respContent = "你发送的是文本消息。";
                respContent = content;
            }
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
                respContent = "你发送的是图片消息。";
                
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
                respContent = "你发送的是地理位置消息。";
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
                respContent = "你发送的是链接消息。";
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
                respContent = "你发送的是音频消息。";
            }
            
            //事件推送
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
                //事件类型
                String eventType = requestMap.get("Event");
                //订阅
                if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                    respContent = "感谢您的关注。";
                }
                //取消订阅
                else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
                    //取消订阅号，用户收不到公众号发送的消息，因此不需要回复消息
                }
                //自定义菜单点击事件
                else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
                    //自定义菜单权没有开放，暂不处理该类消息
                }
            }
            
            textMessage.setContent(respContent);
//            textMessage
            respMessage = MessageUtil.textMessageToXml(textMessage);
            logger.info("---------respContent:"+respContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("---------respMessage如下：");
        logger.info(respMessage);
        return respMessage;
    }
    
    
    
}
