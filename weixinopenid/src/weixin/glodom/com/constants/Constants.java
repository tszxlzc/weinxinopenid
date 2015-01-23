package weixin.glodom.com.constants;

public  class Constants {
	//获取code后，利用微信返回的code获取用户信息
	public static String oauth2Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	public static String APPID     = "wx0d5d37facf86f19d";
	public static String SECRET    = "df4961578c58e024f0b7e57aebddacab";
}
