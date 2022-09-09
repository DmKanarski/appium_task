package org.example.data;

public class DataProvider {

    public static ConfigData getConfigData() {
        return ConfigData.builder().noCityStub("--").build();
    }

    public static TestData getTestData() {
        return TestData.builder()
                .testCityName("Amsterdam")
                .discountItemNumber(1)
                .build();
    }

}
