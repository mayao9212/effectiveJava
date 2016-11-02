package com.mayao.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 
 * @Description: TODO( 暴力反射，对私有变量赋值 )
 * @author: mayao
 * @date 2016年10月11日 下午5:24:08
 */
public class ReflectPoint {

	private int priVal;
	
	public ReflectPoint( int priVal ){
		this.priVal = priVal;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		ReflectPoint pt1 = new ReflectPoint(100);
		Field field = pt1.getClass().getDeclaredField("priVal");//通过属性名获取属性
		field.setAccessible(true);
		field.set(pt1, 200);
		System.out.println(field.get(pt1));//200
		
	}
	
	
}
