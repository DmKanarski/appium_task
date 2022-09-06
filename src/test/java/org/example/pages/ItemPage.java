package org.example.pages;

import org.openqa.selenium.By;
import aquality.appium.mobile.elements.interfaces.ILabel;

public class ItemPage extends BasePage {

    private final ILabel brandNameLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemBrand"), "Brand name");
    private final ILabel sellerNameLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerName"), "Seller name");
    private final ILabel sellerCityLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city");
    private final ILabel priceLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalPrice"), "Price");
    private final ILabel originalPriceLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalOriginal"), "Original price");
    private final ILabel discountValueLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalDiscount"), "Discount value");

    public String getSellerName() {
        return sellerNameLabel.getText();
    }

    public String getSellerCity() {
        return sellerCityLabel.getText();
    }

    public String getBrandName() {
        return brandNameLabel.getText();
    }

    public String getPrice() {
        return priceLabel.getText().replace("Price: ", "");
    }

    public String getOriginalPrice() {
        return originalPriceLabel.getText();
    }

    public String getDiscountValue() {
        return discountValueLabel.getText();
    }

    public void openSellerDetails() {
        sellerCityLabel.click();
    }

    public void swipeBottom() {
        brandNameLabel.state().waitForDisplayed();
        sellerCityLabel.getTouchActions().swipe(brandNameLabel.getCenter());
    }

    @Override
    public void waitUntilDisplayed() {
        brandNameLabel.state().waitForDisplayed();
    }

}
