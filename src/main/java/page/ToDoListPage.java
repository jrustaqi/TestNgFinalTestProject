package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class ToDoListPage{
	
	WebDriver driver;
	String insertedCategoryName;
	
	public ToDoListPage(WebDriver driver) {
		driver = this.driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='categorydata']")WebElement Add_Category_Input_Element;
	@FindBy(how=How.XPATH, using="//input[@name='submit' and @ value='Add category']")WebElement Add_Category_Button_Element;
	@FindBy(how=How.XPATH, using="//select[@name='due_month']")WebElement Click_On_Month_Dropdown_Element;
	@FindBy(how = How.XPATH, using = "//html/body/div[3]") WebElement All_Categories_Body_Text_Element;
	@FindBy(how = How.XPATH, using = "//html/body") WebElement Duplicated_Category_Body_Text_Element;
	
	public void insertOnAddCategoryElement(String categoryName) {
		
		insertedCategoryName=categoryName;
		Add_Category_Input_Element.sendKeys(categoryName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnAddCategoryButtonElement() {
		Add_Category_Button_Element.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnMonthDropdownElement() {
		Select select=new Select(Click_On_Month_Dropdown_Element);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 List<WebElement> dropDownAllOptions=select.getOptions();

		 // Loop to print one by one
		 List<String> strings = new ArrayList<String>();
		    for (int j = 1; j < dropDownAllOptions.size(); j++) {
		        System.out.print(dropDownAllOptions.get(j).getText()+", ");
	        }
		}

	public void validateDuplicatedCategory() {
	Assert.assertNotEquals(insertedCategoryName, Duplicated_Category_Body_Text_Element.getText());
	}
	
	
	
}
