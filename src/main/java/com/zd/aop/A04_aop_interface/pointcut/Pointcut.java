/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:30:12
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * <p>
 * 定义一个切点，指定对应方法匹配。来供切面来针对方法进行处理<br>
 * 继承NameMatchMethodPointcut类，来用方法名匹配
 * </p>
 * @author zhengdong 2016年9月18日 下午5:30:12
 * @version V1.0
 */
public class Pointcut extends NameMatchMethodPointcut {
	
	private static final long serialVersionUID = 3990456017285944475L;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean matches(Method method, Class targetClass) {
		// 设置单个方法匹配
		this.setMappedName("delete");
		// 设置多个方法匹配
		String[] methods = {"delete", "modify"};
		
		// 也可以用“ * ” 来做匹配符号
		// this.setMappedName("get*");
		
		this.setMappedNames(methods);
		
		return super.matches(method, targetClass);
	}
}
