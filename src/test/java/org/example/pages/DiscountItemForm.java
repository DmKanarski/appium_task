package org.example.pages;

import org.openqa.selenium.By;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;

public class DiscountItemForm extends BasePage {

    private static final String ROOT_XPATH_TEMPLATE = "(//*[contains(@resource-id, 'tvDiscount')]//ancestor::*[contains(@resource-id, 'rlBanner')])[%d]";
    private static final String ITEM_IMAGE_LOADING_CIRCLE_XPATH = "//*[contains(@resource-id, 'pbImageLoading')]";
    private static final String ORIGINAL_PRICE_XPATH = "//*[contains(@resource-id, 'tvSumm')]";
    private static final String DISCOUNT_LABEL_XPATH = "//*[contains(@resource-id, 'tvDiscount')]";
    private static final String DISCOUNTED_PRICE_XPATH = "//*[contains(@resource-id, 'tvPrice')]";
    private static final String BRAND_LABEL_XPATH = "//*[contains(@resource-id, 'tvBrand')]";

    private final ILabel rootLabel;
    private final ILabel itemImageLoadingCircleLabel;
    private final ILabel brandNameLabel;
    private final ILabel originalPriceLabel;
    private final ILabel discountValueLabel;
    private final ILabel priceLabel;

    public DiscountItemForm(int itemNumber) {
        rootLabel = getElementFactory().getLabel(By.xpath(String.format(ROOT_XPATH_TEMPLATE, itemNumber)), "Root item");
        itemImageLoadingCircleLabel = rootLabel.findChildElement(By.xpath(ITEM_IMAGE_LOADING_CIRCLE_XPATH), "Item image loading circle", ElementType.LABEL);
        brandNameLabel = rootLabel.findChildElement(By.xpath(BRAND_LABEL_XPATH), "Brand name Label", ElementType.LABEL);
        originalPriceLabel = rootLabel.findChildElement(By.xpath(ORIGINAL_PRICE_XPATH), "Original price Label", ElementType.LABEL);
        discountValueLabel = rootLabel.findChildElement(By.xpath(DISCOUNT_LABEL_XPATH), "Discount value Label", ElementType.LABEL);
        priceLabel = rootLabel.findChildElement(By.xpath(DISCOUNTED_PRICE_XPATH), "Discounted price Label", ElementType.LABEL);
    }

    public String getBrandName() {
        return brandNameLabel.getText();
    }

    public String getOriginalPrice() {
        return originalPriceLabel.getText();
    }

    public String getDiscountValue() {
        return discountValueLabel.getText();
    }

    public String getPrice() {
        return priceLabel.getText();
    }

    public void selectItem() {
        rootLabel.click();
    }

    @Override
    public void waitUntilDisplayed() {
        itemImageLoadingCircleLabel.state().waitForNotDisplayed();
    }

}
