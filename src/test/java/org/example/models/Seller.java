package org.example.models;

import java.util.Objects;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seller {

    private String name;
    private String city;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Seller seller = (Seller) o;
        return Objects.equals(name, seller.name) && Objects.equals(city, seller.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
