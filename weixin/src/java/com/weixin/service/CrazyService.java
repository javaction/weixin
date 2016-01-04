/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.Item;
import com.weixin.message.bean.MusicMessage;
import com.weixin.message.bean.Music;
import com.weixin.message.bean.NewsMessage;
import com.weixin.message.bean.TextMessage;
import com.weixin.message.util.MessageUtil;
import com.weixin.util.LogManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            
            //发送方账号（open_id）ToUserName
            String fromUserName = requestMap.get("FromUserName");
            
            //开发者微信号（公众账号）FromUserName
            String toUserName = requestMap.get("ToUserName");
            
            //消息类型
            String msgType = requestMap.get("MsgType");
            //获取的消息内容
            String content = requestMap.get("Content");
            
            //回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
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
                respContent = "[勿忘初心\n方得始终\n外圆内方\n知行合一]\n首哥，你真是猪头,^(*￣(oo)￣)^...";
                
                //默认回复文本消息
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
                
                //如果用户是按照特定的字符输入，返回对应的图文消息
                NewsMessage newsMessage = new NewsMessage();
                newsMessage.setToUserName(fromUserName);
                newsMessage.setFromUserName(toUserName);
                newsMessage.setCreateTime(new Date().getTime());
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                
                List<Item> Articles = new ArrayList<Item>(); //用于存放图文消息中的item
                if("1".equals(content)){
                    Item item = new Item();
                    item.setTitle("单图文消息");
                    item.setDescription("根植于内心的修养..");
                    item.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw1.jpg"); //此处的图片可以直接加在项目中...是否还有方式，待后面详细了解学习.
                    item.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    //将 item 对象放到 Articles中。
                    Articles.add(item); 
                    newsMessage.setArticleCount(Articles.size());
                    newsMessage.setArticles(Articles);
                    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                
                }
                else if("2".equals(content)){     
                    Item item = new Item();
                    item.setTitle("单图文消息（没有图片）");
                    item.setDescription("别看了，把图片都吓跑了..");
                    item.setPicUrl("");
                    item.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Articles.add(item);
                    newsMessage.setArticleCount(Articles.size());
                    newsMessage.setArticles(Articles);
                    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                }
                else if("3".equals(content)){
                    //多图文消息
                    Item item1 = new Item();
                    item1.setTitle("The First Picture");
                    item1.setDescription("多图文消息的介绍(1)..");
                    item1.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw1.jpg");
                    item1.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    //默认的第一个item会大图标展示.其余的小图标展示。
                    Item item2 = new Item();
                    item2.setTitle("The Second Picture");
                    item2.setDescription("多图文消息的介绍(2)..");
                    item2.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw2.jpg");
                    item2.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item3 = new Item();
                    item3.setTitle("The Third Picture");
                    item3.setDescription("多图文消息的介绍(3)..");
                    item3.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw3.jpg");
                    item3.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item4 = new Item();
                    item4.setTitle("The Fourth Picture");
                    item4.setDescription("多图文消息的介绍(4)..");
                    item4.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw4.jpg");
                    item4.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Articles.add(item1);
                    Articles.add(item2);
                    Articles.add(item3);
                    Articles.add(item4);
                    
                    newsMessage.setArticleCount(Articles.size());
                    newsMessage.setArticles(Articles);
                    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                }
                else if("4".equals(content)){
                    //多图文消息 （首条消息不含图片）
                    Item item1 = new Item();
                    item1.setTitle("The First Picture");
                    item1.setDescription("多图文消息的介绍(1)..");
                    item1.setPicUrl("");
                    item1.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    //默认的第一个item会大图标展示.其余的小图标展示。
                    Item item2 = new Item();
                    item2.setTitle("The Second Picture");
                    item2.setDescription("多图文消息的介绍(2)..");
                    item2.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw2.jpg");
                    item2.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item3 = new Item();
                    item3.setTitle("The Third Picture");
                    item3.setDescription("多图文消息的介绍(3)..");
                    item3.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw3.jpg");
                    item3.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item4 = new Item();
                    item4.setTitle("The Fourth Picture");
                    item4.setDescription("多图文消息的介绍(4)..");
                    item4.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw4.jpg");
                    item4.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Articles.add(item1);
                    Articles.add(item2);
                    Articles.add(item3);
                    Articles.add(item4);
                    
                    newsMessage.setArticleCount(Articles.size());
                    newsMessage.setArticles(Articles);
                    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    
                }
                else if("5".equals(content)){
                    //多图文消息（最后一条消息不含图片）
                    Item item1 = new Item();
                    item1.setTitle("The First Picture");
                    item1.setDescription("多图文消息的介绍(1)..");
                    item1.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw1.jpg");
                    item1.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    //默认的第一个item会大图标展示.其余的小图标展示。
                    Item item2 = new Item();
                    item2.setTitle("The Second Picture");
                    item2.setDescription("多图文消息的介绍(2)..");
                    item2.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw2.jpg");
                    item2.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item3 = new Item();
                    item3.setTitle("The Third Picture");
                    item3.setDescription("多图文消息的介绍(3)..");
                    item3.setPicUrl("http://javactive.tunnel.qydev.com/weixin/image/dw3.jpg");
                    item3.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Item item4 = new Item();
                    item4.setTitle("The Fourth Picture");
                    item4.setDescription("多图文消息的介绍(4)..");
                    item4.setPicUrl("");
                    item4.setUrl("http://javactive.tunnel.qydev.com/weixin/index.jsp");
                    
                    Articles.add(item1);
                    Articles.add(item2);
                    Articles.add(item3);
                    Articles.add(item4);
                    
                    newsMessage.setArticleCount(Articles.size());
                    newsMessage.setArticles(Articles);
                    
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
                
                }
                else if("6".equals(content)){
                    /*
                     * 回复 6（音乐），给用户回复音乐文件
                     * 当用户回复6时候，给予提示信息（文本消息），用于指导用户如何进行歌曲点播
                     *  getMusicCue //获取点播歌曲的提示信息，用于回复音乐消息时候的提示
                     *  
                     */
                     respContent = MessageUtil.getMusicCue();
                     
                     //回复歌曲点播提示菜单
                     textMessage.setContent(respContent);
                     respMessage = MessageUtil.textMessageToXml(textMessage);
                     
//                    MusicMessage musicMessage = new MusicMessage();
//                    musicMessage.setToUserName(fromUserName);
//                    musicMessage.setFromUserName(toUserName);
//                    musicMessage.setCreateTime(new Date().getTime());
//                    musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
                    
                    //关于回复音乐消息-
                    /*
                     * 关于回复音乐消息，具体参见博文中介绍--需后续完成
                     */
//                    Music music = new Music();  
//                    music.setTitle("音乐标题");
//                    music.setDescription("音乐描述...");
//                    music.setMusicURL("http://javactive.tunnel.qydev.com/weixin/music/mus1.mp3");
//                    music.setHQMusicUrl("http://javactive.tunnel.qydev.com/weixin/music/mus1.mp3");
//                    //music.setThumbMediaId("http://javactive.tunnel.qydev.com/weixin/image/dw3.jpg");
//                    
//                    musicMessage.setMusic(music);
//                    respMessage = MessageUtil.musicMessageToXml(musicMessage);
                    
//                    String str = "<xml>"
//                            + "<ToUserName>ow4JdwUaJi3v4YLvqSqtv88dJB68</ToUserName>"
//                            + "<FromUserName>gh_0015044582a8</FromUserName>"
//                            + "<CreateTime>1451009751936</CreateTime>"
//                            + "<MsgType>music</MsgType>"
//                            + "<Music>"
//                            + "<Title>音乐标题</Title>"
//                            + "<Description>音乐描述</Description>"
//                            + "<MusicUrl>http://javactive.tunnel.qydev.com/weixin/music/mus1.mp3</MusicUrl>"
//                            + "<HQMusicUrl>http://javactive.tunnel.qydev.com/weixin/music/mus1.mp3</HQMusicUrl>"
//                            + "<ThumbMediaId>http://javactive.tunnel.qydev.com/weixin/image/dw3.jpg</ThumbMediaId>"
//                            + "</Music>"
//                            + "</xml>";
//                    respMessage = str;
                    
                }
                else if(content.startsWith("歌曲")){
                    //收到用户的消息以‘歌曲’开头，定义为需要点播歌曲
                    // 将‘歌曲’2个字及歌曲后面的+、空格、-等特殊符号去掉  
                    String keyWord = content.replaceAll("^歌曲[\\+ ~!@#%^-_=]?", "");
                    logger.info("--用户回复的信息---："+keyWord);
                    if("".equals(keyWord)){
                        respContent = MessageUtil.getMusicCue();
                    }
                    else{  
                        String songName = null;
                        String songAuthor = null;
                        //消息范例（带@）： 歌曲兄妹@陈奕迅
                        String[] song;
                        if(keyWord.contains("＠")){
                            logger.info("---中文@----");
                            song = keyWord.split("＠");
                        }else {
                            song = keyWord.split("@");
                        
                        }
                        logger.info("---song.length："+song.length);
                        if(song.length == 2){
                            songName = song[0];
                            songAuthor = song[1];
                        }
                        else if(song.length == 1){
                            songName = song[0];
                            songAuthor = "";
                        }
                        logger.info("---歌手是："+songAuthor);
                        Music music = BaiduMusicService.searchMucic(songName, songAuthor);
                        if(music == null){
                            respContent = "没找到您要搜索的歌曲..";
                        }
                        else{
                            MusicMessage musicMessage = new MusicMessage();
                            musicMessage.setToUserName(fromUserName);
                            musicMessage.setFromUserName(toUserName);
                            musicMessage.setCreateTime(new Date().getTime());
                            musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
                            musicMessage.setMusic(music);
                            
                            respMessage = MessageUtil.musicMessageToXml(musicMessage);
                            
                        }
                    }
                }
                
            }
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
                //respContent = "你发送的是图片消息,还需要再处理,才能和你对话..";
                respContent = "<a href = \"http://tieba.baidu.com/\" >随便一个链接吧，以后再补..</a>";
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
                respContent = "你发送的是地理位置消息。";
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
                respContent = "你发送的是链接消息。";
            }
            
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
                respContent = "你发声音我也听不见，哈哈哈..";
            }
            
            //事件推送
            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
                //事件类型
                String eventType = requestMap.get("Event");
                //订阅
                if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                    respContent = "欢迎关注！ /:,@-D \n 我会陆续添加一些新的东西，欢迎体验，么么哒../::$"
                            + "\n\n可以选择输入下面的数字，查看更多内容："
                            + "\n\t1.单图文消息\n\t2.单图文消息（没有图片）\n\t3.多图文消息\n\t4.多图文消息（首条消息无图）\n\t5.多图文消息（末消息无图片）"
                            + "\n\t6.点播歌曲/:sun";
                    
                    textMessage.setContent(respContent);
                    respMessage = MessageUtil.textMessageToXml(textMessage);
                }
                //取消订阅
                else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
                    //取消订阅号，用户收不到公众号发送的消息，因此不需要回复消息
                    respContent = "";
                }
                //自定义菜单点击事件
                else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
                    //自定义菜单权没有开放，暂不处理该类消息
                    respContent = "";
                }
            }
            
//            textMessage.setContent(respContent);
//            respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("---------respMessage如下：");
        logger.info(respMessage);
        return respMessage;
    }
    
    
    
}
