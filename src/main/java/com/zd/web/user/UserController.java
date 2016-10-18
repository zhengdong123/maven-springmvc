/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月22日 上午10:12:03
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zd.anno.SystemControllerLog;
import com.zd.common.SpringBeanFactoryUtils;
import com.zd.service.user.UserService;

/**
 * <p>
 * 用户的controller
 * </p>
 * @author zhengdong 2016年9月22日 上午10:12:03
 * @version V1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	/**
	 * 跳转到用户登录页面
	 * @author zhengdong 2016年9月22日 上午10:34:44
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/go_userlogin.do")
	@SystemControllerLog(description = "跳转到登录页面...")
	public String goUserLogin(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> userMap = userService.getUserMap();
		logger.info("方式一@Autowired：userMap:" + userMap);
		
		UserService userService2 = (UserService)SpringBeanFactoryUtils.getBean(UserService.class);
		Map<String, String> userMap2 = userService2.getUserMap();
		logger.info("方式二获取的用户userMap2：" + userMap2);
		
		logger.info("跳转到登录页面");
		return "user/login";
	}
	
	@SystemControllerLog(description = "保存用户信息")
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject saveUser(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Thread.currentThread().sleep(1000 * 3);
		
		Map<String, Object> parMap = new HashMap<String, Object>();
		parMap.put("username", username);
		parMap.put("password", password);
		
		JSONObject resObject = new JSONObject();
		resObject.put("result", "sucess");
		return resObject;
	}
	
	@SystemControllerLog(description = "测试js对象传给后台")
	@RequestMapping(value = "/getObjectJS", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject getObjectJS(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		String arr = request.getParameter("arr");
		System.out.println("接收到的arr：" + arr);
		
		String[] split = arr.split("&&&");
		String str = split[4];
		JSONObject parseObject = JSONObject.parseObject(str);
		logger.info("获取到的json：" + parseObject.toJSONString());
		String name = parseObject.getString("name");
		String age = parseObject.getString("age");
		String tell = parseObject.getString("tell");
		logger.info("name:" + name + "  age:" + age + "  tell:" + tell);
		
		String params = request.getParameter("params");
		System.out.println("接收到的params：" + params);
		JSONObject paramsjObject = JSONObject.parseObject(params);
		String name2 = paramsjObject.getString("name");
		JSONObject obj3 = paramsjObject.getJSONObject("param");
		logger.info("arr2..name2:" + name2 + "   obj3:" + obj3.toJSONString());
		
		Thread.currentThread().sleep(1000 * 3);
		
		JSONObject resObject = new JSONObject();
		resObject.put("result", "sucess");
		return resObject;
	}
	
	/**
	 * 跳转到用户信息页面
	 * @author zhengdong 2016年9月22日 上午10:36:34
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/go_userinfo.do")
	public String goUserInfo(HttpServletRequest request, HttpServletResponse response) {
		logger.info("需要登录，跳转到用户信息页面");
		return "user/acc_login_userinfo";
	}
	
	/**
	 * 跳转到某个需要权限的页面
	 * @author zhengdong 2016年9月22日 上午10:38:09
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/go_acc_auth.do")
	public String goAccAuth(HttpServletRequest request, HttpServletResponse response) {
		logger.info("跳转到某个需要权限的页面");
		return "user/acc_auth";
	}
	
}
