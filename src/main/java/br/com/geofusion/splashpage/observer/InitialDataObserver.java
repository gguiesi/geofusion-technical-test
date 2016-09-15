package br.com.geofusion.splashpage.observer;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.geofusion.splashpage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger logger = LoggerFactory.getLogger(InitialDataObserver.class);
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

			logger.info("verify if default user already exists");
			User user = entityManager.find(User.class, (long)1);

			if (user == null) {
				logger.info("persiste default user: " + defaultUser.toString());
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
