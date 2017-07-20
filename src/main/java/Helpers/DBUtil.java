package Helpers;

import org.testng.util.Strings;

import java.sql.*;
import java.util.*;

public class DBUtil
{

    String databaseUrl = "jdbc:mysql://10.50.50.150/frontline_automation";
    String username = "";
    String password = ""; // the password should never be written in the project in plaintext

    Vector connectionPool = new Vector();


//    public Connection conn;
    public Statement statement;
    private String testDataTable, reportingTable;
    private String connectionString = "jdbc:mysql://10.50.50.150/frontline_automation";//?serverTimezone=UTC";
//    private String connectionString = "jdbc:jtds:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;domain=FPIC.NET";
//    private String connectionString = "jdbc:sqlserver://AWS-FLGWDEVDB9.fpic.net:1433;databaseName=FLAutomation;integratedSecurity=true;authenticationScheme=JavaKerberos";
//    private String dbFolder = "target/db/";
//    File dbLocation = new File(dbFolder);

    private String query;
    final int MAX_POOL_SIZE = 5;
    public DBUtil()
    {
        initialize();
    }

    private void initialize()
    {
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        while (!isConnectionPoolFull())
        {
            connectionPool.addElement(connect());
        }
        System.out.println("Connection pool is full!!");
    }

    private synchronized boolean isConnectionPoolFull()
    {
        if (connectionPool.size() < MAX_POOL_SIZE)
        {
            return false;
        }
        return true;
    }

    private Connection connect()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println(connection.toString());
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to connect to database\n");
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public synchronized Connection getConnectionFromPool()
    {
        Connection connection = null;

        if (connectionPool.size() > 0)
        {
            connection = (Connection)connectionPool.firstElement();
            connectionPool.removeElementAt(0);
        }
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection)
    {
        connectionPool.addElement(connection);
    }
    
    private void createReportingTable()
    {
        String tableName = "TestResults";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "(TestRunID BIGINT, " +
                "Result TEXT," +
                "AccountNumber BIGINT," +
                "LegacyPolicyNumber TEXT," +
                "EffectiveDate TEXT," +
                "PolicyType TEXT," +
                "BaseState TEXT," +
                "PremiumVariation NUMERIC(20, 2)," +
                "YearBuilt YEAR," +
                "ConstructionType TEXT," +
                "DwellingLimit BIGINT," +
                "TerritoryCode TEXT," +
                "AOPDeductible TEXT," +
                "WhenSafePercentage TEXT," +
                "LastPageVisited TEXT," +
                "TotalAnnualizedPremium INTEGER," +
                "ScreenShot TEXT," +
                "SubmittedForApproval TEXT," +
                "GWWarnings TEXT," +
                "TimeStamp TIMESTAMP," +
                "DataSet TEXT," +
                "MachineName TEXT," +
                "StackTrace TEXT," +
                "MethodName TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private void createAddIntTable()
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
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private void createSpcTable()
    {
        String tableName = "SPC";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS '" + tableName + "' (" +
                "'LegacyPolicyNumber' TEXT," +
                "'Class' TEXT," +
                "'Description' TEXT," +
                "'Limit_' NUMERIC" + // It turns out 'Limit' is a reserved keyword in SQL
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    private void createFLDP3Table()
    {
        String tableName = "FLDP3";

        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "TheftCoverage TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 2)," +
                "DistanceToFireStation NUMERIC(28, 2)," +
                "TerritoryCode TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "DistanceToCoast BIGINT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue NUMERIC(28,2)," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually INT," +
                "MinimumRentalIncrement TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "Terrain TEXT," +
                "RoofCover TEXT," +
                "RoofDeckAttachment TEXT," +
                "RoofWallConnection TEXT," +
                "SecondaryWaterResistance TEXT," +
                "RoofDeck TEXT," +
                "FBCWindSpeed TEXT," +
                "InternalPressure TEXT," +
                "WindBorneDebrisRegion TEXT," +
                "DwellingLimit BIGINT," +
                "OtherStructures TEXT," +
                "OtherStructuresIncreasedLimit BIGINT," +
                "PersonalPropertyExcluded TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "WindExcluded TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability TEXT," +
                "PremisesLiability TEXT," +
                "MedicalPayments TEXT," +
                "WhenSafe TEXT," +
                "LimitedFungiLimit TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit TEXT," +
                "WaterBackUpLimit TEXT," +
                "SinkholeLossCoverage TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createSCDP3Table()
    {
        String tableName = "SCDP3";

        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName    TEXT," +
                "NameInsuredLastName  TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth  TEXT," +
                "HomePhone    TEXT," +
                "WorkPhone    TEXT," +
                "CellPhone    TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress   TEXT," +
                "MailingCity  TEXT," +
                "MailingCounty    TEXT," +
                "MailingState TEXT," +
                "MailingZipCode   TEXT," +
                "AddressType  TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState    TEXT," +
                "Product  TEXT," +
                "PolicyType   TEXT," +
                "LegacyPolicyNumber   TEXT," +
                "PolicyOriginalEffectiveDate  TEXT," +
                "EffectiveDate    TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "OfferingSelection TEXT," +
                "NoPriorInsuranceSurcharge    TEXT," +
                "AdditionalNameInsuredFirstName   TEXT," +
                "AdditionalNameInsuredLastName    TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress  TEXT," +
                "LocationAddressUnit  TEXT," +
                "LocationAddressCity  TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip   TEXT," +
                "LocationAddressCounty    TEXT," +
                "YearBuilt    YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 1)," +
                "DistanceToFireStation NUMERIC(28, 1)," +
                "TerritoryCode    TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode  TEXT," +
                "LocationType TEXT," +
                "InTheWindPool    TEXT," +
                "WindPoolZone TEXT," +
                "DistanceToCoast  TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice    NUMERIC(28, 2)," +
                "MarketValue  TEXT," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor  TEXT," +
                "OccupiedDaily    TEXT," +
                "ResidenceType    TEXT," +
                "HowIsTheDwellingCustomarilyUsed  TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually  INT," +
                "MinimumRentalIncrement   TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline   TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises    TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts    TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition    TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence   TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors  TEXT," +
                "IsTheCommunityGuarded    TEXT," +
                "IsTheCommunityGated  TEXT," +
                "FireAlarmType    TEXT," +
                "SmokeAlarms  TEXT," +
                "OneOrMoreFireExtinguishersInTheHome  TEXT," +
                "SprinklerSystem  TEXT," +
                "Deadbolts    TEXT," +
                "ResidenceVisibleToNeighbors  TEXT," +
                "ValuationType    TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits    TEXT," +
                "UnitsInFireWall  TEXT," +
                "NumberOfStories  TEXT," +
                "SquareFootage    BIGINT," +
                "FoundationType   TEXT," +
                "PrimaryHeating   TEXT," +
                "IsThereASecondaryHeatingSystem   TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear   YEAR," +
                "Wiring   TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof  TEXT," +
                "IsThereAScreenEnclosureOnPremises    TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks  TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes   TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations   TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard   TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape    TEXT," +
                "OpeningProtectionType TEXT," +
                "SecondaryWaterResistance TEXT," +
                "IsTheRoofCoverConstructionBuildingCodeCompliant  TEXT," +
                "IsTheRoofDeckAttachmentBuidingCodeCompliant  TEXT," +
                "IsTheRoofWallConnectionBuildingCodeCompliant TEXT," +
                "DwellingLimit    BIGINT," +
                "OtherStructures TEXT," +
                "OtherStructuresPercentage    TEXT," +
                "OtherStructuresIncreasedLimit    BIGINT," +
                "PersonalPropertyExcluded TEXT," +
                "PersonalPropertyLimit    TEXT," +
                "PersonalPropertyValuationMethod  TEXT," +
                "SectionIDeductiblesAOP   TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability    TEXT," +
                "PremisesLiability    TEXT," +
                "MedicalPayments  TEXT," +
                "WhenSafePercentage   TEXT," +
                "LimitedFungiLimit    TEXT," +
                "EarthquakeCoverageDeductible TEXT," +
                "EarthquakeCoverageConstructionClass  TEXT," +
                "EarthquakeLossAssessmentCoverageLimit    TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit    TEXT," +
                "TheftCoverage    TEXT," +
                "WaterBackUpLimit TEXT," +
                "ConsentToRate    TEXT," +
                "BillingContactInsuredOrMortgage  TEXT," +
                "PaymentPlanSchedule  TEXT," +
                "TotalCost    NUMERIC(28,2)," +
                "GoPaperless  TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createALHO3Table()
    {
        String tableName = "ALHO3";

        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "ExcludeLossOfUseCoverage TEXT," +
                "OfferingSelection TEXT," +
                "NoPriorInsuranceSurcharge TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsureDownAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 2)," +
                "DistanceToFireStation NUMERIC(28, 2)," +
                "TerritoryCode TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "DistanceToCoast TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue TEXT," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually TEXT," +
                "MinimumRentalIncrement TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "ValuationType TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "isAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "DiscountType TEXT," +
                "FortifiedHomeType TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "DwellingLimit BIGINT," +
                "OtherStructures TEXT," +
                "PersonalPropertyExcluded TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesWindHail TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "GuardianEndorsement TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersDescription TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersLimit TEXT," +
                "PermittedIncidentalOccupancyPropertyLimit TEXT," +
                "CreditCardLimit TEXT," +
                "LimitedFungiLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit TEXT," +
                "WaterBackUpLimit TEXT," +
                "InflationGuardPercent TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessActivity TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrmMrtgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createFLHO3Table()
    {
        String tableName = "FLHO3";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateofBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "InflationGuard TEXT," +
                "ExcludeLossOfUseCoverage TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 2)," +
                "DistanceToFireStation NUMERIC(28, 2)," +
                "TerritoryCode TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "DistanceToCoast TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue TEXT," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "ValuationType TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall INT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "Terrain TEXT," +
                "RoofCover TEXT," +
                "RoofDeckAttachment TEXT," +
                "RoofWallConnection TEXT," +
                "SecondaryWaterResistance TEXT," +
                "RoofDeck TEXT," +
                "FBCWindSpeed TEXT," +
                "InternalPressure TEXT," +
                "WindBorneDebrisRegion TEXT," +
                "DwellingLimit BIGINT," +
                "OtherStructures TEXT," +
                "OtherStructuresIncreasedLimit BIGINT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "WindExcluded TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability TEXT," +
                "PremisesLiability TEXT," +
                "MedicalPayments TEXT," +
                "GuardianEndorsement TEXT," +
                "WhenSafe TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit BIGINT," +
                "OtherStructuresIncreaseCoverageRentedToOthersDescription TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersLimit BIGINT," +
                "PermittedIncidentalOccupancyPropertyLimit BIGINT," +
                "CreditCardLimit TEXT," +
                "LimitedFungiLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit BIGINT," +
                "WaterBackUpLimit TEXT," +
                "SinkholeLossCoverage TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AnimalLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessActivity TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createNCHO3Table()
    {
        String tableName = "NCHO3";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateofBirth TEXT," +
                "SeniorCitizenDiscount TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 1)," +
                "DistanceToFireStation NUMERIC(28, 1)," +
                "TerritoryCode TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "DistanceToCoast TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue TEXT," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTHeNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually TEXT," +
                "MinimumRentalIncrement TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "ValuationType TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "DiscountType TEXT," +
                "FortifiedHomeType TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "DwellingLimit TEXT," +
                "OtherStructures TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductibleType TEXT," +
                "SectionIDeductiblesWindHail TEXT," +
                "SectionIDeductiblesNamedStorm TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersDescription TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersLimit TEXT," +
                "PermittedIncidentalOccupancyPropertyLimit TEXT," +
                "CreditCardLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "RefrigeratedPersonalProperty TEXT," +
                "EarthquakeCoverageDeductible TEXT," +
                "EarthquakeCoverageConstructionClass TEXT," +
                "EarthquakeZone TEXT," +
                "EarthquakeLossAssessmentCoverageLimit TEXT," +
                "SpecialComputerCoverage TEXT," +
                "SpecifiedAdditionalAmountOfCoverageA TEXT," +
                "WaterBackUpLimit TEXT," +
                "InflationGuardPercent TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessActivity TEXT," +
                "PersonalInjury TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createSCHO3Table()
    {
        String tableName = "SCHO3";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "nameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "InflationGuard TEXT," +
                "ExcludeLossOfUseCoverage TEXT," +
                "OfferingSelection TEXT," +
                "NoPriorInsuranceSurcharge TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 2)," +
                "DistanceToFireStation NUMERIC(28, 2)," +
                "TerritoryCode TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "WindPoolZone TEXT," +
                "DistanceToCoast TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue TEXT," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "ValuationType TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveknownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "SecondaryWaterResistance TEXT," +
                "IsTheRoofCoverConstructionBuildingCodeCompliant TEXT," +
                "IsTheRoofDeckAttachmentBuidingCodeCompliant TEXT," +
                "IsTheRoofWallConnectionBuildingCodeCompliant TEXT," +
                "DwellingLimit BIGINT," +
                "OtherStructures TEXT," +
                "PersonalPropertyExcluded TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossofUse TEXT," +
                "SectionIDeductiblesAop TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "GuardianEndorsement TEXT," +
                "WhenSafe TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersDescription TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersLimit TEXT," +
                "PermittedIncidentalOccupancyPropertyLimit TEXT," +
                "CreditCardLimit TEXT," +
                "LimitedFungiLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "EarthquakeCoverageDeductible TEXT," +
                "EarthquakeCoverageConstructionClass TEXT," +
                "EarthquakeLossAssessmentCoverageLimit TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit TEXT," +
                "SpecifiedAdditionalAmountOfCoverageA TEXT," +
                "WaterBackUpLimit TEXT," +
                "InflationGuardPercent TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AnimalLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessactivity TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createFLHO6Table()
    {
        String tableName = "FLHO6";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 2)," +
                "DistanceToFireStation NUMERIC(28, 2)," +
                "TerritoryCode TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "DistanceToCoast BIGINT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28,2)," +
                "MarketValue NUMERIC(28,2)," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually INT," +
                "MinimumRentalIncrement TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsThereALockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "EstimatedReplacementCost NUMERIC(28,2)," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories INT," +
                "FloorTheUnitIsLocatedOn TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "Terrain TEXT," +
                "RoofCover TEXT," +
                "RoofDeckAttachment TEXT," +
                "RoofWallConnection TEXT," +
                "SecondaryWaterResistance TEXT," +
                "RoofDeck TEXT," +
                "FBCWindSpeed TEXT," +
                "InternalPressure TEXT," +
                "WindBorneDebrisRegion TEXT," +
                "DwellingLimit TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "WindExcluded TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "PermittedIncidentalOccupancyPropertyLimit TEXT," +
                "CreditCardLimit TEXT," +
                "LimitedFungiLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit TEXT," +
                "UnitOwnersCoverageASpecialCoverageLimit BIGINT," +
                "UnitOwnersRentedToOthers TEXT," +
                "WaterBackUpLimit TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessActivity TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createSCHO6Table()
    {
        String tableName = "SCHO6";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "OfferingSelection TEXT," +
                "NoPriorInsuranceSurcharge TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 1)," +
                "DistanceToFireStation NUMERIC(28, 1)," +
                "TerritoryCode TEXT," +
                "BCEG TEXT," +
                "ProtectionClassCode TEXT," +
                "LocationType TEXT," +
                "InTheWindPool TEXT," +
                "WindPoolZone TEXT," +
                "DistanceToCoast NUMERIC(28, 1)," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "MarketValue NUMERIC(28,2)," +
                "AtTheInceptionOfThisPolicyWillThisPropertyBeDeededInTheNameOfCor TEXT," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "WeeksRentedAnnually INT," +
                "MinimumRentalIncrement TEXT," +
                "UnderContractWithRentalManagementCompany TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrBicycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "BurglarAlarmType TEXT," +
                "IsTheReaLockedPrivacyFence TEXT," +
                "AreThereAnyBurglarBarsOnTheWindowsDoors TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "FireAlarmType TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "Deadbolts TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfUnits TEXT," +
                "UnitsInFireWall TEXT," +
                "NumberOfStories INT," +
                "FloorTheUnitIsLocatedOn INT," +
                "SquareFootage INT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "PlumbingType TEXT," +
                "PlumbingYear YEAR," +
                "WaterHeaterYear YEAR," +
                "Wiring TEXT," +
                "ElectricalSystem TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "ConditionOfRoof TEXT," +
                "IsThereAScreenEnclosureOnPremises TEXT," +
                "DoesThePlumbingSystemHaveKnownLeaks TEXT," +
                "IsTheBuildingRetrofittedForEarthquakes TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "WasTheStructureOriginallyBuiltForOtherThanAPrivateResidenceAndTh TEXT," +
                "AnyLeadPaintHazard TEXT," +
                "IsAnyPortionOfAnyStructureAtThisPropertyLocationNowOrEverHasBeen TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "SecondaryWaterResistance TEXT," +
                "IsTheRoofCoverConstructionBuildingCodeCompliant TEXT," +
                "IsTheRoofDeckAttachmentBuidingCodeCompliant TEXT," +
                "IsTheRoofWallConnectionBuildingCodeCompliant TEXT," +
                "DwellingLimit BIGINT," +
                "PersonalPropertyLimit BIGINT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "GuardianEndorsement TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "PermittedIncidentalOccupancyPropertyLimit TEXT," +
                "CreditCardLimit TEXT," +
                "LimitedFungiLimit TEXT," +
                "LossAssessmentLimit TEXT," +
                "OrdinanceOrLawPercent TEXT," +
                "EarthquakeCoverageDeductible TEXT," +
                "EarthquakeCoverageConstructionClass TEXT," +
                "EarthquakeLossAssessmentCoverageLimit TEXT," +
                "ScreenEnclosureHurricaneCoverageLimit TEXT," +
                "UnitOwnersCoverageASpecialCoverageLimit BIGINT," +
                "UnitOwnersRentedToOthers TEXT," +
                "WaterBackUpLimit TEXT," +
                "PermittedIncidentalOccupancyLiability TEXT," +
                "AdditionalResidenceRentedToOthersLocation TEXT," +
                "AdditionalResidenceRentedToOthersNumberOfFamilies TEXT," +
                "BusinessPursuitsBusinessActivity TEXT," +
                "WatercraftLiablityWatercraftType TEXT," +
                "ConsentToRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28, 2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createNCHOWTable()
    {
        String tableName = "NCHOW";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "LastInspectionCompletionDate TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateofBirth TEXT," +
                "DoesTheInsureDownAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "TerritoryCode TEXT," +
                "DistanceToCoast NUMERIC(28, 1)," +
                "IsTheReaLockedPrivacyFence TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "EstimatedReplacementCost TEXT," +
                "ConstructionType TEXT," +
                "NumberOfStories TEXT," +
                "SquareFootage TEXT," +
                "RoofType TEXT," +
                "RoofYear YEAR," +
                "AnyUnCorrectedFireOrBuildingCodeViolations TEXT," +
                "DiscountType TEXT," +
                "FortifiedHomeType TEXT," +
                "RoofShape TEXT," +
                "OpeningProtectionType TEXT," +
                "DwellingLimit BIGINT," +
                "OtherStructures TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossofUse TEXT," +
                "SectionIDeductiblesWindHail TEXT," +
                "SectionIDeductiblesNamedStorm TEXT," +
                "SpecificOtherStructuresDescription TEXT," +
                "SpecificOtherStructuresLimit TEXT," +
                "OtherStructuresIncreaseCoverageRentedToOthersDescription TEXT," +
                "OtherStructuresIncreaseCoverageRentedtoOthersLimit TEXT," +
                "ResidenceHeldinTrust TEXT," +
                "SpecifiedAdditionalAmountofCoverageA TEXT," +
                "InflationGuardPercent TEXT," +
                "ConsenttoRate TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "TotalCost NUMERIC(28,2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void createFLMH3Table()
    {
        String tableName = "FLMH3";
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "TestRunID BIGINT," +
                "AccountNumber BIGINT," +
                "NameInsuredFirstName TEXT," +
                "NameInsuredMiddleName TEXT," +
                "NameInsuredLastName TEXT," +
                "NameInsuredTitle TEXT," +
                "DateOfBirth TEXT," +
                "HomePhone TEXT," +
                "WorkPhone TEXT," +
                "CellPhone TEXT," +
                "EmailAddress TEXT," +
                "MailingAddress TEXT," +
                "MailingCity TEXT," +
                "MailingCounty TEXT," +
                "MailingState TEXT," +
                "MailingZipCode TEXT," +
                "AddressType TEXT," +
                "Organization TEXT," +
                "ProducerCode TEXT," +
                "BaseState TEXT," +
                "Product TEXT," +
                "PolicyType TEXT," +
                "LegacyPolicyNumber TEXT," +
                "PolicyOriginalEffectiveDate TEXT," +
                "EffectiveDate TEXT," +
                "MobileHomePark TEXT," +
                "OfferingSelection TEXT," +
                "AdditionalNameInsuredFirstName TEXT," +
                "AdditionalNameInsuredLastName TEXT," +
                "AdditionalNameInsuredCompanyName TEXT," +
                "AdditionalNameInsuredDateOfBirth TEXT," +
                "DoesTheInsuredOwnAnyOtherResidenceThatIsInsuredWithFrontline TEXT," +
                "PolicyWriter TEXT," +
                "GroupMembership TEXT," +
                "LocationAddress TEXT," +
                "LocationAddressUnit TEXT," +
                "LocationAddressCity TEXT," +
                "LocationAddressState TEXT," +
                "LocationAddressZip TEXT," +
                "LocationAddressCounty TEXT," +
                "YearBuilt YEAR," +
                "DistanceToFireHydrant NUMERIC(28, 1)," +
                "DistanceToFireStation NUMERIC(28, 1)," +
                "TerritoryCode TEXT," +
                "PurchaseDate TEXT," +
                "PurchasePrice NUMERIC(28, 2)," +
                "PurchasedNew TEXT," +
                "MarketValue NUMERIC(28,2)," +
                "OccupiedDaily TEXT," +
                "ResidenceType TEXT," +
                "HowIsTheDwellingCustomarilyUsed TEXT," +
                "HowIsTheDwellingOccupied TEXT," +
                "IsThereASwimmingPool TEXT," +
                "IsThereATrampoline TEXT," +
                "IsThereASkateboardOrbiCycleRampOnPremises TEXT," +
                "AnyAnimalsOrExoticPetsOnPremises TEXT," +
                "AnyOwnedGolfCarts TEXT," +
                "AnyOwnedRecreationalVehicles TEXT," +
                "HousekeepingCondition TEXT," +
                "IsTheReaLockedPrivacyFence TEXT," +
                "IsTheCommunityGuarded TEXT," +
                "IsTheCommunityGated TEXT," +
                "SmokeAlarms TEXT," +
                "OneOrMoreFireExtinguishersInTheHome TEXT," +
                "SprinklerSystem TEXT," +
                "ResidenceVisibleToNeighbors TEXT," +
                "ValuationType TEXT," +
                "EstimatedReplacementCost TEXT," +
                "MobileHomeMake TEXT," +
                "MobileHomeModel TEXT," +
                "MobileHomeID TEXT," +
                "IsTheMobileHomeTiedDown TEXT," +
                "MobileHomeLength TEXT," +
                "MobileHomeWidth TEXT," +
                "ConstructionType TEXT," +
                "SquareFootage TEXT," +
                "FoundationType TEXT," +
                "PrimaryHeating TEXT," +
                "IsThereASecondaryHeatingSystem TEXT," +
                "AreThereAnyExteriorDoorOpeningsWithoutSteps TEXT," +
                "AreThereAnyAreasWith3orMoreStairsAndNoHandrails TEXT," +
                "AnyUncorrectedFireOrBuildingCodeViolations TEXT," +
                "AtInceptionOnThisPolicyWillThisMobileHomeBeWithoutContinuousUtil TEXT," +
                "IsTheMobileHomeFullySkirted TEXT," +
                "ConstructionCredit TEXT," +
                "DwellingLimit BIGINT," +
                "PersonalPropertyExcluded TEXT," +
                "PersonalPropertyLimit TEXT," +
                "PersonalPropertyValuationMethod TEXT," +
                "LossOfUse TEXT," +
                "SectionIDeductiblesAOP TEXT," +
                "SectionIDeductiblesHurricane TEXT," +
                "SectionIDeductiblesWater TEXT," +
                "PersonalLiability TEXT," +
                "MedicalPayments TEXT," +
                "SpecificOtherStructuresDetachedLimit TEXT," +
                "SpecificOtherStructuresDetachedDescription TEXT," +
                "SpecificOtherStructuresAttachedLimit TEXT," +
                "SpecificOtherStructuresAttachedDescription TEXT," +
                "GolfCartCoverage TEXT," +
                "LimitedFungiLimit TEXT," +
                "JewelryTheftIncreasedLimits TEXT," +
                "BillingContactInsuredOrMortgage TEXT," +
                "PaymentPlanSchedule TEXT," +
                "AAAMembership TEXT," +
                "AARPMembership TEXT," +
                "FMHOMembership TEXT," +
                "TotalCost NUMERIC(28, 2)," +
                "GoPaperless TEXT" +
                ");";
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            statement.execute(sqlCreate);
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nUnable to create table " + tableName);
            System.out.println("\n" + e.getMessage());
        }
    }

    public void insertIntoFLDP3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createFLDP3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO FLDP3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into FLDP3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoSCDP3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;
        createSCDP3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO SCDP3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into SCDP3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoALHO3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createALHO3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO ALHO3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into ALHO3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoFLHO3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createFLHO3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO FLHO3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into FLHO3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoNCHO3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createNCHO3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO NCHO3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into NCHO3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoSCHO3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createSCHO3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO SCHO3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into SCHO3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoFLHO6Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createFLHO6Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO FLHO6 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            System.out.println(query);
            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into FLHO6");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoSCHO6Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createSCHO6Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO SCHO6 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into SCHO6");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoNCHOWTable(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createNCHOWTable();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO NCHOW (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("unable to insert into NCHOW because " + e.getMessage());
        }
    }

    public void insertIntoFLMH3Table(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");
        String header;

        createFLMH3Table();
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!entry.getKey().toLowerCase().contains("ssn")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("annualizedtotalcost")
                    && !entry.getKey().toLowerCase().replaceAll("[\\W]", "").equals("submittedforapproval")
                    && !Strings.isNullOrEmpty(entry.getValue()))
            {
                header = entry.getKey().replaceAll("[\\W]", "");
                headers.add(header.substring(0, Math.min(header.length(), 64)));
                vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();
            query = "INSERT INTO FLMH3 (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into FLMH3");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoPoliciesTable(Map<String, String> data, String policyType)
    {
        if (policyType.contains("SCDP3"))
        {
            insertIntoSCDP3Table(data);
        }
        else if (policyType.contains("FLDP3"))
        {
            insertIntoFLDP3Table(data);
        }
        else if (policyType.contains("ALHO3"))
        {
            insertIntoALHO3Table(data);
        }
        else if (policyType.contains("FLHO3"))
        {
            insertIntoFLHO3Table(data);
        }
        else if (policyType.contains("NCHO3"))
        {
            insertIntoNCHO3Table(data);
        }
        else if (policyType.contains("SCHO3"))
        {
            insertIntoSCHO3Table(data);
        }
        else if (policyType.contains("FLHO6"))
        {
            insertIntoFLHO6Table(data);
        }
        else if (policyType.contains("SCHO6"))
        {
            insertIntoSCHO6Table(data);
        }
        else if (policyType.contains("FLMH3"))
        {
            insertIntoFLMH3Table(data);
        }
        else if (policyType.contains("NCHOW"))
        {
            insertIntoNCHOWTable(data);
        }
    }

    public void insertIntoAddIntsTable(String policyType, Map<String, String> data)
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
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();

            query = "INSERT INTO AddInt (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            System.out.println(query);
            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into AddInts");
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoSpcTable(String policyType, Map<String, String> data)
    {
        createSpcTable();

        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        headers.add("LegacyPolicyNumber");
        vals.add("\"" + policyType.replace(" ", "") + "\"");

        for (Map.Entry<String, String> entry : data.entrySet())
        {
            if (!Strings.isNullOrEmpty(entry.getValue()))
            {
                if (entry.getKey().toLowerCase().equals("limit"))
                    headers.add("Limit_");
                else
                {
                    headers.add(entry.getKey().replaceAll("[\\W]", "").trim());
                }
                vals.add("\"" + entry.getValue().replace("\"", "'").trim() + "\"");
            }
        }

        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();

            query = "INSERT INTO SPC (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";

            System.out.println(query);
            int result = statement.executeUpdate(query);
            if (result != 1)
                System.out.println("\nUnable to insert data into database\n");
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoResultsTable(Map<String, String> data)
    {
        StringJoiner headers = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        createReportingTable();

        try
        {
            for (Map.Entry<String, String> entry : data.entrySet())
            {
                if (entry.getKey().equals("Annualized Total Cost"))
                {
                    headers.add("PremiumVariation");
                } else if (entry.getKey().equals("Section I Deductibles - AOP"))
                {
                    headers.add("AOP Deductible");
                    vals.add(entry.getValue().replaceAll("[^0-9]", ""));
                }
                else if (!Strings.isNullOrEmpty(entry.getValue()))
                {
                    headers.add(entry.getKey().replace(" ", ""));
                    vals.add("\"" + entry.getValue().replace("\"", "'") + "\"");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            Connection conn = getConnectionFromPool();
            statement = conn.createStatement();

            query = "INSERT INTO TestResults (" + headers.toString() + ") " +
                    "VALUES (" + vals.toString() + ")";


            int result = statement.executeUpdate(query);
            System.out.println(query + "\nresult = " + String.valueOf(result));
            returnConnectionToPool(conn);
        }
        catch (SQLException e)
        {
            System.out.println("Unable to insert into TestResults table");
            System.out.println(e.getMessage());
        }
    }
}
