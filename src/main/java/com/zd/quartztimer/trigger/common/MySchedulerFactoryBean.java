/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年10月13日 下午2:30:08
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.quartztimer.trigger.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.zd.quartztimer.trigger.anno.TriggerMethod;
import com.zd.quartztimer.trigger.anno.TriggerType;

/**
 * 继承重写spring实现，加入解析注解
 * <p>
 * 解析日终类
 * </p>
 * @author zhengdong 2016年10月13日 下午2:30:08
 * @version V1.0
 */
public class MySchedulerFactoryBean extends SchedulerFactoryBean {
	
	/** 日志 */
	protected Log log = LogFactory.getLog(MySchedulerFactoryBean.class.getName());
	
	/** Spring 上下文 */
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void registerJobsAndTriggers() throws SchedulerException {
		try {
			// 获取所有bean name
			String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
			for (String beanName : beanNames) {
				Class<?> targetClass = applicationContext.getType(beanName);
				// 循环判断是否标记了TriggerType注解
				if (targetClass.isAnnotationPresent(TriggerType.class)) {
					Object targetObject = applicationContext.getBean(beanName);
					TriggerType triggerType = targetClass.getAnnotation(TriggerType.class);
					// 获取时间表达式
					String cronExpression = triggerType.cronExpression();
					String targetMethod = "";
					// 确定标记了TriggerMethod注解的方法名
					Method[] methods = targetClass.getDeclaredMethods();
					for (Method method : methods) {
						if (method.isAnnotationPresent(TriggerMethod.class)) {
							targetMethod = method.getName();
						}
					}
					// 注册定时器业务类
					registerJobs(targetObject, targetMethod, beanName, cronExpression);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	/**
	 * 注册定时器
	 * 
	 * @param targetObject
	 * @param targetMethod
	 * @param beanName
	 * @param cronExpression
	 * @throws Exception
	 */
	private void registerJobs(Object targetObject, String targetMethod, String beanName, String cronExpression)
	        throws Exception {
		// 声明包装业务类
		MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		jobDetailFactoryBean.setTargetObject(targetObject);
		jobDetailFactoryBean.setTargetMethod(targetMethod);
		jobDetailFactoryBean.setBeanName(beanName);
		jobDetailFactoryBean.afterPropertiesSet();
		
		// 获取JobDetail
		JobDetail jobDetail = jobDetailFactoryBean.getObject();
		
		// 声明定时器
		CronTriggerBean cronTriggerBean = new CronTriggerBean();
		cronTriggerBean.setJobDetail(jobDetail);
		cronTriggerBean.setCronExpression(cronExpression);
		cronTriggerBean.setBeanName(beanName + "CronBean");
		cronTriggerBean.afterPropertiesSet();
		
		// 将定时器注册到factroy
		List<Trigger> triggerList = new ArrayList<Trigger>();
		triggerList.add(cronTriggerBean);
		Trigger[] triggers = triggerList.toArray(new Trigger[triggerList.size()]);
		setTriggers(triggers);
		super.registerJobsAndTriggers();
	}
	
}
