package br.com.geofusion.splashpage.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.geofusion.splashpage.dao.UserDao;
import br.com.geofusion.splashpage.model.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 * Created by guiesi on 9/14/16.
 */
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	public static final String EMAIL_CONTENT = "Please, answers some questions to help the development of our bike\n " +
			"http://localhost:8080/splashpage/web-form?userId=";

	private final Validator validator;
	private final Result result;
	private final UserDao userDao;
	private final Mailer mailer;

	protected UserController() {
		this(null, null, null, null);
	}

	@Inject
	public UserController(Validator validator, Result result, UserDao userDao, Mailer mailer) {
		this.validator = validator;
		this.result = result;
		this.userDao = userDao;
		this.mailer = mailer;
	}

	@Consumes(value="application/json", options=WithoutRoot.class)
	@Post("/user")
	public void add(@NotNull User user) {
		validator.onErrorSendBadRequest();
		logger.info("persiste user: " + user.toString());
		userDao.add(user);
		// send email
		sendEmail(user);
		result.use(Results.json()).withoutRoot().from(user).recursive().serialize();
	}

	public void success() {
	}

	private void sendEmail(User user) {
		try {
			Email email = new SimpleEmail();
			email.setSubject("Welcome");
			email.addTo(user.getEmail());
			email.setMsg(EMAIL_CONTENT + user.getId());
			logger.info("send email to: " + user.toString());
			mailer.send(email);
		} catch (EmailException e) {
			logger.error("Error on send email: " + e.getMessage());
		}
	}
}

