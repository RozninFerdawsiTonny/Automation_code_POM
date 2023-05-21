package com.erp.pom.pages;

import com.erp.pom.BaseErpTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErpLoginPage extends BaseErpTest {
    @FindBy(css = "input#username_txt")
    WebElement usernameEl;

    @FindBy(css = "input[type*='password']")
    WebElement passwordEl;

    @FindBy(css = "button[type*=button]")
    WebElement loginBtn;

    public ErpLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public ErpLoginPage fillUsername(String username) {
        usernameEl.isDisplayed();
        usernameEl.clear();
        usernameEl.sendKeys(username);
        return this;
    }

    public ErpLoginPage fillPassword(String password) {
        passwordEl.isDisplayed();
        passwordEl.clear();
        passwordEl.sendKeys(password);
        return this;
    }

    public HomePage clickBtn() {
        loginBtn.isDisplayed();
        loginBtn.click();
        return new HomePage();
    }
}
