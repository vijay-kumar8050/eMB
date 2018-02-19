package AllWebPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import GenericMethods.Generic_Methods;

public class ArchivePage {
	
	@FindBy(linkText = "Archive") 
	private WebElement pArchiveTab;// Archive tab on practice account
	
	@FindBy(xpath="//a[text()='Claim Closure']")
	private WebElement pClaimClosurebtn; //ClaimClosure button under Archive >> ClaimClosure on practice account
	
	@FindBy(xpath="//div[contains(text(),'Claim Closure')]")
	private WebElement pClaimClosurePageText; // ClaimClosure page text, after click on Archive>> ClaimClosure button the text is 
										  // 'ClaimClosure'
	
	String sETO = Generic_Methods.Get_Property("ETO");
	long ETO = Long.parseLong(sETO);
	
	SoftAssert sAssert = new SoftAssert();
	
	public ArchivePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnArchivePage(WebDriver driver){ // Clicking on Archive Tab
		
		try {
			WebDriverWait w= new WebDriverWait(driver, ETO);
			w.until(ExpectedConditions.visibilityOf(pArchiveTab));
			pArchiveTab.click();
			Reporter.log("Clicked on Archive Tab button");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}
	}
	
	public void clickOnClaimClosure(WebDriver driver){ // clicking on claim closure button
		
		try {
			WebDriverWait w =new WebDriverWait(driver, ETO);
			w.until(ExpectedConditions.visibilityOf(pClaimClosurebtn));
			pClaimClosurebtn.click();
			Reporter.log("Clicked on the ClaimClosure button");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}
	}
	
	public void VerifyArchivePageDisplayed(){
		
		String eText = Generic_Methods.Get_cell_value("VerifiactionTextForAllPages", 2, 2); //(Sheet name, Row, Col)
		String aText = pClaimClosurePageText.getText(); 
		if (aText.equals(eText)) {
			Reporter.log("Appointment Page is displayed");
		} else {
			Reporter.log("Appointment page is not displayed");
			Assert.fail();
		}
	}
}
