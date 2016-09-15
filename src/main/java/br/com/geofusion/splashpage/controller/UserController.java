package br.com.geofusion.splashpage.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.geofusion.splashpage.dao.UserDao;
import br.com.geofusion.splashpage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by guiesi on 9/14/16.
 */
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final Validator validator;
	private final Result result;
	private final UserDao userDao;

	protected UserController() {
		this(null, null, null);
	}

	@Inject
	public UserController(Validator validator, Result result, UserDao userDao) {
		this.validator = validator;
		this.result = result;
		this.userDao = userDao;
	}

	@Consumes(value="application/json", options=WithoutRoot.class)
	@Post("/user")
	public void add(User user) {
		logger.info("persiste user: ", user);
		userDao.add(user);
		// send email
		result.use(Results.json()).withoutRoot().from(user).recursive().serialize();
	}

	public void success() {
	}
}

