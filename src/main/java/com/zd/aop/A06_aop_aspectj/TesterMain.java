/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午4:30:13
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zd.aop.A06_aop_aspectj.service.User;
import com.zd.aop.A06_aop_aspectj.service.UserService;

/**
 * <p>
 * 基于注解的aop
 * </p>
 * @author zhengdong 2016年9月21日 下午4:30:13
 * @version V1.0 http://ntzrj513.blog.163.com/blog/static/27945612201362232315/
 */
public class TesterMain {
	
	// AOP是OOP的延续，是Aspect Oriented Programming的缩写，意思是面向切面编程。
	// 可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。
	// AOP实际是GoF设计模式的延续，设计模式孜孜不倦追求的是调用者和被调用者之间的解耦，AOP可以说也是这种目标的一种实现。
	//
	// 我们现在做的一些非业务，如：日志、事务、安全等都会写在业务代码中(也即是说，这些非业务类横切于业务类)，
	// 但这些代码往往是重复，复制——粘贴式的代码会给程序的维护带来不便，AOP就实现了把这些业务需求与系统需求分开来做。这种解决的方式也称代理机制。
	//
	// 先来了解一下AOP的相关概念，《Spring参考手册》中定义了以下几个AOP的重要概念，结合以上代码分析如下：
	//
	// 切面（Aspect）：官方的抽象定义为“一个关注点的模块化，这个关注点可能会横切多个对象”，在本例中，“切面”就是类TestAspect所关注的具体行为，
	// 例如，AServiceImpl.barA()的调用就是切面TestAspect所关注的行为之一。“切面”在ApplicationContext中<aop:aspect>来配置。
	//
	// 连接点（Joinpoint） ：程序执行过程中的某一行为，例如，UserService.get的调用或者UserService.delete抛出异常等行为。
	//
	// 通知（Advice） ：“切面”对于某个“连接点”所产生的动作，例如，TestAspect中对com.spring.service包下所有类的方法进行日志记录的动作就是一个Advice。
	// 其中，一个“切面”可以包含多个“Advice”，例如ServiceAspect。
	//
	// 切入点（Pointcut） ：匹配连接点的断言，在AOP中通知和一个切入点表达式关联。
	// 例如，TestAspect中的所有通知所关注的连接点，都由切入点表达式execution(* com.spring.service.*.*(..))来决定。
	//
	// 目标对象（Target Object） ：被一个或者多个切面所通知的对象。例如，AServcieImpl和BServiceImpl，当然在实际运行时，Spring AOP采用代理实现，实际AOP操作的是TargetObject的代理对象。
	//
	// AOP代理（AOP Proxy） ：在Spring AOP中有两种代理方式，JDK动态代理和CGLIB代理。默认情况下，TargetObject实现了接口时，则采用JDK动态代理，
	// 例如，AServiceImpl；反之，采用CGLIB代理，例如，BServiceImpl。强制使用CGLIB代理需要将 <aop:config>的 proxy-target-class属性设为true。
	//
	// 通知（Advice）类型：
	// 前置通知（Before advice）：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。ApplicationContext中在<aop:aspect>里面使用<aop:before>元素进行声明。
	// 例如，TestAspect中的doBefore方法。
	// 后置通知（After advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。ApplicationContext中在<aop:aspect>里面使用<aop:after>元素进行声明。
	// 例如，ServiceAspect中的returnAfter方法，所以Teser中调用UserService.delete抛出异常时，returnAfter方法仍然执行。
	// 返回后通知（After return advice）：在某连接点正常完成后执行的通知，不包括抛出异常的情况。ApplicationContext中在<aop:aspect>里面使用<after-returning>元素进行声明。
	// 环绕通知（Around advice）：包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。可以在方法的调用前后完成自定义的行为，也可以选择不执行。
	// ApplicationContext中在<aop:aspect>里面使用<aop:around>元素进行声明。例如，ServiceAspect中的around方法。
	// 抛出异常后通知（After throwing advice）：在方法抛出异常退出时执行的通知。ApplicationContext中在<aop:aspect>里面使用<aop:after-throwing>元素进行声明。
	// 例如，ServiceAspect中的returnThrow方法。
	// 注：可以将多个通知应用到一个目标对象上，即可以将多个切面织入到同一目标对象。
	private final static Log log = LogFactory.getLog(TesterMain.class);
	
	public static void main(String[] args) {
		// 启动Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("A06_2_userService.xml");
		// 获取service组件
		UserService service = (UserService)context.getBean("userService");
		// 以普通的方式调用UserService对象的三个方法
		User user = service.get(1L);
		service.save(user);
		try {
			service.delete(1L);
		} catch (Exception e) {
			if (log.isWarnEnabled()) {
				log.warn("Delete user : " + e.getMessage());
			}
		}
	}
	
}
