package com.flyhawk.dao;

import java.util.List;

import com.flyhawk.bean.Novel;

public interface NovelDAO {
	
	public List<Novel> queryAllNovels();
	public Novel queryNovelByNovelId(String NovelId);
	
	public boolean insertNovel(Novel novel);
	public boolean updateNovel(Novel novel);
	public boolean deleteNovel(Novel novel);
}
