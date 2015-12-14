/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

import java.util.List;

/**
 * 图文消息类
 * @author Administrator
 */
public class NewsMessage extends BaseMessage{
    
    private int ArticleCount; // 图文消息个数，限制为10条以内
    
    private List<Item> Articles; //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应 

    /**
     * @return the ArticleCount
     */
    public int getArticleCount() {
        return ArticleCount;
    }

    /**
     * @param ArticleCount the ArticleCount to set
     */
    public void setArticleCount(int ArticleCount) {
        this.ArticleCount = ArticleCount;
    }

    /**
     * @return the Articles
     */
    public List<Item> getArticles() {
        return Articles;
    }

    /**
     * @param Articles the Articles to set
     */
    public void setArticles(List<Item> Articles) {
        this.Articles = Articles;
    }
    
    
    
    
    
}
