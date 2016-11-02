package com.mayao.singleton;

import java.lang.reflect.Constructor;

/**
 * 
 * @Description: TODO( 饿汉式单列 )
 * @author: mayao
 * @date 2016年10月11日 下午5:42:26
 */
public class Singleton {

	//共有域
	private static final Singleton singleton = new Singleton();
	
	//私有化构造器
	private Singleton(){
		System.out.println("没有第二个实例！！");
	}
	
	//提供对外获取对象方法
	public static Singleton getInstances(){
		return singleton;
	}
	
	/**
	 * 
	 * TODO( 保证反序列化时，对象唯一 )、、不是很懂,必须提供该方法，以便重新指定反序列化得到的对象.还得实现java.io.Serializable接口
	 * @return
	 * @author mayao
	 */
	private Object readResolve(){
		return singleton;
	}
	
	//测试
	public void otherMethod(){
		//其他方法
	}
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//*******

	public static void main(String[] args) throws Exception {
		
		Singleton sing = Singleton.getInstances();
		System.out.println("对象地址："+sing);
		sing.otherMethod();
		
		//测试，是否可以反射生成枚举
        // 利用反射调用私有构造器
        Constructor[] arrayConstructor = sing.getClass().getDeclaredConstructors();
        
        for (Constructor constructor : arrayConstructor)
        {
            // 调用setAccessible(true);
            constructor.setAccessible(true);
            
            // 实例化
            Singleton sing2 = (Singleton)constructor.newInstance();
            System.out.println("对象地址："+sing2);
            /**
             * 没有第二个实例！！
				对象地址：com.mayao.singleton.Singleton@2dfc6dc6
				没有第二个实例！！
				对象地址：com.mayao.singleton.Singleton@178af9c0
				
				说明私有构造器强化单列模式。反射可以调用私有构造器
				
             */
        }
		
	}
	
	
}
