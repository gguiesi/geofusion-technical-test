package br.com.geofusion.splashpage.observer;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.geofusion.splashpage.model.User;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by guiesi on 9/15/16.
 */
@Dependent
public class InitialDataObserver {
	private EntityManagerFactory factory;

	@Inject
	public InitialDataObserver(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void insert(@Observes VRaptorInitialized event) {
		EntityManager entityManager = null;

		try {
			entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();

			User defaultUser = new User();
			defaultUser.setEmail("default@email.com");
			defaultUser.setName("Splashpage default user");

			User user = entityManager.find(User.class, (long)1);

			if (user == null) {
				entityManager.persist(defaultUser);
			}

			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}
