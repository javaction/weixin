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
		// �������û�Ψһƾ֤
		
		String appSecret = "e930a7d8ec98ff0eb97812ce1fb5bfe1";
		String appId = "wx5c5f26b8ac46aab6";
		// �������û�Ψһƾ֤��Կ
		// ���ýӿڻ�ȡaccess_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// ���ýӿڴ����˵�
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// �жϲ˵��������
			if (0 == result)
				log.info("�˵������ɹ���");
			else
				log.info("�˵�����ʧ�ܣ������룺" + result);
		}
	}

	/**
	 * ��װ�˵�����
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton btn31 = new ViewButton();
		btn31.setName("��������");
		btn31.setType("view");
		btn31.setUrl("http://libo890813.oicp.net/weChat/proscenium/help/proDetail.jsp");

		ViewButton btn32 = new ViewButton();
		btn32.setName("��������");
		btn32.setType("view");
		btn32.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

		ViewButton btn33 = new ViewButton();
		btn33.setName("���Խ���");
		btn33.setType("view");
		btn33.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

//		CommonButton btn14 = new CommonButton();
//		btn14.setName("��ʷ�ϵĽ���");
//		btn14.setType("click");
//		btn14.setKey("14");

		ViewButton btn11 = new ViewButton();
		btn11.setName("����̳�");
		btn11.setType("view");
		btn11.setUrl("http://libo890813.oicp.net/weChat/proscenium/shouye.jsp");

		ViewButton btn12 = new ViewButton();
		btn12.setName("��Ʒ�Ź�");
		btn12.setType("view");
		btn12.setUrl("http://libo890813.oicp.net/weChat/proscenium/tuan/proTuan.jsp");

//		ViewButton btn13 = new ViewButton();
//		btn13.setName("��Ů��̨");
//		btn13.setType("view");
//		btn13.setUrl("23");

//		CommonButton btn24 = new CommonButton();
//		btn24.setName("����ʶ��");
//		btn24.setType("click");
//		btn24.setKey("24");
//
//		CommonButton btn25 = new CommonButton();
//		btn25.setName("�������");
//		btn25.setType("click");
//		btn25.setKey("25");

		ViewButton btn21 = new ViewButton();
		btn21.setName("������Ϣ");
		btn21.setType("view");
		btn21.setUrl("http://libo890813.oicp.net/weChat/proscenium/login/proLogin.jsp");

		ViewButton btn22 = new ViewButton();
		btn22.setName("������ѯ");
		btn22.setType("view");
		btn22.setUrl("http://libo890813.oicp.net/weChat/proscenium/login/proLogin.jsp");

//		ViewButton btn33 = new ViewButton();
//		btn33.setName("��ĬЦ��");
//		btn33.setType("view");
//		btn33.setUrl("http://libo890813.oicp.net/weChat/proscenium/index.jsp");
//		
//		ViewButton btn23 = new ViewButton();
//		btn23.setName("����ҳ��");
//		btn23.setType("view");
//		btn23.setUrl("http://libo890813.oicp.net/weChat/proscenium/cart/product1.jsp");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("΢���̳�");
		mainBtn1.setSub_button(new Button[] { btn11, btn12 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("��������");
		mainBtn2.setSub_button(new Button[] { btn21, btn22});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("��������");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33 });

		/**
		 * ���ǹ��ں�xiaoqrobotĿǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br>
		 * 
		 * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br>
		 * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}
