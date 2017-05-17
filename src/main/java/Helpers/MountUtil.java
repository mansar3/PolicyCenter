package Helpers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by afilizzola on 5/10/17.
 */
public class MountUtil
{
    public static String mountSharedFolder()
    {
        String username = "gwtest";
        String password = "Frontline123";
        String address = "10.50.50.157";
        String homeFolder = System.getenv("HOME");
        String smbFolder = "/AutoRenewalProject";
        String mountFolder = homeFolder + "/AutoRenewal/";
        String workingFolder;
        String defaultMountFolder = "/Volumes/AutoRenewalProject/";
        Files f;

        try
        {
            Process p1 = Runtime.getRuntime().exec("/bin/mkdir -p " + mountFolder);
            p1.waitFor();

            String connString = "/sbin/mount_smbfs " + "//" + username + ":" + password +
                    "@" + address + smbFolder + " " + mountFolder;
            Process p2 = Runtime.getRuntime().exec(connString);
            p2.waitFor();

            if (p2.exitValue() == 64) // if shared folder is already mounted,
            {
                System.out.println("It looks like the AutoRenewalProject shared folder is already mounted in the " +
                        "filesystem, I can use that but it'd be better if you could unmount it manually. Thanks bro...");
                Process p3 = Runtime.getRuntime().exec(new String[] { "ls", "/Volumes/AutoRenewalProject"});
                p3.waitFor();

                if (Files.exists(Paths.get(defaultMountFolder)))
                {
                    workingFolder = getPoliciesFolder(defaultMountFolder);
                }

//                System.out.println(workingFolder);
            }
            else
            {
                workingFolder = mountFolder;
            }
//            return getPoliciesFolder(workingFolder);
        }
        catch (IOException|InterruptedException e)
        {
            System.out.println(e.getStackTrace());
        }
        return mountFolder;
    }


    private static String getPoliciesFolder(String folder) throws IOException
    {
        Path dir = Paths.get(folder);
        String policiesConversionFolder = "";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
        {
            for (Path item : stream)
            {
                if (!item.toString().contains("DS_Store"))
                    policiesConversionFolder = item.toString();
            }
        }
        return policiesConversionFolder;
    }

    public static void unmountSharedFolder()
    {

    }
}
