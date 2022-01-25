package Page;

import Steps.BaseSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;


public class InMailPage {
    @FindBy(xpath = "//div[contains(@class, 'list list_hover-support')]")
    WebElement filter;

    @FindBy(xpath = "//div[contains(@class, 'layout__main-frame')]")
    WebElement bluePanel;

    @FindBy(xpath = "//div[(@data-folder-id= '0')]/span/span[contains(@class, 'badge__text')]")
    WebElement counterUnreadEmails;

    @FindBy(xpath = "//span[@title='Пометить прочитанным']")
    List<WebElement> checkbox;

    @FindBy(xpath = "//div[contains(@class, 'dataset-letters')]")
    WebElement scrollLetters;

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), (20)).ignoring(StaleElementReferenceException.class);

    public InMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void chooseBluePanel(String menuItem) {
        wait.until(ExpectedConditions.elementToBeClickable
                (bluePanel.findElement(By.xpath(".//div[(@title='" + menuItem + "')]")))).click();
    }

    public void setFilter(String menuItem) {
        wait.until(ExpectedConditions.elementToBeClickable
                (filter.findElement(By.xpath(".//span[(text()='" + menuItem + "')]/parent::div")))).click();
    }

    public boolean getCounterUnreadEmails(){
        try {
            counterUnreadEmails.isDisplayed();
            return true;
        }catch (Exception a){
            return false;
        }
    }

    public void setCheckbox() throws InterruptedException {
        while (checkbox.size() > 0) {
            Thread.sleep(800);
            Actions actions = new Actions(BaseSteps.getDriver());
            actions.moveToElement(scrollLetters).build().perform();
            checkbox.get(0).click();
        } //else throw new AssertionError("Не смог найти непрочитанные письма");
    }


    public boolean getCheckEmptyUnread() {
        if (checkbox.size() == 0) {
            return true;
        } else return false;
    }


}
