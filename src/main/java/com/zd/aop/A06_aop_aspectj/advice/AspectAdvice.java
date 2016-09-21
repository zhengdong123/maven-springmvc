/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午3:47:16
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 定义切面
 * 系统服务组件Aspect切面Bean
 * @Aspect : 标记为切面类
 * @Pointcut : 指定匹配切点
 * @Before : 指定前置通知，value中指定切入点匹配
 * @AfterReturning ：后置通知，具有可以指定返回值
 * @AfterThrowing ：异常通知
 *                </p>
 * @author zhengdong 2016年9月21日 下午3:47:16
 * @version V1.0
 */
//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
public class AspectAdvice {
	
	/**
	 * 指定切入点匹配表达式，注意它是以方法的形式进行声明的。
	 */
	@Pointcut("execution(* com.zd.aop.A06_aop_aspectj.*.*(..))")
	public void anyMethod() {
	}
	
	/**
	 * 前置通知
	 * 
	 * @param jp
	 */
	@Before(value = "execution(* com.zd.aop.A06_aop_aspectj.*.*(..))")
	public void doBefore(JoinPoint jp) {
		System.out.println("===========进入before advice============ \n");
		
		System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");
		System.out.print(jp.getSignature().getName() + "方法进行对 '");
		System.out.print(jp.getArgs()[0] + "'进行删除！\n\n");
		
		System.out.println("要进入切入点方法了 \n");
	}
	
	/**
	 * 后置通知
	 * 
	 * @param jp 连接点
	 * @param result 返回值
	 */
	@AfterReturning(value = "execution(* com.zd.aop.A06_aop_aspectj.*.*(..))", returning = "result")
	public void doAfter(JoinPoint jp, String result) {
		System.out.println("==========进入after advice=========== \n");
		System.out.println("切入点方法执行完了 \n");
		
		System.out.print(jp.getArgs()[0] + "在");
		System.out.print(jp.getTarget().getClass() + "对象上被");
		System.out.print(jp.getSignature().getName() + "方法删除了");
		System.out.print("只留下：" + result + "\n\n");
	}
	
	/**
	 * 环绕通知
	 * 
	 * @param pjp 连接点
	 */
	@Around(value = "execution(* com.zd.aop.A06_aop_aspectj.*.*(..))")
	public void doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("===========进入around环绕方法！=========== \n");
		
		// 调用目标方法之前执行的动作
		System.out.println("调用方法之前: 执行！\n");
		
		// 调用方法的参数
		Object[] args = pjp.getArgs();
		// 调用的方法名
		String method = pjp.getSignature().getName();
		// 获取目标对象
		Object target = pjp.getTarget();
		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		Object result = pjp.proceed();
		
		System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + result + "\n");
		System.out.println("调用方法结束：之后执行！\n");
		System.out.println("===========结束around环绕方法！=========== \n");
	}
	
	/**
	 * 异常通知
	 * 
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(value = "execution(* com.zd.aop.A06_aop_aspectj.*.*(..))", throwing = "e")
	public void doThrow(JoinPoint jp, Throwable e) {
		System.out.println("删除出错啦");
	}
}
