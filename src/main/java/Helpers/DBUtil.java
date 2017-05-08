package Helpers;

import org.testng.util.Strings;

import java.sql.*;
import java.util.Arrays;
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
    private String connectionString = "jdbc:jtds:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;domain=FPIC.NET";
//    private String connectionString = "jdbc:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;integratedSecurity=true;authenticationScheme=JavaKerberos";
    private String query;

    public Connection connect() throws SQLException
    {
        conn =  DriverManager.getConnection(connectionString);
        statement = conn.createStatement();
        return conn;
    }

    public void writeToDb(String[] data) throws SQLException
    {
        statement = conn.createStatement();
        StringJoiner vals = new StringJoiner("','", "'", "'");
        Stream<String> stream = Arrays.stream(data);
        stream.forEach(x -> vals.add(x));
        vals.add(
                Strings.isNullOrEmpty(System.getenv("USER")) ? "NULL"
                        :
                        System.getenv("USER")
        );

        String newQuery = vals.toString().replace("NULL", "");
        String values = String.join(",", data);
        query = "INSERT INTO testresult (TestResult, AccountNumber, LegacyPolicyNumber, EffectiveDate, " +
                "PolicyType, BaseState, PremimumVariation, YearBuilt, ConstructionType, DwellingLimit," +
                "TerritoryCode, AOPDeductible, WhenSafePercentage, LastPageVisited," +
                "TotalAnnualizedPremium, ScreenShot, SubmittedForApproval, GWWarnings, TimeStamp," +
                "DataSet, MachineName)" +
                "VALUES (" + vals.toString() + ");";
        int result = statement.executeUpdate(query);
        System.out.println(String.valueOf(result));
    }

}
