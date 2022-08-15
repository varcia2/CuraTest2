import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Cura {

	@Keyword
	def ForLoginCura() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Page_CURA Healthcare Service/Button_Make Appointment'))
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/Input_Username'), GlobalVariable.username)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/Input_Password'), GlobalVariable.password)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Page_CURA Healthcare Service/button_Login'))
		WebUI.takeScreenshot()
	}

	@Keyword
	def CreateAppointment(String HealthCareCenter, String DateAppointment, String Comment) {
		WebUI.selectOptionByValue(findTestObject('Page_CURA Healthcare Service/Select_Healtcare Center'), HealthCareCenter, false)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/Input_Date'), DateAppointment)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/Text_Comment'), Comment)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Page_CURA Healthcare Service/button_Book Appointment'))
		WebUI.verifyElementVisible(findTestObject('Page_CURA Healthcare Service/Label_Appointment has been booked'))
		WebUI.takeScreenshot()
		WebUI.closeBrowser()
	}
}
