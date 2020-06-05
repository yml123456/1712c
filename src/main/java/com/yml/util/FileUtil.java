package com.yml.util;

public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”
	*/
	public static String getExtendName(String fileName){
		
		return fileName.substring(fileName.indexOf('.'));
	}
	
	public static void main(String[] args) {
		System.out.println(getExtendName("aaa.text"));
	}
}
