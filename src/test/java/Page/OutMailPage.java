package Page;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutMailPage {
    @FindBy(xpath = "//div[contains(@id, 'mailbox')]")
    WebElement mailBox;

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), (20));

    public OutMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(mailBox));
    }

    public void mailBoxLogin(String login) {
        WebElement arg= wait.until(ExpectedConditions.visibilityOf(mailBox.findElement(By.xpath(".//input[(@name='login')]"))));
        arg.clear();
        arg.sendKeys(login);
    }

    public void buttonEnterPassword() {
        WebElement arg= wait.until(ExpectedConditions.visibilityOf(mailBox.findElement(By.xpath(".//button[(@data-testid='enter-password')]"))));
        arg.click();
    }

    public void mailBoxPassword(String password) {
        WebElement arg = wait.until(ExpectedConditions.visibilityOf(mailBox.findElement(By.xpath(".//input[(@name='password')]"))));
        arg.clear();
        arg.sendKeys(password);
    }

    public void buttonLoginToMail() {
        WebElement arg= wait.until(ExpectedConditions.visibilityOf(mailBox.findElement(By.xpath(".//button[(@data-testid='login-to-mail')]"))));
        arg.click();
    }


    public void fillField(String fieldName, String value) {
        if ("Логин".equals(fieldName)) {
            mailBoxLogin(value);
            buttonEnterPassword();
        } else if ("Пароль".equals(fieldName)) {
            mailBoxPassword(value);
            buttonLoginToMail();
        }
    }




}