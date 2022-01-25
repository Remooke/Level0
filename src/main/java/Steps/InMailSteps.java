package Steps;

import Page.InMailPage;

import io.qameta.allure.Step;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class InMailSteps {
    InMailPage inMailPage = new InMailPage(BaseSteps.getDriver());
    @Step("кликнуть на верхней панели {0}")
    public void chooseBluePanel(String menuItem) {
        inMailPage.chooseBluePanel(menuItem);
    }

    @Step("выбрать фильтр {0}")
    public void filter(String filter){
        inMailPage.setFilter(filter);
    }

    @Step("проверка непрочитанных")
    public void checkCounterUnreadMessage()throws NoSuchElementException {
        Assert.assertEquals("Не найдены непрочитанные письма", inMailPage.getCounterUnreadEmails(),true);
    }

    @Step("отмечаем как прочитанное")
    public void readEmail() throws InterruptedException {
        inMailPage.setCheckbox();
    }

    @Step("писем нет")
    public void nullUnread() {
        boolean checkUnread = new InMailPage(BaseSteps.getDriver()).getCheckEmptyUnread();
        Assert.assertTrue(checkUnread);
    }




}
