/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:40:30
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A01staticproxy;

/**
 * 业务接口
 * <p>
 * 抽象主题角色：声明了真实主题和代理主题的共同接口。
 * </p>
 * @author zhengdong 2016年9月18日 下午4:40:30
 */
public interface ITalk {
	
	public void talk(String msg);
}
