package weixin.glodom.com.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import weixin.glodom.com.constants.Constants;
import weixin.glodom.com.dao.WeixinUserDao;
import weixin.glodom.com.po.TaWeixinUser;
import weixin.glodom.com.utils.AdvancedUtil;
import weixin.glodom.com.weixin.WeiXinOauth2Token;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5797380411009490071L;
	private String openid;

	public String execute() throws ServletException, IOException{
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        String openId ="123";
        WeixinUserDao weixinUserDao = new WeixinUserDao();
        TaWeixinUser user = new TaWeixinUser();
        if (!"authdeny".equals(code)&&code!=null) {
                WeiXinOauth2Token weiXinOauth2Token = AdvancedUtil
                                .getOauth2AccessToken(Constants.APPID,Constants.SECRET, code);
                if(weiXinOauth2Token==null){
                	return "index";
                }
                openId = weiXinOauth2Token.getOpenId();
                user.setAccessToken(weiXinOauth2Token.getAccessToken());
                user.setExpiresIn(weiXinOauth2Token.getExpiresIn());
                user.setRefeshToken(weiXinOauth2Token.getRefeshToken());
                user.setScope(weiXinOauth2Token.getScope());
                user.setOpenId(openId);
                user.setRequest_time(new Date());
                weixinUserDao.addWeixinUser(user);
                request.getSession().setAttribute("openId", openId);
        }
        return "index";
	}
	
	public void checkLottery(){
		
	}
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
