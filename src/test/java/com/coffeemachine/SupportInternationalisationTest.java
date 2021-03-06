package com.coffeemachine;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;


public class SupportInternationalisationTest extends TestCase {
    // Tags: sprint:3
    public Actionwords actionwords;
    public WebDriver driver;

    protected void setUp() throws Exception {
        super.setUp();

        driver = new SeleniumDriverGetter().getDriver();
        actionwords = new Actionwords(driver);

    }

    protected void tearDown() throws Exception {
        driver.quit();
    }

    // 
    // Tags: priority:1
    public void testNoMessagesAreDisplayedWhenMachineIsShutDown() {
        // Given the coffee machine is started
        actionwords.theCoffeeMachineIsStarted();
        // When I shutdown the coffee machine
        actionwords.iShutdownTheCoffeeMachine();
        // Then message "" should be displayed
        actionwords.messageMessageShouldBeDisplayed("");
    }
    public void messagesAreBasedOnLanguage(String language, String readyMessage) {
        // Tags: priority:1
        // Well, sometimes, you just get a coffee.
        // When I start the coffee machine using language "<language>"
        actionwords.iStartTheCoffeeMachineUsingLanguageLang(language);
        // Then message "<ready_message>" should be displayed
        actionwords.messageMessageShouldBeDisplayed(readyMessage);
    }

    public void testMessagesAreBasedOnLanguageEnglish() {
        messagesAreBasedOnLanguage("en", "Ready");
    }

    public void testMessagesAreBasedOnLanguageFrench() {
        messagesAreBasedOnLanguage("fr", "Pret");
    }
}