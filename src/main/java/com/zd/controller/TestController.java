package com.zd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
  * @ClassName: GeneralController 
  * @Description: TODO  测试的controller
  * @author ZD
  * @date 2016年6月11日 下午9:06:18 
  * @version V1.0
 */
@Controller
public class TestController {
	Logger logger = Logger.getLogger(TestController.class);

	@RequestMapping(value = { "/go_index.do" })
	public String go_moreInfoNews(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String type = request.getParameter("type");
		model.addAttribute("xujj", "maven springMVC ,hello world 你好！！！！");
		System.out.println("helloworld");
		logger.info("你好");
		logger.warn("警告。。。12322000");
		return "test";
	}
}
