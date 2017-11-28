package DataProviders;


import com.opencsv.CSVReader;

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
public class AccountPolicyGenerator
{


	//***************************************//
	//			Methods for Rerun            //
	//***************************************//

	public static Object[][] DataCreator(List<LinkedHashMap<String, String>> policies,String filePathBase)
	{
		int i=0;
		Object[][] dataBuffer = null;
		CSVReader reader;
		String filePath= filePathBase + "policies.csv";

		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			//System.out.println("data = '" + data.toArray()[0] + "'");
			dataBuffer = new Object[policies.size()][];
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
				if(containedInList(rowData.get("Legacy Policy Number"), policies))
				{
					String accountNumber =getAccountNumber(rowData.get("Legacy Policy Number"),policies);
					if(accountNumber != null)
						rowData.put("Account Number",accountNumber);

					dataBuffer[i++] = new Object[]{(rowData), (addInts), (spc)};
				}
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

	public static List<LinkedHashMap<String, String>> Rerun(String state, String policyType)
	{
		List<LinkedHashMap<String, String>> testResultData = new ArrayList<>();
		CSVReader reader;
		String filePath= getTestResultIndex();
		System.out.println("Using: " + new File(filePath).getName() + " for Reruns");

		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			//System.out.println("data = '" + data.toArray()[0] + "'");
			for(int row = 1; row < data.size(); row++)
			{
				LinkedHashMap<String, String> failData = new LinkedHashMap<>();
				int numColumns = data.get(0).length;
				if(!data.get(row)[0].toLowerCase().equals("pass"))
				{
					if(data.get(row)[5].equals(state) && (data.get(row)[4].contains(policyType)))
					{
 						for(int column = 0; column < numColumns; column++)
						{

							String key = data.get(0)[column], value = data.get(row)[column];
							if(key.equals("Legacy Policy Number"))
								failData.put(key, value);
							if(!value.equals("") && !value.equals(" ") && key.equals("Account Number"))
								failData.put(key, value);
						}
						testResultData.add(failData);
					}

				}
			}
		}
		catch (Exception e)
		{
		}
		return testResultData;
	}

	// Helper Method
	private static String getAccountNumber(String policyNumber,List<LinkedHashMap<String, String>> policies)
	{
		//addInts.get(i).get("Name")
		for(int i= 0; i <= policies.size() -1;i++)
			if(policyNumber.equals(policies.get(i).get("Legacy Policy Number")))
				if(policies.get(i).get("Account Number") != null)
					return policies.get(i).get("Account Number");
		return null;
	}
	private static boolean containedInList(String policyNumber,List<LinkedHashMap<String, String>> policies)
	{
		//addInts.get(i).get("Name")
		for(int i= 0; i <= policies.size() -1;i++)
			if(policyNumber.equals(policies.get(i).get("Legacy Policy Number")))
				return true;
		return false;
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
