package my.samples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Hello world!
 *
 */
public class App {

	public static String encode(String content) {
		try {
			Base64Encoder base64Content = new Base64Encoder(content.getBytes());
			return base64Content.processString().toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String decode(String content) {
		try {
			Base64Decoder base64Content = new Base64Decoder(content);
			return base64Content.processString();
		} catch (Base64FormatException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		System.out.println("Default Charset=" + Charset.defaultCharset());
		
		String strMsg1 = decode("IjJhKeWkluWMr+Wkp+WuouaItiAtIOKCrOiLsemOijogMjQg5bCP5pmC57eK6LK85Yyv5biCLOS4jeeuoeaXpeWknO+8jOWPquimgeeVtuWMr+WDueWIsOmBlOaCqOeahOaMh+WumuWDueS9jeaZgu+8jOaIkeWAkeS+v+acg+iHquWLleeCuuaCqOWft+ihjOmgkOWFiOioreWumueahOiyt+izo+aMh+ekuu+8jOWKqeaCqOaNleaNiSI=");
		System.out.println("strMsg1 = " + strMsg1);
		
		System.out.println("--------------------------");
		strMsg1 = "Sample Engligh Only Message";
		strMsg1 = encode(strMsg1);
		strMsg1 = decode(strMsg1);
		System.out.println("strMsg1 = " + strMsg1);
		byte[] byeArr1 = strMsg1.getBytes();
		strMsg1 = new String(byeArr1, Charset.forName("UTF-8"));
		System.out.println("strMsg1 = " + strMsg1);
		strMsg1 = encode(strMsg1);
		strMsg1 = decode(strMsg1);
		//strMsg1ConvertedBack = decode(strMsg1ConvertedBack);
		System.out.println("strMsg1 = " + strMsg1);

		System.out.println("--------------------------");
		String strMsg2 = "Sample Engligh Only Message";
		strMsg2 = encode(strMsg2);
		strMsg2 = decode(strMsg2);
		System.out.println("strMsg2 = " + strMsg2);
		byte[] byeArr2 = strMsg2.getBytes(Charset.forName("UTF-8"));
		strMsg2 = new String(byeArr2, Charset.forName("UTF-8"));
		System.out.println("strMsg2 = " + strMsg2);
		strMsg2 = encode(strMsg2);
		strMsg2 = decode(strMsg2);
		System.out.println("strMsg2 = " + strMsg2);
		

		System.out.println("-------------------------- Without any encoding ");
		String strMsg3 = "我的名字不是Rakesh";
		strMsg3 = encode(strMsg3);
		strMsg3 = decode(strMsg3);
		System.out.println("strMsg3 = " + strMsg3);
		byte[] byeArr3 = strMsg3.getBytes();
		strMsg3 = new String(byeArr3);
		System.out.println("strMsg3 = " + strMsg3);
		strMsg3 = encode(strMsg3);
		strMsg3 = decode(strMsg3);
		System.out.println("strMsg3 = " + strMsg3);

		System.out.println("--------------------------");
		strMsg3 = "我的名字不是Rakesh";
		System.out.println("strMsg3 = " + strMsg3);
		byeArr3 = strMsg3.getBytes();
		strMsg3 = new String(byeArr3);
		System.out.println("strMsg3 = " + strMsg3);
		strMsg3 = encode(strMsg3);
		strMsg3 = decode(strMsg3);
		System.out.println("strMsg3 = " + strMsg3);

		System.out.println("--------------------------");
		strMsg3 = "我的名字不是Rakesh";
		strMsg3 = encode(strMsg3);
		strMsg3 = decode(strMsg3);
		System.out.println("strMsg3 = " + strMsg3);
		byeArr3 = strMsg3.getBytes();
		strMsg3 = new String(byeArr3, Charset.forName("UTF-8"));
		System.out.println("strMsg3 = " + strMsg3);
		strMsg3 = encode(strMsg3);
		strMsg3 = decode(strMsg3);
		System.out.println("strMsg3 = " + strMsg3);

		System.out.println("-------------------------- With UtF-8 encoding");
		String strMsg4 = "我的名字不是Rakesh";
		strMsg4 = encode(strMsg4);
		//strMsg4 = decode(strMsg4);
		System.out.println("strMsg4 = " + strMsg4);
		byte[] byeArr4 = strMsg4.getBytes(Charset.forName("UTF-8"));
		String strMsg4ConvertedBack = new String(byeArr4, Charset.forName("UTF-8"));
		System.out.println("strMsg4ConvertedBack = " + strMsg4ConvertedBack);
		//strMsg4 = encode(strMsg4ConvertedBack);
		strMsg4 = decode(strMsg4);
		//strMsg4ConvertedBack = decode(strMsg4ConvertedBack);
		System.out.println("strMsg4 = " + strMsg4);

		
		System.out.println("-------------------------- With only ISO-8859-1 encoding");
		String strMsg5 = "我的名字不是Rakesh";
		System.out.println("strMsg5 = " + strMsg5);
		byte[] byeArr5 = strMsg5.getBytes(Charset.forName("ISO-8859-1"));
		strMsg5 = new String(byeArr5, Charset.forName("ISO-8859-1"));
		System.out.println("strMsg5 = " + strMsg5);


	}
}
