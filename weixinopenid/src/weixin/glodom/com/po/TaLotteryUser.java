package weixin.glodom.com.po;

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
@Table(name = "ta_lottery_user")
public class TaLotteryUser {

	private int id;
	private String user_openid;
	private Date lottery_time;
	
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
	
	@Column(name = "user_openid",length = 40)
	public String getUser_openid() {
		return user_openid;
	}
	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lottery_time", length = 19)
	public Date getLottery_time() {
		return lottery_time;
	}
	public void setLottery_time(Date lottery_time) {
		this.lottery_time = lottery_time;
	}
	
	
}
