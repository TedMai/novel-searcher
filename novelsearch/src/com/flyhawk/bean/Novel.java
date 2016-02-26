package com.flyhawk.bean;

import java.util.Date;

/***
 * POJO类 小说
 * @author Administrator
 *
 */
public class Novel {
	
	private int novelSeq;   /*数据库使用小说序号*/
	private String novelId; /*小说Id*/
	private String novelName; /*小说名*/
	private String novelAuthor; /*作者*/
	private String novelType; /*类别*/
	private String novelDescripion; /*小说简介*/
	private String novelUrl; /*链接Url*/
	
	private String lastestChapterSeq; /*最新章节序号*/
	
	private int wordCount; /*小说总字数*/
	private String keywords; /*小说关键词*/
	
	private Date createTime; /*小说创建时间*/
	private Date updateTime; /*小说更新时间*/
	
	public int getNovelSeq() {
		return novelSeq;
	}
	public String getNovelId() {
		return novelId;
	}
	public String getNovelName() {
		return novelName;
	}
	public String getNovelAuthor() {
		return novelAuthor;
	}
	public String getNovelType() {
		return novelType;
	}
	public String getNovelDescripion() {
		return novelDescripion;
	}
	public String getNovelUrl() {
		return novelUrl;
	}
	public String getLastestChapterSeq() {
		return lastestChapterSeq;
	}
	public int getWordCount() {
		return wordCount;
	}
	public String getKeywords() {
		return keywords;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setNovelSeq(int novelSeq) {
		this.novelSeq = novelSeq;
	}
	public void setNovelId(String novelId) {
		this.novelId = novelId;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	public void setNovelAuthor(String novelAuthor) {
		this.novelAuthor = novelAuthor;
	}
	public void setNovelType(String novelType) {
		this.novelType = novelType;
	}
	public void setNovelDescripion(String novelDescripion) {
		this.novelDescripion = novelDescripion;
	}
	public void setNovelUrl(String novelUrl) {
		this.novelUrl = novelUrl;
	}
	public void setLastestChapterSeq(String lastestChapterSeq) {
		this.lastestChapterSeq = lastestChapterSeq;
	}
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
