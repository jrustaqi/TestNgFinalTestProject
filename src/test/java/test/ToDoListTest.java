package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.ToDoListPage;
import util.BrowserFactory;


public class ToDoListTest {
	WebDriver driver;
	ToDoListPage toDoPage;
	
	String actualCategoryName = "TestTestTest9";
	
	@BeforeTest
	public void openUrl() {
		driver = BrowserFactory.init();
		toDoPage = PageFactory.initElements(driver, ToDoListPage.class);	
	
	}
	@Test(priority=1)
	public void validateUserIsAbleToAddCategory(){
		
		toDoPage.insertOnAddCategoryElement(actualCategoryName);
		toDoPage.clickOnAddCategoryButtonElement();
		
		String bodytext = driver.findElement(By.xpath("//html/body/div[3]")).getText();
		String[] allCategoryNames = bodytext.split(" ");
		String allCategoryNamesWithComma= allCategoryNames.toString().replace(" ", ", ");
		System.out.println(allCategoryNames[allCategoryNames.length-1]);
		String expected=allCategoryNames[allCategoryNames.length-1];
		Assert.assertEquals(actualCategoryName, expected, "Category Names are not matching!");
		
	}
	
	@Test(priority=3)
	public void validateDuplicateCategory() {
		
		toDoPage.insertOnAddCategoryElement(actualCategoryName);
		toDoPage.clickOnAddCategoryButtonElement();
		toDoPage.validateDuplicatedCategory();
	}
				
	@Test(priority=2)
	public void validateMonthDropdownElement(){
		
		toDoPage.clickOnMonthDropdownElement();
	}
	
	@AfterTest
	public void  closeUrl() {
		
		BrowserFactory.tearDown();
	}
	
}
	
	
	
	
	
	
	

