package com.free.util;


public class FileUtil {

	/**
	 * 通过绝对路径获取文件路径，文件名
	 * @param fileNamePath
	 * @return
	 * 		fileAtt[0]:文件路径
	 * 		fileAtt[0]:文件名
	 */
	public static String[] getFileNameAndPath(String filePathName) {
		String[] fileAtt = new String[2] ;
		fileAtt[0] = filePathName.substring(0,filePathName.lastIndexOf("/"));
		fileAtt[1] = filePathName.substring(filePathName.lastIndexOf("/")+1);
		return fileAtt ;
	}
}
