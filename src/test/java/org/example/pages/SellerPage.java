package org.example.pages;

import org.openqa.selenium.By;
import aquality.appium.mobile.elements.interfaces.ILabel;

public class SellerPage extends BasePage {

    private final ILabel sellerNameLabel =
            getElementFactory().getLabel(By.xpath("//*[contains(@resource-id, 'toolbar')]//*[contains(name(), 'TextView')]"), "Seller name");
    private final ILabel sellerCityLabel =
            getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller name");

    public String getSellerName() {
        return sellerNameLabel.getText();
    }

    public String getSellerCity() {
        return sellerCityLabel.getText();
    }

    @Override
    public void waitUntilDisplayed() {
        sellerNameLabel.state().waitForDisplayed();
    }
}

