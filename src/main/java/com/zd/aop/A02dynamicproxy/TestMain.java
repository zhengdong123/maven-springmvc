/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:57:13
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A02dynamicproxy;

import com.zd.aop.A01staticproxy.ITalk;
import com.zd.aop.A01staticproxy.PeopleTalk;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月18日 下午4:57:13
 * @version V1.0
 */
public class TestMain {
	
	// 说明只要在业务调用方法切面之前，是可以动态的加入需要处理的方法。
	// 从代码来看，如果再建立一个业务模块，也只需要一个代理类。ITalk iTalk = (ITalk) new DynamicProxy().bind(new PeopleTalk()); 将业务接口和业务类绑定到动态代理类。
	// 但是这种方式：还是需要定义接口。
	
	public static void main(String[] args) {
		// 绑定代理，这种方式会在所有的方法都加上切面方法
		ITalk iTalk = (ITalk)new DynamicProxy().bind(new PeopleTalk("aop", "18"));
		iTalk.talk("业务说明");
	}
	
}
