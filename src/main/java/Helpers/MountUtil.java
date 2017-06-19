package Helpers;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by afilizzola on 5/10/17.
 */
public class MountUtil
{
    static String username = "gwtest";
    static String password = "Frontline123";
    static String address = "10.50.50.157";
    static String homeFolder = System.getenv("HOME");
    static String smbFolder = "/AutoRenewalProject";
    static String mountFolder = homeFolder + "/AutoRenewalProject/";
    static String workingFolder = mountFolder;
//    static String defaultMountFolder = "/Volumes/AutoRenewalProject/input-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";

    public static String mountSharedFolder()
    {
    	if(!SystemUtils.IS_OS_LINUX)
		{
			try
			{

				unMountSharedFolder();
				Process p1 = Runtime.getRuntime().exec("/bin/mkdir -p " + mountFolder);
				p1.waitFor();

				String connString = "/sbin/mount_smbfs " + "//" + username + ":" + password + "@" + address + smbFolder + " " + mountFolder;
				Process p2 = Runtime.getRuntime().exec(connString);
				p2.waitFor();

				System.out.println("Beginning mounting process..");
				return mountFolder;
//				if(p2.exitValue() == 64) // if shared folder is already mounted
//				{
//					System.out.println("It looks like the AutoRenewalProject shared folder is already mounted in the " + "filesystem, I can use that but it'd be better if you could unmount it manually [umount path/to/sharedFolder/]. Thanks bro...");
//					Process p3 = Runtime.getRuntime().exec(new String[]{"ls", "/Volumes/AutoRenewalProject"});
//					p3.waitFor();
//
//					if(Files.exists(Paths.get(defaultMountFolder)))
//					{
//						workingFolder = getPoliciesFolder(defaultMountFolder);
//						mountFolder = defaultMountFolder;
//					}
//					else if(Files.exists(Paths.get(mountFolder)))
//					{
//						workingFolder = getPoliciesFolder(mountFolder);
//					}
//				}
//				else
//				{
//					System.out.println("Drive was not mounted.. \nMounting in progres...");
////					workingFolder = getPoliciesFolder(mountFolder);
//					workingFolder = mountFolder;
//				}
			}
			catch(IOException | InterruptedException e)
			{
				System.out.println("~~~~~~~~~~~~~Could not mount folder~~~~~~~~~~~~~~`");
				System.out.println(e.getStackTrace());
			}
//			return workingFolder;
		}

			return mountFolder;
    }


//    private static String getPoliciesFolder(String folder)
//    {
//    	String policiesConversionFolder = "";
//    	try
//		{
//			Path dir = Paths.get(folder);
//
//			try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
//			{
//				for(Path item : stream)
//				{
//					if(!item.toString().contains("DS_Store"))
//						policiesConversionFolder = item.toString();
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("File was not found in the directory.");
//		}
//        return policiesConversionFolder;
//
//    }

    public static void unMountSharedFolder()
    {
        try
        {
            Process p1 = Runtime.getRuntime().exec(new String[] {"umount", mountFolder});
            p1.waitFor();
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
		File current = new File(currentDir);
		System.out.println("Moving XML...");
		current.renameTo(new File(destDir));
		System.out.println("~~~~ XML has been successfully moved. ~~~~");

	}
}
