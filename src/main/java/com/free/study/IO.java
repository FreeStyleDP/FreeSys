package com.free.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
分类：
	按方向
		输入、输出
	按功能
		节点、处理

		节点：所有流必须的基本
		处理：在节点流的基础上进行封装，便捷
	按处理内容
		字节、字符

要点：
	stream结尾：字节流
	read、write结尾：字符流
	字符流都是以缓冲流为基础，需要主动close plush

常用流
	FileInputStream 文件读取字节流
	InputStreamRead 字节转字符流
	BufferedRead 缓冲字符流

 */
public class IO {
	
	public static void main(String[] args) throws IOException {
		String filePathName = "";
		FileInputStream fs = new FileInputStream(filePathName);
		InputStreamReader in = new InputStreamReader(fs,"utf-8");
		BufferedReader bufferedReader = new BufferedReader(in);
		
		FileOutputStream os = new FileOutputStream(filePathName);
		OutputStreamWriter out = new OutputStreamWriter(os,"utf-8");
		BufferedWriter bufferedWriter = new BufferedWriter(out);
		
		bufferedReader.close();
		bufferedWriter.close();
		
	}
}
