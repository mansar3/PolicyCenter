package Helpers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.testng.Assert;

import java.io.*;

/**
 * Created by aansari on 6/1/17.
 */
public class FTPConnector
{
	public void connector(String filePath,String remoteFile)
	{
		String server = "10.50.50.150";
        int port = 21;
        String user = "donquixote";
        String pass = "donkeypee";

        FTPClient ftpClient = new FTPClient();

        try {

            ftpClient.connect(server, port);
            Assert.assertTrue(ftpClient.login(user, pass),"Login was unsuccessfull");
			System.out.println("Login Sucessfull.");
			ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File(filePath);

            String firstRemoteFile = firstLocalFile.getName();
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile("www/" + firstRemoteFile, inputStream);
            inputStream.close();
			if(done)
			{
				System.out.println("The file is uploaded successfully.");
			}
			else
			{
				System.out.println(ftpClient.getReplyString());
				Assert.fail("File Failed to upload to server");
			}


        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

}
