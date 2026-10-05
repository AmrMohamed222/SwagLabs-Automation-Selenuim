package dataProviderTest;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    };

    @DataProvider(name = "products")
    public Object[][] getProducts() {
        return new Object[][]{
                {"standard_user","secret_sauce", "backpack", "bike", "t-shirt", "jacket"}
        };
    };

    @DataProvider(name = "MyInformation")
    public Object[][] getMyInformation() {
        return new Object[][]{
                {"Amr","Mohamed","11767"}
        };
    }

}
