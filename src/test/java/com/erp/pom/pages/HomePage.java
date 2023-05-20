package com.erp.pom.pages;

import com.erp.pom.BaseErpTest;
import com.erp.pom.util.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseErpTest {
    @FindBy(css = "#btn_login")
    WebElement clickable;

    @FindBy(css = "a[href='/logout']")
    WebElement logoutText;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLogOutText() {
        driver.navigate().refresh();
        General.waitForDomSable();

        clickable.isDisplayed();
        clickable.click();

        General.waitForDomSable();
        return logoutText.isDisplayed();
    }

}
