package DataProviders;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by aansari on 11/15/16.
 */
public class AccountPolicyGenerator
{
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
			filePathBase = "/Users/aansari/Downloads/ConversionPolicies-20170208_095334/FLHO3-20170208_095336/";
		else
			filePathBase = "\\\\FLHIFS1\\General\\ConversionData\\Policies\\FLHO3-20170202_130152\\";
		String filePath= filePathBase + "policies.csv";

		//OutputStream out=new FileOutputStream(new File("\\\\10.28.45.80\\share\\myFile.txt"));
//		NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("fpic.net", "username", "password"); // replace with actual values
//		SmbFile file = null; // note the different format
//		try
//		{
//			file = new SmbFile(filePath, authentication);
//		}
//		catch(MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//		try
//		{
//			OutputStream out = file.getOutputStream();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}

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
		return DataCreator("/Users/aansari/Downloads/ConversionPolicies-20170214_094817/ALHO3-20170214_095216/");
	}

	@DataProvider(parallel = true)
	public static Object[][] FLHO3Data()
	{
		return DataCreator("/Users/aansari/Downloads/ConversionPolicies-20170214_094817/FLHO3-20170214_094821/");
	}

	@DataProvider(parallel = true)
	public static Object[][] NCHO3Data()
	{
		return DataCreator("/Users/aansari/Downloads/ConversionPolicies-20170214_094817/NCHO3-20170214_095235/");
	}

	@DataProvider(parallel = true)
	public static Object[][] SCHO3Data()
	{
		return DataCreator("/Users/aansari/Downloads/ConversionPolicies-20170214_094817/SCHO3-20170214_094902/");
	}

	public static Object[][] DataCreator(String filePathBase)
	{
		Object[][] dataBuffer = null;
		CSVReader reader;
		String filePath= filePathBase + "policies.csv";

		//OutputStream out=new FileOutputStream(new File("\\\\10.28.45.80\\share\\myFile.txt"));
//		NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication("fpic.net", "username", "password"); // replace with actual values
//		SmbFile file = null; // note the different format
//		try
//		{
//			file = new SmbFile(filePath, authentication);
//		}
//		catch(MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//		try
//		{
//			OutputStream out = file.getOutputStream();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}

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
}
