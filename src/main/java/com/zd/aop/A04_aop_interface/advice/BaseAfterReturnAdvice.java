/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:25:09
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * <p>
 * 后置通知
 * </p>
 * @author zhengdong 2016年9月18日 下午5:25:09
 * @version V1.0
 */
public class BaseAfterReturnAdvice implements AfterReturningAdvice {
	
	/**
	 * returnValue ：切入点执行完方法的返回值，但不能修改 <br>
	 * method ：切入点方法 <br>
	 * args ：切入点方法的参数数组 <br>
	 * target ：目标对象
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("==========进入afterReturning()   后置通知start=========== \n");
		System.out.println("切入点方法执行完了 \n");
		
		System.out.print(args[0] + "在");
		System.out.print(target + "对象上被");
		System.out.print(method + "方法删除了");
		System.out.print("只留下：" + returnValue + "\n\n");
		System.out.println("========== 后置通知 end=========== \n");
	}
	
}
