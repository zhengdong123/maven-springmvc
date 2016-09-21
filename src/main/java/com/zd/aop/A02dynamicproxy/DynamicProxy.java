/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:55:28
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A02dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * jdk1.5中提供，利用反射。实现InvocationHandler接口。
 * </p>
 * @author zhengdong 2016年9月18日 下午4:55:28
 * @version V1.0
 */
public class DynamicProxy implements InvocationHandler {
	
	/** 需要代理的目标类 */
	private Object target;
	
	/**
	 * 写法固定，aop专用:绑定委托对象并返回一个代理类
	 * 
	 * @param delegate
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	/**
	 * @param Object target：指被代理的对象。
	 * @param Method method：要调用的方法
	 * @param Object [] args：方法调用时所需要的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		// 切面之前执行
		System.out.println("切面之前执行");
		// 执行业务
		result = method.invoke(target, args);
		// 切面之后执行
		System.out.println("切面之后执行");
		return result;
	}
}
