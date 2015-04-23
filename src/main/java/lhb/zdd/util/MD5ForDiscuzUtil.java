package lhb.zdd.util;
import java.security.MessageDigest;
/**
 * 有钱网密码加密方式：单次MD5，不是Discuz的双次加密。
 * @author Zhouxj
 * 
 * 2014-11-07
 * ver 1.01
 */
public class MD5ForDiscuzUtil {

	private String inStr;

	private MessageDigest md5;

	/**
	 * Constructs the MD5 object and sets the string whose MD5 is to be
	 * computed.
	 * 
	 * @param inStr
	 *            the <code>String</code> whose MD5 is to be computed
	 */
	public MD5ForDiscuzUtil(String inStr) {
		this.inStr = inStr;
		try {
			this.md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Computes the MD5 fingerprint of a string.
	 * 
	 * @return the MD5 digest of the input <code>String</code>
	 */
	public String compute() {
		// convert input String to a char[]
		// convert that char[] to byte[]
		// get the md5 digest as byte[]
		// bit-wise AND that byte[] with 0xff
		// prepend "0" to the output StringBuffer to make sure that we don't
		// end up with
		// something like "e21ff" instead of "e201ff"

		char[] charArray = this.inStr.toCharArray();

		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = this.md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * 该测试在Discuz 7.2版本上
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// admin为dz_uc_members表的password字段未加密前的明文
		MD5ForDiscuzUtil md5 = new MD5ForDiscuzUtil("x17r2d2fiyQwertyuiop!@");

		// 用MD5第一次加密
		String pwd = md5.compute();
		System.out.println("1:" + pwd);
		pwd=md5.getMd5(pwd+"3f283b");
		System.out.println("2:" + pwd);
		
		System.out.println("3:" + getMd5Salt("x17r2d2fiyQwertyuiop!@","3f283b"));
		// 将加密后的密文加上dz_uc_members表的salt字段
		// 因为DZ加密是使用MD5加密后加上随机码再次加密，所以需要还原加密
		// pwd = pwd + "2632ef";
		// pwd = pwd ;
		// //再次用MD5加密
		// MD5ForDiscuz m = new MD5ForDiscuz(pwd);
		//
		// //得到最终密文
		// String npwd = m.compute();
		// System.out.println(npwd);

		// e10adc3949ba59abbe56e057f20f883e //数据库的密文
		// 1:e10adc3949ba59abbe56e057f20f883e //控件台输出的密文
	}
	/*
	 * 静态方法便于通过类名调用
	 */
	public static String getMd5(String password){
		MD5ForDiscuzUtil md5 = new MD5ForDiscuzUtil(password);

		// 用MD5第一次加密
		String pwd = md5.compute();
		return pwd;
		
	
	}
	
	/*
	 * 静态方法便于通过类名调用
	 * discuz X3.2的加密方式，两次Md5加密，有Salt值干扰
	 */
	public static String getMd5Salt(String password,String Salt){
		MD5ForDiscuzUtil md5 = new MD5ForDiscuzUtil(password);

		// 用MD5第一次加密
		String pwd = md5.compute();
		pwd=md5.getMd5(pwd+Salt);
		return pwd;
		
	
	}
}