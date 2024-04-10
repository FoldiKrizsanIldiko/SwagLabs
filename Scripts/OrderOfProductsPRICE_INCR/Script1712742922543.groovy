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

List listOfPrices = []

// Select Z-A sorting
WebUI.selectOptionByValue(findTestObject('Object Repository/Products/sorting_select'), 'lohi', false)

List productPrices = WebUI.findWebElements(findTestObject('Object Repository/Products/PricesOfProducts'), 5)

for (def productPrice : productPrices) {
	// getting the price String of each product
	def priceOfProduct = WebUI.getText(WebUI.convertWebElementToTestObject(productPrice))
	
	// removing dollar sign
	def priceWithoutDollarSign = priceOfProduct.substring(1)
	
	// changing to Float to sort
	def priceInt = priceWithoutDollarSign.toFloat()

	listOfPrices.add(priceInt)
}

def sortedListOfPrices = listOfPrices.sort()
assert listOfPrices == sortedListOfPrices



WebUI.closeBrowser()

