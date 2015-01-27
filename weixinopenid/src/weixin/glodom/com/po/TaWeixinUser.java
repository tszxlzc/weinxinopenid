package weixin.glodom.com.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="ta_weixin_user")
public class TaWeixinUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6086185680034019820L;
	private int id;
	private String accessToken;
    private String openId;
	private Date request_time;
	private int expiresIn;
	private String refeshToken;
	private String scope;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "accessToken", length = 150)
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Column(name = "openId", length = 40)
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "request_time", length = 19)
	public Date getRequest_time() {
		return request_time;
	}
	public void setRequest_time(Date request_time) {
		this.request_time = request_time;
	}
	
	@Column(name = "expiresIn", length = 11)
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	@Column(name = "refeshToken", length = 150)
	public String getRefeshToken() {
		return refeshToken;
	}
	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}
	
	@Column(name = "scope", length = 50)
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

}
