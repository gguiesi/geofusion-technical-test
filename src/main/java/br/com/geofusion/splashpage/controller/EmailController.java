package br.com.geofusion.splashpage.controller;

//import br.com.caelum.vraptor.Controller;
//import br.com.caelum.vraptor.Get;
//import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.environment.Environment;
//import br.com.caelum.vraptor.simplemail.AsyncMailer;
//import br.com.caelum.vraptor.validator.Validator;
//import br.com.geofusion.splashpage.model.User;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by guiesi on 9/14/16.
 */
//@Controller
public class EmailController {
//	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
//
//	private final Validator validator;
//	private final Result result;
//	private final AsyncMailer mailer;
//	private final Environment environment;
//
////	protected EmailController() {
////		this(null, null, null, null);
////	}
//
////	@Inject
//	public EmailController(Validator validator, Result result, AsyncMailer mailer, Environment environment) {
//		this.validator = validator;
//		this.result = result;
//		this.mailer = mailer;
//		this.environment = environment;
//	}
//
////	@Get("/email")
//	public void sendEmail(User user) throws EmailException {
//		System.out.println(environment.get("email"));
//		Email email = new SimpleEmail();
//		email.setSubject("subject");
//		email.addTo(user.getEmail());
//		email.setMsg("message");
//		mailer.asyncSend(email);
//		logger.info("send email to: ", user.getEmail());
//	}
}
