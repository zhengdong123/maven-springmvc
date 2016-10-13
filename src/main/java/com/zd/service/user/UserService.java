/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年10月11日 下午4:59:22
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.service.user;

import java.util.Map;

/**
 * <p>
 * 用户
 * </p>
 * @author zhengdong 2016年10月11日 下午4:59:22
 * @version V1.0
 */
public interface UserService {
	
	/**
	 * 获取用户信息
	 * @author zhengdong 2016年10月12日 上午9:42:32
	 * @return
	 */
	public Map<String, String> getUserMap();
}
