package com.mayao.constructor;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * @Description: TODO( 消除过期的对象引用 )
 * @author: mayao
 * @date 2016年10月12日 上午11:16:30
 */
public class ClearOldObject {

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT = 16;
	
	public ClearOldObject(){
		elements = new Object[DEFAULT];
	}
	
	public void push( Object e ){
		ensureCapacity();
		elements[size++] = e;
	}
	
	//只要一个单元弹出栈，指向他的引用就过期了
	public Object pop(){
		if( size == 0 ){
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	//修改版本
	public Object pop2(){
		if( size == 0 ){
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements = null;//清空过期的引用
		return result;
	}
	
	
	
	public void ensureCapacity(){
		if( elements.length == size ){
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
}
