package Steps;

import Page.OutMailPage;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;

public class OutMailSteps {

    @Step("входим на почту")
    public void enterToEmail(DataTable fields){
      OutMailPage outMailPage =  new OutMailPage(BaseSteps.getDriver());
    fields.<String,String>asMap(String.class, String.class)
                .forEach(outMailPage::fillField);
    }



}
