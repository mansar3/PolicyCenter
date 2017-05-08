package SC.HO6;

import base.BaseTestPC;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageobjects.SCHO6.*;

import java.time.format.DateTimeFormatter;

public class ProductModelSCHO6 extends BaseTestPC
{
    private SCHO6EnterAccountInformation enterAccountInformation;
    private String firstname, lastname;

    @Test(description = "Creates account for South Carolina HO6 product")
    public void createPersonAccountSCHO6(ITestContext itc)
    {
        log(itc.getName());

        DateTimeFormatter.ofPattern("01/dd/uuuu");
        firstname = String.format("SCHO6Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
        String  country = "United States",
                dob = ldt.minusYears(30).format(formatter),
                phoneNumber = "2561234567",
                address = "3222 Sand Marsh Ln",
                city = "Mount Pleasant",
                state = "South Carolina",
                county = "Charlestone",
                zipcode = "29466",
                addressType = "Home",
                ssn = "777-12-3456",
                producerCode = "523-23-21498 Brown & Brown of Florida - West Palm Beach";

        enterAccountInformation = new SCHO6EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        SCHO6CreateAccount createAccount = enterAccountInformation.createNewPersonAccountSCHO6();
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

            SCHO6AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            log(e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Test
    public void productModelSCHO6LessCoverage(ITestContext itc)
    {

    }

    @Test(description = "FL.HO6.ProductModel.MoreCoverage003", dependsOnMethods =
            { "createPersonAccountSCHO6" })
    public void productModelMoreCoverageSCHO6(ITestContext itc)
    {
        log(itc.getName());

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
        String dwellingLimit = "340000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "50,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        String lossOfUsePercentage, expectedLossOfUsePercentage = "40%";
        String lossOfUseLimit, defaultLossOfUseLimit = "20,000";
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
        SCHO6NavigationBar nb = new SCHO6NavigationBar(sh);

        enterAccountInformation = new SCHO6EnterAccountInformation(sh);
        SCHO6AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberSCHO6();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        SCHO6NewSubmission ns = new SCHO6NewSubmission(sh);
        SCHO6Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        SCHO6Dwelling dwelling = qualification
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

        SCHO6Coverages coverages = dwelling.next()
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
        lossOfUseLimit = coverages.getLossOfUseLimit(3);
        Assert.assertTrue(defaultLossOfUseLimit.equals(lossOfUseLimit),
                        "Loss Of Use Limit was expected to be " + defaultLossOfUseLimit +
                                ", but it was " + lossOfUseLimit);


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

        SCHO6Coverages.SCHO6PropertyEndorsements pe = coverages.clickPropertyEndorsements();

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

        SCHO6Coverages.SCHO6LiabilityEndorsements le = pe.clickLiabilityEndorsements();

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
