package com.joeflood.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.util.TestUtil;


public class SubmissionPage extends TestBase {
	 //Page factory - OR:
	@FindBy(xpath="//span[normalize-space()='Submission']")
    WebElement SubmissionBtn;
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//span[@class='MuiButton-label']")
	WebElement CreateSubmission;
	@FindBy(xpath="//input[@placeholder='Search Places ...']")
	WebElement Location;
	@FindBy(xpath="//textarea[@name='notes']")
	WebElement SubmissionNotes;
	@FindBy(xpath="//input[@name='checkedB']")
	WebElement VerifyLocation;
	@FindBy(xpath="//input[@name='floodZone']")
	WebElement FloodZone;	
	@FindBy(xpath="//span[normalize-space()='Create Submission']")
	WebElement CreateSubmissionBtn;
	@FindBy(xpath="//input[@name='applicantType']")
	WebElement ApplicantType;
	@FindBy(xpath="//*[contains(text(),'Personal')]")
	WebElement ApplicantTypePersonal;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement InsuredFirstName;
	@FindBy(xpath="//span[normalize-space()='save']")
	WebElement saveBtn;
	@FindBy(xpath="//button[@aria-label='change date']//span[@class='MuiIconButton-label']//*[name()='svg']")
	WebElement policyEffectiveDate;
	@FindBy(xpath="//*[contains(text(),'OK')]")
	WebElement cuurentDateBtn;
	
	@FindBy(xpath="//input[@name='occupancyType']")
	WebElement occupancyType;
	@FindBy(xpath="//input[@name='constructionType']")
	WebElement constructionType;
	@FindBy(xpath="//input[@name='occupancyClassification']")
	WebElement occupancyClassification;
	@FindBy(xpath="//input[@id='mui-30599']")
	WebElement occupancyClassification1;
	
	//input[@id='mui-91232']
	@FindBy(xpath="//input[@name='underConstruction']")
	WebElement underConstruction;
	
	@FindBy(xpath="//input[@name='foundationType']")
	WebElement foundationType;
	@FindBy(xpath="//input[@name='noOfUnitsInBuilding']")
	WebElement noOfUnitsInBuilding;
	@FindBy(xpath="//input[@value='PRIMARY_INSURENCE']")
	WebElement coverageType;
	@FindBy(xpath="//span[normalize-space()='Primary']")
	WebElement PrimaryInsuranceBtn;
	
	@FindBy(xpath="//*[contains(text(),'Yes')]")
	WebElement confirmDelete;
	@FindBy(className="MuiSnackbarContent-message")
	WebElement ConfirmMessage;
	@FindBy(xpath="//span[normalize-space()='INSURED']")
	WebElement InsuredTab;
	@FindBy(xpath="//span[normalize-space()='STRUCTURE']")
	WebElement STRUCTURETab;
	@FindBy(xpath="//span[normalize-space()='COVERAGE']")
	WebElement COVERAGETab;
	@FindBy(name="pStructureCoverageRCV")
	WebElement StructureCoverageRCV;
	@FindBy(name="pStructureCoverageAmount")
	WebElement StructureCoverageAmount;
	@FindBy(name="pStructureCoverageDeductibleAmount")
	WebElement StructureCoverageDeductibleAmount;
	@FindBy(name="pContentsCoverageRCV")
	WebElement ContentsCoverageRCV;
	@FindBy(name="pContentsCoverageAmount")
	WebElement ContentsCoverageAmount;
	@FindBy(name="pContentsCoverageDeductibleAmount")
	WebElement ContentsCoverageDeductibleAmount;
	@FindBy(xpath="//span[normalize-space()='Get Quote']")
	WebElement getQuoteBtn;
	@FindBy(xpath="//span[normalize-space()='View Quote']")
	WebElement viewQuoteBtn;
	@FindBy(xpath="//input[@class='PrivateSwitchBase-input-1585' and @type='checkbox']")
	WebElement selectCarrierBtn;
	@FindBy(xpath="//*[contains(text(),'Send Request to Get Quote')]")
	WebElement SendRequestToGetQuote;
	@FindBy(xpath="//h6[@class='MuiTypography-root MuiTypography-subtitle2']")
	WebElement viewQuotesPlans;	
	@FindBy(xpath="//*[name()='path' and contains(@d,'M19 9h-4V3')]")
	WebElement QuotesDownloadPlans;
	//@FindBy(xpath = "//input[@name='loanClosing']")    
	//List<WebElement> LoanClosingRadioBtn;
	
	//List LoanClosingRadioBtn = driver.findElements(By.xpath("//input[@name='loanClosing']"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	LoginPage loginPage;
    HomePage homePage;
    SubmissionPage dashboardPage;
	
	
	public SubmissionPage() {
        PageFactory.initElements(driver, this);
    }
	
	 public String verifyUsersPageTitleMethod() {	
		 SubmissionBtn.click();
	        return driver.getTitle();
	    }
	
	 public void CreateSubmissionMethod(String location, String submissionNotes, String insuredFirstName, String OccupancyType,String OccupancyClassification,String ConstructionType,String FoundationType,String structureCoverageRCV,String structureCoverageAmount,String structureCoverageDeductibleAmount,String contentsCoverageRCV,String contentsCoverageAmount,String contentsCoverageDeductibleAmount) throws InterruptedException {	
		 	SubmissionBtn.click();
		 	CreateSubmission.click();
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(Location));
		 	Location.click();
		 	Location.sendKeys(location);
		 	Thread.sleep(2000);
		 	Actions act = new Actions(driver);
		    act.sendKeys(Keys.DOWN).perform();
		    act.sendKeys(Keys.ENTER).perform();
		 	SubmissionNotes.sendKeys(submissionNotes);
		 	VerifyLocation.click();
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
		 	js.executeScript("window.scrollBy(0,350)", "");
		 	//wait.until(ExpectedConditions.visibilityOf(FloodZone));
		 	Thread.sleep(15000);
		 	//FloodZone.sendKeys("B", Keys.ARROW_DOWN, Keys.ENTER);
		 	FloodZone.click();
		 	FloodZone.sendKeys("B");
			Thread.sleep(2000);
			act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
		 	CreateSubmissionBtn.click();
		 	wait.until(ExpectedConditions.visibilityOf(ApplicantTypePersonal));
		 	ApplicantTypePersonal.click();
		 	/*wait.until(ExpectedConditions.visibilityOf(ApplicantType));
		 	js.executeScript("arguments[0].click();", ApplicantType);
		 	ApplicantType.click();*/
		 	InsuredFirstName.clear();
		 	InsuredFirstName.sendKeys(insuredFirstName);
			js.executeScript("window.scrollBy(0,350)", "");
		 	List LoanClosingRadioBtn = driver.findElements(By.xpath("//input[@name='loanClosing']"));
		 	for(int i=0; i < LoanClosingRadioBtn.size(); i++)
		 		{
		 		String val = ((WebElement) LoanClosingRadioBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) LoanClosingRadioBtn.get(i)).click();
			 		break;
		 			
		 		}
		 			
	            }
		 	List ReplaceExistingRadioBtn = driver.findElements(By.xpath("//input[@name='replaceExistingPolicy']"));
		 	for(int i=0; i < ReplaceExistingRadioBtn.size(); i++)
		 		{
		 		String val = ((WebElement) ReplaceExistingRadioBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) ReplaceExistingRadioBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	saveBtn.click();
		 	Thread.sleep(3000);
		 	policyEffectiveDate.click();
		 	Thread.sleep(2000);
		 	policyEffectiveDate.click();
		 	//js.executeScript("arguments[0].click();",policyEffectiveDate);
		 	//policyEffectiveDate.sendKeys("02012022");
		 	Thread.sleep(4000);
		 	//js.executeScript("arguments[0].click();",cuurentDateBtn);
		 	//cuurentDateBtn.click();
		 	//driver.switchTo().alert().accept();
		 	act.sendKeys(Keys.ENTER).perform();
		 	Thread.sleep(3000);
		  	saveBtn.click();
		 	wait.until(ExpectedConditions.visibilityOf(occupancyType));
		 	js.executeScript("window.scrollBy(0,-350)", "");
		 	occupancyType.click();
		 	occupancyType.sendKeys(OccupancyType);
		 	Thread.sleep(2000);
		 	Actions actd = new Actions(driver);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		 	//occupancyType.sendKeys("Residential Unit",Keys.ARROW_DOWN, Keys.ENTER);
		 	//occupancyType.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		    occupancyClassification.click();
		    occupancyClassification.sendKeys(OccupancyClassification);
		 	Thread.sleep(2000);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		    constructionType.click();
		    constructionType.sendKeys(ConstructionType);
		 	Thread.sleep(2000);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		    List underConstructionBtn = driver.findElements(By.xpath("//input[@name='underConstruction']"));
		 	for(int i=0; i < underConstructionBtn.size(); i++)
		 		{
		 		String val = ((WebElement) underConstructionBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) underConstructionBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	foundationType.click();
		 	foundationType.sendKeys(FoundationType);
		 	Thread.sleep(2000);		 	
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		    //actd.sendKeys(Keys.TAB).perform();
		    js.executeScript("window.scrollBy(0,300)", "");
		 	//occupancyClassification.sendKeys("Primary Residence", Keys.ARROW_DOWN, Keys.ENTER);
		 	//constructionType.sendKeys("masonry", Keys.ARROW_DOWN, Keys.ENTER);
		 	//foundationType.sendKeys("Finished Basement",Keys.ARROW_DOWN,Keys.ENTER);
		 	List RentalPropertyBtn = driver.findElements(By.xpath("//input[@name='rentalProperty']"));
		 	for(int i=0; i < RentalPropertyBtn.size(); i++)
		 		{
		 		String val = ((WebElement) RentalPropertyBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) RentalPropertyBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	//noOfUnitsInBuilding.sendKeys("1",Keys.ARROW_DOWN,Keys.ENTER);
		 	List isElevationCertificateBtn = driver.findElements(By.xpath("//input[@name='isElevationCertificate']"));
		 	for(int i=0; i < isElevationCertificateBtn.size(); i++)
		 		{
		 		String val = ((WebElement) isElevationCertificateBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) isElevationCertificateBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	List nfipPolicyLapsed = driver.findElements(By.xpath("//input[@name='nfipPolicyLapsed']"));
		 	for(int i=0; i < nfipPolicyLapsed.size(); i++)
		 		{
		 		String val = ((WebElement) nfipPolicyLapsed.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) nfipPolicyLapsed.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	List floodInsuranceClaimInLast5Years = driver.findElements(By.xpath("//input[@name='floodInsuranceClaimInLast5Years']"));
		 	for(int i=0; i < floodInsuranceClaimInLast5Years.size(); i++)
		 		{
		 		String val = ((WebElement) floodInsuranceClaimInLast5Years.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) floodInsuranceClaimInLast5Years.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	
		 	saveBtn.click();
		 	
		 	
		 	wait.until(ExpectedConditions.visibilityOf(PrimaryInsuranceBtn));
		 	PrimaryInsuranceBtn.click();
		 	List primaryStructureCoverageBtn = driver.findElements(By.xpath("//input[@name='primaryStructureCoverage']"));
		 	for(int i=0; i < primaryStructureCoverageBtn.size(); i++)
		 		{
		 		String val = ((WebElement) primaryStructureCoverageBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("YES"))
		 		{
		 			((WebElement) primaryStructureCoverageBtn.get(i)).click();
		 			
			 		break;
		 			
		 		}
		 			
	            }
		 	StructureCoverageRCV.sendKeys("1000");
		 	StructureCoverageAmount.sendKeys("10000");
		 	StructureCoverageDeductibleAmount.sendKeys("1000");
		 	List primaryContentsCoverageBtn = driver.findElements(By.xpath("//input[@name='primaryContentsCoverage']"));
		 	for(int i=0; i < primaryContentsCoverageBtn.size(); i++)
	 		{
	 		String val = ((WebElement) primaryContentsCoverageBtn.get(i)).getAttribute("value");
	 		if (val.equalsIgnoreCase("YES"))
	 		{
	 			((WebElement) primaryContentsCoverageBtn.get(i)).click();
		 		break;
	 			
	 		}
	 			
            }
		 	ContentsCoverageRCV.sendKeys("10000");
		 	ContentsCoverageAmount.sendKeys("10000");
		 	ContentsCoverageDeductibleAmount.sendKeys("1000");
		 	
		 	saveBtn.click();
		 	Thread.sleep(5000);
		 	
		 	
		 	
		 	
	    }
	 
	 public String DeleteSubmissionFormMethod() {	
		 	SubmissionBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(3).click();
			}
		 	//userDelete.click();
		 	confirmDelete.click();
		 	String expectedText=ConfirmMessage.getText();
		 	return expectedText;
		 	
	    }
	 
	 public void editSubmissionFormMethod() throws InterruptedException {	
		 	SubmissionBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	//Location Tab
		 	/*wait.until(ExpectedConditions.visibilityOf(Location));
		 	InsuredTab.click();
		 	wait.until(ExpectedConditions.visibilityOf(ApplicantTypePersonal));
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
		 	js.executeScript("arguments[0].click();", ApplicantTypePersonal);
		 	//ApplicantTypePersonal.click();
		 	InsuredFirstName.clear();
		 	InsuredFirstName.sendKeys("Prem");
		 	//JavascriptExecutor js = (JavascriptExecutor) driver;
		 	js.executeScript("window.scrollBy(0,350)", "");
		 	Thread.sleep(1000);
		 	
		 	List LoanClosingRadioBtn = driver.findElements(By.xpath("//input[@name='loanClosing']"));
		 	for(int i=0; i < LoanClosingRadioBtn.size(); i++)
		 		{
		 		String val = ((WebElement) LoanClosingRadioBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 			((WebElement) LoanClosingRadioBtn.get(i)).click();
		 		break;
	            }
		 	List ReplaceExistingRadioBtn = driver.findElements(By.xpath("//input[@name='replaceExistingPolicy']"));
		 	for(int i=0; i < ReplaceExistingRadioBtn.size(); i++)
		 		{
		 		String val = ((WebElement) ReplaceExistingRadioBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 			((WebElement) ReplaceExistingRadioBtn.get(i)).click();
		 		break;
	            }
	            
		 	saveBtn.click();
		 	Thread.sleep(1000);
		 	policyEffectiveDate.click();
		 	//policyEffectiveDate.sendKeys("02012022");
		 	Thread.sleep(1000);
		 	
		 	cuurentDateBtn.click();
		 	//policyEffectiveDate.sendKeys("02/01/2022");
		 	//loanClosingNo.click();
		 	//replaceExistingPolicyNo.click();
		 	saveBtn.click();
		 	//JfiLastName.sendKeys(Keys.ENTER);
		  
		 	 
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(JfiStatus));
		 	JfiStatus.sendKeys("INACTIVE",Keys.ARROW_DOWN,Keys.ENTER);
		 	//JavascriptExecutor js = (JavascriptExecutor) driver;
		     //js.executeScript("arguments[0].click();", Save);
		 	*/
		 	
		 	//Structre Tab
		 /*	
		 	STRUCTURETab.click();
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
		 	wait.until(ExpectedConditions.visibilityOf(occupancyType));
		 	js.executeScript("window.scrollBy(0,-350)", "");
		 	occupancyType.click();
		 	occupancyType.sendKeys("Single Family");
		 	Thread.sleep(2000);
		 	Actions actd = new Actions(driver);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
	       //occupancyType.sendKeys("Residential Unit",Keys.ARROW_DOWN,Keys.ENTER);
		    //occupancyClassification.sendKeys("Primary Residence", Keys.ARROW_DOWN, Keys.ENTER);
		   //Thread.sleep(2000);
		    wait.until(ExpectedConditions.visibilityOf(occupancyClassification));
		    occupancyClassification.click();
		    occupancyClassification.clear();
		    occupancyClassification.sendKeys("Primary Residence");
		 	Thread.sleep(2000);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		   
		    //  constructionType.click();
		    constructionType.clear();
		    constructionType.sendKeys("frame");
		 	Thread.sleep(2000);
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		 	//constructionType.sendKeys("masonry", Keys.ARROW_DOWN, Keys.ENTER);
		 /*	List underConstructionBtn = driver.findElements(By.xpath("//input[@name='underConstruction']"));
		 	for(int i=0; i < underConstructionBtn.size(); i++)
		 		{
		 		String val = ((WebElement) underConstructionBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) underConstructionBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	foundationType.click();
		 	foundationType.sendKeys("UnFinished Basement");
		 	Thread.sleep(2000);		 	
		    actd.sendKeys(Keys.DOWN).perform();
		    actd.sendKeys(Keys.ENTER).perform();
		 	//foundationType.sendKeys("Finished Basement",Keys.ARROW_DOWN,Keys.ENTER);
		    js.executeScript("window.scrollBy(0,300)", "");
		 	List RentalPropertyBtn = driver.findElements(By.xpath("//input[@name='rentalProperty']"));
		 	for(int i=0; i < RentalPropertyBtn.size(); i++)
		 		{
		 		String val = ((WebElement) RentalPropertyBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) RentalPropertyBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	
		 	
		 	noOfUnitsInBuilding.sendKeys("1",Keys.ARROW_DOWN,Keys.ENTER);
		 	List isElevationCertificateBtn = driver.findElements(By.xpath("//input[@name='isElevationCertificate']"));
		 	for(int i=0; i < isElevationCertificateBtn.size(); i++)
		 		{
		 		String val = ((WebElement) isElevationCertificateBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) isElevationCertificateBtn.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	List nfipPolicyLapsed = driver.findElements(By.xpath("//input[@name='nfipPolicyLapsed']"));
		 	for(int i=0; i < nfipPolicyLapsed.size(); i++)
		 		{
		 		String val = ((WebElement) nfipPolicyLapsed.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) nfipPolicyLapsed.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	List floodInsuranceClaimInLast5Years = driver.findElements(By.xpath("//input[@name='floodInsuranceClaimInLast5Years']"));
		 	for(int i=0; i < floodInsuranceClaimInLast5Years.size(); i++)
		 		{
		 		String val = ((WebElement) floodInsuranceClaimInLast5Years.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("NO"))
		 		{
		 			((WebElement) floodInsuranceClaimInLast5Years.get(i)).click();
			 		break;
		 		}
		 			
	            }
		 	
		 	saveBtn.click();
		 	
		 	*/
		 	//coverageTab
		 	
		 	COVERAGETab.click();
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
		 	wait.until(ExpectedConditions.visibilityOf(PrimaryInsuranceBtn));
		 	PrimaryInsuranceBtn.click();
		 	List primaryStructureCoverageBtn = driver.findElements(By.xpath("//input[@name='primaryStructureCoverage']"));
		 	for(int i=0; i < primaryStructureCoverageBtn.size(); i++)
		 		{
		 		String val = ((WebElement) primaryStructureCoverageBtn.get(i)).getAttribute("value");
		 		if (val.equalsIgnoreCase("YES"))
		 		{
		 			((WebElement) primaryStructureCoverageBtn.get(i)).click();
		 			
			 		break;
		 			
		 		}
		 			
	            }
		 	StructureCoverageRCV.clear();
		 	StructureCoverageRCV.sendKeys("1000");
		 	StructureCoverageAmount.clear();
		 	StructureCoverageAmount.sendKeys("10000");
		 	StructureCoverageDeductibleAmount.clear();
		 	StructureCoverageDeductibleAmount.sendKeys("1000");
		 	List primaryContentsCoverageBtn = driver.findElements(By.xpath("//input[@name='primaryContentsCoverage']"));
		 	for(int i=0; i < primaryContentsCoverageBtn.size(); i++)
	 		{
	 		String val = ((WebElement) primaryContentsCoverageBtn.get(i)).getAttribute("value");
	 		if (val.equalsIgnoreCase("YES"))
	 		{
	 			((WebElement) primaryContentsCoverageBtn.get(i)).click();
		 		break;
	 			
	 		}
	 			
            }
		 	ContentsCoverageRCV.sendKeys("10000");
		 	ContentsCoverageAmount.sendKeys("10000");
		 	ContentsCoverageDeductibleAmount.sendKeys("1000");
		 	Thread.sleep(5000);
		 	saveBtn.click();
		 	
	       
	  
	    
	   
	  }
	 public void GetQuoteMethod() throws InterruptedException {	
		 	SubmissionBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	//getQuoteBtngetQuoteBtn
		 	getQuoteBtn.click();
		 	Thread.sleep(10000);
		 	List<WebElement> listOfCarrier = driver.findElements(By.xpath("//input[@type='checkbox']"));
		 	if(listOfCarrier.size()>0)
			{
		 		listOfCarrier.get(1).click();
		 		listOfCarrier.get(2).click();
		 		listOfCarrier.get(3).click();
		 		listOfCarrier.get(4).click();
		 		listOfCarrier.get(5).click();
			}
		 	SendRequestToGetQuote.click();
		 	Thread.sleep(2000);
		 	
		 	
	    }
	 
	 public String ViewQuoteMethod() throws InterruptedException {	
		 	SubmissionBtn.click();
		 	Thread.sleep(50000);
		 	driver.navigate().refresh();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	//getQuoteBtngetQuoteBtn
		 	viewQuoteBtn.click();
		 	Thread.sleep(10000);
		 	
		 	String expectedText=viewQuotesPlans.getText();
		 	return expectedText;
		 	
	    }
	 
	 public void QuoteDownloadMethod() throws InterruptedException {	
		 	SubmissionBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
			
		 	
		 	viewQuoteBtn.click();
		 	Thread.sleep(5000);
		 	QuotesDownloadPlans.click();
		 	Thread.sleep(10000);
		 	String home = System.getProperty("user.home");
		 	File f =  new File(home+"/Downloads/Quotes.pdf");
		 	System.out.println(f);
		 	System.out.println(f + (f.exists()? " is found " : " is missing "));
			
			}
		 	
		 	
		 	
		 	
		 	
		 	
	    
	 
	 	}
	
	
	
	
	 	


