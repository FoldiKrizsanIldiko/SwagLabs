import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'LoginKeyword.login'('standard_user', 'qcu24s4901FyWDTwXGr6XA==')


List cartButtons =WebUI.findWebElements(findTestObject('Object Repository/Products/AddToCartButtons'),5)
def numberOfProducts=2;

for (def i = 0; i < numberOfProducts; i++) {
    // getting the price and name String of each product
	WebUI.enableSmartWait()
	WebUI.click(WebUI.convertWebElementToTestObject(cartButtons.get(i)))
	}
	
	WebUI.click(findTestObject('Object Repository/Side_Bar/CartButton'))
	WebUI.click(findTestObject('Object Repository/Cart/Checkout_button'))
	
	WebUI.sendKeys(findTestObject('Object Repository/Checkout_Info/FirstName'),"Róbert")
	WebUI.sendKeys(findTestObject('Object Repository/Checkout_Info/LastName'),"Gida")
	WebUI.sendKeys(findTestObject('Object Repository/Checkout_Info/PostalCode'),"1234")
	WebUI.click(findTestObject('Object Repository/Checkout_Info/ContinueButton'))
	
	//how many divs with class= cart_item inside CheckoutOverwiev site
	
	WebUI.click(findTestObject('Object Repository/CheckoutOverwiev/FinishButton'))
	def confirmText = WebUI.getText(findTestObject('Object Repository/CheckoutComplete/Confirmation'))
	assert confirmText.contains('Thank you for your order!')
	WebUI.click(findTestObject('Object Repository/CheckoutComplete/BackTobutton'))
	
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/Side_Bar/cartBadge'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	

WebUI.closeBrowser()

