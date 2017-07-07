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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

class EmailResults {

    //Frontline.QA.Email@gmail.com


    static void sendEmail(String filePath, String timeStamp) {

        // Home directory
        String filePathHome = FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Desktop/";

        // These are needed for the Email sending.
        //Created a new one for our QA team so that anybody can have access.
        final String username = "Frontline.QA.Email@gmail.com";
        final String password = "Frontline1";

        // Properties required for sending the email
        Properties props = new Properties();

        // making sure to have this values for our socketFactory class
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // setting the proper values to make sure we are using port '465'
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        // set socketFactory port to '465'
        props.setProperty("mail.smtp.socketFactory.port", "465");

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
            String recipientEmail = "AAnsari@flhi.com";
            // EMAIL RECIPIENT

            // Setting the recipients here.
            // Needs to change if we multiple users are requirec
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));

            message.setSubject("Testing Results " + timeStamp);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Test results from " + timeStamp);


            // Packing file for email
            File zippedScreensFile = new File(filePathHome + "ScreenShots.zip");

            // Path to our screens
//            String filePathScreens = FileSystemView.getFileSystemView().getHomeDirectory()
//                    .toString() + "target/ScreenShots";
            String filePathScreens = "target/ScreenShots";

            // Saves out to desktop a zipped folder that will be deleted upon sending
            File screenFile = new File(filePathScreens);
            File[] screenCount = screenFile.listFiles();
            int size = screenCount.length;
            if (size != 0 ) {
                ZipUtil.pack(new File(filePathScreens), zippedScreensFile);

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
				System.out.println("CSV Attached");
			}

			// Third attachment log file
			File logFile = new File("log.txt");
			if (logFile.exists()) {

				File zippedLogFile = new File("log.zip");
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zippedLogFile));
				ZipEntry e = new ZipEntry("log.txt");
				out.putNextEntry(e);
				out.closeEntry();
				out.close();
				String filePathLog = "log.zip";
				//ZipUtil.pack(new File(filePathLog), zippedLogFile);
                MimeBodyPart attachmentBodyPartLog = new MimeBodyPart();
                String fileNameLog = "log.zip";


                DataSource sourceLog = new FileDataSource(filePathLog);
                attachmentBodyPartLog.setDataHandler(new DataHandler(sourceLog));
                attachmentBodyPartLog.setFileName(fileNameLog);

                // add to our message
                multipart.addBodyPart(attachmentBodyPartLog);
				System.out.println("Log File Attached");
			}


            //Add message and attachments
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            //Delete new zip
            zippedScreensFile.delete();

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println("Error Sending mail: ");
            e.printStackTrace();
        }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
