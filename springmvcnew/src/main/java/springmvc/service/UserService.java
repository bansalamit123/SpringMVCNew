package springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.model.User;
import springmvc.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	/* Writing mode allowed using @Transaction */
	@Transactional
	public int createUser(User user) {
		return this.userDao.saveUser(user);

	}

}
