package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3DwellingConstruction extends DwellingConstruction<FLMH3DwellingConstruction> {

    public FLMH3DwellingConstruction(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3Coverages next()
    {
        super.coveragesNext();
        return new FLMH3Coverages(sh, path);
    }


    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public FLMH3DwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public FLMH3DwellingConstruction setEstimatedReplacementCost(String text)
    {
        return super.setEstimatedReplacementCost(text);
    }

    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }
    public FLMH3DwellingConstruction clickeditpolicytransaction(){
        return super.editPolicyTransaction();
    }

    public FLMH3DwellingConstruction acceptYes(){
        return super.accept();
    }
    public FLMH3DwellingConstruction setFloorUnitIsLocatedOn(String text)
    {
        super.setFloorUnitIsLocatedOn(text);
        return new FLMH3DwellingConstruction(sh, path);
    }


    public String getEstimatedReplacementCost()
    {
        return super.getEstimatedReplacementCost();
    }
    public FLMH3DwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }
    public FLMH3DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}

    public String getConstructionType()
    {
        return super.getConstructionType();
    }

    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }


    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }


    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public FLMH3DwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public FLMH3DwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public FLMH3DwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }


    public String getPlumbing()
    {
        return super.getPlumbing();
    }


    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }


    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }


    public String getWiring()
    {
        return super.getWiring();
    }


    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }


    public String getRoofType()
    {
        return super.getRoofType();
    }


    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public FLMH3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public FLMH3DwellingConstruction setIsTheMobileHomeFullySkirted(String flag){
        return super.setIsTheMobileHomeFullySkirted(flag);
    }

    public FLMH3DwellingConstruction setIsTheMobileHomeTiedDown(String flag){
        return super.setIsTheMobileHomeTiedDown(flag);
    }
    public FLMH3DwellingConstruction setMobileHomeWidth(String text){
        return super.setMobileHomeWidth(text);
    }
    public String getsetMobileHomeWidth(){return super.getMobileHomeWidth();}

    public FLMH3DwellingConstruction setMobileHomeLength(String text){
        return super.setMobileHomeLength(text);
    }
    public String getsetMobileHomeLength(){return super.getMobileHomeWidth();}

    public FLMH3DwellingConstruction setMobileHomeMake(String text){
        return super.setMobileHomeMake(text);
    }
    public String getsetMobileHomeMake(){return super.getMobileHomeWidth();}

    public FLMH3DwellingConstruction setMobileHomeModel(String text){
        return super.setMobileHomeModel(text);
    }
    public String getsetMobileHomeModel(){return super.getMobileHomeWidth();}

    public FLMH3DwellingConstruction setMobileHomeId(String text){
        return super.setMobileHomeId(text);
    }
    public String getsetMobileHomeId(){return super.getMobileHomeWidth();}

    public FLMH3DwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public FLMH3Dwelling back()
    {
        super.dwellingBack();
        return new FLMH3Dwelling(sh,path);
    }
    public FLMH3Quote clickDwellingconstructionQuote(){
        super.DwellingconstructionQuote();
        return new FLMH3Quote(sh,path);
    }
    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }


    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }


    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }


    public FLMH3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }


    public FLMH3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public FLMH3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public FLMH3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public FLMH3DwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
	public FLMH3DwellingConstruction setAreThereAnyExteriorDoorOpeningsWithoutSteps(String flag)
	{
		return super.setAreThereAnyExteriorDoorOpeningsWithoutSteps(flag);
	}
	public FLMH3DwellingConstruction setAreThereAnyAreasWith3OrMoreStairsAndNoHandrails(String flag)
	{
		return super.setAreThereAnyAreasWith3OrMoreStairsAndNoHandrails(flag);
	}
	public FLMH3DwellingConstruction setConstructionCredit(String flag)
	{
		return super.setConstructionCredit(flag);
	}
	public FLMH3DwellingConstruction setAtTheInceptionOfThisPolicyWillThisMobileHomeBeWithoutContinuousUtilityService(String flag)
	{
		return super.setAtTheInceptionOfThisPolicyWillThisMobileHomeBeWithoutContinuousUtilityService(flag);
	}
    public boolean isMobileHomeTiedDown()
    {
        return super.isMobileHomeTiedDown();
    }

    public boolean isConstructionTypeRequired()
    {
        return super.isConstructionTypeRequired();
    }

    public boolean isFoundationTypeRequired()
    {
        return super.isFoundationTypeRequired();
    }

    public boolean isMobileHomeFullySkirtedRequired()
    {
        return super.isMobileHomeFullySkirtedRequired();
    }

    public boolean isMobileHomeFullySkirted()
    {
        return super.isMobileHomeFullySkirted();
    }

}
