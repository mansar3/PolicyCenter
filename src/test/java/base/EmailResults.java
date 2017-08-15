package base;

import org.zeroturnaround.zip.ZipUtil;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Properties;

/**
 * Created by ajmac on 4/25/17.
 */

    /* IMPORTANT NOTE
    *  Using Dependency Java Mail : ****1.4.7****
    *  Using Maven library 'zeroturnaround:zt-zip:1.8' ZIP convenience methods
    *  Was getting warning that “No appenders could be found for logger (org.zeroturnaround.zip.ZipUtil)”
    *  "No defualt configuration files for log4j.properties and log4j.xml
    *  can be found and the application performs no explicit configuration", but I believe we have them set in our project!
    *  SIDE NOTE:
    *  I believe our project uses slf4j:1.7.2  Log and Api
    *  so the version of zeroturnaround should not have any slf4j issues
    *  */

class EmailResults extends BaseTest{

    //Frontline.QA.Email@gmail.com


    static void sendEmail(String filePath, String timeStamp) {

        // Home directory
        String filePathHome = FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Desktop/";

        // These are needed for the Email sending.
        //Created a new one for our QA team so that anybody can have access.
        final String username = "ConversionRenewals@fpic.net";
        final String password = "Fr0nt@2#7$8";

        // Properties required for sending the email
        Properties props = new Properties();

        // making sure to have this values for our socketFactory class
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // setting the proper values to make sure we are using port '465'
        props.setProperty("mail.smtp.host", "flhicas1.fpic.net");
        //props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "true");
        props.setProperty("mail.smtp.port", "25");
        // set socketFactory port to '465'
        props.setProperty("mail.smtp.socketFactory.port", "25");

        // place our old values in properties like normal!
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");

        // Authentication
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Creating message here
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));

            // EMAIL RECIPIENT

            String recipientEmail;
            if(prod)
				recipientEmail = "AAnsari@flhi.com,kgeist@flhi.com,mcoad@flhi.com,kbabroski@flhi.com,JCarlos@flhi.com";
			else
            	recipientEmail= "AAnsari@flhi.com";

            // EMAIL RECIPIENT

            // Setting the recipients here.
            // Needs to change if we multiple users are requirec
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));



            Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            if(prod)
			{
				message.setSubject("PROD Renewal Run " + timeStamp);
				messageBodyPart.setText("PROD Renewal Test results from " + timeStamp);
			}
			else
			{
				message.setSubject("Staging Renewal Run " + timeStamp);
				messageBodyPart.setText("Staging Renewal Test results from " + timeStamp);
			}
            // Packing file for email
            File zippedScreensFile = new File(filePathHome + "ScreenShots" + timeStamp + ".zip");

            // Path to our screens
//            String filePathScreens = FileSystemView.getFileSystemView().getHomeDirectory()
//                    .toString() + "target/ScreenShots";
            String filePathScreens = "target/ScreenShots";

            // Saves out to desktop a zipped folder that will be deleted upon sending
            File screenFile = new File(filePathScreens);
            File[] screenCount = screenFile.listFiles();
            int size = screenCount.length;
            if (size != 0 ) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~	Zipping ScreenShots	  ~~~~~~~~~~~~~~~~~~~~~~~~~~");
				ZipUtil.pack(new File(filePathScreens), zippedScreensFile);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~	Screenshots have been zipped	~~~~~~~~~~~~~~~~~~~~~~~~~~");
				if(!prod)
				{
					// now create this segment
					// First attachment here (Screens)
					MimeBodyPart attachmentBodyPartScreens = new MimeBodyPart();

					String fileName = filePath + ".zip";
					DataSource source = new FileDataSource(zippedScreensFile);
					attachmentBodyPartScreens.setDataHandler(new DataHandler(source));
					attachmentBodyPartScreens.setFileName(fileName);

					//add the attachment

					multipart.addBodyPart(attachmentBodyPartScreens);
					System.out.println("Screenshots Attached");
				}
			}



            // Second attachment CSV
            File csvFile = new File(filePath);
            if (csvFile.exists()) {
                MimeBodyPart attachmentBodyPartCSV = new MimeBodyPart();
                String fileNameCSV = "TestResult_CSV.csv";

                String csvPath = filePath;
                DataSource sourceCsv = new FileDataSource(csvPath);
                attachmentBodyPartCSV.setDataHandler(new DataHandler(sourceCsv));
                attachmentBodyPartCSV.setFileName(fileNameCSV);

                // add to our message
                multipart.addBodyPart(attachmentBodyPartCSV);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~		CSV Attached	  ~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}

			// Third attachment log file
//			if(!prod)
//			{
//				File logFile = new File("log.txt");
//				if(logFile.exists())
//				{
//					System.out.println("Log file found");
//					File zippedLogFile = new File("log.zip");
//					ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zippedLogFile));
//					ZipEntry e = new ZipEntry("log.txt");
//					out.putNextEntry(e);
//					out.closeEntry();
//					out.close();
//					String filePathLog = "log.zip";
//					//ZipUtil.pack(new File(filePathLog), zippedLogFile);
//					MimeBodyPart attachmentBodyPartLog = new MimeBodyPart();
//					String fileNameLog = "log.zip";
//
//
//					DataSource sourceLog = new FileDataSource(filePathLog);
//					attachmentBodyPartLog.setDataHandler(new DataHandler(sourceLog));
//					attachmentBodyPartLog.setFileName(fileNameLog);
//
//					// add to our message
//					multipart.addBodyPart(attachmentBodyPartLog);
//					System.out.println("Log File Attached");
//				}
//			}


            //Add message and attachments
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            //Delete new zip
//            zippedScreensFile.delete();

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println("Error Sending mail: ");
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
