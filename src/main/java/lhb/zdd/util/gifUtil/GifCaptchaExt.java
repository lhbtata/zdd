package lhb.zdd.util.gifUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * <p>
 * Gif验证码类
 * </p>
 *
 * @author: zhouxj
 * @version:1.01
 */
public class GifCaptchaExt extends Captcha {
	char[] rands = { 49, 49, 49, 49 }; // 初始为1111

	public GifCaptchaExt() {
	}

	public GifCaptchaExt(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public GifCaptchaExt(int width, int height, int len) {
		this(width, height); // 宽度，高度
		this.len = len; // 验证码字符数量
	}

	public GifCaptchaExt(int width, int height, int len, char[] str) {

		this(width, height); // 宽度，高度
		this.len = len; // 验证码字符数量
		rands = str; // 需要生产的字符，必须是数字或者ASCII字符

	}

	public GifCaptchaExt(int width, int height, int len, Font font) {
		this(width, height, len);
		this.font = font;
	}

	@Override
	public void out(OutputStream os) {
		try {
			GifEncoder gifEncoder = new GifEncoder(); // gif编码类，这个利用了洋人写的编码类，所有类都在附件中
			// 生成字符
			gifEncoder.start(os);
			gifEncoder.setQuality(8);		//图像品质
			gifEncoder.setDelay(200);		//每个动画页持续时间，单位ms
			gifEncoder.setRepeat(0);
			BufferedImage frame;
			// char[] rands =alphas();
			// char[] rands =; //字符串自定义

			Color fontcolor[] = new Color[len];
			for (int i = 0; i < len; i++) {
				fontcolor[i] = new Color(20 + Randoms.num(110),
						20 + Randoms.num(110), 20 + Randoms.num(110));
			}
			for (int i = 0; i < len; i++) {
				frame = graphicsImage(fontcolor, rands, i);
				gifEncoder.addFrame(frame);
				frame.flush();
			}
			gifEncoder.finish();
		} finally {
			Streams.close(os);
		}

	}

	/**
	 * 画随机码图
	 * 
	 * @param fontcolor
	 *            随机字体颜色
	 * @param strs
	 *            字符数组
	 * @param flag
	 *            透明度使用
	 * @return BufferedImage
	 */
	private BufferedImage graphicsImage(Color[] fontcolor, char[] strs, int flag) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 或得图形上下文
		// Graphics2D g2d=image.createGraphics();
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		// 利用指定颜色填充背景
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		AlphaComposite ac3;
		int h = height - ((height - font.getSize()) >> 1);
		int w = width / len;
		g2d.setFont(font);
		for (int i = 0; i < len; i++) {
			
			ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					getAlpha(Randoms.num(flag+1), Randoms.num(i+1))); //使用随机透明度
			//ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
			//		getAlpha(flag, i));
			g2d.setComposite(ac3);
			g2d.setColor(fontcolor[i]);
			
			//g2d.setColor(fontcolor[Randoms.num(len)]); //色彩使用随机色彩
			g2d.drawOval(Randoms.num(width), Randoms.num(height),
					5 + Randoms.num(10), 5 + Randoms.num(10));
//			g2d.drawString(strs[i] + "",
//					(width - (len - i) * w) + (w - font.getSize()) + 1, h - 4);
			g2d.drawString(strs[i] +"",
					(width - (len - i) * w) + (w - font.getSize()) + Randoms.numZero(35), h - 4); //字体粘连

		}
		g2d.dispose();
		return image;
	}

	/**
	 * 获取透明度,从0到1,自动计算步长
	 * 
	 * @return float 透明度
	 */
	private float getAlpha(int i, int j) {
		int num = i + j;
		float r = (float) 1 / len, s = (len + 1) * r;
		return num > len ? (num * r - s) : num * r;
	}

}