/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月21日 下午4:24:21
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.aop.A06_aop_aspectj.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * </p>
 * @author zhengdong 2016年9月21日 下午4:24:21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年9月21日
 * @modify by reason:{方法名}:{原因}
 */
public class UserService {
	
	private final static Log log = LogFactory.getLog(UserService.class);
	
	public User get(long id) {
		if (log.isInfoEnabled()) {
			log.info("getUser method . . .");
		}
		return new User();
	}
	
	public void save(User user) {
		if (log.isInfoEnabled()) {
			log.info("saveUser method . . .");
		}
	}
	
	public boolean delete(long id) throws Exception {
		if (log.isInfoEnabled()) {
			log.info("delete method . . .");
			throw new Exception("spring aop ThrowAdvice演示");
		}
		return false;
	}
	
}
