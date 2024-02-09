/*
Assignment 1: Webdriver Navigation
Objective: Use Selenium WebDriver to navigate to a website and perform basic navigation operations.
Open the Google homepage.
Navigate to the Wikipedia homepage.
Open the GitHub homepage.
Visit the Amazon homepage and then go back to the Google homepage.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;

public class Assignment1 {
    public static void main(String[] args) throws IOException {
        // Invoking the browser driver (I have chosen Chrome)
        WebDriver driver = new ChromeDriver();

        // Reading the URL and maximizing the browser window
        driver.get("https://www.google.ca/");
        driver.manage().window().maximize();

//        //Putting the wikipedia URL in the search field
//        driver.findElement(By.id("APjFqb")).sendKeys("https://en.wikipedia.org/wiki/Main_Page");
//
//        // ASK: The correct option in the list of choices can only be selected by Study Dynamic Xpath? or is there another way?
//
//        // Auto click search button
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/input[3]")).click();
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        driver.navigate().to("https://github.com/");
        driver.navigate().to("https://www.amazon.ca/");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }
}
