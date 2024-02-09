
/*
Assignment 2: Excel Data Entry
Objective: Read data from an Excel sheet and use it to fill out a web form.
E.g. Open the Google registration page.
Read user registration data (e.g., first name and last name) from an Excel sheet.
Fill out the Google registration form using the data from the Excel sheet.
Submit the form and verify that the registration was successful.(optional)
 */


 import org.apache.poi.xssf.usermodel.XSSFSheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 
 import java.io.FileInputStream;
 import java.io.IOException;
 
 public class Assignment2 {
     public static void main(String[] args) throws IOException {
 
         //Invoking browser driver (I have chosen Chrome)
         WebDriver driver = new ChromeDriver();
 
         //Reading the URL for the Google Registration page and maximizing the window
         driver.get("https://accounts.google.com/lifecycle/steps/signup/name?continue=https://console.cloud.google.com/freetrial?facet_url%3Dhttps://cloud.google.com/free%26_ga%3D2.207732752.-380980086.1703562232%26_gac%3D1.16056834.1703562232.EAIaIQobChMIr-L_6ZesgwMVuySDAx0wsgBKEAAYASAAEgKw1PD_BwE%26facet_utm_source%3Dgoogle%26facet_utm_campaign%3Djapac-IN-all-en-dr-BKWS-all-cloud-trial-EXA-dr-1605216%26facet_utm_medium%3Dcpc&dsh=S-1191048983:1703706296031083&flowEntry=SignUp&flowName=GlifWebSignIn&followup=https://console.cloud.google.com/freetrial?facet_url%3Dhttps://cloud.google.com/free%26_ga%3D2.207732752.-380980086.1703562232%26_gac%3D1.16056834.1703562232.EAIaIQobChMIr-L_6ZesgwMVuySDAx0wsgBKEAAYASAAEgKw1PD_BwE%26facet_utm_source%3Dgoogle%26facet_utm_campaign%3Djapac-IN-all-en-dr-BKWS-all-cloud-trial-EXA-dr-1605216%26facet_utm_medium%3Dcpc&ifkv=ASKXGp0AqzP6YXD7YLIrrz8L9Ij9vt_g9Y8pR2JGkVAuW4LXCRdvJ-fgI2gxS7nr2MVbHFkU7IJZ&osid=1&service=cloudconsole&theme=glif&TL=AHNYTIThis8GlGDtQFyj79a2aIODUtRbS3pU_jRgy-PPFR9T1utUtn6qqtT-dgJj");
         driver.manage().window().maximize();
 
         //Reading information from Excel test data
         FileInputStream file = new FileInputStream("C:\\Users\\rocha\\Documents\\Classes with Saurav\\Toronto Raptors roster 2023.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(file);
         XSSFSheet sheet = workbook.getSheet("Sheet1");
 
         // ASK : Explain line by line from 29 to 31 . Explain with terms like classes,objects
 
         // Get the ROW and COLUMN counts from the excel file
         int rowCount = sheet.getLastRowNum();
         int colCount = sheet.getRow(0).getLastCellNum(); // So the getRow here is being used since we need to select a row to count the number of cells(columns)
         System.out.println("Total number of rows"+(rowCount + 1));
         System.out.println("Total number of columns"+(colCount));
 
         WebElement first_name = driver.findElement(By.name("firstName"));
         WebElement last_name = driver.findElement(By.name("lastName"));
 
         first_name.sendKeys(sheet.getRow(2).getCell(0).getStringCellValue()); // getting data from the 3rd row
         last_name.sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
     }
 }
 