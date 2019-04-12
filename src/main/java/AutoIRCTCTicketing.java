package main.java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

/**
 * Created by Irfan on 22-Feb-18.
 */
public class AutoIRCTCTicketing {
    public static void main(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "C:\\PERSONAL PARTITION\\INTERVIEW PREP STUFFS\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //----------------- Loding ITCTC Home page------------------------------///
        driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

        //----------------- ITCTC login page------------------------------///
        WebElement username = driver.findElement(By.xpath("//*[@id=\'usernameId\']"));
        username.sendKeys("");// your username
        WebElement password = driver.findElement(By.xpath("//*[@id=\'loginFormId\']/div[1]/div[2]/table[1]/tbody/tr[2]/td[2]/input"));
        password.sendKeys(""); // your password
//        System.out.println("enter something!!!");

//        scanner.nextLine();
        WebElement captcha = driver.findElement(By.xpath("//*[@id='nlpAnswer']"));
        System.out.print("Type the CAPTCHA string : ");
        captcha.sendKeys(scanner.nextLine());
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\'loginbutton\']"));
        loginButton.click();

        //----------------- First page after login to IRCTC------------------------------///

        WebElement quickbook = driver.findElement(By.xpath("//*[@id='quickbookTab:header:inactive']/span"));
        quickbook.click();

        WebElement trainNo = driver.findElement(By.xpath("//*[@id=\'qbform:trainNUmber\']"));
        trainNo.sendKeys("12723");

        WebElement fromStation = driver.findElement(By.xpath("//*[@id=\'qbform:fromStation\']"));
        fromStation.sendKeys("SECUNDERABAD JN - SC");

        WebElement toStation = driver.findElement(By.xpath("//*[@id=\'qbform:toStation\']"));
        toStation.sendKeys("NEW DELHI - NDLS");

        WebElement journeyDate = driver.findElement(By.xpath("//*[@id=\'qbform:qbJrnyDateInputDate\']"));
        journeyDate.sendKeys("04-04-2018");

        WebElement bookingClass = driver.findElement(By.xpath("//*[@id=\'qbform:class\']"));
        Select bookingClassSelect = new Select(bookingClass);
//        journeySelect.selectByIndex(10);
        bookingClassSelect.selectByVisibleText("SLEEPER CLASS (SL)");

        WebElement quota = driver.findElement(By.xpath("//*[@id=\'qbform:quota\']"));
        Select quotaSelect = new Select(quota);
//        quotaSelect.selectByIndex(4);
        quotaSelect.selectByVisibleText("GENERAL");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\'qbform:quickBookSubmit\']"));
        submit.click();

        //----------------- after quick book has been filled and now filling reservation form------------------------------///
//        WebElement passengerName = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:0:p696827142\']"));
        WebElement passengerName = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:tb\']/tr/td[2]/input"));
        passengerName.sendKeys("Imran Ansari");

//        WebElement age = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:0:j_idt576\']"));
        WebElement age = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:0:psgnAge\']"));
        age.sendKeys("29");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:0:psgnGender\']"));
        Select genderSelect = new Select(gender);
        genderSelect.selectByVisibleText("Male");

        WebElement birthPreference = driver.findElement(By.xpath("//*[@id=\'addPassengerForm:psdetail:0:berthChoice\']"));
        Select birthPreferenceSelect = new Select(birthPreference);
        birthPreferenceSelect.selectByVisibleText("UPPER");

        System.out.println("Enter Your Second Captcha");
        WebElement secondCaptcha = driver.findElement(By.xpath("//*[@id=\'nlpAnswer\']"));
        secondCaptcha.sendKeys(scanner.nextLine());

        WebElement netBankingLink = driver.findElement(By.xpath("//*[@id=\'NETBANKING\']"));
        netBankingLink.click();

        WebElement hdfcRadioButton = driver.findElement(By.xpath("//input[@id='NETBANKING' and @type='radio' and @value='36']"));
        hdfcRadioButton.click();

        WebElement makePaymentButton = driver.findElement(By.xpath("//*[@id=\'validate\']"));
        makePaymentButton.click();







        //----------------- now we are on HDFC login page------------------------------///



        //----------------- now we are on another HDFC screen will open for final confirmation ------------------------------///


        System.out.println("success!!!");

    }

}
