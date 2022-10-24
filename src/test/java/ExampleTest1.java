
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ExampleTest1 extends TestBase {


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
    }

    @Test(priority = 2, alwaysRun = true)
    public void testFileUpload() {
        driver.get(url);
        driver.findElement(btnChooseFile).sendKeys("G:\\MyFrameWorkTest\\text.txt");
        driver.findElement(btnUpload).click();
        String text = driver.findElement(lblUploadedFile).getText();
        softAssert.assertEquals("text.txt", text, "file not found");
        softAssert.assertAll();
    }
}
