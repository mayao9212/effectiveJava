package com.mayao.constructor;
/**
 * 
 * @Description: TODO( 服务提供者接口 )
 * @author: mayao
 * @date 2016年10月11日 下午3:02:15
 */
public interface Provider {

	/**
	 * 
	 * TODO( 获取Service服务对象 )
	 * @return
	 * @author mayao
	 */
	Service newService();
	
	/**
	 * 更过的Service...
	 */
}
