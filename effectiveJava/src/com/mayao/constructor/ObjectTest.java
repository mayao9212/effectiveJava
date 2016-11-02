package com.mayao.constructor;

import org.junit.Test;

/**
 * 
 * @Description: TODO( 优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱  )
 * @author: mayao
 * @date 2016年10月12日 上午10:49:42
 */
public class ObjectTest {

	
	@Test
	public void LonglongTest(){
		
		//Long sum = 0l ;
		long sum = 0l ;
		for( long i = 0 ; i < Integer.MAX_VALUE ; i++ ){
			sum += i;
		}
		System.out.println(sum);
		
		
		/**
		 * Long 自动装箱类型，10.080s;因为创建了Integer.MAX_VALUE个Long实例
		 * 
		 * long 0.650s
		 * 
		 * 
		 */
		
	}
	
	
}
