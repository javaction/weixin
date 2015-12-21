/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.weixin.message.bean.AccessToken;
import com.weixin.service.MenuService;

/**
 * 用于直接测试方法能否正常的获取数据
 * @author Administrator
 */
public class TestUtil {
    
        private  static final String appid = "wxd68a456655aa5fd9";
        private  static final String secret = "d4624c36b6795d1d99dcf0547af5443d";
    
    public static void main(String agrs[]){
        
        /*
         * 1.测试获取access_token
         */
        
        AccessToken accessToken = WeixinUtil.getAccessToken2(appid, secret);//获取access_token
        System.out.println("---TestUtil--"+accessToken.getAccess_token());
        
        int i = WeixinUtil.createMenu(MenuService.getMenu(), accessToken.getAccess_token()); //生成自定义菜单
    
    }
    
    
}
