/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class LogManager {
    
    public static Logger getLogger(Class clazz){
        
        Logger logger = Logger.getLogger(clazz.getName());
        
        return logger;
    }
    
}
