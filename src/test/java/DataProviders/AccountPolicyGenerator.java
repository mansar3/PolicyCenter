package DataProviders;

import base.BaseTest;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.DataProvider;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by aansari on 11/15/16.
 */
public class AccountPolicyGenerator extends BaseTest
{
	private static POLICYTYPE policytype;
	protected static int flho3pc,ncho3pc;

	public enum POLICYTYPE
	{
		FLDP3,SCDP3,ALHO3,FLHO3,NCHO3,
		SCHO3,FLHO6,SCHO6,NCHOW,FLMH3;
	}

	@DataProvider(parallel = true)
	public static Object[][] POCData()
	{
		Object[][] dataBuffer = null;
		CSVReader reader;
		String filePathBase;
		if(SystemUtils.IS_OS_MAC)
			//filePathBase = "/Users/aansari/Downloads/FLHO3-20170125_160052/";
			//filePathBase = "/Volumes/General/ConversionData/Policies/FLHO3-20170202_130152/";
			//filePathBase = "/Users/aansari/Desktop/";
			filePathBase = "/Users/ajmac/Downloads/ConversionPolicies-20170420_3/";
		else
			filePathBase = "\\\\FLHIFS1\\General\\ConversionData\\Policies\\FLHO3-20170202_130152\\";
		String filePath= filePathBase + "policies.csv";


		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			System.out.println("data = '" + data.toArray()[0] + "'");
			dataBuffer = new Object[data.size()-1][];
			for(int row = 1; row < data.size(); row++)
			{
				List<LinkedHashMap<String, String>> addInts = new ArrayList<>();
				List<LinkedHashMap<String, String>> spc = new ArrayList<>();
				LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
				int numColumns = data.get(0).length;
				for(int column = 0; column < numColumns  ; column++)
				{
					String key = data.get(0)[column],
					value = data.get(row)[column];

					if(key.equals("Additional Interests File") && !value.equals(""))
					{
						CSVReader addIntsReader = new CSVReader(new FileReader(filePathBase + data.get(row)[column]));

						List<String[]> addIntsData = addIntsReader.readAll();

						for(int aiRow = 1; aiRow < addIntsData.size(); aiRow++)
						{
							LinkedHashMap<String, String> addInt = new LinkedHashMap<>();
							for(int thisColumn = 0; thisColumn < addIntsData.get(0).length; thisColumn++)
								if(!addIntsData.get(aiRow)[thisColumn].equals("") && !addIntsData.get(aiRow)[thisColumn].equals(" "))
									addInt.put(addIntsData.get(0)[thisColumn], addIntsData.get(aiRow)[thisColumn]);

							addInts.add(addInt);
						}
					}
					else if(key.equals("SPC File") && !value.equals(""))
					{
						CSVReader sppReader = new CSVReader(new FileReader(filePathBase + data.get(row)[column]));

						List<String[]> sppData = sppReader.readAll();

						for(int sppRow = 1; sppRow < sppData.size();sppRow++)
						{
							LinkedHashMap<String, String> spp = new LinkedHashMap<>();
							for(int thisColumn = 0; thisColumn < sppData.get(0).length; thisColumn++)
								if(!sppData.get(sppRow)[thisColumn].equals("") && !sppData.get(sppRow)[thisColumn].equals(" "))
									spp.put(sppData.get(0)[thisColumn], sppData.get(sppRow)[thisColumn]);

							spc.add(spp);
						}

					}
					else if(!value.equals("") && !value.equals(" "))
						rowData.put(key, value);
				}

				if(rowData.get("Mailing Address") == null)
				{
					rowData.put("Mailing Address", rowData.get("Location Address"));
					rowData.put("Mailing City", rowData.get("Location Address - City"));
					rowData.put("Mailing State", rowData.get("Location Address - State"));
					rowData.put("Mailing Zip Code",rowData.get("Location Address - Zip"));
					rowData.put("Mailing County",rowData.get("Location Address - County"));


				}

				dataBuffer[row-1] = new Object[]{(rowData),(addInts),(spc)};
			}

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("databuffer.leg = '" + dataBuffer.length + "'");
		return dataBuffer;
	}
	@DataProvider(parallel = true)
	public static Object[][] ALHO3Data()
	{
		policytype  = POLICYTYPE.ALHO3;
		return DataCreator(policyFolder +"/ALHO3/");
	}

	@DataProvider(parallel = true)
	public static Object[][] FLDP3Data()
	{
		policytype  = POLICYTYPE.FLDP3;
		return DataCreator(policyFolder + "/FLDP3/");
	}

	@DataProvider(parallel = true)
	public static Object[][] FLHO3Data()
	{
		policytype  = POLICYTYPE.FLHO3;
		return DataCreator(policyFolder + "/FLHO3/");
	}

	@DataProvider(parallel = true)
	public static Object[][] FLHO6Data()
	{
		policytype  = POLICYTYPE.FLHO6;
		return DataCreator(policyFolder + "/FLHO6/");
	}

	@DataProvider(parallel = true)
	public static Object[][] FLMH3Data()
	{
		policytype  = POLICYTYPE.FLMH3;
		return DataCreator(policyFolder + "/FLMH3/");
	}


	@DataProvider(parallel = true)
	public static Object[][] NCHO3Data()
	{
		policytype  = POLICYTYPE.NCHO3;
		return DataCreator(policyFolder + "/NCHO3/");
	}
	@DataProvider(parallel = true)
	public static Object[][] NCHOWData()
	{
		policytype  = POLICYTYPE.NCHOW;
		return DataCreator(policyFolder + "/NCHOW/");
	}
	@DataProvider(parallel = true)
	public static Object[][] SCDP3Data()
	{
		policytype  = POLICYTYPE.SCDP3;
		return DataCreator(policyFolder + "/SCDP3/");
	}

	@DataProvider(parallel = true)
	public static Object[][] SCHO3Data()
	{
		policytype  = POLICYTYPE.SCHO3;
		return DataCreator(policyFolder + "/SCHO3/");
	}
	@DataProvider(parallel = true)
	public static Object[][] SCHO6Data()
	{

		policytype  = POLICYTYPE.SCHO6;
		return DataCreator(policyFolder + "/SCHO6/");
	}

	public static Object[][] DataCreator(String filePathBase)
	{
		Object[][] dataBuffer = null;
		CSVReader reader;
		String filePath= filePathBase + "policies.csv";

		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			//System.out.println("data = '" + data.toArray()[0] + "'");
			dataBuffer = new Object[data.size()-1][];
			for(int row = 1; row < data.size(); row++)
			{
				List<LinkedHashMap<String, String>> addInts = new ArrayList<>();
				List<LinkedHashMap<String, String>> spc = new ArrayList<>();
				LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
				int numColumns = data.get(0).length;
				for(int column = 0; column < numColumns  ; column++)
				{
					String key = data.get(0)[column],
					value = data.get(row)[column];

					if(key.equals("Additional Interests File") && !value.equals(""))
					{
						CSVReader addIntsReader = new CSVReader(new FileReader(filePathBase + data.get(row)[column]));

						List<String[]> addIntsData = addIntsReader.readAll();

						for(int aiRow = 1; aiRow < addIntsData.size(); aiRow++)
						{
							LinkedHashMap<String, String> addInt = new LinkedHashMap<>();
							for(int thisColumn = 0; thisColumn < addIntsData.get(0).length; thisColumn++)
								if(!addIntsData.get(aiRow)[thisColumn].equals("") && !addIntsData.get(aiRow)[thisColumn].equals(" "))
									addInt.put(addIntsData.get(0)[thisColumn], addIntsData.get(aiRow)[thisColumn]);

							addInts.add(addInt);
						}
					}
					else if(key.equals("SPC File") && !value.equals(""))
					{
						CSVReader sppReader = new CSVReader(new FileReader(filePathBase + data.get(row)[column]));

						List<String[]> sppData = sppReader.readAll();

						for(int sppRow = 1; sppRow < sppData.size();sppRow++)
						{
							LinkedHashMap<String, String> spp = new LinkedHashMap<>();
							for(int thisColumn = 0; thisColumn < sppData.get(0).length; thisColumn++)
								if(!sppData.get(sppRow)[thisColumn].equals("") && !sppData.get(sppRow)[thisColumn].equals(" "))
									spp.put(sppData.get(0)[thisColumn], sppData.get(sppRow)[thisColumn]);

							spc.add(spp);
						}

					}
					else if(key.equals("Group Membership") && !value.equals(""))
					{
						CSVReader gmReader = new CSVReader(new FileReader(filePathBase + data.get(row)[column]));
						List<String[]> gmData = gmReader.readAll();

						for(int gmRow =1; gmRow < gmData.size();gmRow++)
						{
							String membership = gmData.get(gmRow)[0];
							switch(membership)
							{
								case "AAA":
									rowData.put("AAA Membership", "True");
									break;
								case "AARP":
									rowData.put("AARP Membership", "True");
									break;
								case "FMHO":
									rowData.put("FMHO Membership", "True");
							}
						}
					}
					else if(!value.equals("") && !value.equals(" "))
						rowData.put(key, value);
				}

				if(rowData.get("Mailing Address") == null)
				{
					rowData.put("Mailing Address", rowData.get("Location Address"));
					rowData.put("Mailing City", rowData.get("Location Address - City"));
					rowData.put("Mailing State", rowData.get("Location Address - State"));
					rowData.put("Mailing Zip Code",rowData.get("Location Address - Zip"));
					rowData.put("Mailing County",rowData.get("Location Address - County"));


				}

				dataBuffer[row-1] = new Object[]{(rowData),(addInts),(spc)};
			}

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("databuffer.leg = '" + dataBuffer.length + "'");
		//setCount(dataBuffer.length);
		return dataBuffer;
	}

	private static void setCount(int count)
	{
		switch(policytype)
		{
			case FLHO3:
				System.out.println("*************FLHO3 policy count: " +count + "\n");
				break;
			case NCHO3:
				System.out.println("*************NCHO3 policy count: " +count + "\n");
				break;
			case SCHO3:
				System.out.println("*************SCHO3 policy count: " +count + "\n");
				break;
			case ALHO3:
				System.out.println("*************ALHO3 policy count: " +count + "\n");
				break;
			case FLDP3:
				System.out.println("*************FLDP3 policy count: " +count + "\n");
				break;
			case FLHO6:
				System.out.println("*************FLHO6 policy count: " +count + "\n");
				break;
			case FLMH3:
				System.out.println("*************FLMH3 policy count: " +count + "\n");
				break;
			case SCDP3:
				System.out.println("*************SCDP3 policy count: " +count + "\n");
				break;
			case SCHO6:
				System.out.println("*************SCHO6 policy count: " +count + "\n");
				break;
			case NCHOW:
				System.out.println("*************NCHOW policy count: " +count + "\n");
				break;

		}
	}
	@DataProvider(parallel = true)
	public static Object[][] Rerun()
	{
		Object[][] buffer = null;
		List<LinkedHashMap<String, String>> testResultData = new ArrayList<>();
		List<LinkedHashMap<String, String>> scdp3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> fldp3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> flho3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> ncho3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> scho3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> flho6Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> scho6Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> flmh3Policies = new ArrayList<>();
		List<LinkedHashMap<String, String>> nchowPolicies = new ArrayList<>();

		String filePathBase = FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Downloads/ConversionPolicies-20170628_1";
		CSVReader reader;
		String policiesFilePath= filePathBase + "policies.csv";
		String desktop= FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Desktop/",
		timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
		String filePath= getTestResultIndex();

		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			//System.out.println("data = '" + data.toArray()[0] + "'");
			buffer = new Object[data.size() - 1][];
			for(int row = 1; row < data.size(); row++)
			{
				LinkedHashMap<String, String> failData = new LinkedHashMap<>();
				int numColumns = data.get(0).length;
				if(!data.get(row)[0].toLowerCase().equals("pass"))
				{
					for(int column = 0; column < numColumns; column++)
					{
						String key = data.get(0)[column], value = data.get(row)[column];
						if(key.equals("Legacy Policy Number"))
							failData.put(key, value);
						if(key.equals("Account Number"))
							failData.put(key, value);
					}
					testResultData.add(failData);

				}
			}
		}
		catch (Exception e)
		{
		}
		return buffer;
	}
	private static String getTestResultIndex()
	{
		String filePathBase = FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Desktop/", //+"/Desktop/",
			timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
		String filePath= filePathBase + "TestResult" + timeStamp + "_1.csv";
		if(new File(filePath).exists())
		{
			int i = 1;
			while(new File(filePathBase + "TestResult" + timeStamp + "_" + String.valueOf(i) + ".csv").exists())
				i++;
			return filePathBase + "TestResult" + timeStamp + "_" + String.valueOf(--i) + ".csv";
		}
		return filePath;
	}
}
