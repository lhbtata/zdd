package lhb.zdd.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lhb.zdd.model.ZddUser;
import lhb.zdd.service.UserServiceI;
import lhb.zdd.util.DateTools;
import lhb.zdd.util.MD5ForDiscuzUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sun.tools.tree.NewArrayExpression;

/**
 * 首页相关controller
 * @author haibin
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private UserServiceI userService;
	/**
	 * 首页
	 * @param session
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpSession session,HttpServletRequest request) {
		String strIP = getIP(request);
		String city = getAddressByIP(strIP);
		session.setAttribute("session_area", city);
		return "index";
		//return "logout";
	}
	/**
	 * 转到登录页面
	 * @return
	 */
	@RequestMapping("denglu")
	public ModelAndView denglu(){
		ModelAndView view = new ModelAndView("denglu");
		return view;
	}
	/**
	 * 用户登录
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, ZddUser user){
		ModelAndView view = new ModelAndView("/user/userCenter");
		ModelAndView error = new ModelAndView("/denglu");
		String username = user.getUsername();
		String password = user.getPassword();
		//
		String msn = "";
		if(null==username||"".equals(username)){
			msn="用户名不能为空";
			error.addObject("msn", user);
			return error;
		}else if(null==password||"".equals(password)){
			msn="密码不能为空";
			error.addObject("msn", user);
			return error;
		}else if(username.matches("[0-9]+")){//判断username是否是纯数字（此处用户名为手机号）
			user.setPhone(username);
			user.setUsername(null);
		}else if( username.indexOf("@")>0){//判断username是否是邮箱
			user.setEmail(username);
			user.setUsername(null);
		}
		user= userService.selectWhenUserlogin(user);
		if(null==user){
			msn="用户名不存在";
			error.addObject("msn", user);
			return error;
		}else {
			if(user.getErrtime()>=6){
				msn="账号已经锁定！请明天再试吧！或能过密码找回功能找回";
			}else if(!user.getPassword().equals(MD5ForDiscuzUtil.getMd5(password))){
				msn="密码错误!你还剩下" + user.getErrtime()+1 + "次机会！";
				user.setErrtime(1);
			}
			user.setLastip(getIP(request));
			user.setLasttime(DateTools.getCurrentTimeStringyyyyMMddHHmmss());
			view.addObject("msn", user);
			userService.updateByPrimaryKeySelective(user);
			if(!"".equals(msn)){
				error.addObject("msn", user);
				return error;
			}
				
		}
		return view;
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("zhuce")
	public ModelAndView zhuce(){
		ModelAndView view = new ModelAndView("zhuce");
		return view;
	}
	/**
	 * 用户注册
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("register")
	public ModelAndView register(HttpSession session,HttpServletRequest request,ZddUser user,String checkCode){
		ModelAndView view = new ModelAndView("redirect:index.do");
		ModelAndView view2 = new ModelAndView("zhuce");
		String ip = getIP(request);//用户登录IP
		String time = DateTools.getCurrentTimeStringyyyyMMddHHmmss();//当前时间
		user.setPassword(MD5ForDiscuzUtil.getMd5(user.getPassword()));//md5加密密码
		user.setRegip(ip);
		user.setLastip(ip);
		user.setRegtime(time);
		user.setLasttime(time);
		String msn = checkCode(session, checkCode);
		//view.addObject("user", user);
		//view.addObject("checkCode", checkCode);
		view2.addObject("user", user);
		view2.addObject("checkCode", checkCode);
		if(!"".equals(msn)){//如果验证码不正确则回到注册页面
			view2.addObject("fale_msn", msn);
			return view2;
		}
		Boolean flag = userService.selectByEntity(user);
		if(!flag){//判断用户名是否可用
			view2.addObject("fale_msn", "该用户名已经存在！");
			return view2;
		}
		flag = userService.userRegister(user);
		if(!flag){
			view2.addObject("fale_msn", "用户注册失败！");
			return view2;
		}
		session.setAttribute("session_user", user);
		return view;
	}
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.do";
		//return "logout";
	}
	
	/**
	 * 获取用户登录IP
	 * @param request
	 * @return
	 */
	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		}
	
	/**
	 * 检查验证码是否正确
	 * @param session
	 * @param checkCode
	 * @return
	 */
	public String checkCode(HttpSession session,String checkCode){
		String checkSession=(String)session.getAttribute("checkCodeSession");
		checkCode=checkCode.toUpperCase();
		String msn = "";
		if(checkCode.equals(checkSession.toUpperCase())){
			//正确的附加码输入
		}else{
			msn = "验证码输入错误！";
		}
		return msn;
	}
	/**
	 * 根据IP获取地理位置
	 * @param strIP
	 * @return
	 */
	public String getAddressByIP(String strIP)
	{ 
	  try
	  {
	    //String strIP = "27.205.41.232";
		if(!strIP.equals("127.0.0.1")){
			 URL url = new URL( "http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP); 
			    URLConnection conn = url.openConnection(); 
			    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK")); 
			    String line = null; 
			    StringBuffer result = new StringBuffer(); 
			    while((line = reader.readLine()) != null)
			    { 
			      result.append(line); 
			    } 
			    reader.close(); 
			    strIP = result.substring(result.indexOf( "该IP所在地为：" ));
			    strIP = strIP.substring(strIP.indexOf( "：") + 1);
			    String province = strIP.substring(6, strIP.indexOf("省"));
			    String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));
//			    System.out.println(strIP);
//			    System.out.println(province);
//			    System.out.println(city);
			    return city;
		}else {
			return "本地测试";
		}
	   
	  }
	  catch( IOException e)
	  { 
	    return "读取失败"; 
	  }
	}
	public static void main(String[] args) {
		System.out.println(0.03*100%(0.02*100));
		IndexController indexController = new IndexController();
		indexController.getAddressByIP("27.205.41.232");
	}

}
