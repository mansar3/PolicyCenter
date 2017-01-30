package DataProviders;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by aansari on 11/14/16.
 */
public class PolicyCreatorData
{
	@DataProvider
	public static Object[][] TestingCSV()
	{
		//BufferedReader crunchifyBuffer = null;
		boolean flag= true;
		CSVReader reader =null;
		String[] buffer;
		Object[][] objectList = null;
		int counter = 0;
		int numRows = 0;
		String filePath= "/Users/aansari/Desktop/csv_test2.csv";

		try
		{
			String[] crunchifyLine;
			//crunchifyBuffer = new BufferedReader(new FileReader(filePath));
			reader = new CSVReader(new FileReader(filePath));
			while((crunchifyLine = reader.readNext()) != null)
			{
				numRows++;
			}
			System.out.println("Number of rows with data in file:"+numRows);

			objectList = new Object[numRows-1][];
			reader.close();

			reader = new CSVReader(new FileReader(filePath));

			//skips headers row
			buffer =reader.readNext();
			// Change to counter <numRows when implementing hashmap
			// and delete above line
//			while(counter <numRows -1)
			while((crunchifyLine = reader.readNext()) != null)
			{
				objectList[counter++] = crunchifyLine;

//				System.out.println("Raw CSV data: " +buffer);
//				objectList[counter++] = reader.readNext();


			}

			System.out.println(objectList[0].length);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reader != null)
					reader.close();
			}
			catch(IOException CsvException)
			{
				CsvException.printStackTrace();
			}
		}

		return objectList;
	}
}