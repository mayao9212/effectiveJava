package com.mayao.constructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: TODO( 服务访问 )
 * @author: mayao
 * @date 2016年10月11日 下午3:05:32
 */
public class Services {

	private Services(){};//防止实例化
	
	//Map services names to provider	容器
	private static final Map<String, Provider> providers = new HashMap<String, Provider>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	//provider registration api 注册
	public static void registerDefaultProvider(Provider p){
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}
	public static void registerProvider(String name, Provider p){
		providers.put(name, p);
	}
	
	
	//Service access api 访问
	public static Service newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	public static Service newInstance(String name){
		Provider p = providers.get(name);
		if( null == p ){
			System.err.println("provider: "+name+" 没有注册过");
		}
		return p.newService();
	}
	
}
