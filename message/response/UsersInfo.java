package com.message.response;

public class UsersInfo {
	
	private String touser;//发送目的人
	private String msgtype;//发送的信息类型

	private Articles news;//信息
	

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
