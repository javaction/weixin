package com.message.response;

public class UsersInfo {
	
	private String touser;//����Ŀ����
	private String msgtype;//���͵���Ϣ����

	private Articles news;//��Ϣ
	

	public Articles getNews() {
		return news;
	}
	public void setNews(Articles news) {
		this.news = news;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	
}
