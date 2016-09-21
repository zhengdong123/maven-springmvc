/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:21:38
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A04_aop_interface;

/**
 * 业务接口
 * <p>
 * 代理类接口，也是业务类接口<br>
 * 
 * 利用接口的方式，spring aop 将默认通过jdk 动态代理来实现代理类<br>
 * 不利用接口，则spring aop 将通过cglib 来实现代理类
 * </p>
 * @author zhengdong 2016年9月18日 下午5:21:38
 * @version V1.0
 */
public interface IBaseBusiness {
	
	/**
	 * 用作代理的切入点方法
	 * 
	 * @param obj
	 * @return
	 */
	public String delete(String obj);
	
	/**
	 * 这方法不被切面切
	 * 
	 * @param obj
	 * @return
	 */
	public String add(String obj);
	
	/**
	 * 这方法切不切呢？可以设置
	 * 
	 * @param obj
	 * @return
	 */
	public String modify(String obj);
	
}
