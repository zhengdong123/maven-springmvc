/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:29:09
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * <p>
 * 异常通知，接口没有包含任何方法。通知方法自定义
 * </p>
 * @author zhengdong 2016年9月18日 下午5:29:09
 * @version V1.0
 */
public class BaseAfterThrowsAdvice implements ThrowsAdvice {
	
	/**
	 * 通知方法，需要按照这种格式书写
	 * 
	 * @param method 可选：切入的方法
	 * @param args 可选：切入的方法的参数
	 * @param target 可选：目标对象
	 * @param throwable 必填 : 异常子类，出现这个异常类的子类，则会进入这个通知。
	 */
	public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
		System.out.println("======异常通知    start=======");
		System.out.println("删除出错啦");
		System.out.println("======异常通知    end=======");
	}
	
}
