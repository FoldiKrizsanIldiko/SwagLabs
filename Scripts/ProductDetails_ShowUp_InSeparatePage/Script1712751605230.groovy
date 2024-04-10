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

def productsWithPrices = []

List productPrices = WebUI.findWebElements(findTestObject('Object Repository/Products/PricesOfProducts'), 5)

List productNames = WebUI.findWebElements(findTestObject('Object Repository/Products/NamesByClass'), 5)

for (def i = 0; i < productPrices.size(); i++) {
    // getting the price and name String of each product
	WebUI.enableSmartWait()
    def productName = WebUI.getText(WebUI.convertWebElementToTestObject(productNames.get(i)))
	def productPrice = WebUI.getText(WebUI.convertWebElementToTestObject(productPrices.get(i)))

    productsWithPrices.add([productName,productPrice])
}

for (def i = 0; i < productPrices.size(); i++) {
	
	// NAV to separate product page
	WebUI.click(WebUI.convertWebElementToTestObject(WebUI.findWebElements(findTestObject('Object Repository/Products/NamesByClass'), 5).get(i)))

	assert WebUI.getText(findTestObject('Object Repository/Product_Details/ProductName')) == productsWithPrices.get(i).get(0)
	assert WebUI.getText(findTestObject('Object Repository/Product_Details/ProductPrice')) == productsWithPrices.get(i).get(1)

	WebUI.click(findTestObject('Object Repository/Product_Details/BackToProducts'))

	WebUI.enableSmartWait()
	}
	


//def sortedListOfPrices = listOfPrices.sort(false).reverse(false)
//assert listOfPrices == sortedListOfPrices
WebUI.closeBrowser()

