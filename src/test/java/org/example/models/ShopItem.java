package org.example.models;

import java.util.Objects;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopItem {

    private Seller seller;
    private String brand;
    private String originalPrice;
    private String discountValue;
    private String price;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ShopItem shopItem = (ShopItem) o;
        return Objects.equals(seller, shopItem.seller) && Objects.equals(brand, shopItem.brand) && Objects.equals(originalPrice, shopItem.originalPrice) && Objects.equals(discountValue, shopItem.discountValue) && Objects.equals(price, shopItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seller, brand, originalPrice, discountValue, price);
    }

}
