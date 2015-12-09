package com.message.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.message.response.Article;
import com.message.response.NewsMessage;
import com.message.response.TextMessage;
import com.message.util.MessageUtil;

public class CoreService {

	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "�����͵����ı���Ϣ��";
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "�̵���ü���ڵȵ�����~/::*ѡ��̩ɽ��Ե��ƽ���������!�����Ļ�·��˵���ѯ�̳����»����¼�������Ź��Ż���Ϣ�����๦�ܵ�������";
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
	
	public static String myReturn(HttpServletRequest request, String message) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");
			
			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);	
			
			/**
			 *���ʱ��
			 *DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			 *System.out.println(format.format(new Date(textMessage.getCreateTime())));
			 */
			/**
			 *�Բ� 
			 *System.out.println(textMessage.getCreateTime());
			 *System.out.println(textMessage.getFromUserName());
			 *System.out.println(textMessage.getToUserName());
			 *System.out.println(textMessage.getMsgType());
			 *System.out.println(textMessage.getMsgType());
			 *System.out.println(textMessage.getContent());
			 */
			
			//��֤QQ���飿
			if(MessageUtil.isQqFace(requestMap.get("Content"))){
				textMessage.setContent(requestMap.get("Content"));
			} else {
				textMessage.setContent(message);
			}
			
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			System.out.println("��Ϣ�Ľ��ܺͷ��������쳣��");
			e.printStackTrace();
		}

		return respMessage;
	}
	
	
	public static String Article(HttpServletRequest request) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";
			
			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			/**System.out.println(newsMessage.getCreateTime());//1410914209642
			 * System.out.println(newsMessage.getFromUserName());//gh_462761b7434f
			 *System.out.println(newsMessage.getToUserName());//oAP7QsqnC6vJkwRdZFHUZl9vOUKk
			*/
			newsMessage.setFuncFlag(0);
			List<Article> articleList = new ArrayList<Article>();
			//��ͼ����Ϣ
//			Article article = new Article();
//			article.setTitle("���Ա��� ");
//			article.setDescription("������Ϣ������������");
//			article.setPicUrl("http://bizhi.zhuoku.com/wall/jie/20070415/FWA/035.jpg");
//			article.setUrl("http://www.sohu.com");
//			articleList.add(article);
//			// ����ͼ����Ϣ����
//			newsMessage.setArticleCount(articleList.size());
//			// ����ͼ����Ϣ������ͼ�ļ���
//			newsMessage.setArticles(articleList);
//			respMessage = MessageUtil.newsMessageToXml(newsMessage);  
			
			//��ͼ����Ϣ
			 Article article1 = new Article();  
             article1.setTitle("���ڲ��Եı���");  
             article1.setDescription("˵��1");  
             article1.setPicurl("http://bizhi.zhuoku.com/wall/jie/20070415/FWA/035.jpg");  
             article1.setUrl("http://www.sohu.com");  

             Article article2 = new Article();  
             article2.setTitle("���ڲ��Եı���2");  
             article2.setDescription("˵��2");  
             article2.setPicurl("http://pingdesign.gotoip3.com/admin/type/upload/11393498587.png");  
             article2.setUrl("http://pingdesign.gotoip3.com/");  

             Article article3 = new Article();  
             article3.setTitle("���ڲ��Եı���3");  
             article3.setDescription("˵��3");  
             article3.setPicurl("http://pingdesign.gotoip3.com/admin/type/upload/11393499367.png");  
             article3.setUrl("http://pingdesign.gotoip3.com/");  

             articleList.add(article1);  
             articleList.add(article2);  
             articleList.add(article3);  
             newsMessage.setArticleCount(articleList.size());  
             newsMessage.setArticles(articleList);  
             // ��ͼ����Ϣ����ת����xml�ַ���
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
	
	
	public static String processMenu(HttpServletRequest request){
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "�����͵����ı���Ϣ��";
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "лл���Ĺ�ע��";
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// �¼�KEYֵ���봴���Զ���˵�ʱָ����KEYֵ��Ӧ
					String eventKey = requestMap.get("EventKey");

					if (eventKey.equals("11")) {
						respContent = "����Ԥ���˵�������";
					} else if (eventKey.equals("12")) {
						respContent = "������ѯ�˵�������";
					} else if (eventKey.equals("13")) {
						respContent = "�ܱ������˵�������";
					} else if (eventKey.equals("14")) {
						respContent = "��ʷ�ϵĽ���˵�������";
					} else if (eventKey.equals("21")) {
						respContent = "�����㲥�˵�������";
					} else if (eventKey.equals("22")) {
						respContent = "������Ϸ�˵�������";
					} else if (eventKey.equals("23")) {
						respContent = "��Ů��̨�˵�������";
					} else if (eventKey.equals("24")) {
						respContent = "����ʶ��˵�������";
					} else if (eventKey.equals("25")) {
						respContent = "������ྲ˵�������";
					} else if (eventKey.equals("31")) {
						respContent = "Q��Ȧ�˵�������";
					} else if (eventKey.equals("32")) {
						respContent = "��Ӱ���а�˵�������";
					} else if (eventKey.equals("33")) {
						respContent = "��ĬЦ���˵�������";
					}
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
