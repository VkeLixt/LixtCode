package com.entor.recruit.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.User;
import com.entor.recruit.service.UserService;
import com.entor.recruit.utils.CaptchaUtils;
import com.entor.recruit.utils.CaptchaUtils.ComplexLevel;
import com.entor.recruit.utils.RecruitConstants;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	//当浏览器访问页面的时候，直接跳转到登录页面
	
	@GetMapping("/index")
	public String index(){
		return "login";
	}
	
	/**
	 * 验证码
	 */
	@RequestMapping("/getCode")
	public void getCaptchaImage(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//通知浏览器不用缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma", "-1");
		System.out.println("121212121212\n\n\n\n\n\n\n");
		//制作验证码
		Object[] obj = CaptchaUtils.getCaptchaImage(150,50,35,50,500,true,true,ComplexLevel.SIMPLE);
		//将验证码输入到session中，用来验证
		session.setAttribute("code", obj[1]);
		//输出打印web页面
		ImageIO.write((BufferedImage) obj[0], "jpg", response.getOutputStream());
	}
	
	
	//登录事件
	/**
	 * @ResponseBody将Java对象转换成json字符串
	 * @RequestParam 静态页面的Input元素的name属性
	 * @param loginname
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody String login(@RequestParam("loginname") String loginname,@RequestParam("password") String password,HttpSession session){
		
		//判断用户是否存在
		User user = userService.login(loginname, password);
		if(user != null){
			//如果用户不为空，则将User保存到session
			session.setAttribute(RecruitConstants.USER_SESSION, user);
			return "{\"message\":true}";
		}else{
			return "{\"message\":false}";
		}
	}
	
	@RequestMapping("/loginname")
	public @ResponseBody String loginname(@RequestParam("loginname") String loginname){
		
		User user = userService.loginname(loginname);
		if(user != null){
			return "{\"message\":true}";
		}else{
			return "{\"message\":false}";
		}
		
		
	}
	
	
	/**
	 * 登录成功之后跳转到的页面
	 */
	@RequestMapping("/main")
	public String main(HttpSession session){
		//提取session中的用户
		User user = (User) session.getAttribute(RecruitConstants.USER_SESSION);
		
		if(user != null){
			return "home";
		}else{
			return "login";
		}
	}
	
	
	/**
	 * 请求服务器session
	 * @param session
	 * @return
	 */
	@RequestMapping("/main/getSession")
	public @ResponseBody User getSession(HttpSession session){
		User user = (User) session.getAttribute(RecruitConstants.USER_SESSION);
		if(user != null){
			return user;
		}else{
			return new User();
		}
	}
	
	
	@RequestMapping("/main/welcome")
	public String welcome(){
		return "welcome";
	}
	
	
	@RequestMapping("/main/recruit")
	public String recruit(){
		return "recruit";
	}
	
	@RequestMapping("/main/applied")
	public String applied(){
		return "applied";
	}
	
	@RequestMapping("/main/resume")
	public String resume(HttpSession session){
		User user = (User) session.getAttribute(RecruitConstants.USER_SESSION);
		if(user.getUsername().equals("超级管理员")){	
			return "resumeRoot";
		}else{
			return "resume";
		}
		

	}
	
	@RequestMapping("/main/admission")
	public String admission(){
		return "admission";
	}
	
	@RequestMapping("/main/seeResume")
	public String see(){
		return "seeResume";
	}
	
	
	
	
	//请求注册页面
	//静态页面跳转使用的是：get请求方式
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	
	
	@RequestMapping("/cardid")
	public @ResponseBody String cardid(@RequestParam("cardId") String cardid){
		User user = userService.findCardId(cardid);
		if(user != null){
			return "{\"message\":true}";
		}else{
			return "{\"message\":false}";
		}
	}
	
	@RequestMapping("/regist")
	public @ResponseBody String regist(User user){
		User userRegName = userService.loginname(user.getLoginname());
		User userRegCard = userService.findCardId(user.getCardId());
		
		if(userRegName == null && userRegCard == null){
			userService.addUser(user);
			return "{\"message\":true}";
		}else{
			return "{\"message\":false}";
		}
		
	}
	
	
	/**
	 * 请求服务器session
	 * 
	 * @return
	 */
	@RequestMapping("/getCode/getSession")
	public @ResponseBody String getCode(HttpSession session) {
		String code = (String) session.getAttribute(RecruitConstants.CODE);
		if (code != null) {
			return "{\"code\":\"" + code + "\"}";
		} else {
			return "{}";
		}
	}
	
	@RequestMapping("/main/logout")
	public String logout(HttpSession session){
		//清空seession里面的数据
		session.setAttribute(RecruitConstants.USER_SESSION, null);
		
		return "redirect:/index";
	}
	
	
	@RequestMapping("/main/newResume")
	public String newResume(){
		
		return "newResume";
	}
	
	
}
