package com.flyhawk.service;

import java.util.List;

import com.flyhawk.bean.Chapter;
import com.flyhawk.bean.Novel;

public interface ChapterService {
	
	public List<Chapter> getAllChaptersByNovel(Novel novel);
	public Chapter getChapterByChapterseq(int chapterseq);
}
