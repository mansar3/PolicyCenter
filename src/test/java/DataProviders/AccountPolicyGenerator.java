package DataProviders;

import com.opencsv.CSVReader;
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
		String filePathBase = "/Users/aansari/Desktop/";
		String filePath= filePathBase + "output1.csv";

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
				int numColumns = data.get(row).length;
				for(int column = 0; column < numColumns ; column++)
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
								spp.put(sppData.get(0)[thisColumn], sppData.get(sppRow)[thisColumn]);

							spc.add(spp);
						}

					}
					else if(!value.equals(""))
						rowData.put(key, value);
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
