package Steps;

import Page.InMailPage;

import io.qameta.allure.Step;
import org.junit.Assert;

public class InMailSteps {
    InMailPage inMailPage = new InMailPage(BaseSteps.getDriver());
    @Step("кликнуть на верхней панели {0}")
    public void chooseBluePanel(String menuItem) {
       // InMailPage inMailPage = new InMailPage(BaseSteps.getDriver());
        inMailPage.chooseBluePanel(menuItem);
    }

    @Step("выбрать фильтр {0}")
    public void filter(String filter){
       // new InMailPage(BaseSteps.getDriver()).setFilter(filter);
        inMailPage.setFilter(filter);
    }

    @Step("проверка непрочитанных")
    public void checkCounterUnreadMessage(){
        String s = new InMailPage(BaseSteps.getDriver()).getCounterUnreadEmails();
        boolean check = false;
        if (s != null){
            check = true;
        }
        Assert.assertTrue("Присутсвуют непрочитанные письма",check);
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
