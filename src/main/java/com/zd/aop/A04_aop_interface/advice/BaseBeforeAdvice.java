/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:24:11
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * <p>
 * 前置通知。
 * </p>
 * @author zhengdong 2016年9月18日 下午5:24:11
 * @version V1.0
 */
public class BaseBeforeAdvice implements MethodBeforeAdvice {
	
	/**
	 * method : 切入的方法 <br>
	 * args ：切入方法的参数 <br>
	 * target ：目标对象
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("===========进入beforeAdvice()== start ========== \n");
		
		System.out.print("准备在" + target + "对象上用");
		System.out.print(method + "方法进行对 '");
		System.out.print(args[0] + "'进行删除！\n\n");
		
		System.out.println("===========进入beforeAdvice()== end  1 ========== \n");
		System.out.println("要进入切入点方法了 \n");
	}
	
}
