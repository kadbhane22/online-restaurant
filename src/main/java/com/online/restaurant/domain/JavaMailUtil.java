//package com.online.restaurant.domain;
//
//
//
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.websocket.Session;
//
//import org.apache.logging.log4j.message.Message;
//import org.springframework.boot.rsocket.server.RSocketServer.Transport;
//
//
//public class JavaMailUtil {
//	static String myAccountEmail;
//	static String password;
//	static String notifiactionMessages;
//	public static void sendMail(String recepient) throws Exception
//	{
//		System.out.println("Prepring the send Email");
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth","true");
//		properties.put("mail.smtp.starttls.enable","true");
//		properties.put("mail.smtp.host","smtp.gmail.com");
//		properties.put("mail.smtp.port","587");
//		
//		myAccountEmail="sangramyadav9617@gmail.com";			// put your email
//		password="9011262284@123";								// here password
//		Session session = Session.getInstance(properties, new Authenticator()
//				{
//
//				@Override
//				protected PasswordAuthentication getPasswordAuthentication()
//				{
//					return new PasswordAuthentication(myAccountEmail,password);
//				}
//				
//			
//			
//				});
//		
//		Message message = preparedMessage(session,myAccountEmail,recepient);
//		Transport.send(message);
//		System.out.println("Email Send Successfully");
//	
//	}
//	
//	
//	private static Message preparedMessage(Session session , String myAccountEmail,String recepient)
//	{
//		
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(myAccountEmail));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//			message.setSubject("Order Notifiaction");
//			message.setText(notifiactionMessages);
//			return message;
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		return null;
//	}
//	
//	@SuppressWarnings("static-access")
//	public void mail(String notifiactionMessages,String email)
//	{
//		this.notifiactionMessages=notifiactionMessages;
//		try {
//			sendMail(email);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//}
//
