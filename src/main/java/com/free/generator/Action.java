package com.free.generator;

import org.mybatis.generator.api.ShellRunner;

public class Action {

	/**
	 * @param type 数据库类型   
	 * 			oracle
	 * 			mysql
	 * @author dengp_m   
	 * @date 2018年5月5日 下午8:16:57 
	 */
	public static void generator(String type) {
		String[] oracle = new String[] { "-configfile", "src/main/java/com/dp/mybatisGenerator/generatorConfigOracle.xml","-overwrite" };
		String[] mysql =  new String[] { "-configfile", "src/main/resources/generator/generatorConfigMysql.xml","-overwrite" };
		if("mysql".equals(type)) {
			ShellRunner.main(mysql);
		}else {
			ShellRunner.main(oracle);
		}
		System.out.println("finish!");
	}
	
	public static void main(String[] args) {
		
		generator("mysql");
	}
}
