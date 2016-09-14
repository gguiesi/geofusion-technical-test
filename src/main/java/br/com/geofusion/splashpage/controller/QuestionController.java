package br.com.geofusion.splashpage.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.geofusion.splashpage.dao.QuestionDao;
import br.com.geofusion.splashpage.dao.UserDao;
import br.com.geofusion.splashpage.model.Question;
import br.com.geofusion.splashpage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by guiesi on 9/14/16.
 */
@Controller
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	private final QuestionDao questionDao;
	private final UserDao userDao;

	protected QuestionController() {
		this(null, null);
	}

	@Inject
	public QuestionController(QuestionDao questionDao, UserDao userDao) {
		this.questionDao = questionDao;
		this.userDao = userDao;
	}

	@Consumes(value="application/json", options=WithoutRoot.class)
	@Post("/question")
	public void add(Question question) {
		logger.info("persiste question: ", question);
		User user = userDao.get(question.getUserId());
		question.setUser(user);
		questionDao.add(question);
	}
}
