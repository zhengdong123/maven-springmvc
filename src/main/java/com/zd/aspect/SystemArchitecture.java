/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月23日 下午1:02:37
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * <p>
 * 定义 PointCut
 * </p>
 * PointCut 即切入点，就是定义方法执行的点，before、after 或者 around。 一般情况下，我们把 PointCut 全部集中定义在 SystemArchitecture 类中，以方便修改和管理。 当实现 Aspect 时可以很方便的使用我们在 SystemArchitecture
 * 中定义的PointCut。
 * @author zhengdong 2016年9月23日 下午1:02:37
 * @version V1.0
 */

public class SystemArchitecture {
	
	/**
	 * A Join Point is defined in the action layer where the method needs a permission check.
	 */
	@Pointcut("execution(* com.zd..*(..))")
	public void userAccess() {
	}
	
}
