package br.com.geofusion.splashpage.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.geofusion.splashpage.dao.UserDao;
import br.com.geofusion.splashpage.model.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.inject.Inject;

/**
 * Created by guiesi on 9/14/16.
 */
@Controller
public class EmailController {
	private final UserDao userDao;
	private final Mailer mailer;

	protected EmailController() {
		this(null, null);
	}

	@Inject
	public EmailController(UserDao userDao, Mailer mailer) {
		this.userDao = userDao;
		this.mailer = mailer;
	}

	public void send() throws EmailException {
		User user = userDao.get((long) 1);
		Email email = new SimpleEmail();
		email.setSubject("Your subject");
		email.addTo(user.getEmail());
		email.setMsg("clique no link" + user.getId());
		mailer.send(email);
	}
}
