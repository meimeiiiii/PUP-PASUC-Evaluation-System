package others;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class Mail{  	
	public static void main(String args[]) {
		try {
			System.out.println(Send("ieriznicolle@gmail.com","pupcores.19@gmail.com","impinitydobol",
					"PUP PASUC Evaluation: Email Verification","Test"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean Send(String toUser, String frUser, String frPsw, String subj, String msgBod) 
			throws AddressException, MessagingException {
	    Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
         
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(frUser, frPsw);
            }
        });
        try {
	        Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(frUser));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toUser));
	            message.setSubject(subj);
	            message.setText(msgBod);

            Transport.send(message);
            System.out.println("Mail sent successfully.");
	            
	        return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
	
//	public static boolean Send(String toUser, String frUser, String frPsw, String subj, String msgBod) throws AddressException,
//			MessagingException {
//		Properties emailProperties;
//		Session mailSession;
//		MimeMessage emailMessage;
//
//
//		// SET PROPERTIES
//		String emailPort = "587";//gmail's smtp port
//
//		emailProperties = System.getProperties();
//		emailProperties.put("mail.smtp.port", emailPort);
//		emailProperties.put("mail.smtp.auth", "true");
//		emailProperties.put("mail.smtp.starttls.enable", "true");
//		
//		
//		// CREATE EMAIL MSG
//		String[] toEmails = { toUser };
//
//		mailSession = Session.getDefaultInstance(emailProperties, null);
//		emailMessage = new MimeMessage(mailSession);
//
//		for (int i = 0; i < toEmails.length; i++) {
//			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
//		}
//
//		emailMessage.setSubject(subj);
//		//emailMessage.setContent(emailBody, "text/html");//for a html email
//		emailMessage.setText(msgBod);// for a text email
//
//		// SEND EMAIL
//		String emailHost = "smtp.gmail.com";
//
//		Transport transport = mailSession.getTransport("smtp");
//
//		transport.connect(emailHost, frUser, frPsw);
//		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
//		transport.close();
//		System.out.println("Email sent successfully.");
//		
//		return true;
//		
//	}
//	
	
//	public static boolean Send(String user, String password, String text, String subject) {  
//  
//  String host="smtp.gmail.com"; 
//    
//  String to="louisa.may05@gmail.com";//change accordingly  
//  
//   //Get the session object  
//   Properties props = new Properties();  
//   props.put("mail.smtp.host",host);  
//   props.put("mail.smtp.auth", "true");  
//     
//   Session session = Session.getDefaultInstance(props,  
//    new javax.mail.Authenticator() {  
//      protected PasswordAuthentication getPasswordAuthentication() {  
//    return new PasswordAuthentication(user,password);  
//      }  
//    });  
//  
//    try {  
//     MimeMessage message = new MimeMessage(session);  
//     message.setFrom(new InternetAddress(user));  
//     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
//     message.setSubject(subject);  
//     message.setText(text);  
//       
//    //send the message  
//     Transport.send(message);  
//  
//     System.out.println("message sent successfully...");  
//     
//     return true;
//   
//     } catch (MessagingException e) {e.printStackTrace(); return false;}  
// }  

