package com.flyhawk.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Test;

import com.flyhawk.util.CharsetUtil;

public class TestCpDetector {
	
	@Test
	public void testCharset()throws Exception{
		BufferedInputStream  fis = new BufferedInputStream(new FileInputStream("D:\\devSoftware\\UltraISO_9_注册码.txt"));
		Assert.assertEquals(CharsetUtil.getStreamCharset(fis, "GBK"), "GB2312");
	}
}
