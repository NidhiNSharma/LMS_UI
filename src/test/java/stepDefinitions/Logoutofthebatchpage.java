package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class Logoutofthebatchpage {
	PicoDInjection picoObject;

	public Logoutofthebatchpage(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() throws InterruptedException {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		picoObject.batchPage.click_BatchLogout_btn();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() throws Throwable {
		Assert.assertEquals(picoObject.batchPage.getCurrentUrl(),picoObject.batchPage.getCurrentUrl());
	    
	}
}
