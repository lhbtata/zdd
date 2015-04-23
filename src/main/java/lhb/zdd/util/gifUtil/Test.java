package lhb.zdd.util.gifUtil;
import java.io.*;
public class Test{
public static void main(String[] args) throws FileNotFoundException    {
     //   Captcha captcha = new SpecCaptcha(150,40,5);// png格式验证码
     //   captcha.out(new FileOutputStream("d:/temp/1.png"));
        for(int i=0;i<=100;i++){
        String aa=Randoms.getRadom(4); //随机产生4个字符
        System.out.println(aa);
        char[] aac=aa.toCharArray();
  
       // Captcha captcha = new GifCaptchaExt(115,30,aac.length,aac);//   gif格式动画验证码
        Captcha captcha = new GifCaptchaSimple(115,30,aac.length,aac);//   gif格式动画验证码

        captcha.out(new FileOutputStream("d:/temp/"+aa+".gif"));
        }
        //rands 
    }
}