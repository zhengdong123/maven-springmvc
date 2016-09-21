/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:39:33
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月18日 下午5:39:33
 * @version V1.0
 */
public class DebugMain {
	
	/*
	 * 　具体的代码实现可以从代码注释中很容易理解 接口方式的实现。结果也可想而知，前置方法会在切入点方法之前执行，后置会在切入点方法执行之后执行，环绕则会在切入点方法执行前执行同事方法结束也会执行对应的部分。
	 * 主要是调用proceed()方法来执行切入点方法。来作为环绕通知前后方法的分水岭。然后在实现的过程中，有几点却是可以细揣摩一下的。 　　 可以看出在xml 配置
	 * businessProxy这个bean的时候，ProxyFactoryBean类中指定了，proxyInterfaces参数。这里我把他配置了IBaseBusiness接口。 因为在项目开发过程中，往往业务类都会有对应的接口，以方便利用IOC解耦。但Spring
	 * AOP却也能支持没有接口的代理。这就是为什么需要导入cglib.jar的包了。 看过spring的源码，知道在目标切入对象如果有实现接口，spring会默认走jdk动态代理来实现代理类。 如果没有接口，则会通过cglib来实现代理类。 　　这个业务类现在有
	 * 前置通知，后置通知，环绕三个通知同时作用，可能以及更多的通知进行作用 。那么这些通知的执行顺序是怎么样的？就这个例子而言，同时实现了三个通知。
	 * 在例子xml中，则显示执行before通知，然后执行around的前处理，执行切点方法，再执行return处理。最后执行around的后处理。经过测试，知道spring
	 * 处理顺序是按照xml配置顺序依次处理通知，以队列的方式存放前通知，以压栈的方式存放后通知。所以是前通知依次执行，后通知到切入点执行完之后，从栈里在后进先出的形式把后通知执行。 　 　在实现过程中发现通知执行对应目标对象的整个类中的方法，如何精确到某个方法，则需要定义一个切点匹配的方式：
	 * spring提供了方法名匹配或正则方式来匹配。然后通过DefaultPointcutAdvisor来包装通知，指定切点。
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("schema_aop.xml");
		IBaseBusiness business = (IBaseBusiness)context.getBean("businessProxy");
		business.delete("猫");
	}
}
