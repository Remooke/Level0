package Steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class ScenarioSteps {

    OutMailSteps outMailSteps = new OutMailSteps();
    InMailSteps inMailSteps = new InMailSteps();

    @When("входим в почту")
    public void enterToEmail(DataTable fields){
        outMailSteps.enterToEmail(fields);
    }


    @И("ставим фильтр: \"(.*)\"$")
    public void ставимФильтрПоНепрочитаннымСообщениям(String menuItem) {
        inMailSteps.filter(menuItem);
    }

    @И("выбираем на панели \"(.*)\"$")
    public void выбираемНаПанели(String menuItem) {
        inMailSteps.chooseBluePanel(menuItem);
    }


    @И("проверяем количество непрочитанных писем")
    public void проверяемКоличествоНепрочитанныхПисем() {
        new InMailSteps().checkCounterUnreadMessage();
    }

    @И("отмечаем каждое письмо как прочитанное")
    public void отмечаемКаждоеПисьмоКакПрочитанное() throws InterruptedException {
        inMailSteps.readEmail();
    }

    @Тогда("непрочитанных писем нет")
    public void checkUnread() throws InterruptedException {
        inMailSteps.nullUnread();
    }

}
