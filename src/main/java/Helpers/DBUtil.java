package Helpers;

import org.testng.util.Strings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Created by afilizzola on 4/25/17.
 */
public class DBUtil
{
    public Connection conn;
    public Statement statement;
//    private String connectionString = "jdbc:mysql://172.16.35.78/frontline_automation";
//    private String connectionString = "jdbc:jtds:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;domain=FPIC.NET";
//    private String connectionString = "jdbc:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;integratedSecurity=true;authenticationScheme=JavaKerberos";
    private String connectionString = "jdbc:sqlite:target/db/frontlineTests.db";

    private String query;

    private Connection connect() throws SQLException
    {
        try
        {
            conn =  DriverManager.getConnection(connectionString);
            statement = conn.createStatement();
        }
        finally
        {
            return conn;
        }

    }

    public void writeToDb(Map<String, String> data, String passOrFail)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
//        headers.add("TestResult")
//        .add("Account Number")
//        .add("Legacy Policy Number")
//        .add("Effective Date")
//        .add("Policy Type")
//        .add("Base State")
//        .add("Annualized Total Cost")
//        .add("Year Built")
//                .add("Construction Type")
//                .add("Dwelling Limit")
//                .add("Territory Code")
//                .add("Section I Deductibles - AOP")


        for (Map.Entry<String,String> entry : data.entrySet())
        {
            if (entry.getKey().equals("Annualized Total Cost"))
            {
                headers.add("PremiumVariation");
            }
            else if (entry.getKey().equals("Section I Deductibles - AOP"))
            {
                headers.add("AOP Deductible");
            }
            headers.add(entry.getKey().replace(" ", ""));
            vals.add("'" + entry.getValue() + "'");
        }

        try
        {
            conn = connect();
            statement = conn.createStatement();

            query = "INSERT INTO testresults (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void createDb()
    {
        String query = "CREATE TABLE `testresults` ( `TestResult` TEXT, `AccountNumber` NUMERIC, `LegacyPolicyNumber` TEXT, `EffectiveDate` DATE, `PolicyType` TEXT, `BaseState` TEXT, `PremiumVariation` INTEGER, `YearBuilt` DATE, `ConstructionType` TEXT, `DwellingLimit` INTEGER, `TerritoryCode` INTEGER, `AOPDeductible` NUMERIC, `WhenSafePercentage` INTEGER, `LastPageVisited` TEXT, `TotalAnnualizedPremium` INTEGER, `ScreenShot` TEXT, `SubmittedForApproval` TEXT, `GWWarnings` TEXT, `TimeStamp` DATE, `DataSet` TEXT, `MachineName` TEXT )";
    }

}
