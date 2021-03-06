
package cs636.music.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cs636.music.domain.User;


public class UserDAO {
	
	private DbDAO dbdao;

	

	public UserDAO(DbDAO db) {
		dbdao = db;
	}
	

	public void insertUser(User user) {
		dbdao.getEM().persist(user);
	}
	

	public User findUserByEmail(String email) {
		EntityManager em = dbdao.getEM();
		TypedQuery<User> q = em.createQuery("select u from User u where u.emailAddress = '" + email + "'", User.class);
		List<User> user = q.getResultList();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}
	

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  