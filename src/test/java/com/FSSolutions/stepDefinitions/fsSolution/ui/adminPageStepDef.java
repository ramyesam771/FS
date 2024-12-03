package com.FSSolutions.stepDefinitions.fsSolution.ui;

import com.FSSolutions.common.ui.base.BaseWebDriver;
import com.FSSolutions.flairstech.ui.AdminPage;
import com.FSSolutions.common.ui.uiAutomation.JSUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class adminPageStepDef extends BaseWebDriver {
    private final AdminPage productsPage = new AdminPage();
    private final JSUtils jsUtils = new JSUtils();

    @And("user Click on Admin tab on the left side menu")
    public void userClickOnAdminTab() throws InterruptedException {
        productsPage.clickOnAdminTab();
        Thread.sleep(5000);
    }

    @And("user Get the number of records found")
    public void userGetTheNumberOFRecords() {
        productsPage.getTheNumberOFRecords();
    }

    @And("Verify that the number of records increased by 1")
    public void userVerifyTheNumberOFRecordsIncreased1() throws InterruptedException {
        productsPage.VerifyTheNumberOFRecordsIncreased1();
    }

    @And("user Click on add button")
    public void userClickOnAddButton() throws InterruptedException {
        productsPage.clickOnAddButton();
    }

    @And("user Fill the required data in Admin page")
    public void userFillRequiredData() throws InterruptedException {
        productsPage.FillRequiredData();

    }


    @Then("user Search with the username for the new user")
    public void user_search_with_the_username_for_the_new_user() {
        productsPage.searchWithNewUser();
    }

    @Then("user delete the new user")
    public void user_delete_the_new_user() throws InterruptedException {
        productsPage.deleteUser();
    }


    @Then("Verify that the number of records decreased by 1")
    public void verify_that_the_number_of_records_decreased_by() throws InterruptedException {
        productsPage.verifyNumberOfRecordsDecreased();
    }


}




