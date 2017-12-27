package org.talend.spring.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorldSteps {
	WebDriver driver;// = new FirefoxDriver();
	
	@Given("go to home page $url")
	public void getHomePage(String url) {
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@Then("get users number $number")
	public void listUsers(int number){
		WebElement names = driver.findElement(By.id("names"));
		System.out.println(names.getText() + ": number - " + number);
	}
	

	@When("Add a user with name $name")
	public void addUser(String user) {
		
	}
}
