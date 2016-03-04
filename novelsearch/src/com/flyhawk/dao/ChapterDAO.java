package com.flyhawk.dao;

import java.util.List;

import com.flyhawk.bean.Chapter;
import com.flyhawk.bean.Novel;

public interface ChapterDAO {
	
	public List<Chapter> queryAllChaptersByNovel(Novel novel);
	public Chapter queryChapterByChapterseq(int chapterseq);
	
	public boolean insertChapter(Chapter chapter);
	public boolean updateChapter(Chapter chapter);
	public boolean deleteChapter(Chapter chapter);
}
