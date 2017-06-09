package Helpers;

import org.testng.util.Strings;

import java.sql.*;
import java.util.Map;
import java.util.StringJoiner;

public class DBUtil
{
    public static Connection conn;
    public static Statement statement;
    private String testDataTable, reportingTable;
//    private String connectionString = "jdbc:mysql://172.16.35.78/frontline_automation";
//    private String connectionString = "jdbc:jtds:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;domain=FPIC.NET";
//    private String connectionString = "jdbc:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;integratedSecurity=true;authenticationScheme=JavaKerberos";
    private static String connectionString = "jdbc:sqlite:target/db/frontlineTests.db";

    private static String query;

    private static void connect()
    {
        try
        {
            conn = DriverManager.getConnection(connectionString);
            System.out.println(conn.toString());
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to connect to database\n");
            System.out.println(e.getMessage());
        }
    }

    private static void createReportingTable()
    {
        String tableName = "TestResults";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS '" + tableName + "' "
                + "( 'Result' TEXT, "
                + "'AccountNumber' NUMERIC, "
                + "'LegacyPolicyNumber' TEXT, "
                + "'EffectiveDate' DATE, "
                + "'PolicyType' TEXT, "
                + "'BaseState' TEXT, "
                + "'PremiumVariation' INTEGER, "
                + "'YearBuilt' DATE, "
                + "'ConstructionType' TEXT, "
                + "'DwellingLimit' INTEGER, "
                + "'TerritoryCode' INTEGER, "
                + "'AOPDeductible' NUMERIC, "
                + "'WhenSafePercentage' INTEGER, "
                + "'LastPageVisited' TEXT, "
                + "'TotalAnnualizedPremium' INTEGER, "
                + "'ScreenShot' TEXT, "
                + "'SubmittedForApproval' TEXT, "
                + "'GWWarnings' TEXT, "
                + "'TimeStamp' DATE, "
                + "'DataSet' TEXT, "
                + "'MachineName' TEXT, "
                + "'StackTrace' TEXT, "
                + "'MethodName' TEXT);";
        try
        {
            connect();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private static void createAddIntTable()
    {
        String tableName = "AddInt";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS '" + tableName + "' (" +
                "'LegacyPolicyNumber' TEXT," +
                "'Type' TEXT," +
                "'LoanNumber' NUMERIC," +
                "'Name' TEXT," +
                "'Address' TEXT," +
                "'City' TEXT," +
                "'State' TEXT," +
                "'ZipCode' TEXT" +
                ");";

        try
        {
            connect();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private void createSPCTable()
    {
        String tableName = "SPC";
        String sqlCreate = "CREATE TABLE '" + tableName + "' (" +
                 "'Class'	TEXT, " +
	            "'Description'	TEXT, " +
	            "'Limit'	INTEGER" +
                ");";

        try
        {
            connect();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private static void createPoliciesTable()
    {
        String tableName = "policies";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS '" + tableName + "' (" +
                "'SPCFile'	TEXT," +
                "'AdditionalInterestsFile'	TEXT," +
                "'NameInsuredFirstName'	TEXT," +
                "'NameInsuredMiddleName'	TEXT," +
                "'NameInsuredLastName'	TEXT," +
                "'NameInsuredTitle'	TEXT," +
                "'DateofBirth'	TEXT," +
                "'HomePhone'	TEXT," +
                "'WorkPhone'	TEXT," +
                "'CellPhone'	TEXT," +
                "'EmailAddress'	TEXT," +
                "'MailingAddress'	TEXT," +
                "'MailingCity'	TEXT," +
                "'MailingCounty'	TEXT," +
                "'MailingState'	TEXT," +
                "'MailingZipCode'	TEXT," +
                "'AddressType'	TEXT," +
                "'Organization'	TEXT," +
                "'ProducerCode'	TEXT," +
                "'BaseState'	TEXT," +
                "'Product'	TEXT," +
                "'PolicyType'	TEXT," +
                "'LegacyPolicyNumber'	TEXT," +
                "'PolicyOriginalEffectiveDate'	TEXT," +
                "'EffectiveDate'	TEXT," +
                "'LastInspectionCompletionDate'	TEXT," +
                "'ExcludeLossofUseCoverage'	TEXT," +
                "'OfferingSelection'	TEXT," +
                "'NoPriorInsuranceSurcharge'	TEXT," +
                "'AdditionalNameInsuredFirstName'	TEXT," +
                "'AdditionalNameInsuredLastName'	TEXT," +
                "'AdditionalNameInsuredCompanyName'	TEXT," +
                "'AdditionalNameInsuredDateofBirth'	TEXT," +
                "'AdditionalNameInsuredSSN'	TEXT," +
                "'DoestheinsuredownanyotherresidencethatisinsuredwithFrontline'	TEXT," +
                "'PolicyWriter'	TEXT," +
                "'LocationAddress'	TEXT," +
                "'LocationAddressUnit'	TEXT," +
                "'LocationAddressCity'	TEXT," +
                "'LocationAddressState'	TEXT," +
                "'LocationAddressZip'	TEXT," +
                "'LocationAddressCounty'	TEXT," +
                "'YearBuilt'	TEXT," +
                "'DistancetoFireHydrant'	TEXT," +
                "'DistancetoFireStation'	TEXT," +
                "'TerritoryCode'	TEXT," +
                "'ProtectionClassCode'	TEXT," +
                "'LocationType'	TEXT," +
                "'IntheWindpool'	TEXT," +
                "'DistancetoCoast'	TEXT," +
                "'PurchaseDate'	TEXT," +
                "'PurchasePrice'	TEXT," +
                "'MarketValue'	TEXT," +
                "'AttheinceptionofthispolicywillthispropertybedeededinthenameofcorporationbusinessLLCoranyotherentity'	TEXT," +
                "'OccupiedDaily'	TEXT," +
                "'ResidenceType'	TEXT," +
                "'HowisthedwellingcustomarilyUsed'	TEXT," +
                "'Howisthedwellingoccupied'	TEXT," +
                "'WeeksRentedAnnually'	TEXT," +
                "'MinimumRentalIncrement'	TEXT," +
                "'UnderContractwithRentalManagementcompany'	TEXT," +
                "'Isthereaswimmingpool'	TEXT," +
                "'Isthereatrampoline'	TEXT," +
                "'isthereaskateboardorbicycleramponpremises'	TEXT," +
                "'Anyanimalsorexoticpetsonpremises'	TEXT," +
                "'AnyownedGolfCarts'	TEXT," +
                "'Anyownedrecreationalvehicles'	TEXT," +
                "'HousekeepingCondition'	TEXT," +
                "'BurglarAlarmType'	TEXT," +
                "'Istherealockedprivacyfence'	TEXT," +
                "'arethereanyburglarbarsonthewindowsdoors'	TEXT," +
                "'IsthecommunityGuarded'	TEXT," +
                "'IsthecommunityGated'	TEXT," +
                "'FireAlarmtype'	TEXT," +
                "'SmokeAlarms'	TEXT," +
                "'Oneormorefireextinguishersinthehome'	TEXT," +
                "'SprinklerSystem'	TEXT," +
                "'Deadbolts'	TEXT," +
                "'ResidenceVisibletoneighbors'	TEXT," +
                "'ValuationType'	TEXT," +
                "'EstimatedReplacementCost'	TEXT," +
                "'ConstructionType'	TEXT," +
                "'NumberofUnits'	TEXT," +
                "'UnitsinFireWall'	TEXT," +
                "'NumberofStories'	TEXT," +
                "'SquareFootage'	TEXT," +
                "'FoundationType'	TEXT," +
                "'PrimaryHeating'	TEXT," +
                "'Isthereasecondaryheatingsystem'	TEXT," +
                "'PlumbingType'	TEXT," +
                "'PlumbingYear'	TEXT," +
                "'WaterHeaterYear'	TEXT," +
                "'Wiring'	TEXT," +
                "'ElectricalSystem'	TEXT," +
                "'RoofType'	TEXT," +
                "'RoofYear'	TEXT," +
                "'ConditionofRoof'	TEXT," +
                "'Isthereascreenenclosureonpremises'	TEXT," +
                "'Doestheplumbingsystemhaveknownleaks'	TEXT," +
                "'Isthebuildingretrofittedforearthquakes'	TEXT," +
                "'Anyuncorrectedfireorbuildingcodeviolations'	TEXT," +
                "'Wasthestructureoriginallybuiltforotherthanaprivateresidenceandthenconverted'	TEXT," +
                "'Anyleadpainthazard'	TEXT," +
                "'Isanyportionofanystructureatthispropertylocationnoworeverhasbeenamobilehomemodularhometrailerhomeorotherprefabricatedhome'	TEXT," +
                "'DiscountType'	TEXT," +
                "'FortifiedHomeType'	TEXT," +
                "'RoofShape'	TEXT," +
                "'OpeningProtectionType'	TEXT," +
                "'DwellingLimit'	TEXT," +
                "'OtherStructures'	TEXT," +
                "'PersonalPropertyExcluded'	TEXT," +
                "'PersonalPropertyLimit'	TEXT," +
                "'PersonalPropertyValuationMethod'	TEXT," +
                "'LossofUse'	TEXT," +
                "'SectionIDeductiblesAOP'	TEXT," +
                "'SectionIDeductiblesWindHail'	TEXT," +
                "'SectionIDeductiblesNamedStorm' TEXT," +
                "'ResidenceHeldInTrust' TEXT," +
                "'PersonalLiability'	TEXT," +
                "'MedicalPayments'	TEXT," +
                "'SpecifiedAdditionalAmountofCoverageA' TEXT," +
                "'GuardianEndorsement'	TEXT," +
                "'SpecificOtherStructuresDescription'	TEXT," +
                "'SpecificOtherStructuresLimit'	TEXT," +
                "'OtherStructuresIncreaseCoverageRentedtoOthersDescription'	TEXT," +
                "'OtherStructuresIncreaseCoverageRentedtoOthersLimit'	TEXT," +
                "'PermittedIncidentalOccupancyPropertyLimit'	TEXT," +
                "'CreditCardLimit'	TEXT," +
                "'LimitedFungiLimit'	TEXT," +
                "'LossAssessmentLimit'	TEXT," +
                "'OrdinanceorLawPercent'	TEXT," +
                "'ScreenEnclosureHurricaneCoverageLimit'	TEXT," +
                "'WaterBackUpLimit'	TEXT," +
                "'InflationGuardPercent'	TEXT," +
                "'PermittedIncidentalOccupancyLiability'	TEXT," +
                "'AdditionalResidenceRentedtoOthersLocation'	TEXT," +
                "'AdditionalResidenceRentedtoOthersNumberoffamilies'	TEXT," +
                "'BusinessPursuitsBusinessactivity'	TEXT," +
                "'WatercraftLiablityWatercraftType'	TEXT," +
                "'ConsenttoRate'	TEXT," +
                "'BillingContactinsuredormortgage'	TEXT," +
                "'PaymentPlanSchedule'	TEXT," +
                "'TotalCost'	TEXT," +
                "'GoPaperless'	TEXT" +
                ");";

        try
        {
            connect();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void insertIntoPoliciesTable(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        createPoliciesTable();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn") && !Strings.isNullOrEmpty(entry.getValue()))
            {
                headers.add(entry.getKey().replaceAll("[\\W]", ""));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            connect();
            statement = conn.createStatement();

            query = "INSERT INTO policies (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoAddIntsTable(String policyType, Map<String, String> data)
    {
        createAddIntTable();

        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        headers.add("LegacyPolicyNumber");
        vals.add("\"" + policyType.replace(" ", "") + "\"");

        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!Strings.isNullOrEmpty(entry.getValue()))
            {
                headers.add(entry.getKey().replaceAll("[\\W]", ""));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            connect();
            statement = conn.createStatement();

            query = "INSERT INTO AddInt (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            System.out.println(query);
            int result = statement.executeUpdate(query);
            if (result != 1)
                System.out.println("\nUnable to insert data into database\n");
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoResultsTable(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        createReportingTable();

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
            vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
        }

        try
        {
            connect();
            statement = conn.createStatement();

            query = "INSERT INTO testresults (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
