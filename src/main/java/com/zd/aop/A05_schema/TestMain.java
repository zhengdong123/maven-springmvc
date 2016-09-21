/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月19日 上午9:50:05
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A05_schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月19日 上午9:50:05
 * @version V1.0
 */
public class TestMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("A05_schema_aop.xml");
		AspectBusiness business = (AspectBusiness)context.getBean("aspectBusiness");
		business.delete("猫");
	}
	
}
