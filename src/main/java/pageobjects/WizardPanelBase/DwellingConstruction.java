package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;

public abstract class DwellingConstruction<T extends DwellingConstruction> extends CenterPanelBase {
    private DwellingConstructionBy by;
    protected String dwellingConstructionBase, windMitigationBase, tabBase, discountBase;
    public WindMitigation wm;

    public DwellingConstruction(CenterSeleniumHelper sh, Path path) {
        this.sh = sh;
        this.path = path;
        expectedPanelTitle = "Dwelling Construction";
        waitForTitle(sh);
        setID(path);
        by = new DwellingConstructionBy();
        wm = new WindMitigation(sh, path);
        log("Navigated to page: " + expectedPanelTitle);
    }

    public void setID(Path path) {
        switch (path) {
            case SUBMISSION:
                dwellingConstructionBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
                tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                discountBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                break;
            case POLICYRENEWAL:
                dwellingConstructionBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
                tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                discountBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                break;
            case POLICYCHANGE:
                dwellingConstructionBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
                tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                break;
        }
    }

    protected T coveragesNext() {
        sh.waitForNoMask();
        sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
        return (T) this;
    }

    protected T setRoofYear(String roofYear) {
        sh.setText(by.roofYear, roofYear);
        return (T) this;
    }

    protected String getRoofYear() {
        return sh.getValue(by.roofYear);
    }


    protected T windMitigation() {

        sh.clickElement(by.windMitigation);
        return (T) this;
    }

    protected T editPolicyTransaction(){
        sh.waitForNoMask();
        sh.clickElement(by.editPolicyTransaction);
        return (T) this;
    }

    protected T accept()
    {
        sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
        sh.clickElement(By.xpath(".//*[text()= 'OK']"));
        return (T) this;

    }
    protected  T clickDwellingConstructionSaveDraft()
    {
        sh.clickElement(by.saveDraft);
        sh.waitForNoMask();
        return (T) this;

    }

    protected String getValuationType() {
        return sh.getValue(by.valuationType);
    }

    protected T setValuationType(String valuationType) {
        sh.setText(by.valuationType, valuationType);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getEstimatedReplacementCost() {
        return sh.getValue(by.estimatedReplacementCost);
    }

    protected T setEstimatedReplacementCost(String estimatedReplacementCost) {
        sh.setText(by.estimatedReplacementCost, estimatedReplacementCost);
        return (T) this;
    }

    protected String getConstructionType() {
        return sh.getValue(by.constructionType);
    }

    protected T setConstructionType(String constructionType) {
        sh.setText(by.constructionType, constructionType);
        sh.tab();
        return (T) this;
    }

    protected String getNumberOfUnits() {
        return sh.getValue(by.numberOfUnits);
    }

    protected T setNumberOfUnits(String numberOfUnits) {
        sh.setText(by.numberOfUnits, numberOfUnits);
        sh.tab();
        return (T) this;
    }

    protected String getUnitsInFireWall() {
        return sh.getValue(by.unitsInFireWall);
    }

    protected T setUnitsInFireWall(String unitsInFireWall) {
        sh.setText(by.unitsInFireWall, unitsInFireWall);
        sh.tab();
        return (T) this;
    }

    protected String getNumberOfStories() {
        return sh.getValue(by.numberOfStories);
    }

    protected T setNumberOfStories(String numberOfStories) {
        sh.setText(by.numberOfStories, numberOfStories);
        return (T) this;
    }

    protected String getSquareFootage() {
        return sh.getValue(by.squareFootage);
    }

    protected T setSquareFootage(String squareFootage) {
        sh.setText(by.squareFootage, squareFootage);
        return (T) this;
    }

    protected String getFoundationType() {
        return sh.getValue(by.foundationType);
    }

    protected T setFoundationType(String foundationType) {
        sh.setText(by.foundationType, foundationType);
        sh.tab();

        return (T) this;
    }

    protected String getPrimaryHeating() {
        return sh.getValue(by.primaryHeating);
    }

    protected T setPrimaryHeating(String primaryHeating) {
        sh.setText(by.primaryHeating, primaryHeating);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getPlumbing() {
        return sh.getValue(by.plumbing);
    }

    protected T setPlumbing(String plumbing) {
        sh.setText(by.plumbing, plumbing);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getPlumbingYear() {
        return sh.getValue(by.plumbingYear);
    }

    protected T setPlumbingYear(String plumbingYear) {
        sh.setText(by.plumbingYear, plumbingYear);
        return (T) this;
    }

    protected String getWaterHeaterYear() {
        return sh.getValue(by.waterHeaterYear);
    }

    protected T setWaterHeaterYear(String waterHeaterYear) {
        sh.setText(by.waterHeaterYear, waterHeaterYear);
        return (T) this;
    }

    protected String getWiring() {
        return sh.getValue(by.wiring);
    }

    protected T setWiring(String wiring) {
        sh.setText(by.wiring, wiring);
        sh.tab();
        return (T) this;
    }

    protected String getMobileHomeWidth() {
        return sh.getValue(by.mobileHomeWidth);
    }

    protected T setMobileHomeWidth(String mobilehomewidth) {
        sh.setText(by.mobileHomeWidth, mobilehomewidth);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }


    protected String getMobileHomeLength() {
        return sh.getValue(by.mobileHomeLength);
    }

    protected T setMobileHomeLength(String mobilehomeLength) {
        sh.setText(by.mobileHomeLength, mobilehomeLength);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getMobileHomeMake() {
        return sh.getValue(by.mobileHomeMake);
    }

    protected T setMobileHomeMake(String mobilehomeMake) {
        sh.setText(by.mobileHomeMake, mobilehomeMake);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getMobileHomeModel() {
        return sh.getValue(by.mobileHomeModel);
    }

    protected T setMobileHomeModel(String mobilehomeModel) {
        sh.setText(by.mobileHomeModel, mobilehomeModel);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getMobileHomeId() {
        return sh.getValue(by.mobileHomeId);
    }

    protected T setMobileHomeId(String mobilehomeModel) {
        sh.setText(by.mobileHomeId, mobilehomeModel);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }





    protected String getElectricalSystem() {
        return sh.getValue(by.electricalSystem);
    }


    protected T setElectricalSystem(String electricalSystem) {
        sh.setText(by.electricalSystem, electricalSystem);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getRoofType() {
        return sh.getValue(by.roofType);
    }

    protected T setRoofType(String roofType) {
        sh.setText(by.roofType, roofType);
        sh.tab();
        sh.waitForNoMask();
        return (T) this;
    }

    protected String getConditionOfRoof() {
        return sh.getValue(by.conditionOfRoof);
    }

    protected T setConditionOfRoof(String conditionOfRoof) {
        sh.setTextUntil(by.conditionOfRoof, conditionOfRoof);
        sh.tab();
        return (T) this;
    }

    protected T setIsThereASecondaryHeatingSystem(String flag) {
        sh.clickElement(By.id(dwellingConstructionBase + "SecondaryHeatingExists_" + flag.toLowerCase() + "-inputEl"));

        return (T) this;
    }

    protected T setIsTheMobileHomeFullySkirted(String flag) {
        sh.clickElement(By.id(dwellingConstructionBase + "IsMHFullySkirted_fli_" + flag.toLowerCase() + "-inputEl"));
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setIsTheMobileHomeTiedDown(String flag) {
        sh.clickElement(By.id(dwellingConstructionBase + "MHConstructionDetail:IsMHTiedDown_fli_" + flag.toLowerCase() + "-inputEl"));
        sh.waitForNoMask();
        return (T) this;
    }



    protected String getElectricalSystemDescribeOther() {
        return sh.getValue(by.electricalSystemDescribeOther);
    }

    protected T setElectricalSystemDescribeOther(String electricalSystemDescribeOther) {
        sh.setText(by.electricalSystemDescribeOther, electricalSystemDescribeOther);
        sh.tab();

        return (T) this;
    }

    protected String getRoofTypeDescription() {
        return sh.getValue(by.roofTypeDescription);
    }

    protected T setRoofTypeDescription(String roofTypeDescription) {
        sh.setText(by.roofTypeDescription, roofTypeDescription);
        sh.tab();

        return (T) this;
    }

    protected String getPlumbingDescribeOther() {
        return sh.getValue(by.plumbingDescribeOther);
    }

    protected T setPlumbingDescribeOther(String plumbingDescribeOther) {
        sh.setText(by.plumbingDescribeOther, plumbingDescribeOther);
        sh.tab();

        return (T) this;
    }

    protected T setPlumbingSystemHaveKnownLeaks(String flag) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Does the plumbing system have known leaks?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setBuildingRetrofittedForEarthquakes(String flag) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Is the building retrofitted for earthquakes?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setUncorrectedFireOrBuildingCodeViolations(String flag) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Any uncorrected fire or building code violations?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }
	protected T setAreThereAnyExteriorDoorOpeningsWithoutSteps(String flag)
	{
		sh.clickElement(By.xpath(".//*[text() = 'Are there any exterior door openings without steps?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setAreThereAnyAreasWith3OrMoreStairsAndNoHandrails(String flag)
	{
		sh.clickElement(By.xpath(".//*[text() = 'Are there any areas with 3 or more stairs and no handrails?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setAtTheInceptionOfThisPolicyWillThisMobileHomeBeWithoutContinuousUtilityService(String flag)
	{
		sh.clickElement(By.xpath(".//*[text() = 'At inception of this policy, will this mobile home be without continuous utility service?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		return (T)this;
	}

	protected T setConstructionCredit(String flag)
	{
		sh.waitForNoMask();
		sh.clickElement(By.xpath("//*[@id = '" + discountBase +
		"Modifiers_fliPanelSet:aRateModifierListView:0']//div[text() = 'Construction Credit']/../..//input[@inputvalue = '" + flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		sh.clickElement(By.xpath("//*[@id = '" + discountBase +
		"Modifiers_fliPanelSet:aRateModifierListView:0']//div[text() = 'Construction Credit']/../..//input[@inputvalue = '" + flag.toLowerCase() + "']"));
		sh.waitForNoMask();

		return (T)this;
	}

    protected T setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Was the structure originally built for other than a private residence and then converted?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }


    protected T setLeadPaintHazard(String flag) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Any lead paint hazard?']/../..//input[@inputvalue = '" +
                        flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag) {
        sh.clickElement(
                By.xpath("//*[@id = '" + tabBase + "HODwellingConstruction_fliPanelSet:questionSetsDVx:QuestionSetsDV:0:QuestionSetLV-body']" +
                        "//div[contains(text(), 'Is any portion of any structure at this property location now (or ever has been) a mobile')]/../..//input[@inputvalue = '" + flag.toLowerCase() + "']"));
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setBuildingRetrofittedForEarthquakesDescription(String text) {
        sh.clickElement(By.xpath("//*[text() = 'Is the building retrofitted for earthquakes?']/../../following-sibling::tr[1]/td[3]/div"));
        sh.waitForElementToAppear(By.name("c2"));
        sh.setText(By.name("c2"), text);
		sh.waitForNoMask();
        return (T) this;
    }

    protected T setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String text) {
        sh.clickElement(By.xpath("//*[text() = 'Was the structure originally built for other than a private residence and then converted?']/../../following-sibling::tr[1]/td[3]/div"));

        sh.waitForElementToAppear(By.name("c2"));
        sh.setText(By.name("c2"), text);
		sh.waitForNoMask();
        return (T) this;
    }

    protected T setUncorrectedFireOrBuildingCodeViolationsDescription(String text) {
        sh.clickElement(
                By.xpath(".//*[text() = 'Any uncorrected fire or building code violations?']/../../following-sibling::tr[1]/td[3]/div"));
        sh.waitForElementToAppear(By.name("c2"));
        sh.setText(By.name("c2"), text);
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setLeadPaintHazardDescription(String text) {
        sh.clickElement(
                By.xpath("//*[text() = 'Any lead paint hazard?']/../../following-sibling::tr[1]/td[3]/div"));
        sh.waitForElementToAppear(By.name("c2"));
        sh.setText(By.name("c2"), text);
        sh.waitForNoMask();
        return (T) this;
    }

    protected T setScreenEnclosureOnPremises(String flag) {
        sh.clickElement(By.id(dwellingConstructionBase + "HasScreenedEnclosure_fli_" + flag.toLowerCase() + "-inputEl"));
        sh.waitForNoMask();
        return (T) this;
    }

    private void setTextToDescription(String text) {
        sh.waitForElementToAppear(By.name("c2"));
        sh.setText(By.name("c2"), text);
    }

    protected String getFloorUnitIsLocatedOn() {
        return sh.getValue(by.floorUnitIsLocatedOn);
    }

    protected DwellingConstruction setFloorUnitIsLocatedOn(String floorUnitIsLocatedOn) {
        sh.setText(by.floorUnitIsLocatedOn, floorUnitIsLocatedOn);
        sh.tab();
        return this;
    }

    protected T dwellingBack() {
        clickBack();
        sh.waitForNoMask();
        return (T) this;
    }


    protected String dwellingConstructionErrorMessage()

    {
        sh.waitForNoMask();
        String Error = sh.driver.findElement(By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:_msgs']/div")).getText();
        return Error;
    }


    protected T dwellingConstructionEnter() {
        sh.driver.findElement(By.id("SubmissionWizard:Next-btnInnerEl")).sendKeys(Keys.ENTER);
        sh.waitForNoMask(10);
        return (T) this;
    }

    protected T DwellingconstructionQuote(){
        sh.waitForNoMask();
        sh.clickElement(by.quote);
        return (T) this;
    }


    /**
     * @return true if answer is 'yes', false if 'no'
     */
    protected boolean isMobileHomeTiedDown()
    {
        boolean yesButton = sh.isRadioButtonSelected(by.isTheMobileHomeTiedDownYes);
        boolean noButton = sh.isRadioButtonSelected(by.isTheMobileHomeTiedDownNo);

        if (!yesButton && !noButton)
            throw new WebDriverException("Yes or No was expected to be selected, but none of they were");
        else if (yesButton && noButton)
            throw new WebDriverException("Both Yes and No radio buttons were selected");
        return yesButton;
    }

    protected boolean isConstructionTypeRequired()
    {
        return sh.isFieldMarkedRequired(by.constructionType);
    }

    protected boolean isFoundationTypeRequired()
    {
        return sh.isFieldMarkedRequired(by.foundationType);
    }

    protected boolean isMobileHomeFullySkirtedRequired()
    {
        return sh.isFieldMarkedRequired(by.isTheMobileHomeFullySkirted);
    }

    protected boolean isMobileHomeFullySkirted()
    {
        return sh.yesOrNoSelected(by.isTheMobileHomeFullySkirted);
    }

    public class DwellingConstructionBy {

        final By roofYear = By.id(dwellingConstructionBase + "RoofYear_fli-inputEl"),
                valuationType = By.id(dwellingConstructionBase + "MSBInputSet:ValuationType_fli-inputEl"),
                estimatedReplacementCost = By.id(dwellingConstructionBase + "ReplacementCost-inputEl"),
                constructionType = By.id(dwellingConstructionBase + "ConstructionType-inputEl"),
                numberOfUnits = By.id(dwellingConstructionBase + "UnitsNumber-inputEl"),
                unitsInFireWall = By.id(dwellingConstructionBase + "NumOfUnitsInFirewall_fli-inputEl"),
                numberOfStories = By.id(dwellingConstructionBase + "NumberOfStories_fli-inputEl"),
                floorUnitIsLocatedOn = By.id(dwellingConstructionBase + "CondoUnitFloorNumber_fli-inputEl"),
                squareFootage = By.id(dwellingConstructionBase + "ApproxSquareFootage-inputEl"),
                mobileHomeWidth = By.id(dwellingConstructionBase + "MHConstructionDetail:MHWidth_fli-inputEl"),
                mobileHomeLength = By.id(dwellingConstructionBase + "MHConstructionDetail:MHLength_fli-inputEl"),
                mobileHomeMake = By.id(dwellingConstructionBase + "MHConstructionDetail:MHMake_fli-inputEl"),
                mobileHomeModel =  By.id(dwellingConstructionBase + "MHConstructionDetail:MHModel_fli-inputEl"),
                mobileHomeId =  By.id(dwellingConstructionBase + "MHConstructionDetail:MHSerialNumber_fli-inputEl"),
                foundationType = By.id(dwellingConstructionBase + "Foundation-inputEl"),
                primaryHeating = By.id(dwellingConstructionBase + "PrimaryHeating-inputEl"),
                plumbing = By.id((dwellingConstructionBase + "PlumbingType-inputEl")),
                plumbingDescribeOther = By.id(dwellingConstructionBase + "PlumbingTypeDescription-inputEl"),
                plumbingYear = By.id(dwellingConstructionBase + "PlumbingYear_fli-inputEl"),
                waterHeaterYear = By.id(dwellingConstructionBase + "WaterHeaterYear_fli-inputEl"),
                wiring = By.id(dwellingConstructionBase + "WiringType-inputEl"),
                electricalSystem = By.id(dwellingConstructionBase + "ElectricalType-inputEl"),
                electricalSystemDescribeOther = By.id(dwellingConstructionBase + "ElectricalTypeDesc-inputEl"),
                roofType = By.id(dwellingConstructionBase + "RoofType-inputEl"),
                roofTypeDescription = By.id(dwellingConstructionBase + "RoofTypeDesc-inputEl"),
                conditionOfRoof = By.id(dwellingConstructionBase + "RoofCondition_fli-inputEl"),
                isTheMobileHomeTiedDownLabel = By.xpath("//*[@id='" + dwellingConstructionBase + "MHConstructionDetail:IsMHTiedDown_fli-labelEl']//span[text()='Is the mobile home tied down?']"),
                isTheMobileHomeTiedDownYes = By.xpath("//*[@id='" + dwellingConstructionBase + "MHConstructionDetail:IsMHTiedDown_fli-labelEl']//span[text()='Is the mobile home tied down?']/../../div/div/table/tbody/tr/td/div/div/div//label[text()='Yes']/../input"),
                isTheMobileHomeTiedDownNo = By.xpath("//*[@id='" + dwellingConstructionBase + "MHConstructionDetail:IsMHTiedDown_fli-labelEl']//span[text()='Is the mobile home tied down?']/../../div/div/table/tbody/tr/td/div/div/div//label[text()='No']/../input"),
                isTheMobileHomeFullySkirted = By.xpath("//*[@id='" + dwellingConstructionBase +"MHConstructionDetail:IsMHTiedDown_fli-labelEl']//span[text()='Is the mobile home tied down?']"),
            //  ErrorMessage= By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:_msgs']/div"),

            //  Wind Mitigation
                windMitigation = By.id(tabBase + "WindMitTab-btnInnerEl"),
                    saveDraft = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"),
                quote= By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
                    editPolicyTransaction = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl");


    }


    public class WindMitigation<T extends WindMitigation> extends CenterPanelBase {
        private WindMitigationBy by;

        public WindMitigation(CenterSeleniumHelper sh, Path path) {
            this.sh = sh;
            this.path = path;
            setID(path);
            by = new WindMitigationBy();
            log("Navigated to page: Wind Mitigation");
        }

        public void setID(Path path) {
            switch (path) {
                case SUBMISSION:
                    windMitigationBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
                    tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                    break;
                case POLICYRENEWAL:
                    windMitigationBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
                    tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                    break;
                case POLICYCHANGE:
                    windMitigationBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
                    tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
                    break;
            }
        }

        public class WindMitigationBy {
            final By discountType = By.id(windMitigationBase + "WindMitDiscountType_fli-inputEl"),
                    fortifiedHomeType = By.id(windMitigationBase + "FortifiedHomeType_fli-inputEl"),
                    roofShapeType = By.id(windMitigationBase + "RoofShapeType_fli-inputEl"),
                    openingProtectionType = By.id(windMitigationBase + "OpeningProtectionType_fli-inputEl"),
                    terrain = By.id(windMitigationBase + "TerrainType_fli-inputEl"),
                    roofCover = By.id(windMitigationBase + "RoofCoverType_fli-inputEl"),
                    roofDeckAttachment = By.id(windMitigationBase + "RoofDeckAttachType_fli-inputEl"),
                    roofWallConnection = By.id(windMitigationBase + "RoofWallConnectType_fli-inputEl"),
                    ErrorMessage = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:_msgs']/div"),
                    windmitiquote = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
                    saveDraft = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"),



            roofDeck = By.id(windMitigationBase + "RoofDeckType_fli-inputEl"),
                    fbcWindSpeed = By.id(windMitigationBase + "FBCWindSpeedType_fli-inputEl"),
                    internalPressure = By.id(windMitigationBase + "InternalPressureType_fli-inputEl"),


            details = By.id(tabBase + "DetailsTab-btnInnerEl"),

            policyQualificationWarning = By.className("warning_icon");
        }

        protected T DwellingConstructionWindMitiQuote() {
            sh.clickElement(by.windmitiquote);
            sh.waitForNoMask();
            return (T) this;
        }

        protected  T clickWindMitigationSaveDraft()
        {
            sh.clickElement(by.saveDraft);
            sh.waitForNoMask();
            return (T) this;

        }

        protected T clickDetailsTab() {
            sh.clickElement(by.details);
            sh.waitForNoMask();
            return (T) this;
        }

        protected T coveragesNext() {
            sh.waitForNoMask();
            sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
            sh.waitForPageLoad();
            return (T) this;
        }

        protected String dwellingConstructionWingMitigationErrorMessage()

        {
            sh.waitForNoMask();
            String Error = sh.driver.findElement(By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:_msgs']//div")).getText();
            return Error;
        }

        protected T doubleClickCoveragesNext() {
            sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
            sh.waitForPageLoad();
            sh.waitForNoMask();
            sh.waitForElementToAppear(By.className("warning_icon"));
//			for(int i =0; i < 5; i++)
//			{
//				if(sh.isDisplayed(By.className("warning_icon")))
//				{
//					sh.waitForNoMask();
//					sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
//				}
//				else
//					break;
//			}
            clickDetailsTab().coveragesNext();

//			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));

            //sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
            return (T) this;
        }

        protected T WinddwellingBack() {
            clickBack();
            return (T) this;
        }


        protected String getRoofShapeType() {
            return sh.getValue(by.roofShapeType);
        }

        protected T setRoofShapeType(String roofShapeType) {
            sh.setText(by.roofShapeType, roofShapeType);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getDiscountType() {
            return sh.getValue(by.discountType);
        }

        protected T setDiscountType(String discountType) {
            sh.setText(by.discountType, discountType);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getFortifiedHomeType() {
            return sh.getValue(by.fortifiedHomeType);
        }

        protected T setFortifiedHomeType(String fortifiedHomeType) {
            sh.setText(by.fortifiedHomeType, fortifiedHomeType);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getOpeningProtectionType() {
            return sh.getValue(by.openingProtectionType);
        }

        protected T setOpeningProtectionType(String openingProtectionType) {
            sh.setText(by.openingProtectionType, openingProtectionType);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getTerrain() {
            return sh.getValue(by.terrain);
        }

        protected T setTerrain(String terrain) {
            sh.setText(by.terrain, terrain);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getRoofCover() {
            return sh.getValue(by.roofCover);
        }

        protected T setRoofCover(String roofCover) {
            sh.setText(by.roofCover, roofCover);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getRoofDeckAttachment() {
            return sh.getValue(by.roofDeckAttachment);
        }

        protected T setRoofDeckAttachment(String roofDeckAttachment) {
        	sh.waitForNoMask();
            sh.setText(by.roofDeckAttachment, roofDeckAttachment);
            // Added because tabbing is occurring too quickly for the value to match
            // with value in drop down.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getRoofWallConnection() {
            return sh.getValue(by.roofWallConnection);
        }

        protected T setRoofWallConnection(String roofWallConnection) {
            sh.setText(by.roofWallConnection, roofWallConnection);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected T setSecondaryWaterResistance(String flag) {

            sh.clickElement(By.id(windMitigationBase + "IsSecondaryWaterResistance_" + flag.toLowerCase() + "-inputEl"));
            sh.waitForNoMask();
            return (T) this;
        }

        protected T setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag) {
            sh.clickElement(By.id(windMitigationBase + "IsRoofCoverCompliant_" + flag.toLowerCase() + "-inputEl"));
            return (T) this;
        }

        protected T setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag) {
            sh.clickElement(By.id(windMitigationBase + "IsRoofDeckCompliant_" + flag.toLowerCase() + "-inputEl"));
            return (T) this;
        }

        protected T setIsTheRoofWallconnectionBuildingCodeCompliant(String flag) {
            sh.clickElement(By.id(windMitigationBase + "IsRoofWallCompliant_" + flag.toLowerCase() + "-inputEl"));
            return (T) this;
        }

        protected String getRoofDeck() {
            return sh.getValue(by.roofDeck);
        }

        protected T setRoofDeck(String roofDeck) {
            sh.setText(by.roofDeck, roofDeck);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getFbcWindSpeed() {
            return sh.getValue(by.fbcWindSpeed);
        }

        protected T setFbcWindSpeed(String fbcWindSpeed) {
            sh.setText(by.fbcWindSpeed, fbcWindSpeed);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected String getInternalPressure() {
            return sh.getValue(by.internalPressure);
        }

        protected T setInternalPressure(String internalPressure) {
            sh.setText(by.internalPressure, internalPressure);
            sh.tab();
            sh.waitForNoMask();
            return (T) this;
        }

        protected T setWindBorneDebris(String flag) {
            sh.clickElement(By.id(windMitigationBase + "IsWindBorneDebrisRegion_" + flag.toLowerCase() + "-inputEl"));
            sh.waitForNoMask();
            return (T) this;
        }


    }


}
