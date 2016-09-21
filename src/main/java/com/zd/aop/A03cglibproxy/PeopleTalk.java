/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午5:02:19
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A03cglibproxy;

/**
 * <p>
 * 业务类
 * </p>
 * @author zhengdong 2016年9月18日 下午5:02:19
 * @version V1.0
 */
public class PeopleTalk {
	
	public void talk(String msg) {
		System.out.println("people talk" + msg);
	}
	
	/**
	 * @author zhengdong 2016年9月18日 下午5:04:30
	 * @param string
	 */
	public void spreak(String msg) {
		System.out.println("people spreak" + msg);
		
	}
	
}
