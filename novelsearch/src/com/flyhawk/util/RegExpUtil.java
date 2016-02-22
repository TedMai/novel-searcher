package com.flyhawk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtil {
	
	/**
	 * @param srcStr 待处理的字符串
	 * @param regExpStr 正则表达式
	 * @param separator 结果分隔符(默认使用空格分割)
	 * @param matchNum 匹配的结果数
	 * @return 返回所有匹配结果，结果使用$separator分割的字符串
	 */
	public static String getAllMatchedString(String srcStr, String regExpStr, String separator , int matchNum){
		String result = "";
		if(srcStr == null || regExpStr == null || matchNum < 1 || srcStr.isEmpty() ){
			return result;
		}
		separator = ( separator == null ) ? " " : separator;
		Pattern pattern = Pattern.compile(regExpStr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(srcStr);
		StringBuffer stringBuffer = new StringBuffer();
		while(matcher.find()){
			stringBuffer.append(matcher.group(matchNum).trim());
			stringBuffer.append(separator);
		}
		result = stringBuffer.toString();
		if(result.endsWith(separator)){
			result = result.substring(0, result.length()-separator.length());
		}
		return result;
	}
	
	/**
	 * 
	 * @param srcStr
	 * @param regExpStr
	 * @param matchNum
	 * @return 返回第一个匹配的记录
	 */
	public static String getFirstMatchedString(String srcStr, String regExpStr, int matchNum ){
		String result = "";
		if(srcStr == null || regExpStr == null || matchNum < 1 || srcStr.isEmpty() ){
			return result;
		}
		Pattern pattern = Pattern.compile(regExpStr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(srcStr);
		if(matcher.find()){
			result = matcher.group(matchNum).trim(); 
		}
		return result;
	}
}
