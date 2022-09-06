package org.example.tests;

import org.example.data.DataProvider;
import org.example.models.ShopItem;
import org.example.steps.Steps;
import org.testng.annotations.Test;

import aquality.appium.mobile.application.AqualityServices;

public class AppiumTests {

    @Test
    public static void secretClosetTest() {
        AqualityServices.getApplication();
        Steps.selectCity(DataProvider.getTestData().getTestCityName());
        ShopItem expectedItem = Steps.getDiscountItemInfo(DataProvider.getTestData().getDiscountItemNumber());
        Steps.openDiscountItemDetailsPage(DataProvider.getTestData().getDiscountItemNumber());
        ShopItem actualItem = Steps.verifyItemDetails(expectedItem);
        Steps.openItemSellerDetailsPage();
        Steps.verifySellerDetails(actualItem.getSeller());
    }

}
