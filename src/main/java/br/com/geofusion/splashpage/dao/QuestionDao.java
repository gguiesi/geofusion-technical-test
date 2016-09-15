package br.com.geofusion.splashpage.dao;

import br.com.geofusion.splashpage.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by guiesi on 9/14/16.
 */
public class QuestionDao {
	private static final Logger logger = LoggerFactory.getLogger(QuestionDao.class);

	private final EntityManager entityManager;

	protected QuestionDao() {
		this(null);
	}

	@Inject
	public QuestionDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(Question question) {
		logger.info("add question" + question.toString());
		entityManager.persist(question);
	}

	public List<Question> listAll() {
		return entityManager.createQuery("select q from Music q", Question.class).getResultList();
	}
}
