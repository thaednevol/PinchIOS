package com.ach.sop.utility.biz.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.ach.common.biz.model.EmailVO;

public class MailSender {

	private static final String MAIL_PROTOCOL = "mail.transport.protocol";
	private static final String MAIL_SMTP_HOST = "mail.host";

	private static final String MAIL_SMTP_PORT = "mail.smtp.port";
	private static final String MAIL_SMTPS_PORT = "mail.smtps.port";

	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_SMTPS_AUTH = "mail.smtps.auth";
	
	static int seq = 0;

	private static final Logger logger = Logger.getLogger(MailSender.class.getName());
	
	public static void sendMail(final EmailVO email) {
		final String host = email.getServerName();  
		final String user = email.getUsernameAuthentication();  
		final String password = email.getPasswordAuthentication();
		final String port = email.getServerPort();
				
		boolean useTls = email.isUseTLS();
		boolean useSsl = email.isUseSSL();
		boolean authentication = email.isServerRequiredAuthentication();
		String from = email.getFromAddress();
		String debug = "true";
		
		/*final String host="smtp.gmail.com";  
		final String user="jegutierrezl@gmail.com";  
		final String password="xxxxxxxxxxxx";
		final String port = "587";
				
		String useTls = "true";
		String useSsl = "false";
		String authentication = "true";*/
		  
		//Get the session object  
		final Properties emailProperties = new Properties();
		
		javax.mail.Session mailSession = null;

		emailProperties.setProperty("mail.transport.protocol", "smtp");
		emailProperties.setProperty("mail.host", host);
		emailProperties.put("mail.smtp.port", port);
		emailProperties.put("mail.smtp.starttls.enable", ""+useTls);
		
					
		if ( useSsl ) {
			emailProperties.put("mail.smtp.ssl", "true");
			emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		}

		emailProperties.put("mail.debug", debug);

		try {

			if (authentication) {			
				emailProperties.put("mail.smtp.auth", "true");
				emailProperties.put("mail.smtps.auth", "true");
				mailSession = (javax.mail.Session)javax.mail.Session.getInstance(emailProperties,new javax.mail.Authenticator() {
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(user, password);
			        }
			    });
			} else {
				mailSession = (javax.mail.Session)javax.mail.Session.getInstance(emailProperties);
			}
			  
			  
			final MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(email.getFromAddress()));
			for ( String to:email.getToAddresses() ){
				msg.addRecipients(Message.RecipientType.TO,to);
			}			
			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(email.getText(), EmailVO.HTML_CONTENT_TYPE);
			final Collection<MimeBodyPart> parteMensaje = new ArrayList<MimeBodyPart>();
			parteMensaje.add(mbp);

			// verificar si el mensaje contiene archivos adjuntos que enviar
			if (email.getArchivosAdjuntos() != null) {
				logger.debug("El mensaje contiene archivos adjuntos");
				FileDataSource fds = null;
				for (File file : email.getArchivosAdjuntos()) {
					mbp = new MimeBodyPart();
					// attach the file to the message
					if (file.exists()) {
						fds=new FileDataSource(file);
						mbp.setDataHandler(new DataHandler(fds));
						mbp.setFileName(fds.getName());
						parteMensaje.add(mbp);
					}
				}
			}

//			if(email.isAgregarLogo()){
//				mbp.setHeader("Content-ID","logoImage");
//			}
				
			final Multipart mp = new MimeMultipart();

			for (MimeBodyPart mbpEnC : parteMensaje) {
				mp.addBodyPart(mbpEnC);
			}
			
			if(email.isIncluirLogo() && email.getRutaLogo()!=null){
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.attachFile(email.getRutaLogo());
				imagePart.setContentID("<"+email.getCid()+">");
				imagePart.setDisposition(MimeBodyPart.INLINE);
				mp.addBodyPart(imagePart);
			}


			msg.setContent(mp);
			logger.debug("Transport.send(msg);");
			Transport.send(msg);
			logger.debug("ENVIADO Transport.send(msg);");
		} catch (Exception e) {
			logger.debug("NO ENVIADO Transport.send(msg);");
			logger.error("NO ENVIADO Transport.send(msg);",e);
		} 
	}

	/*public static void sendMail(final EmailVO email) {
		Session session = null;
		try {
			logger.debug(new StringBuilder("Send Mail [").append(email).append("]"));

			final Properties emailProperties = new Properties();

			emailProperties.setProperty(MAIL_PROTOCOL, "smtp");
			emailProperties.setProperty(MAIL_SMTP_HOST, email.getServerName());

			if (email.isUseTLS()) {
				emailProperties.put(MAIL_SMTPS_PORT, email.getServerPort());
			} else {
				emailProperties.put(MAIL_SMTP_PORT, email.getServerPort());
			}

			if (email.isUseTLS()) {
				emailProperties.put("mail.smtps.socketFactory.port", email.getServerPort());
				emailProperties.put("mail.smtps.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				emailProperties.put("mail.smtps.socketFactory.fallback","false");
			}
			
			if (email.isUseSSL()) {
				emailProperties.put("mail.smtp.ssl", "true");
				emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		    }

			emailProperties.setProperty("mail.smtps.quitwait", "false");

			emailProperties.put("mail.debug", "false");

			final Collection<MimeBodyPart> parteMensaje = new ArrayList<MimeBodyPart>();

			if (email.isServerRequiredAuthentication()) {
				final EmailAuthenticator emailAuthenticator = new EmailAuthenticator(email.getUsernameAuthentication(), email.getPasswordAuthentication());
				emailProperties.put(MAIL_SMTP_AUTH, "true");
				emailProperties.put(MAIL_SMTPS_AUTH, "true");
				session = (Session) Session.getInstance(emailProperties,emailAuthenticator);
			} else {
				session = (Session) Session.getInstance(emailProperties);
			}

			final MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFromAddress()));
			msg.addRecipients(Message.RecipientType.TO,converArrayToAddress(email.getToAddresses()));
			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(email.getText(), EmailVO.HTML_CONTENT_TYPE);

			parteMensaje.add(mbp);

			// verificar si el mensaje contiene archivos adjuntos que enviar
			if (email.getArchivosAdjuntos() != null) {
				logger.debug("El mensaje contiene archivos adjuntos");
				FileDataSource fds = null;
				for (File file : email.getArchivosAdjuntos()) {
					mbp = new MimeBodyPart();
					// attach the file to the message
					if (file.exists()) {
						fds=new FileDataSource(file);
						mbp.setDataHandler(new DataHandler(fds));
						mbp.setFileName(fds.getName());
						parteMensaje.add(mbp);
					}
				}
			}

//			if(email.isAgregarLogo()){
//				mbp.setHeader("Content-ID","logoImage");
//			}
				
			final Multipart mp = new MimeMultipart();

			for (MimeBodyPart mbpEnC : parteMensaje) {
				mp.addBodyPart(mbpEnC);
			}
			
			if(email.isIncluirLogo() && email.getRutaLogo()!=null){
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.attachFile(email.getRutaLogo());
				imagePart.setContentID("<"+email.getCid()+">");
				imagePart.setDisposition(MimeBodyPart.INLINE);
				mp.addBodyPart(imagePart);
			}


			msg.setContent(mp);
			logger.debug("Transport.send(msg);");
			Transport.send(msg);
			logger.debug("ENVIADO Transport.send(msg);");
		} catch (Exception e) {
			logger.debug("NO ENVIADO Transport.send(msg);");
			logger.error(new StringBuilder("Error enviando mensaje[").append(
					email).append("]"), e);
		}
	}

	private static Address[] converArrayToAddress(final Collection<String> mails)
			throws Exception {
		InternetAddress internetAddress = null;
		Address toDirs[] = new Address[mails.size()];

		for (int i = 0; i < mails.size(); i++) {
			try {
				internetAddress = new InternetAddress(((ArrayList<String>)mails).get(i));
				toDirs[i] = internetAddress;
			} catch (AddressException e) {
				throw new SystemException(e);
			}
		}
		return toDirs;
	}
	
	/**
	   * Sequence goes from 0 to 100K, then starts up at 0 again.  This is large enough, 
	   * and saves
	   * @return
	   */
	  
	 
}
