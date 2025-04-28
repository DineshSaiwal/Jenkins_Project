package Base_Package;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.*;

public class Java_Mail extends Base_Class{
	

@SuppressWarnings("deprecation")
public static void sendmail() throws EmailException {
	
				Date date = new Date();
				SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MMM kk:mm");
				String formattedDate = Date_Format.format(date);
				
			  EmailAttachment attachment = new EmailAttachment();
			  attachment.setPath( userdir + "/Reports/Automation_Report.html");
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("TestReport"+" "+formattedDate+".html");
			  attachment.setName("TestReport");
			  
			
			  MultiPartEmail email = new MultiPartEmail();
			  email.setHostName("mail.aptagrim.co");
			  email.setSmtpPort(465);
			  email.setAuthenticator(new DefaultAuthenticator("support@aptagrim.co", "Abcd.1234"));
			  email.setSSLOnConnect(true);
			  email.setTLS(true);
			  email.setFrom("support@aptagrim.co");
			  email.setSubject("Test Automation Report CI/CD"+" "+formattedDate);
			
		      String signature = "\n\nBest regards,\nDinesh (QA Engg)";
		      
		     
		     
			  email.addTo("dinesh.saiwal@aptagrim.com");

			  email.setMsg(result+signature);
			  email.attach(attachment);
			  
			  try {email.send();
				System.out.println("************************* Email Sent Successfully *****************************");} 
			catch (Exception e) {
				System.out.println("************************* Failed to send email.*************************");
				e.printStackTrace();}
  
}}