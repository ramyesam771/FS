package com.FSSolutions.flairstech.ui;

import com.FSSolutions.common.ui.base.BaseWebDriver;
import com.FSSolutions.common.ui.uiAutomation.BrowserWinUtils;
import com.FSSolutions.common.ui.uiAutomation.SeleUtils;
import com.FSSolutions.common.utils.generator.Generator;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AdminPage extends BaseWebDriver {
    private static final By adminButton = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]");
    private static final By enabled = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]");

    private static final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    private static final By userRole = By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]");
    private static final By status = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private static final By employeeNamePrueba = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[5]/span");
    private static final By employeeName = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private static final By username = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private static final By password = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private static final By confirmPassword = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private static final By numberOfRecords = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
    private static final By addButton = By.xpath("(//button[normalize-space()='Add'])[1]");
    private static final By searchBar = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private static final By searchButton = By.xpath("(//button[normalize-space()='Search'])[1]");
    private static final By deleteButton = By.xpath("(//button[@type='button'])[7]");
    private static final By deleteConfirmation = By.xpath("//button[normalize-space()='Yes, Delete']");

    private static final By admin = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    private final SeleUtils seleUtils = new SeleUtils();
    private final BrowserWinUtils browserWinUtils = new BrowserWinUtils();
    private final Generator generator = new Generator();

    String oldRecord = "a";
    String oldRecord1 = "a";
    String lastRecord = "a";
    String lastRecord1 = "a";
    String newRecord = "a";
    String newRecord1 = "a";
    String userNameG = null;
    int oldRecord1Int = 0;

    public void clickOnAdminTab() {
        seleUtils.clickOnElement(admin);
    }

    public void searchWithNewUser() {
        seleUtils.setText(searchBar, userNameG);
        seleUtils.clickOnElement(searchButton);
    }

    public void deleteUser() throws InterruptedException {
        seleUtils.clickOnElement(deleteButton);
        seleUtils.clickOnElement(deleteConfirmation);
    }

    public void verifyNumberOfRecordsDecreased() throws InterruptedException {
        browserWinUtils.refreshPage();
        Thread.sleep(3000);
        lastRecord = seleUtils.getText(numberOfRecords);
        lastRecord1 = lastRecord.replace(" Records Found", "")
                .replace("(", "").replace(")", "");
        Assert.assertEquals(lastRecord1, oldRecord1);
        System.out.println("lastRecord1 = " + lastRecord1);
    }

    public void getTheNumberOFRecords() {
        oldRecord = seleUtils.getText(numberOfRecords);
        oldRecord1 = oldRecord.replace(" Records Found", "")
                .replace("(", "").replace(")", "");
        System.out.println("oldRecord1 = " + oldRecord1);
    }

    public void VerifyTheNumberOFRecordsIncreased1() throws InterruptedException {
        newRecord = seleUtils.getText(numberOfRecords);
        newRecord1 = newRecord.replace(" Records Found", "")
                .replace("(", "").replace(")", "");
        System.out.println("newRecord1 = " + newRecord1);
        int newRecord1Int = Integer.parseInt(newRecord1);
        int oldRecord1Int = Integer.parseInt(oldRecord1);
        oldRecord1Int += 1;
        System.out.println("oldRecordInt = " + oldRecord1Int);
        System.out.println("newRecord1Int = " + newRecord1Int);
        Assert.assertEquals(oldRecord1Int, newRecord1Int);
        Thread.sleep(3000);
    }

    public void clickOnAddButton() throws InterruptedException {
        seleUtils.clickOnElement(addButton);
        Thread.sleep(5000);
    }

    public void FillRequiredData() throws InterruptedException {
        seleUtils.clickOnElement(userRole);
        seleUtils.clickOnElement(adminButton);
        Thread.sleep(2000);
        seleUtils.setText(employeeName, "1");
        Thread.sleep(4000);
        seleUtils.clickOnElement(employeeNamePrueba);
        seleUtils.clickOnElement(status);
        seleUtils.clickOnElement(enabled);
        userNameG = generator.generateRandomName(7);
        seleUtils.setText(username, userNameG);
        System.out.println(userNameG);
        Thread.sleep(2000);
        seleUtils.setText(password, "ramyessam1");
        seleUtils.setText(confirmPassword, "ramyessam1");
        Thread.sleep(2000);
        seleUtils.clickOnElement(saveButton);
        Thread.sleep(4000);
    }

}
