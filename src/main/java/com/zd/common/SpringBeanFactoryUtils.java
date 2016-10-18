/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年10月18日 下午3:54:29
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 * 普通类调用Spring注解方式的Service层bean
 * </p>
 * @author zhengdong 2016年10月18日 下午3:54:29
 * @version V1.0
 */
public class SpringBeanFactoryUtils implements ApplicationContextAware {
	
	private static ApplicationContext appCtx;
	
	/**
	 * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
	 * 
	 * @param applicationContext ApplicationContext 对象.
	 * @throws BeansException
	 * @author hzc
	 */
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}
	
	/**
	 * 获取ApplicationContext
	 * 
	 * @return
	 * @author hzc
	 */
	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}
	
	/**
	 * 这是一个便利的方法，帮助我们快速得到一个BEAN
	 * 
	 * @param beanName bean的名字
	 * @return 返回一个bean对象
	 * @author hzc
	 */
	public static Object getBean(String beanName) {
		return appCtx.getBean(beanName);
	}
	
	/**
	 * 这是一个便利的方法，帮助我们快速得到一个BEAN
	 * 
	 * @param Class 服务bean
	 * @return 返回一个bean对象
	 * @author hzc
	 */
	public static Object getBean(Class c) {
		return appCtx.getBean(c);
	}
}
