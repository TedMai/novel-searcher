package com.flyhawk.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flyhawk.bean.Novel;

public class TestMybatis {
	
	@Test
	public void getSqlSession() throws IOException{
		
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Novel blog = sqlSession.selectOne(
					"com.flyhawk.novelMapper.selectNovel", 13);
			System.out.println(blog.getNovelName());
		} finally {
			sqlSession.close();
		}
	}
}
