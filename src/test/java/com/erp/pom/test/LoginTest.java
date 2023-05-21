package com.erp.pom.test;

import com.erp.pom.BaseErpTest;
import com.erp.pom.pages.HomePage;
import com.erp.pom.pages.ErpLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseErpTest {
    ErpLoginPage loginPage;
    HomePage homePage;

    public LoginTest() {
        super();
    }

    @Test
    public void loginShouldSucceed() {
        loginPage = new ErpLoginPage();
        homePage = loginPage
                .fillUsername(getUserName())
                .fillPassword(getPassword())
                .clickBtn();
        Assert.assertTrue(homePage.isLogOutText());

    }

}
