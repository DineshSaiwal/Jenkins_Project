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
			  attachment.setPath(reportPath);
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("Execution Report"+" "+formattedDate+".html");
			  attachment.setName("TestReport");
			  
			
			  MultiPartEmail email = new MultiPartEmail();
			  email.setHostName("Host");
			  email.setSmtpPort("Port No");
			  email.setAuthenticator(new DefaultAuthenticator("Mail", "Abcd.1234"));
			  email.setSSLOnConnect(true);
			  email.setTLS(true);
			  email.setFrom("Mail");
			  email.setSubject("bidPlan Automation Report_"+" "+formattedDate);
			
		      String signature = "\n\nBest regards,\n Dinesh Saiwal";
		      
		     
		     
			  email.addTo("dineshsaiwal@gmail.com");


			  email.setMsg(result+signature);
			  email.attach(attachment);
			  
			  try {email.send();
				System.out.println("************************* Email Sent Successfully *****************************");} 
			catch (Exception e) {
				System.out.println("************************* Failed to send email. *************************");
				e.printStackTrace();}
  
}}
