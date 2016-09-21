/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:42:54
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A01staticproxy;

/**
 * 代理对象
 * <p>
 * 代理主题角色：内部包含对真实主题的引用，并且提供和真实主题角色相同的接口。
 * </p>
 */
public class TalkProxy implements ITalk {
	
	private final ITalk talker;
	
	public TalkProxy(ITalk talker) {
		// super();
		this.talker = talker;
	}
	
	public void talk(String msg) {
		talker.talk(msg);
	}
	
	public void talk(String msg, String singname) {
		talker.talk(msg);
		sing(singname);
	}
	
	// 后置处理
	private void sing(String singname) {
		System.out.println("唱歌：" + singname);
	}
}
