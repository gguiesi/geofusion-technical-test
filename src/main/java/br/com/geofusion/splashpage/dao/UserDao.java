package br.com.geofusion.splashpage.dao;

import br.com.geofusion.splashpage.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by guiesi on 9/14/16.
 */
public class UserDao {
	private final EntityManager entityManager;

	protected UserDao() {
		this(null);
	}

	@Inject
	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(User user) {
		entityManager.persist(user);
	}

	public User get(Long id) {
		return entityManager.find(User.class, id);
	}
}
