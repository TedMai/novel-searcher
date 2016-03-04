package com.flyhawk.service;

import java.util.List;

import com.flyhawk.bean.Novel;

public interface NovelService {
	
	public List<Novel> getAllNovels();
	public Novel getNovelByNovelId(String NovelId);
	public void updateNovel(Novel novel);
}
