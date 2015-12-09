package com.message.service;

import org.apache.log4j.Logger;

import com.message.button.AccessToken;
import com.message.button.Button;
import com.message.button.CommonButton;
import com.message.button.ComplexButton;
import com.message.button.Menu;
import com.message.button.ViewButton;
import com.message.util.WeixinUtil;

public class MenuManager {

	private static Logger log = Logger.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		
		String appSecret = "e930a7d8ec98ff0eb97812ce1fb5bfe1";
		String appId = "wx5c5f26b8ac46aab6";
		// 第三方用户唯一凭证密钥
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton btn31 = new ViewButton();
		btn31.setName("官网介绍");
		btn31.setType("view");
		btn31.setUrl("http://libo890813.oicp.net/weChat/proscenium/help/proDetail.jsp");

		ViewButton btn32 = new ViewButton();
		btn32.setName("常见问题");
		btn32.setType("view");
		btn32.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

		ViewButton btn33 = new ViewButton();
		btn33.setName("留言建议");
		btn33.setType("view");
		btn33.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

//		CommonButton btn14 = new CommonButton();
//		btn14.setName("历史上的今天");
//		btn14.setType("click");
//		btn14.setKey("14");

		ViewButton btn11 = new ViewButton();
		btn11.setName("逛逛商城");
		btn11.setType("view");
		btn11.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

		ViewButton btn12 = new ViewButton();
		btn12.setName("精品团购");
		btn12.setType("view");
		btn12.setUrl("http://libo890813.oicp.net/weChat/proscenium/tuan/proTuan.jsp");

//		ViewButton btn13 = new ViewButton();
//		btn13.setName("美女电台");
//		btn13.setType("view");
//		btn13.setUrl("23");

//		CommonButton btn24 = new CommonButton();
//		btn24.setName("人脸识别");
//		btn24.setType("click");
//		btn24.setKey("24");
//
//		CommonButton btn25 = new CommonButton();
//		btn25.setName("聊天唠嗑");
//		btn25.setType("click");
//		btn25.setKey("25");

		ViewButton btn21 = new ViewButton();
		btn21.setName("个人信息");
		btn21.setType("view");
		btn21.setUrl("http://libo890813.oicp.net/weChat/proscenium/login/proLogin.jsp");

		ViewButton btn22 = new ViewButton();
		btn22.setName("订单查询");
		btn22.setType("view");
		btn22.setUrl("http://libo890813.oicp.net/weChat/proscenium/login/proLogin.jsp");

//		ViewButton btn33 = new ViewButton();
//		btn33.setName("幽默笑话");
//		btn33.setType("view");
//		btn33.setUrl("http://libo890813.oicp.net/weChat/proscenium/index.jsp");
//		
//		ViewButton btn23 = new ViewButton();
//		btn23.setName("测试页面");
//		btn23.setType("view");
//		btn23.setUrl("http://libo890813.oicp.net/weChat/proscenium/cart/product1.jsp");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("微信商城");
		mainBtn1.setSub_button(new Button[] { btn11, btn12 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("个人中心");
		mainBtn2.setSub_button(new Button[] { btn21, btn22});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("帮助中心");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33 });

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}
