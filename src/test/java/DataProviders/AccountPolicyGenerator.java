package DataProviders;

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
		CSVReader reader;
		String filePath= "/Users/aansari/Desktop/csv_test3.csv";

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
				for(int column = 0; column < numColumns ; column++)
					rowData.put(data.get(0)[column], data.get(row)[column]);

				dataBuffer[row-1] = new Object[]{(rowData)};
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
