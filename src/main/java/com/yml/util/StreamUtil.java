package com.yml.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {
	/*
	* 方法1：批量关闭流，参数能传入无限个
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(AutoCloseable... streams){
		for (int i = 0; i < streams.length; i++) {
			try {
				streams[i].close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第1个方法关闭流
	*/
	public static String readTextFile(InputStream src) throws IOException{
		StringBuffer buffer = new StringBuffer();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(src));
		String str = "";
		
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str + "\r\n");
		}
		
		closeAll(bufferedReader,src);
		
		return buffer.toString();
	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容，并且要求内部调用上面第2个方法。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws IOException{
		FileInputStream inputStream = new FileInputStream(txtFile);
		
		return readTextFile(inputStream);
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/test/resources/read.txt");
		
		System.out.println(readTextFile(file));
	}
}
