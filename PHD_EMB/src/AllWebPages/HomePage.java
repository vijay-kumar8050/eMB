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

public class HomePage {
	@FindBy(linkText = "Home")
	private WebElement pHomeBtn;// practice home button element

	@FindBy(xpath = "//span[text()='Claim Status Summary']")
	private WebElement pDashlet1TitleClaimStatusSummary; // dashlet one tile claim status summary

	@FindBy(id = "dashlet1")
	private WebElement pFrameDashlet1; // on home page inside iframe dashlet one

	String sETO = Generic_Methods.Get_Property("ETO");
	long ETO = Long.parseLong(sETO);

	SoftAssert sAssert = new SoftAssert();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnpracticeHomePage(WebDriver driver) { // clicking on home button on practice account
		try {
			WebDriverWait w = new WebDriverWait(driver, ETO);
			w.until(ExpectedConditions.visibilityOf(pHomeBtn));
			pHomeBtn.click();
			Reporter.log("Clicked on home button");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}
	}

	public void switchToiframDashlet1(WebDriver driver) {
		try {
			WebDriverWait w = new WebDriverWait(driver, ETO);
			w.until(ExpectedConditions.visibilityOf(pFrameDashlet1));
			driver.switchTo().frame(pFrameDashlet1);
			Reporter.log("Switching to frame dashlet one");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}

	}

	public void switchToMainpage(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			Reporter.log("Switching to Main page");
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}

	}

	public void VerifyDashletTitleIsClaimStatusSummary() {
		try {
			String aText = pDashlet1TitleClaimStatusSummary.getText();
			String eText = "Claim Status Summary";
			if (aText.equals(eText)) {
				Reporter.log("Dashlet title matches  ");
				Reporter.log("Actual dashlet title  " + aText);
				Reporter.log("Expected dashlet title   " + eText);
			} else {
				Reporter.log("Dashlet title is not matching");
				Reporter.log("Actual dashlet title  " + aText);
				Reporter.log("Expected dashlet title   " + eText);
				sAssert.fail();
				sAssert.assertAll();

			}
		} catch (Exception e) {
			e.printStackTrace();
			sAssert.fail();
			sAssert.assertAll();
		}
	}

}
