import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class ExampleTest2 extends TestBase {

    private String url = "https://the-internet.herokuapp.com/upload";
    private By btnChooseFile = By.id("file-upload");
    private By btnUpload = By.id("file-submit");
    private By lblUploadedFile = By.id("uploaded-files");


    @Test(priority = 1, alwaysRun = true)
    public void testPageTitleIsReturnCorrectly() {
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);
        softAssert.assertEquals("The Internet", title, "title not found");
        softAssert.assertAll();
    }

    @Test(priority = 2, alwaysRun = true)
    public void testFileUpload() {
        driver.get(url);
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(btnChooseFile));
        element.sendKeys(System.getProperty("user.dir") + "\\text.txt");
        WebElement upload = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnUpload));
        upload.click();
        WebElement lbl = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(lblUploadedFile));
        String text = lbl.getText();
        softAssert.assertEquals("text.txt", text, "file not found");
        softAssert.assertAll();
    }
}
