package com.flyhawk.bean;

import java.util.Date;

/***
 * POJO类 章节
 * @author Administrator
 *
 */
public class Chapter {
	
	private int chapterSeq; /*数据库使用chapterSeq*/
	private int novelSeq; /*小说序号*/
	private String chapterId; /*章节Id*/
	private String chapterTitle; /*章节标题*/
	private String wordCount; /*章节字数*/
	private String chapterUrl; /*章节URL*/
	private Date createTime; /*章节创建时间*/
	private Date updateTime; /*章节更新时间*/
	private byte[] chapterContent; /*章节内容*/
	
	
	public int getChapterSeq() {
		return chapterSeq;
	}
	public int getNovelSeq() {
		return novelSeq;
	}
	public String getChapterId() {
		return chapterId;
	}
	public String getChapterTitle() {
		return chapterTitle;
	}
	public String getWordCount() {
		return wordCount;
	}
	public String getChapterUrl() {
		return chapterUrl;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public byte[] getChapterContent() {
		return chapterContent;
	}
	public void setChapterSeq(int chapterSeq) {
		this.chapterSeq = chapterSeq;
	}
	public void setNovelSeq(int novelSeq) {
		this.novelSeq = novelSeq;
	}
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	public void setChapterUrl(String chapterUrl) {
		this.chapterUrl = chapterUrl;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setChapterContent(byte[] chapterContent) {
		this.chapterContent = chapterContent;
	}
}
