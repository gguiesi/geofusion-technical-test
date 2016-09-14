package br.com.geofusion.splashpage.dao;

import br.com.geofusion.splashpage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by guiesi on 9/14/16.
 */
public class UserDao {
	Logger logger = LoggerFactory.getLogger(UserDao.class);

	private final EntityManager entityManager;

	protected UserDao() {
		this(null);
	}

	@Inject
	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(User user) {
		logger.info("add user:", user);
		entityManager.persist(user);
	}

	public User get(Long id) {
		logger.info("get user by id:", id);
		return entityManager.find(User.class, id);
	}

	public List<User> listAll() {
		return entityManager.createQuery("select u from user u", User.class).getResultList();
	}
}
