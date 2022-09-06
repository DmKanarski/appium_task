package org.example.steps;

import org.example.data.DataProvider;
import org.example.models.ShopItem;
import org.example.models.Seller;
import org.example.pages.AppPage;
import org.example.pages.DiscountItemForm;
import org.example.pages.ItemPage;
import org.example.pages.SellerPage;
import org.testng.Assert;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Steps {

    public static String getCurrentCityName() {
        log.info("Getting current City Name");
        AppPage page = new AppPage();
        page.waitForCityChange(DataProvider.getConfigData().getNoCityStub());
        return page.getSelectedCity();
    }

    public static void selectCity(String cityName) {
        log.info("Selecting city " + cityName);
        AppPage page = new AppPage();
        String currentCityName = getCurrentCityName();
        page.clickCityLabel();
        page.clickOKButton();
        page.waitUntilDisplayed();
        page.typeCityName(cityName);
        page.selectFirstCity();
        page.waitForCityChange(DataProvider.getConfigData().getNoCityStub());
        page.waitForCityChange(currentCityName);
        String actualCityName = getCurrentCityName();
        Assert.assertEquals(actualCityName, cityName, "Wrong city selected");
    }

    public static void openDiscountItemDetailsPage(int itemNumber) {
        log.info("Opening details for the discount item number " + itemNumber);
        new AppPage().getDiscountItemForm(itemNumber).selectItem();
    }

    public static ShopItem verifyItemDetails(ShopItem shopItem) {
        ItemPage itemPage = new ItemPage();
        Seller seller = Seller.builder().city(itemPage.getSellerCity()).build();
        String brandName = itemPage.getBrandName();
        String sellerName = itemPage.getSellerName();
        itemPage.swipeBottom();
        ShopItem actualItem = ShopItem.builder()
                .brand(brandName)
                .originalPrice(itemPage.getOriginalPrice())
                .discountValue(itemPage.getDiscountValue())
                .price(itemPage.getPrice())
                .seller(seller)
                .build();
        Assert.assertEquals(actualItem, shopItem, "Wrong item selected");
        seller.setName(sellerName);
        return actualItem;
    }

    public static ShopItem getDiscountItemInfo(int itemNumber) {
        log.info("Getting info for item number " + itemNumber);
        AppPage appPage = new AppPage();
        DiscountItemForm discountItemForm = appPage.getDiscountItemForm(itemNumber);
        discountItemForm.waitUntilDisplayed();
        return ShopItem.builder()
                .brand(discountItemForm.getBrandName())
                .originalPrice(discountItemForm.getOriginalPrice())
                .discountValue(discountItemForm.getDiscountValue())
                .price(discountItemForm.getPrice())
                .seller(Seller.builder().city(appPage.getSelectedCity()).build())
                .build();
    }

    public static void openItemSellerDetailsPage() {
        log.info("Opening the page with information about the seller of the item");
        ItemPage itemPage = new ItemPage();
        itemPage.openSellerDetails();
    }

    public static void verifySellerDetails(Seller expectedSeller) {
        log.info("Verifying seller details");
        SellerPage sellerPage = new SellerPage();
        Seller actualSeller = Seller.builder()
                .name(sellerPage.getSellerName())
                .city(sellerPage.getSellerCity())
                .build();
        Assert.assertEquals(actualSeller, expectedSeller, "Wrong seller details");
    }

}
