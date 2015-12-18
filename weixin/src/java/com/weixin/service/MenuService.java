/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.Button;
import com.weixin.message.bean.ComplexButton;
import com.weixin.message.bean.Menu;
import com.weixin.message.bean.ViewButton;
import com.weixin.util.LogManager;
import java.util.logging.Logger;
/**
 * 菜单控制类
 * @author Administrator
 */
public class MenuService {
    private static final Logger logger = LogManager.getLogger(MenuService.class);
    
    public static Menu getMenu(){

        //先创建第三级菜单按钮
        ViewButton vb11 = new ViewButton();
        vb11.setName("三级11111");
        vb11.setType("view");
        vb11.setUrl("");
        
        ViewButton vb12 = new ViewButton();
        vb12.setName("三级2222");
        vb12.setType("view");
        vb12.setUrl("");
        
        ViewButton vb21 = new ViewButton();
        vb21.setName("三级2222");
        vb21.setType("view");
        vb21.setUrl("");
        
        ViewButton vb22 = new ViewButton();
        vb22.setName("三级2222");
        vb22.setType("view");
        vb22.setUrl("");
        
        ViewButton vb31 = new ViewButton();
        vb31.setName("三级2222");
        vb31.setType("view");
        vb31.setUrl("");
        
        ViewButton vb32 = new ViewButton();
        vb32.setName("三级2222");
        vb32.setType("view");
        vb32.setUrl("");
        
        //创建一级菜单
        ComplexButton cb1 = new ComplexButton();
        cb1.setName("一级一号");
        cb1.setSub_button(new Button[]{vb11,vb12});
        
        ComplexButton cb2 = new ComplexButton();
        cb2.setName("一级二号");
        cb2.setSub_button(new Button[]{vb21,vb22});
        
        ComplexButton cb3 = new ComplexButton();
        cb3.setName("一级三号");
        cb3.setSub_button(new Button[]{vb11,vb12});
        
        Menu menu = new Menu();
        menu.setMenu(new Button[]{cb1,cb2,cb3});
    
        return menu;
    }
    
    
    
}
