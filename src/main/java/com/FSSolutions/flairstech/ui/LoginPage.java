package com.FSSolutions.flairstech.ui;

import com.FSSolutions.common.ui.base.BaseWebDriver;
import com.FSSolutions.common.ui.uiAutomation.SeleUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import com.FSSolutions.common.utils.files.JsonUtils;

public class LoginPage extends BaseWebDriver {
    private static final By nameBox = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]");
    private static final By passwordBox = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]");
    private static final By loginBtn = By.xpath("(//button[normalize-space()='Login'])[1]");
    private static final By errorMessage = By.tagName("h3");
    public static final By pageTitle = By.className("title");
    private final SeleUtils seleUtils = new SeleUtils();

    public boolean userOnLoginPage() {
        return seleUtils.isElementDisplayed(nameBox);
    }

    private String getJsonValue(String key) {
        return JsonUtils.ReadJson(key);
    }

    public void enterName() {
        String name = getJsonValue("name");
        log.info("Username is set to : {}", name);
        seleUtils.setText(nameBox, name);
    }

    public void enterPassword(){
        String password = getJsonValue("password");
        log.info("Password is set to : {}", password);
        seleUtils.setText(passwordBox, password);
    }


    public void TypeOnUserNameTextBox(String userName) {
        seleUtils.setText(nameBox, userName);
    }

    public void TypeOnPassWordTextBox(String passWord) {
        seleUtils.setText(passwordBox, passWord);
    }

    public void clickLogin() {
        seleUtils.clickOnElement(loginBtn);
    }

    public void errorMessage(String expectedMessage) {
        seleUtils.isElementDisplayed(errorMessage);
        String actualErrorMessage = seleUtils.getText(errorMessage);
        Assertions.assertEquals(expectedMessage, actualErrorMessage, "Error message does not match expected text.");
    }

    public void validatePageTitle(String expectedPageTitle) {
        seleUtils.isElementDisplayed(pageTitle);
        String actualPageTitle = seleUtils.getText(pageTitle);
        Assertions.assertEquals(expectedPageTitle.toLowerCase(), actualPageTitle.toLowerCase(), "Error page title does not match expected page title.");
    }
}
