/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午3:49:57
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 测试类
 * </p>
 * @author zhengdong 2016年9月21日 下午3:49:57
 * @version V1.0
 */
public class DebugMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("A06_annotation_aop.xml");
		Business business = (Business)context.getBean("business");
		business.delete("猫");
	}
	
}
