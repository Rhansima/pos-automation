package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

@Epic("POS System")
@Feature("Login Feature")
@Listeners(utils.AllureListener.class)

public class LoginTest extends BaseTest {

    @Test(description = "Verify user can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid login")
    @Description("Test Description: Login with correct username and password")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(props.getProperty("username"), props.getProperty("password"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")));

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard URL not loaded");
    }
}
