package Helpers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by afilizzola on 5/10/17.
 */
public class MountUtil
{
	public enum Folder
	{
		CSV, CONTROL_FILE
	}


    static String username;
    static String password;
    static String address;
    static String homeFolder = System.getenv("HOME");
    static String smbFolder;
    static String mountFolder;
    static String workingFolder;

	private static void setCredentials(Folder folder)
	{
		switch(folder)
		{
			case CONTROL_FILE:
				username = "gwtest";
				password = "Frontline123";
				address = "10.50.50.157";
				smbFolder = "/AutoRenewalProject";
				mountFolder = homeFolder + "/AutoRenewalProject/";
				workingFolder = mountFolder;
				break;
			case CSV:
				username = "gwconversionrenewals";
				password = "ThD605Cz";
				address = "10.50.50.116";
				smbFolder = "/croutput";
				mountFolder = homeFolder + "/AutoRenewalProjectTest/";
				workingFolder = mountFolder;
		}
	}
    public static String mountSharedFolder(boolean controlFile)
    {
    	if(!SystemUtils.IS_OS_LINUX)
		{
			try
			{
				if(!controlFile)
				{
					unMountSharedFolder(false);
					setCredentials(Folder.CSV);

				}

				else
				{
					unMountSharedFolder(true);
					setCredentials(Folder.CONTROL_FILE);

				}

				Process p1 = Runtime.getRuntime().exec("/bin/mkdir -p " + mountFolder);
				p1.waitFor();

				String connString = "/sbin/mount_smbfs " + "//" + username + ":" + password + "@" + address + smbFolder + " " + mountFolder;
				Process p2 = Runtime.getRuntime().exec(connString);
				p2.waitFor();

				System.out.println("Beginning mounting process..");
				return mountFolder;

			}
			catch(IOException | InterruptedException e)
			{
				System.out.println("~~~~~~~~~~~~~Could not mount folder~~~~~~~~~~~~~~`");
				System.out.println(e.getStackTrace());
			}

		}
		else
		{
			if(!controlFile)
			{
				setCredentials(Folder.CSV);
				System.out.println("CSV Mounted folder is: " + mountFolder);
			}
			else
			{
				setCredentials(Folder.CONTROL_FILE);
				System.out.println("Control File Mounted folder is: " + mountFolder);
			}

		}

			return mountFolder;
    }

	public static void unMountSharedFolders()
	{
		unMountSharedFolder(true);
		unMountSharedFolder(false);
	}
    public static void unMountSharedFolder(boolean controlFileFolder)
    {
        try
		{
			if(!controlFileFolder)
			{
				setCredentials(Folder.CSV);
				Process p2 = Runtime.getRuntime().exec(new String[]{"umount", mountFolder});
				p2.waitFor();
			}
			else
			{
				setCredentials(Folder.CONTROL_FILE);
				Process p2 = Runtime.getRuntime().exec(new String[]{"umount", mountFolder});
				p2.waitFor();
			}
			System.out.println("mountFolder: " + mountFolder);
			System.out.println("workingFolder: " + workingFolder);
        }
        catch (InterruptedException|IOException e)
        {
            System.out.println(e.getStackTrace());
        }
        System.out.println("mountFolder: " + mountFolder);
        System.out.println("workingFolder: " + workingFolder);
    }
	public static void moveXML(String currentDir, String destDir)
	{
		try
		{
			System.out.println("Copying file(s) to: " + destDir);
			FileUtils.copyDirectory(new File(currentDir),new File(destDir));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
//		if(!new File(destDir).exists())
//		{
//			File current = new File(currentDir);
//			System.out.println("Moving XML...");
//			current.renameTo(new File(destDir));
//
//		}
		System.out.println("~~~~ XML has been successfully moved. ~~~~");

	}
}
