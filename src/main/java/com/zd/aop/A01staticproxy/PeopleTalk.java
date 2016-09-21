/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月18日 下午4:41:45
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A01staticproxy;

/**
 * 业务实现
 * <p>
 * 真实主题角色：定义真实的对象。
 * </p>
 * @author zhengdong 2016年9月18日 下午4:41:45
 */
public class PeopleTalk implements ITalk {
	
	public String username;
	public String age;
	
	public PeopleTalk(String username, String age) {
		this.username = username;
		this.age = age;
	}
	
	public void talk(String msg) {
		System.out.println(msg + "!你好,我是" + username + "，我年龄是" + age);
	}
	
	public String getName() {
		return username;
	}
	
	public void setName(String name) {
		this.username = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
}
