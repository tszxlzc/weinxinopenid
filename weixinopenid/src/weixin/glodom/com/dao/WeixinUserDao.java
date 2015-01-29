package weixin.glodom.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import weixin.glodom.com.po.TaWeixinUser;

@SuppressWarnings("deprecation")
public class WeixinUserDao {

	public void addWeixinUser(TaWeixinUser user){
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}
