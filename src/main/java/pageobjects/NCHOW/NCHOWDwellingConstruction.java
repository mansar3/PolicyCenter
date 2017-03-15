package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWDwellingConstruction extends DwellingConstruction<NCHOWDwellingConstruction>
{
	public NCHOWDwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHOWCoverages next()
	{
		super.coveragesNext();
		return new NCHOWCoverages(sh, path);
	}

	public NCHOWWindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new NCHOWWindMitigation(sh, path);
	}

	public NCHOWDwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}

	public NCHOWDwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}

	public NCHOWDwelling back()
	{
		super.dwellingBack();
		return new NCHOWDwelling(sh, path);
	}

	public String dwellingConstructionErrorMessage()
	{
		return super.dwellingConstructionErrorMessage();
	}

	public NCHOWDwellingConstruction dwellingConstructionEnter()
	{
		return super.dwellingConstructionEnter();
	}

	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}

	public NCHOWDwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}


	public NCHOWDwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}

	public NCHOWDwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}

	public NCHOWDwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}

	public NCHOWDwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public NCHOWDwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public NCHOWDwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}


    public NCHOWDwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }

	public NCHOWQuote clickDwellingconstructionQuote(){
		super.DwellingconstructionQuote();
		return new NCHOWQuote(sh,path);
	}


    public class NCHOWWindMitigation extends WindMitigation<NCHOWWindMitigation>
    {
        public NCHOWWindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCHOWDwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new NCHOWDwellingConstruction(sh, path);
        }
        public NCHOWCoverages next()
        {
            super.coveragesNext();
            return new NCHOWCoverages(sh,path);
        }
        public NCHOWCoverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new NCHOWCoverages(sh, path);
        }
        public NCHOWWindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public NCHOWWindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }

        public NCHOWWindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }

        public NCHOWDwelling windDwellingBack()
        {
            super.WinddwellingBack();
            return new NCHOWDwelling(sh,path);
        }

















    }
}
