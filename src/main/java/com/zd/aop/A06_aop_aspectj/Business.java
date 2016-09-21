/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午3:46:07
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 业务类
 * </p>
 * @author zhengdong 2016年9月21日 下午3:46:07
 * @version V1.0
 */
@Component
public class Business {
	
	/**
	 * 切入点
	 */
	public String delete(String obj) {
		System.out.println("==========调用切入点：" + obj + "说：你敢删除我！===========\n");
		return obj + "：瞄～";
	}
	
	public String add(String obj) {
		System.out.println("================这个方法不能被切。。。============== \n");
		return obj + "：瞄～ 嘿嘿！";
	}
	
	public String modify(String obj) {
		System.out.println("=================这个也设置加入切吧====================\n");
		return obj + "：瞄改瞄啊！";
	}
	
}
