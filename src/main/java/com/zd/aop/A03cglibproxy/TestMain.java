/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:03:59
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A03cglibproxy;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月18日 下午5:03:59
 * @version V1.0
 */
public class TestMain {
	
	// CGLIB是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强。采用的是继承的方式。
	
	public static void main(String[] args) {
		PeopleTalk peopleTalk = (PeopleTalk)new CglibProxy().getInstance(new PeopleTalk());
		peopleTalk.talk("业务方法1");
		peopleTalk.spreak("业务方法2");
	}
	
}
