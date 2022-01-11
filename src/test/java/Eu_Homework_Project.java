import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;



/*Test case #1
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”

Test case #2
  Step 1. Go to “https://practicecybertekschool.herokuapp.com”
  Step 2. Click on “Registration Form”
  Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript */

public class Eu_Homework_Project {
    //Gulizar
    WebDriver driver;
    WebDriverWait wait;
    Faker faker = new Faker();


    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //busra Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//*[text()='Registration Form']")).click();

    }

    @AfterMethod
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void test1() {

        //busra Step 3. Enter “wrong_dob” into date of birth input box.
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");


        //Test1/Step.4 by mahammad

        WebElement warnTxt = driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));

        Assert.assertTrue(warnTxt.isDisplayed());


    }

    @Test
    public void test2() {

       // Test2/Step1 by Gulizar
       //
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("https://practicecybertekschool.herokuapp.com");

        // Step-3 by Seref
        List<WebElement> programmingElements = driver.findElements(By.cssSelector(".form-check-label"));

        for (WebElement eachcheckbox : programmingElements) {
            String languageProgramming = eachcheckbox.getText();

            System.out.println("Selected programming languages: " + languageProgramming.toString());

            assertTrue(eachcheckbox.isDisplayed(), "verify" + languageProgramming + " is displayed");


        }


        }


    }