package com.automation.framework.reusables;

import com.automation.application.shoppingcart.testDataManager.RandomDataGenerator;
import com.automation.framework.configurations.ConfigurationLoader;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginDataProvider")
    public static Object[][] getLoginData(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
    }

    @DataProvider(name = "randomLoginDataProvider")
    public static Object[][] getRandomLoginData(){
        int noOfData = ConfigurationLoader.configOptions.getNoOfDataSets();
        Object[][] objects = new Object[noOfData][2];
        for (int row=0; row<noOfData;row++){
            objects[row][0] = RandomDataGenerator.getUserName();
            objects[row][1] = RandomDataGenerator.getPassword();
        }
        return objects;
    }
}
