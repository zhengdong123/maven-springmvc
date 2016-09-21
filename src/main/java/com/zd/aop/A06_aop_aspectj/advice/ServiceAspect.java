/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午4:28:41
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 系统服务组件Aspect切面Bean
 * @author Shenghany
 * @date 2013-5-28
 */
// 声明这是一个组件
@Component
// 声明这是一个切面Bean
@Aspect
public class ServiceAspect {
	
	private final static Log log = LogFactory.getLog(ServiceAspect.class);
	
	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.zd.aop.A06_aop_aspectj.service..*(..))")
	public void aspect() {
	}
	
	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		System.out.println("==================");
		System.out.println("before....start..");
		System.out.println("方法名：" + joinPoint.getSignature().getName());
		System.out.println("参数：" + joinPoint.getArgs()[0]);
		if (log.isInfoEnabled()) {
			log.info("before " + joinPoint);
		}
		System.out.println("before....end..");
	}
	
	// 配置后置通知,使用在方法aspect()上注册的切入点
	@After(value = "aspect()")
	public void after(JoinPoint joinPoint) {
		System.out.println("==================");
		System.out.println("after....start..");
		if (log.isInfoEnabled()) {
			log.info("after " + joinPoint);
		}
		System.out.println("after....end..");
	}
	
	// 配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("aspect()")
	public void around(JoinPoint joinPoint) {
		System.out.println("==================");
		System.out.println("around....start..");
		long start = System.currentTimeMillis();
		try {
			// 调用方法的参数
			Object[] args = joinPoint.getArgs();
			// 调用的方法名
			String method = joinPoint.getSignature().getName();
			// 获取目标对象
			Object target = joinPoint.getTarget();
			// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
			Object result = ((ProceedingJoinPoint)joinPoint).proceed();
			
			System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + result + "\n");
			// ((ProceedingJoinPoint)joinPoint).proceed();
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			}
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
			}
		}
		System.out.println("around....end..");
	}
	
	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint) {
		System.out.println("==================");
		System.out.println("afterReturn....start..");
		if (log.isInfoEnabled()) {
			log.info("afterReturn " + joinPoint);
		}
		System.out.println("afterReturn....end..");
	}
	
	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "aspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		if (log.isInfoEnabled()) {
			log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
		}
	}
	
}
