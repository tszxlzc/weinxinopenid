package weixin.glodom.com.utils;

import java.io.UnsupportedEncodingException;

public class urlEncode{
	public static void main(String[] args){
		String url = "http://192.168.75.34:8080/weixinopenid/index";
		String urlEncoded = urlEncodeUTF8(url);
		System.out.println(urlEncoded);
	}
	public static String urlEncodeUTF8(String source){
        String result = source;
        try {
                result = java.net.URLEncoder.encode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
        }
        return result;
	}
}
