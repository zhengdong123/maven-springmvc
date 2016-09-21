/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:43:55
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A01staticproxy;

/**
 * 测试类
 * <p>
 * 代理测试类，使用代理
 * </p>
 */
public class ProxyPatternMain {
	
	/**
	 * 从这段代码可以看出来，代理模式其实就是AOP的雏形。 上端代码中talk(String msg, String singname)是一个切面。在代理类中的sing(singname)方法是个后置处理方法。
	 * 这样就实现了，其他的辅助方法和业务方法的解耦。业务不需要专门去调用，而是走到talk方法，顺理成章的调用sing方法 再从这段代码看：1、要实现代理方式，必须要定义接口。2、每个业务类，需要一个代理类。
	 */
	public static void main(String[] args) {
		// 不需要执行额外方法的。
		ITalk people = new PeopleTalk("AOP", "18");
		people.talk("No ProXY Test");
		System.out.println("-----------------------------");
		
		// 需要执行额外方法的（切面）
		TalkProxy talker = new TalkProxy(people);
		talker.talk("ProXY Test", "代理");
	}
	
}
