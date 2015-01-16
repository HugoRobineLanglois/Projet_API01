package com.UTC.BooksMatching.Beans;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.UTC.BooksMatching.dao.AppConfigDAO;

public class MailSendingManager {
	private String from;
	private String host;
	private String port;
	private String username;
	private String password;
	private String protocol;
	
	public MailSendingManager(){
		
		AppConfigDAO appconfig = new AppConfigDAO();
		Map<String, String> mailSettings = appconfig.getMailSettings();
		from = mailSettings.get("email");
		host = mailSettings.get("host");
		port = mailSettings.get("port");
		username = mailSettings.get("username");
		password = mailSettings.get("password");
		protocol = mailSettings.get("protocol");
	}
	public void sendMail(String to, String subject, String body) throws Exception{
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port",port);
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, null);
		session.setDebug(true);
		Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));
	    InternetAddress[] address = {new InternetAddress(to)};
	    message.setRecipients(Message.RecipientType.TO, address);
	    message.setSubject(subject);
	    message.setContent(body, "text/html");
	    Transport transport = session.getTransport(protocol);
	    transport.connect(host, username, password);
	    transport.sendMessage(message, message.getAllRecipients());
	}
}
