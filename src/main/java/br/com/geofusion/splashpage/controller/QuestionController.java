package br.com.geofusion.splashpage.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
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

	private final Result result;
	private final QuestionDao questionDao;
	private final UserDao userDao;

	protected QuestionController() {
		this(null, null, null);
	}

	@Inject
	public QuestionController(Result result, QuestionDao questionDao, UserDao userDao) {
		this.result = result;
		this.questionDao = questionDao;
		this.userDao = userDao;
	}
	
	private User getUser(Question question) {
		final User defaultUser = userDao.get((long) 1);
		User user = null;
		if (question.getUserId() != null) {
			user = userDao.get(question.getUserId());
		}
		if (user != null && user.getId() != 1) {
			return user;
		} else {
			logger.info("using default user: ", defaultUser);
			return defaultUser;
		}
	}

	@Consumes(value="application/json", options=WithoutRoot.class)
	@Post("/question")
	public void add(Question question) {
		logger.info("persiste question: ", question);
		User user = getUser(question);
		question.setUser(user);
		questionDao.add(question);
//		result.use(Results.http()).setStatusCode(200);
		result.use(Results.json()).withoutRoot().from(question).recursive().serialize();
	}
}
