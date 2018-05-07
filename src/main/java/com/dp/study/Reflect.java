package com.dp.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 反射学习
 * 	反射：
 * 		在运行时，动态调用类的方法，属性
 * 
 * @author dengp_w
 * @date 2018年3月30日 上午11:21:47
 */
public class Reflect {
	/*
	 * 学习地址：https://blog.csdn.net/sinat_38259539/article/details/71799078
	 * 特点：
	 * 		反射可无视private public 等限制
	 * 		反射可用于无视泛型（泛型是在编译期及以前的限制，反射在编译以后） 
	 */
	/**
	 * 类获取
	 * @throws ClassNotFoundException
	 * @author dengp_w
	 * @date 2018年3月30日 下午3:48:08
	 */
	@Test
	public void Clazz() throws ClassNotFoundException {
//		获取类型的三种方式
	//		通过对象
		PersonForTest person = new PersonForTest();
			Class<? extends PersonForTest> clazz = person.getClass();
			System.out.println(clazz.getSimpleName());
			
	//		通过类
			Class personC =  PersonForTest.class;
			System.out.println(clazz == personC);
			
	//		通过类型全名
			Class<?> personForName = Class.forName("com.dp.study.Person");
			System.out.println(personForName.getName());
	}
	
	/**
	 * 构造方法
	 * @author dengp_w
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @date 2018年3月30日 下午3:49:02
	 */
	@Test
	public void constructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/* 
		 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员； 
		 *  
		 * 1.获取构造方法： 
		 *      1).批量的方法： 
		 *          public Constructor[] getConstructors()：所有"公有的"构造方法 
		            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有) 
		      
		 *      2).获取单个的方法，并调用： 
		 *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法： 
		 *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有； 
		 *       
		 *          调用构造方法： 
		 *          Constructor-->newInstance(Object... initargs) 
		 */ 
		//1.加载Class对象  
        Class clazz = Class.forName("fanshe.Student");  
          
          
        //2.获取所有公有构造方法  
        System.out.println("**********************所有公有构造方法*********************************");  
        Constructor[] conArray = clazz.getConstructors();  
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
          
          
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");  
        conArray = clazz.getDeclaredConstructors();  
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
          
        System.out.println("*****************获取公有、无参的构造方法*******************************");  
        Constructor con = clazz.getConstructor(null);  
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型  
        //2>、返回的是描述这个无参构造函数的类对象。  
      
        System.out.println("con = " + con);  
        //调用构造方法  
        Object obj = con.newInstance();  
    //  System.out.println("obj = " + obj);  
    //  Student stu = (Student)obj;  
          
        System.out.println("******************获取私有构造方法，并调用*******************************");  
        con = clazz.getDeclaredConstructor(char.class);  
        System.out.println(con);  
        //调用构造方法  
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)  
        obj = con.newInstance('男');  
	}
	
	/**
	 * 成员变量
	 * @author dengp_w
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @date 2018年3月30日 下午3:53:43
	 */
	@Test
	public void field() throws NoSuchFieldException, SecurityException, ClassNotFoundException, InstantiationException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		/* 
		 * 获取成员变量并调用： 
		 *  
		 * 1.批量的 
		 *      1).Field[] getFields():获取所有的"公有字段" 
		 *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有； 
		 * 2.获取单个的： 
		 *      1).public Field getField(String fieldName):获取某个"公有的"字段； 
		 *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的) 
		 *  
		 *   设置字段的值： 
		 *      Field --> public void set(Object obj,Object value): 
		 *                  参数说明： 
		 *                  1.obj:要设置的字段所在的对象； 
		 *                  2.value:要为字段设置的值； 
		 *  
		 */  
		 //1.获取Class对象  
        Class stuClass = Class.forName("fanshe.field.Student");  
        //2.获取字段  
        System.out.println("************获取所有公有的字段********************");  
        Field[] fieldArray = stuClass.getFields();  
        for(Field f : fieldArray){  
            System.out.println(f);  
        }  
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");  
        fieldArray = stuClass.getDeclaredFields();  
        for(Field f : fieldArray){  
            System.out.println(f);  
        }  
        System.out.println("*************获取公有字段**并调用***********************************");  
        Field f = stuClass.getField("name");  
        System.out.println(f);  
        //获取一个对象  
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();  
        //为字段设置值  
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"  
        //验证  
        PersonForTest stu = (PersonForTest)obj;  
//        System.out.println("验证姓名：" + stu.name);  
          
          
        System.out.println("**************获取私有字段****并调用********************************");  
        f = stuClass.getDeclaredField("phoneNum");  
        System.out.println(f);  
        f.setAccessible(true);//暴力反射，解除私有限定  
        f.set(obj, "18888889999"); 
        System.out.println("验证电话：" + stu);  
          
	}
	
	/**
	 * 方法调用
	 * @author dengp_w
	 * @date 2018年3月30日 下午4:05:15
	 */
	@Test
	public void method() {
		/* 
		 * 获取成员方法并调用： 
		 *  
		 * 1.批量的： 
		 *      public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类） 
		 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的) 
		 * 2.获取单个的： 
		 *      public Method getMethod(String name,Class<?>... parameterTypes): 
		 *                  参数： 
		 *                      name : 方法名； 
		 *                      Class ... : 形参的Class类型对象 
		 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes) 
		 *  
		 *   调用方法： 
		 *      Method --> public Object invoke(Object obj,Object... args): 
		 *                  参数说明： 
		 *                  obj : 要调用方法的对象； 
		 *                  args:调用方式时所传递的实参； 
		 
		): 
		 */  
		//1.获取Class对象  
        Class stuClass;
		try {
			stuClass = Class.forName("fanshe.method.Student");
	        //2.获取所有公有方法  
	        System.out.println("***************获取所有的”公有“方法*******************");  
	        stuClass.getMethods();  
	        Method[] methodArray = stuClass.getMethods();  
	        for(Method m : methodArray){  
	            System.out.println(m);  
	        }  
	        System.out.println("***************获取所有的方法，包括私有的*******************");  
	        methodArray = stuClass.getDeclaredMethods();  
	        for(Method m : methodArray){  
	            System.out.println(m);  
	        }  
	        System.out.println("***************获取公有的show1()方法*******************");  
	        Method m = stuClass.getMethod("show1", String.class);  
	        System.out.println(m);  
	        //实例化一个Student对象  
	        Object obj = stuClass.getConstructor().newInstance();  
	        m.invoke(obj, "刘德华");  
	          
	        System.out.println("***************获取私有的show4()方法******************");  
	        m = stuClass.getDeclaredMethod("show4", int.class);  
	        System.out.println(m);  
	        m.setAccessible(true);//解除私有限定  
	        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参  
	        System.out.println("返回值：" + result);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
}


