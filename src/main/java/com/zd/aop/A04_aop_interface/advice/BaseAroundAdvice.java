/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:26:00
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>
 * 环绕通知
 * </p>
 * @author zhengdong 2016年9月18日 下午5:26:00
 * @version V1.0
 */
public class BaseAroundAdvice implements MethodInterceptor {
	
	/**
	 * invocation ：连接点
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("===========进入around环绕方法！=========== \n");
		
		// 调用目标方法之前执行的动作
		System.out.println("调用方法之前: 执行！\n");
		
		// 调用方法的参数
		Object[] args = invocation.getArguments();
		// 调用的方法
		Method method = invocation.getMethod();
		// 获取目标对象
		Object target = invocation.getThis();
		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		Object returnValue = invocation.proceed();
		
		System.out.println("===========结束进入around环绕方法！ 2=========== \n");
		
		System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + returnValue + "\n");
		
		System.out.println("调用方法结束：之后执行！\n");
		
		return returnValue;
	}
	
}
