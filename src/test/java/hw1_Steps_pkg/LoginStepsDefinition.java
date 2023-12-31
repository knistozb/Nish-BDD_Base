
package hw1_Steps_pkg;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import hw1_Page_pkg.AddNewAccountPage;
import hw1_Page_pkg.DashboardPage;
import hw1_Page_pkg.LoginPage;
import hw1_Util_pkg.BrowserFactory_or_TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition extends BrowserFactory_or_TestBase {

	
	// Home work(Due on 08/05/2023 Saturday 09:00 am CST):
		// Automate following scenario by creating a new feature using Cucumber BDD Framework
		// (which was built in class#11 & 12) drive  e data  from Examples and push  e code   your own github/bitbucket reposito ry
		// and email  the project URL to  mdislam@live.com.
	
	
	// ctrl + shift +F
	// given: pre-condition
	// when: actions to perform
	// then: validation
	// and : last step of the same steps mentioned above
	// but : 
	
	// given when, and ==> here and is the last of given and above
	// then, and, and, but, and and and, and, then ==> then here is just to tell you are on some other page but is the continuation
	// OR
	// then, when, when, when, when, when, and, then   ==> use and before your last step so you know then will be the last test step
	
	// background, feature,scenario, scenario outline
	
	
	// CI/CD: Continuous Integration/Continuous Deployment
	
		// Repo : codes will be sent by: 
			// Dev: they will develop coming from d1,d2,d3 then send it to DevRepo who will then send it to Dev deployment for initial Build version 1.0
			// QA: then it will be to QA environment for testing... QA'S will have their own Repo where QA 1, QA2 and QA3 will work on it...
					// they will then send it to UAT
					// if any bugs then based on its severity and priority, those codes will be reworked again then same testing will be done again...
					// then if everythign passes from QA then it will be sent o UAT to prod/deploy
			// Deployment: once it passes from UAT then it will be sent for final deployment
	
	// Jenkins: its a go to place anytime I have new changes made, it will automatically run the repository and give us the report
		// if someone pushed a new code on the github, Jenkin runs it automatically..... 
			// meaning we dont have to physically run our Jenkins as it does everything on the background offline
	
	
	// download Jenkins: https://www.jenkins.io/download/
	// Unlock Jenkins Password setup: /Users/user/.jenkins/secrets/initialAdminPassword
		// paste this in terminal first: sudo cat /Users/$(whoami)/.jenkins/secrets/initialAdminPassword
		// password from terminal: e3fb744205bd4964907d84e193253062
	
	// link from MD Islam's Jenkins: https://github.com/mdislam786/Feb2023.git
	
	
	// JAVA_HOME pwd:$ echo $JAVA_HOME
		// path : /Library/Java/JavaVirtualMachines/jdk-11.0.17.jdk/Contents/Home
	
	// maven home pwd: mvn -version
		// path: /usr/local/Cellar/maven/3.9.4
	
	// /Users/user/Documents/Imp Softwares Installations/apache-maven-3.9.4
	
	// Before : touch .zshrc then open -e .zshrc  ==>
		// export MAVEN_HOME=$HOME/apache-maven-3.6.1
		//	export PATH=$MAVEN_HOME/bin:$PATH
	
	
	
	
	
	
	
	// ========== =============== =============== ============ =============== =============== 
	
	
	LoginPage loginPage;
	DashboardPage dashbboardPage;
	AddNewAccountPage addContactPage;
	
	
	@Before
	public void setup() {

		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashbboardPage = PageFactory.initElements(driver, DashboardPage.class);
		addContactPage = PageFactory.initElements(driver, AddNewAccountPage.class);

	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
	}
	/*
	@When("User enters the {string} in the {string} field")
	public void user_enters_from_TechfiosLoginFeature(String loginData, String Field) {

		if (loginData.equalsIgnoreCase("username")) {
			
			loginPage.insertUsername("username");
		}
		else if (loginData.equalsIgnoreCase("password")){
			
			loginPage.insertPassword("password");
		} 
		else {
			System.out.println("Please use correct login credentials, and try again!!!");
			
			
		}
	}
	*/
	
	@When("User enters the {string} in the {string} field")
	public void user_enters_in_the_field(String loginData, String field) {
		switch(field) {
		case "username":
			loginPage.insertUsername(loginData);
			break;
			
		case "password":
			loginPage.insertPassword(loginData);
			break;
			default:
				System.out.println("Unable to find field " + field);
				Assert.fail();    
					// it will stop running the rest of the codes below if the above codes fails.
		}	
	}
	
	/*
	@When("User enters the {string} in the username field")   
	public void user_enters_username_as(String username) {    
		loginPage.insertUsername(username);
	}
	
	@When("User enters the {string} in the password field")
	public void user_enters_password_as(String password) {
	    loginPage.insertPassword(password);
	}
	*/

	@And("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clickSignInButton();
	}
	
	@Then("User should land on dashboard page")
	public void user_should_land_on_dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	/*
	@Then("User is on the techfios dashboard page")
	public void user_should_land_on_the_techfios_dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
//		takeScreenshot(driver);
	}
	*/
	
	@And("User clicks on Bank and Cash")
	public void user_clicks_on_bank_and_cash () {
		dashbboardPage.clickOnBankAndCashButton();
	}
	
	@And("User clicks on New Account")
	public void user_clicks_on_New_Account () {
		dashbboardPage.clickOnNewAccountButton();
	}
	
	@Then("User should land on Add Contact page")
	public void user_should_land_on_Add_Contact_page() {
		addContactPage.validateAddNewContactPage();
//		takeScreenshot(driver);
	}
	/*
	@Then("User should land on Add Contact page")
	public void user_should_land_on_Add_Contact_page() {
		String expectedTitle = "Accounts- iBilling";
		String actualTitle = addContactPage.getAddContactPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Add New Contact Page is not found!");
//		takeScreenshot(driver);
	}
	*/
	
	@And("User enters {string} in the {string} field in accounts page")
	public void User_enters_addContactPage_info_in_respective_fields(String info, String field){
		switch(field) {
		case "accountTitle":
			addContactPage.insertAccountTitle(info);
			break;
		case "description":
			addContactPage.insertDescription(info);
			break;
		case "initialBalance":
			addContactPage.insertInitialBalance(info);
			break;
		case "accountNumber":
			addContactPage.insertAccountNumber(info);
			break;
		case "contactPerson":
			addContactPage.insertContactPerson(info);
			break;
		case "phone":
			addContactPage.insertPhone(info);
			break;
		case "internetBankingURL":
			addContactPage.insertInternetBankingURL(info);
			break;		
			default:
				System.out.println("Unable to find " + field);
				Assert.fail();
		}	
	}
	
	/*
	@And("User enters {string} in the description field in accounts page")
	public void User_enters_description_in_the_description_field(String description){
		addContactPage.insertDescription(description);
	}
	
	@And("User enters {string} in the initialBalance field in accounts page")
	public void User_enters_initialBalance_in_the_initialBalance_field(String initialBalance){
		addContactPage.insertInitialBalance(initialBalance);
	}
	
	@And("User enters {string} in the accountNumber field in accounts page")
	public void User_enters_accountNumber_in_the_accountNumber_field(String accountNumber){
		addContactPage.insertAccountNumber(accountNumber);
	}
	
	@And("User enters {string} in the contactPerson field in accounts page")
	public void User_enters_contactPerson_in_the_contactPerson_field(String contactPerson){
		addContactPage.insertContactPerson(contactPerson);
	}
	
	@And("User enters {string} in the phone field in accounts page")
	public void User_enters_phone_in_the_phone_field(String phone){
		addContactPage.insertPhone(phone);
	}
	
	@And("User enters {string} in the internetBankingURL field in accounts page")
	public void User_enters_internetBankingURL_in_the_internetBankingURL_field(String internetBankingURL){
		addContactPage.insertInternetBankingURL(internetBankingURL);
	}
	*/
	
	@And("User clicks on submit button")
	public void User_clicks_submit_button(){
		addContactPage.clickOnSubmitButton();
		takeScreenshot(driver);
	}
	
	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
		dashbboardPage.clickOnListAccountsButton();
		takeScreenshot(driver);
	}
	
	@After
	public void tearDown() {
		try {
			Thread.sleep(1500);
			driver.close();
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}
