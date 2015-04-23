package lhb.zdd.util.gifUtil;

import java.util.Random;

/**
 * 
 * <p>
 * 随机工具类
 * </p>
 * 
 * @author: wuhongjun
 * @version:1.0
 */
public class Randoms {
	private static final Random RANDOM = new Random();
	// 定义验证码字符.去除了O和I等容易混淆的字母
	public static final char ALPHA[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'G', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 产生两个数之间的随机数
	 * 
	 * @param min
	 *            小数
	 * @param max
	 *            比min大的数
	 * @return int 随机数字
	 */

	public static int num(int min, int max) {
		return min + RANDOM.nextInt(max - min);
	}

	/**
	 * 产生0--num的随机数,不包括num
	 * 
	 * @param num
	 *            数字
	 * @return int 随机数字
	 */
	public static int num(int num) {
		return RANDOM.nextInt(num);
	}

	/**
	 * 产生-num--num的随机数,不包括num ,可以为负数
	 * 
	 * @param num
	 *            数字
	 * @return int 随机数字
	 */
	public static int numZero(int num) {

		int msNum = -RANDOM.nextInt(num);
		int Num = RANDOM.nextInt(num);
		int ret = (msNum + Num) / 2;
		return ret;
	}

	public static char alpha() {
		return ALPHA[num(0, ALPHA.length)];
	}
	/**
	 * 产生随机字符串，长度为length
	 * 
	 * @param length 字符串长度
	 * @return String 随机字符串
	 */	
	public static String getRadom(int length){
		String str="";
		
		for(int i=0;i<length;i++){
			char strs=alpha();
			str=str+strs;
		}
		return str;
	}
}
