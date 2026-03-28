package com.bhuvi.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bhuvi.driver.DriverManager;
import com.bhuvi.enums.WaitStrategy;
import com.bhuvi.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

    private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";

    private String linkSubMenu =
            "//div[@id='hmenu-content']//a[normalize-space()='%s']";

    public AmazonHamburgerMenuPage clickComputer() throws Exception {
        Click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");

        // Wait for the submenu panel to fully slide in before any further clicks
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hmenu-content")));

        return this;
    }

    public AmazonLaptopPage clickOnSubMenuItem(String menuText) throws Exception {
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement subMenuItem = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(newxpath))
        );

        try {
            subMenuItem.click(); // try normal click first
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Fallback: JS click if another element is still intercepting
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("arguments[0].click();", subMenuItem);
        }

        if (menuText.contains("All Mobile Phones")) {
            return new AmazonLaptopPage();
        }
        return null;
    }
}