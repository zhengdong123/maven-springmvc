/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月23日 下午1:06:36
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aspect;

import javax.naming.NoPermissionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.zd.anno.ISLOGIN;
import com.zd.anno.UserAccessAnnotation;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月23日 下午1:06:36
 * @version V1.0
 */
// 声明这是一个组件
// @Component
// 声明这是一个切面Bean
// @Aspect
public class PermissionAspect {
	
	private final static Log log = LogFactory.getLog(PermissionAspect.class);
	
	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void cutController() {
	}
	
	@Before(value = "cutController()", argNames = "userAccessAnnotation")
	public void checkPermission(UserAccessAnnotation userAccessAnnotation) throws Exception {
		ISLOGIN login = userAccessAnnotation.isLogin();
		
		if (!"".equals(login.toString())) {// 或者用户信息，验证是否有权限
			throw new NoPermissionException("user_no_permission_error");
		}
	}
	
	@AfterThrowing(value = "aspect()", argNames = "userAccessAnnotation")
	public void throwUserNoPermissionException(JoinPoint joinPoint, Exception ex) throws Exception {
		log.error(ex);
	}
}
