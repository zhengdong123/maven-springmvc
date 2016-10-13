/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年10月13日 下午2:27:44
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.quartztimer.trigger;

import com.zd.quartztimer.trigger.anno.TriggerMethod;
import com.zd.quartztimer.trigger.anno.TriggerType;

/**
 * <p>
 * 使用注解的业务类
 * </p>
 * @author zhengdong 2016年10月13日 下午2:27:44
 * @version V1.0
 */
@TriggerType(cronExpression = "0/10 * * * * ?")
// 指定定时时间
public class Job2 {
	
	@TriggerMethod
	public void execute() {
		System.out.println("注解的定时任务。。job2 say");
	}
}
