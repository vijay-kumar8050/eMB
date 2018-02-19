package AllWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import GenericMethods.Generic_Methods;

public class BatchStatusPage {

	@FindBy(linkText = "Batch Status")
	private WebElement pBatchStatustab; // Batch status tab on practice page

	String sETO = Generic_Methods.Get_Property("ETO");
	long ETO = Long.parseLong(sETO);

	SoftAssert sAssert = new SoftAssert();

	public BatchStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBatchStatustab(WebDriver driver) {
		try {
			WebDriverWait w = new WebDriverWait(driver, ETO);
			w.until(ExpectedConditions.visibilityOf(pBatchStatustab));
			pBatchStatustab.click();
			Reporter.log("Clicked on Batch Status Tab");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}
	}

}
