package org.example.pages;

import org.openqa.selenium.By;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;

public class AppPage extends BasePage {

    private static final String CITY_XPATH = "//*[contains(@resource-id, 'com.zdv.secretcloset:id/tvCityItemName')]";

    private final ILabel currentCityLabel =
            getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "Current city");
    private final IButton okButton = getElementFactory().getButton(By.id("android:id/button1"), "OK button");
    private final ITextBox cityInput =
            getElementFactory().getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "City input");
    private final IButton firstCityButton =
            getElementFactory().getButton(By.xpath(CITY_XPATH), "First city button");

    public DiscountItemForm getDiscountItemForm(int itemNumber) {
        return new DiscountItemForm(itemNumber);
    }

    public String getSelectedCity() {
        return currentCityLabel.getText();
    }

    public void waitForCityChange(String previousCity) {
        AqualityServices.getConditionalWait().waitFor(() -> !currentCityLabel.getText().equals(previousCity));
    }

    public void clickCityLabel() {
        waitForClickableAndClick(currentCityLabel);
    }

    public void clickOKButton() {
        waitForClickableAndClick(okButton);
    }

    public void waitForCityInputDisplayed() {
        cityInput.state().waitForDisplayed();
    }

    public void typeCityName(String cityName) {
        cityInput.state().waitForDisplayed();
        cityInput.type(cityName);
    }

    public void selectFirstCity() {
        waitForClickableAndClick(firstCityButton);
    }

    @Override
    public void waitUntilDisplayed() {
    }

}
