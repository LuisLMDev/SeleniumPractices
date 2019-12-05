package bsn;

import master.TestCaseAbs;
import org.openqa.selenium.WebDriver;

import static Keywords.SmartKeywords.*;

public class BSN_Registry extends TestCaseAbs {
    public BSN_Registry(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    String lnkSignIn = "//a[@class='login']";
    String btnCreate = "//button[@id='SubmitCreate']/span";
    String txtEmail = "id:email_create";
    String btnInStock = "(//*[normalize-space(text())='Printed Summer Dress'])[4]/following::span[@class='available-now'][1]";

    @Override
    public boolean isFillFormCompleted() {
        try {
            clickOnLink(lnkSignIn);
            Thread.sleep(3000);
            enterData(txtEmail, "luis.tester@testing.com");
            clickOnWebElement(btnCreate);
            return true;

        } catch (Exception e) {
            defect = e.getMessage();
            System.out.println(defect);
            return false;
        }
    }
}
