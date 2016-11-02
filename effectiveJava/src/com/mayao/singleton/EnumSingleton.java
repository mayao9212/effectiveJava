package com.mayao.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/**
 * 枚举实现单例
*<p>目前最好的方式，避免了反射的攻击和序列化的问题
*
*<pre>
*反射调用枚举私有构造函数测试结果:
*    Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
    at java.lang.reflect.Constructor.newInstance(Unknown Source)
    at com.book.chap2.singleton.Singleton3.main(Singleton3.java:34)
 * 
 * 
 * @Description: TODO( 枚举强化singleton )
 * @author: mayao
 * @date 2016年10月11日 下午5:38:09
 */
public enum EnumSingleton {
	
	INSTANCE;//空参私有构造器
	
	private int priVal;
	private EnumSingleton( int priVal ){
		this.priVal = priVal;
	}
	private EnumSingleton(){
	}

	
	public static void main (String[] args) throws Exception {
		
		EnumSingleton es = EnumSingleton.INSTANCE;
		Field field = es.getClass().getDeclaredField("priVal");//通过属性名获取属性
		field.setAccessible(true);
		field.set(es, 200);
		System.out.println(field.get(es));
		
		
		//测试，是否可以反射生成枚举
        // 利用反射调用私有构造器
        Constructor[] arrayConstructor = EnumSingleton.INSTANCE.getClass().getDeclaredConstructors();
        for (Constructor constructor : arrayConstructor)
        {
            // 调用setAccessible(true);
            constructor.setAccessible(true);

            // 实例化,这里一定会抛出异常
            constructor.newInstance();
            
            /**
             * Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
			 *	at java.lang.reflect.Constructor.newInstance(Unknown Source)
			 *  at com.mayao.singleton.EnumSingleton.main(EnumSingleton.java:41)
             */
        }
		
	}
	
}
