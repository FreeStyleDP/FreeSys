package com.free.study;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*XML的常有四种解析方法理解：
	 * 	1.DOM将内容读入到内存中，以树结构保存，树结构符合xml的特性，但是全文保存，内存容易溢�?
	 * 	2.sax事件驱动，不保存内容，读到目标位置，等待请求操作。不便于�?复读取�?�操�?
	 * 	3.JDOM结合上述两种，极大量的减少代码，用于要求�?单功能的场合，如解析创建
	 * 	4.DOM4J性能优异、功能强大�?�极端易用的优点，最常用的xml api�?
	 * 		
	 * 问题�?
	 * 	1.dom4j读取xml的原理？
	 * 		树结构保存原理，但是具体的就不清楚来
	 * 	2.dom4j将文件读取到内存中不会像dom那样影响性能吗？
	 * 	3.dom4j的读�? 用的�?  SAXReader  ，内部采用的sax读取的原理吗�?
	 */

//参�?�地�?：http://blog.csdn.net/redarmy_chen/article/details/12969219
/**
 * xml的基本读取�?�建立介�?
 * @author dengping
 *
 */
public class XMLStudy{
	
	public static void main(String[] args) throws DocumentException, IOException {
//		读xml
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("text.xml"));
		
		Element rootE = document.getRootElement();
		
//		写xml
		OutputFormat format = OutputFormat.createPrettyPrint();//创建文件输出的时候，自动缩进
//		有中文的时�?�设置编码格式，没有可以不�?�虑xmlWriter的最后一�?
		format.setEncoding("utf-8");
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("text.xml"),format);
		
		xmlWriter.write(document);
		xmlWriter.close();
	}

}
