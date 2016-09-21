/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月19日 上午9:42:22
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A05_schema.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>
 * 定义一个切面：切面类中，包含了所有的通知
 * </p>
 * @author zhengdong 2016年9月19日 上午9:42:22
 * @version V1.0
 */
public class AspectAdvice {
	
	/**
	 * 前置通知
	 * 
	 * @param jp
	 */
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
		System.out.println("===========结束 进入around环绕方法！==== end 2 ======= \n");
		System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + result + "\n");
		System.out.println("调用方法结束：之后执行！\n");
	}
	
	/**
	 * 异常通知
	 * 
	 * @param jp
	 * @param e
	 */
	public void doThrow(JoinPoint jp, Throwable e) {
		System.out.println("删除出错啦");
	}
	
}
