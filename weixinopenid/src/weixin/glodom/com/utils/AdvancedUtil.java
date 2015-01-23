package weixin.glodom.com.utils;




import net.sf.json.JSONObject;
import weixin.glodom.com.constants.Constants;
import weixin.glodom.com.weixin.WeiXinOauth2Token;

public class AdvancedUtil {
	public static WeiXinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WeiXinOauth2Token wat = new WeiXinOauth2Token();
        String requestUrl = Constants.oauth2Url.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
                try {
                        wat = new WeiXinOauth2Token();
                        wat.setAccessToken(jsonObject.getString("access_token"));
                        wat.setExpiresIn(jsonObject.getInt("expires_in"));
                        wat.setRefeshToken(jsonObject.getString("refresh_token"));
                        wat.setOpenId(jsonObject.getString("openid"));
                        wat.setScope(jsonObject.getString("scope"));
                } catch (Exception e) {
                        wat = null;
                        String errorCode = jsonObject.getString("errcode");
                        String errorMsg = jsonObject.getString("errmsg");
//                        log.error("获取网页授权凭证失败 errcode{},errMsg", errorCode, errorMsg);
                }

        }
        return wat;
	}
	
/*	public static void main(String[] args){
		AdvancedUtil util = new AdvancedUtil();
		AdvancedUtil.getOauth2AccessToken(Constants.APPID, Constants.SECRET, "123");
	}*/
}
