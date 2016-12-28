package DataProviders;

import java.util.ArrayList;
import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by aansari on 11/15/16.
 */
public class AccountPolicyGenerator
{
	@DataProvider
	public static Object[][] POCData()
	{
		Object[][] dataBuffer = null;
		List<LinkedHashMap<String, String>> addInts = new ArrayList<>();
		CSVReader reader;
		String filePath= "/Users/jordanponceflhi/Desktop/Workbook1.csv";

		try
		{
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> data = reader.readAll();
			System.out.println("data = '" + data.toArray()[0] + "'");
			dataBuffer = new Object[data.size()-1][];
			for(int row = 1; row < data.size(); row++)
			{
				LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
				int numColumns = data.get(row).length;
				for(int column = 1; column < numColumns ; column++)
				{
					if(column > 181 && column < 184 && !data.get(row)[column].equals(""))
					{
						CSVReader addIntsReader = new CSVReader(new FileReader("/Users/jordanponceflhi/Desktop/"+ data.get(row)[column] +".csv"));
						LinkedHashMap<String, String> addInt = new LinkedHashMap<>();
						List<String[]> addIntsData = addIntsReader.readAll();
						for(int thisColumn = 0; thisColumn < addIntsData.get(0).length; thisColumn++)
						{
							addInt.put(addIntsData.get(0)[thisColumn], addIntsData.get(1)[thisColumn]);
						}
						addInts.add(addInt);
					}
					else
						rowData.put(data.get(0)[column], data.get(row)[column]);
				}

				dataBuffer[row-1] = new Object[]{(rowData),(addInts)};
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
