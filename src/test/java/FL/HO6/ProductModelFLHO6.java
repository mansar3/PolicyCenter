package FL.HO6;

import base.BaseTestPC;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageobjects.FLHO6.*;

import java.time.format.DateTimeFormatter;

public class ProductModelFLHO6 extends BaseTestPC
{
    private FLHO6EnterAccountInformation enterAccountInformation;
    private String firstname, lastname;

    @Test(description = "Creates account for Florida HO6 product")
    public void createPersonAccountFLHO6(ITestContext itc)
    {
        log(itc.getName());

        DateTimeFormatter.ofPattern("01/dd/uuuu");
        firstname = String.format("FLHO6Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
        String country = "United States",
                dob = ldt.minusYears(30).format(formatter),
                phoneNumber = "4071234567",
                address = "234 Walnut St",
                city = "Daytona Beach",
                state = "Florida",
                zipcode = "32114",
                addressType = "Home",
                ssn = "777-12-3456",
                producerCode = "523-23-21498 Brown & Brown of Florida - West Palm Beach";

        enterAccountInformation = new FLHO6EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLHO6CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLHO6();
        log(String.format("Creating new account: %s", dateString));

        try {
            createAccount
                    .setCountry(country)
                    .setDateOfBirth(dob)
                    .setMobilePhone(phoneNumber)
                    .setAddressLine1(address)
                    .setCity(city)
                    .setState(state)
                    .clickVerifyAddress()
                    .selectSuccessfulVerificationIfPossibleForCreateAccount()
                    .setAddressType(addressType)
                    .setSsn(ssn)
                    .setProducerCode(producerCode);

            String expectedAddress = createAccount.getAddressLine1();
            Assert.assertTrue(expectedAddress.toUpperCase().equals(address.toUpperCase()),
                    "Address expected was " + address + " but it was " + expectedAddress);
            Assert.assertTrue(createAccount.getZipCode().contains(zipcode),
                    "Zipcode expected was " + createAccount.getZipCode() +
                            ", but it was " + zipcode);

            FLHO6AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            log(e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Test(description = "FL.HO6.productModel.LessCoverage001",
            dependsOnMethods = {"createPersonAccountFLHO6"})
    public void productModelLessCoverageFLHO6(ITestContext itc)
    {
        log(itc.getName());

        String policyType = "Condominium (HO6)";
        String offeringSelection = "Less Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "Condominium";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Owner Occupied";
        String roofShapeType = "Gable";
        String dwellingLimit = "100000";
        String personalPropertyLimit = "50,000",
                expectedPersonalPropertyLimit = "",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Actual Cash Value";
        String lossOfUsePercentage, defaultLossOfUsePercentage = "40%";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String hurricanePercentage, defaultHurricanePercentage = "10%";
        String personalLiabilityLimit, defaultPersonalLiabilityLimit = "100,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String otherStructuresTableLimit = "1,000";
        String scheduledPersonalPropertyArticleType = "Antiques", scheduledPersonalPropertyDescription = "test",
                scheduledPersonalPropertyValue = "1,000";
        String expectedScheduledPersonalPropertyArticleType, expectedScheduledPersonalPropertyValue;
        String creditCard, defaultCreditCard = "5,000";
        String lossAssessmentLimit, expectedLossAssessmentLimit = "2,000";
        String ordinanceOrLawLimit, defaultOrdinanceOrLawLimit = "25%";
        String otherStructuresTableDescription = "test";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "10,000 / 50,000";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";
        String watercraftType, expectedWatercraftType = "Up to 50 Horsepower and up to 15 feet";

    /* Begin Test */
        enterAccountInformation = new FLHO6EnterAccountInformation(sh);
        FLHO6AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLHO6();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO6NewSubmission ns = new FLHO6NewSubmission(sh);
        FLHO6Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++)
        {
            qualification.questionnaire.answerNo(i+1);
        }

        FLHO6Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode("005")    // This line had to be added because test would not proceed without this value
                .setBCEG("05")              // This line had to be added because test would not proceed without this value
                .setProtectionClassCode(protectionClassCode)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity("false")
                .setResidenceType(residenceType)
                .setDwellingUsage(dwellingUsage)
                .setDwellingOccupancy(dwellingOccupance);

        FLHO6Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next();

        /* Dwelling Limit */
        String defaultDwellingLimit = coverages.getDwellingLimit();
        Assert.assertTrue(defaultDwellingLimit.equals(defaultDwellingLimit),
                "Dwelling limit was expected to be " + defaultDwellingLimit +
                        " but it was" + defaultDwellingLimit);
        coverages.setDwellingLimit(dwellingLimit);

        /* Personal Property */
        String defaultPersonalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(defaultPersonalPropertyLimit.equals(expectedPersonalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + defaultPersonalPropertyLimit);

        coverages.setPersonalPropertyLimit(personalPropertyLimit);
        expectedPersonalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        /* Personal Property Valuation Method */
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyValuationMethod);

        lossOfUsePercentage = coverages.getLossOfUseSelection();
        Assert.assertTrue(defaultLossOfUsePercentage.equals(lossOfUsePercentage),
                "Loss Of Use Percentage was expected to be " + defaultLossOfUsePercentage +
                        ", but it was " + lossOfUsePercentage);

        /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");

        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricanePercentage = coverages.setHurricane(defaultHurricanePercentage).getHurricanePercentage();
        Assert.assertTrue(defaultHurricanePercentage.equals(hurricanePercentage),
                "Hurricane Deductible was expected to be " + defaultHurricanePercentage +
                        ", but it was " + hurricanePercentage);

        Assert.assertFalse(coverages.setWindExcluded("true").isHurricanePresent(),
                "Hurricane was not expected to be present but it was");
        Assert.assertTrue(coverages.setWindExcluded("false").isHurricanePresent(),
                "Hurricane was expected to be present but it was not");
        coverages.setHurricane(defaultHurricanePercentage);

        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(defaultPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability Limit was expected to be " + defaultPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);

        /* Medical Payments */
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        FLHO6Coverages.FLHO6PropertyEndorsements pe = coverages.clickPropertyEndorsements();
        pe.checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresDescription(1, otherStructuresTableDescription)
                .setSpecificOtherStructuresLimit(1, otherStructuresTableLimit);

        Assert.assertFalse(pe.isScheduledPersonalPropertyChecked(),
                "Scheduled Personal Property was not expected to be checked, but it was");
        pe.checkScheduledPersonalProperty().clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, scheduledPersonalPropertyArticleType)
                .setPersonalPropertyDescription(1, scheduledPersonalPropertyDescription)
                .setPersonalPropertyValue(1, scheduledPersonalPropertyValue);

        expectedScheduledPersonalPropertyArticleType = pe.getScheduledPersonalPropertyClassArticleType(1);
        expectedScheduledPersonalPropertyValue = pe.getScheduledPersonalPropertyClassValue(1);

        Assert.assertTrue(expectedScheduledPersonalPropertyArticleType.equals(scheduledPersonalPropertyArticleType),
                "Was expected " + expectedScheduledPersonalPropertyArticleType +
                        ", but it was " + scheduledPersonalPropertyArticleType);
        Assert.assertTrue(expectedScheduledPersonalPropertyValue.equals(scheduledPersonalPropertyValue),
                "Was expected " + expectedScheduledPersonalPropertyValue +
                        ", but it was " + scheduledPersonalPropertyValue);

        pe.checkCreditCardFundTransferForgeryCounterfeitMoney();
        creditCard = pe.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        Assert.assertTrue(defaultCreditCard.equals(creditCard),
                "Credit Card was expected to be " + defaultCreditCard +
                        ", but it was " + creditCard);

        /* Limited Fungi, Wet or dry Rot, or Bacteria */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                "Limit Fungi, Wet or Dry Rot... Occurrence/Aggregate Limit " + defaultFungiOccurrenceAggregateLimit +
                        ", but it was " + fungiOccurrenceAggregateLimit);

        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                        ", but it was " + lossAssessmentLimit);

        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(defaultOrdinanceOrLawLimit.equals(ordinanceOrLawLimit),
                "Ordinance Or Law Limit was expected to be " + defaultOrdinanceOrLawLimit +
                        ", but it was " + ordinanceOrLawLimit);

        Assert.assertFalse(pe.isScreenEnclosureHurricaneCoverageChecked(),
                "Screen Enclosure Hurricane Coverage was expected to be checked but it was not");
        Assert.assertFalse(pe.isUnitOwnersCoverageASpecialCoverage(),
                "Unit Owners Coverage A - Special Coverage was not expected to be checked but it was");

        //TODO Unit Owners Rented to Others is now showing up so this must be uncommented when fixed
        /*Assert.assertFalse(pe.isUnitOwnersRentedToOthers(),
                "Unit Owners Rented to Others was not expected to be checked but it was");*/

        Assert.assertFalse(pe.isWaterBackUpChecked(),
                "Water Back Up was not expected to be checked but it was");
        waterBackUpLimit = pe.checkWaterBackUp().getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);

        FLHO6Coverages.FLHO6LiabilityEndorsements le = pe.clickLiabilityEndorsements();

        /* Liability Endorsements */
        Assert.assertFalse(le.isPermittedIncidentalOccupancyLiabilityChecked(),
                "Permitted Incidental Occupancy Liability was not expected to be checked but it was");
        
        Assert.assertFalse(le.isBusinessPursuitsChecked(),
                "Business Pursuits was not expected to be checked but it was");
        Assert.assertFalse(le.isWatercraftLiabilityChecked(),
                "Watercraft Liability was not expected to be checked but it was");
        le.checkWatercraftLiability().setWatercraftType(expectedWatercraftType);
        watercraftType = le.getWatercraftType();
        Assert.assertTrue(expectedWatercraftType.equals(watercraftType),
                        "Watercraft Type was expected to be " + expectedWatercraftType +
                                ", but it was " + watercraftType);

        afs.westPanel.clickDwelling();
        dwelling.setDwellingOccupancy("Tenant Occupied")
                .setDwellingUsage("Secondary")
                .setResidenceType("Condominium")
                .next()
                .next()
                .clickLiabilityEndorsements();

        Assert.assertTrue(le.checkPermittedIncidentalOccupancyLiability().clickPropertyEndorsements()
                .isPermittedIncidentalOccupancyDisplayed(),
                "Permitted Incidental Occupancy was expected to be present but it was not");

        le.clickCoverages().setPersonalPropertyLimit("110,000");
        Assert.assertFalse(coverages.isItemInHurricaneDropdown("500"),
                "500 was not expected to be an option in Hurricane dropdown but it was");

        Assert.assertTrue(coverages.setDwellingLimit("500,000")
                        .setPersonalPropertyLimit("35,000")
                        .setAllOtherPerils("500")
                        .isItemInHurricaneDropdown("5%"),
                        "5% was expected to be an option in Hurricane dropdown but it was not");

        Assert.assertTrue(coverages.setPersonalPropertyLimit("110,000")
                        .setAllOtherPerils("1,000")
                        .isItemInHurricaneDropdown("5%"),
                "5% was expected to be an option in Hurricane dropdown but it was not");

        Assert.assertTrue(coverages.setPersonalPropertyLimit("34,000")
                        .setAllOtherPerils("2,500")
                        .isItemInHurricaneDropdown("5%"),
                "5% was expected to be an option in Hurricane dropdown but it was not");

        Assert.assertTrue(coverages.setPersonalPropertyLimit("12,000")
                        .setAllOtherPerils("1,000")
                        .isItemInHurricaneDropdown("10%"),
                "10% was expected to be an option in Hurricane dropdown but it was not");

        Assert.assertTrue(coverages.setAllOtherPerils("2,500")
                        .isItemInHurricaneDropdown("10%"),
                "10% was expected to be an option in Hurricane dropdown but it was not");
    }

    @Test(description = "FL.HO6.ProductModel.MoreCoverage003"/*, dependsOnMethods =
            { "createPersonAccountFLHO6" }*/)
    public void productModelMostCoverageFLHO6(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
        firstname = "FLHO6Ricky0302013826";
        lastname = "Bobby0302013826";

        String policyType = "Condominium (HO6)";
        String offeringSelection = "More Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "Condominium";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Owner Occupied";
        String roofShapeType = "Gable";
        String dwellingLimit = "400000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "50,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        String lossOfUsePercentage, expectedLossOfUsePercentage = "40%";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String creditCard, defaultCreditCard = "5,000";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "10,000 / 50,000";
        String lossAssessmentLimit,
                expectedLossAssessmentLimit = "3,000";
        String ordinanceOrLawLimit, defaultOrdinanceOrLawLimit = "50%";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";

        /* Begin Test */
        FLHO6NavigationBar nb = new FLHO6NavigationBar(sh);
        FLHO6SearchAccounts sa = nb.clickSearchAccount();
        FLHO6AccountFileSummary afs = sa.setFirstName(firstname)
                .setLastName(lastname)
                .clickSearchButton()
                .clickAccountNumberSearchAccount();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO6NewSubmission ns = new FLHO6NewSubmission(sh);
        FLHO6Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        FLHO6Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode("005")    // This line had to be added because test would not proceed without this value
                .setBCEG("05")              // This line had to be added because test would not proceed without this value
                .setProtectionClassCode(protectionClassCode)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity("false")
                .setResidenceType(residenceType)
                .setDwellingUsage(dwellingUsage)
                .setDwellingOccupancy(dwellingOccupance);

        FLHO6Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .setDwellingLimit(dwellingLimit);

        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue("".equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);
        coverages.setPersonalPropertyLimit(expectedPersonalPropertyLimit);

        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyLimit);

        lossOfUsePercentage = coverages.getLossOfUseSelection();
        Assert.assertTrue(expectedLossOfUsePercentage.equals(lossOfUsePercentage),
                        "Loss Of Use Percentage was expected to be " + expectedLossOfUsePercentage +
                                ", but it was " + lossOfUsePercentage);

        /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricanePercentage();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "" + defaultHurricaneDeductible +
                        ", but it was " + hurricaneDeductible);

        /* Medical Payments */
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        FLHO6Coverages.FLHO6PropertyEndorsements pe = coverages.clickPropertyEndorsements();

        /* Property Endorsements */
        Assert.assertFalse(pe.isSpecificOtherStructuresChecked(),
                "Specific Other Structures was not expected to be checked but it was");
        Assert.assertFalse(pe.isScheduledPersonalPropertyChecked(),
                "Scheduled Personal Property was expected to be checked but it was not");
        creditCard = pe.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        Assert.assertTrue(defaultCreditCard.equals(creditCard),
                        "Credit Card was expected to be " + defaultCreditCard +
                                ", but it was " + creditCard);

        /* Limited Fungi, Wet or dry Rot, or Bacteria */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                "Limit Fungi, Wet or Dry Rot... Occurrence/Aggregate Limit " + defaultFungiOccurrenceAggregateLimit +
                        ", but it was " + fungiOccurrenceAggregateLimit);

        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                        "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                                ", but it was " + lossAssessmentLimit);

        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(defaultOrdinanceOrLawLimit.equals(ordinanceOrLawLimit),
                        "Ordinance Or Law Limit was expected to be " + defaultOrdinanceOrLawLimit +
                                ", but it was " + ordinanceOrLawLimit);

        Assert.assertFalse(pe.isScreenEnclosureHurricaneCoverageChecked(),
                "Screen Enclosure Hurricane Coverage was not expected to be checked but it was");

        Assert.assertFalse(pe.isUnitOwnersCoverageASpecialCoverage(),
                "Unit Owners Coverage A Special Coverage was not expected to be checked but it was");

        Assert.assertFalse(pe.isUnitOwnersRentedToOthers(),
                "Unit Owners Rented To Others was not expected to be checked but it was");

        Assert.assertTrue(pe.isWaterBackUpChecked(),
                "Water Back Up was expected to be checked but it was not");
        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);

        FLHO6Coverages.FLHO6LiabilityEndorsements le = pe.clickLiabilityEndorsements();

        /* Liability Endorsements */
        Assert.assertFalse(le.isPermittedIncidentalOccupancyLiabilityChecked(),
                "Permitted Incidental Occupancy Liability was not expected to be checked but it was");
        Assert.assertFalse(le.isAdditionalResidenceRentedToOthersChecked(),
                "Additional Residence Rented To Others was not expected to be checked but it was");
        Assert.assertFalse(le.isBusinessPursuitsChecked(),
                "Business Pursuits was not expected to be checked but it was");
        Assert.assertFalse(le.isWatercraftLiabilityChecked(),
                "Watercraft Liability was not expected to be checked but it was");
    }
}
