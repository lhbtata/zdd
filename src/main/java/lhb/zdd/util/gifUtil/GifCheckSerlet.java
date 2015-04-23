/*************************************************************
 * 
 * <b>创建日期: </b> 2014-11-10<br>
 * <b>标题: </b>动画图片附加码程序 <br>
 * <b>类描述: </b><br>
 * <br>
 * <p>Copyright: Copyright (c)2014</p>
 * <p>Company: </p>
 * 
 * @author zhouxj
 * 
 * @version 1.00
 * 
 * @since 
 * 
 * @see 
 * v1.00 创建文件
 *************************************************************/

package lhb.zdd.util.gifUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GifCheckSerlet")
public class GifCheckSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GifCheckSerlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 验证码图片的宽度。

		// 将四位数字的验证码保存到Session中。
		HttpSession session = request.getSession();
		String flag="0"; //是否使用动画附加码标志
		
		flag=(String )request.getAttribute("flag");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/gif");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		String aa = Randoms.getRadom(4); // 随机产生4个字符
		session.setAttribute("checkCodeSession", aa); //附加码的值域
		System.out.println(aa);
		char[] aac = aa.toCharArray();
		Captcha captcha;
		if(flag==null || flag.equals("0")){
			 captcha = new GifCaptchaExt(113, 40, aac.length, aac);// gif格式动画验证码
			 captcha.out(sos);
		}else {
			 captcha = new GifCaptchaSimple(113, 40, aac.length, aac);// gif格式验证码,无动画
			 captcha.out(sos);
		}
		sos.flush();
		sos.close();
	}

}
