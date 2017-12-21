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
	
	//�����������ҳ���ʱ��ֱ����ת����¼ҳ��
	
	@GetMapping("/index")
	public String index(){
		return "login";
	}
	
	/**
	 * ��֤��
	 */
	@RequestMapping("/getCode")
	public void getCaptchaImage(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		//֪ͨ��������û���
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma", "-1");
		System.out.println("121212121212\n\n\n\n\n\n\n");
		//������֤��
		Object[] obj = CaptchaUtils.getCaptchaImage(150,50,35,50,500,true,true,ComplexLevel.SIMPLE);
		//����֤�����뵽session�У�������֤
		session.setAttribute("code", obj[1]);
		//�����ӡwebҳ��
		ImageIO.write((BufferedImage) obj[0], "jpg", response.getOutputStream());
	}
	
	
	//��¼�¼�
	/**
	 * @ResponseBody��Java����ת����json�ַ���
	 * @RequestParam ��̬ҳ���InputԪ�ص�name����
	 * @param loginname
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody String login(@RequestParam("loginname") String loginname,@RequestParam("password") String password,HttpSession session){
		
		//�ж��û��Ƿ����
		User user = userService.login(loginname, password);
		if(user != null){
			//����û���Ϊ�գ���User���浽session
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
	 * ��¼�ɹ�֮����ת����ҳ��
	 */
	@RequestMapping("/main")
	public String main(HttpSession session){
		//��ȡsession�е��û�
		User user = (User) session.getAttribute(RecruitConstants.USER_SESSION);
		
		if(user != null){
			return "home";
		}else{
			return "login";
		}
	}
	
	
	/**
	 * ���������session
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
		if(user.getUsername().equals("��������Ա")){	
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
	
	
	
	
	//����ע��ҳ��
	//��̬ҳ����תʹ�õ��ǣ�get����ʽ
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
	 * ���������session
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
		//���seession���������
		session.setAttribute(RecruitConstants.USER_SESSION, null);
		
		return "redirect:/index";
	}
	
	
	@RequestMapping("/main/newResume")
	public String newResume(){
		
		return "newResume";
	}
	
	
}
