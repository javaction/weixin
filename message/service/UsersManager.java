package com.message.service;

import com.message.button.AccessToken;
import com.message.response.Content;
import com.message.response.UsersInfo;
import com.message.util.MessageUtil;
import com.message.util.WeixinUtil;

public class UsersManager {

	public static void main(String[] args) {
		
		// 第三方用户唯一凭证
		String appId = "wx5c5f26b8ac46aab6";
		// 第三方用户唯一凭证密钥
		String appSecret = "e930a7d8ec98ff0eb97812ce1fb5bfe1";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		
//		System.out.println(WeixinUtil.getFocusUsersList(at.getToken()));
//		System.out.println(WeixinUtil.getUserById(at.getToken(), "e930a7d8ec98ff0eb97812ce1fb5bfe1"));
		
//		UsersInfo usersInfo = new UsersInfo();
//		usersInfo.setTouser("oAP7QsqnC6vJkwRdZFHUZl9vOUKk");
//		usersInfo.setMsgtype(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
//		Content content = new Content();
//		content.setContent("测试信息");
//		usersInfo.setText(content);
//		
//		WeixinUtil.sendInfoForUser(usersInfo, at.getToken());
	}
}
