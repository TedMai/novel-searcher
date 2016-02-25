package com.flyhawk.bean;

import java.util.Date;

/***
 * POJO类 小说
 * @author Administrator
 *
 */
public class Novel {
	
	private int novelId; 
	private String novelName; /*小说名*/
	private String novelAuthor; /*作者*/
	private String novelType; /*类别*/
	private String novelDescripion; /*小说简介*/
	private String novelUrl; /*链接Url*/
	
	private String lastestChapterId; /*最新章节Id*/
	private String lastestChapterUrl; /*最新章节链接*/
	
	private int wordCount; /*小说总字数*/
	private String keywords; /*小说关键词*/
	
	private Date createTime; /*小说创建时间*/
	private Date updateTime; /*小说更新时间*/
}
