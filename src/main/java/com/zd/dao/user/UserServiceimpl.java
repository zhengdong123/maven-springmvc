/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年10月11日 下午4:59:57
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.dao.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zd.service.user.UserService;

/**
 * <p>
 * 用户
 * </p>
 * @author zhengdong 2016年10月11日 下午4:59:57
 * @version V1.0
 */
@Transactional
@Service("userService")
public class UserServiceimpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceimpl.class);
	
	public Map<String, String> getUserMap() {
		logger.warn("准备从数据库获取用户信息了...");
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("name", "小强");
		userMap.put("password", "123456");
		logger.warn("从数据库获取用户信息完毕...");
		return userMap;
	}
	
}
