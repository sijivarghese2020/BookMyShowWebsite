package BookMyShow.Common;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMyShowDP {

    @DataProvider (name ="ListMyShow")
    public static Object[][] ListMyShow(){
        String items [][] = {
                                {"Online Streaming",
                                 "Performances",
                                 "Experiences",
                                 "Expositions",
                                 "Parties",
                                  "Sports",
                               "Conferences"}
                             };

        return items;
    }
    @DataProvider (name ="offeredServices")
    public static Object[][] offeredServices(){
        String services[] []={
                {"Online Sales & Marketing" ,
                "Pricing" ,
                "Food & beverages, stalls and the works!" ,
                "On ground support & gate entry management" ,
                "Reports & business insights" ,
                "POS, RFID, Turnstiles & more..." }
              };
        return services;
    }
    @DataProvider (name="Reports")
    public static  Object[][] Reports_BusinessInsights(){
        String [][] reports = {
                                {"In depth reports", "Access registration data","behavioural insights"}
                            };
        return reports;
    }

    @DataProvider (name ="Offers")
    public static Object[][] Offers_Rewards(){
        String [][] rewards ={
                         {"REWARD POINTS REDEMPTION","PAYBACK POINTS" ,"SIMPLYCLICK SBI CARD REWARDS OFFER"}
                        };
        return rewards;
    }
    @DataProvider (name = "footers")
    public static Object[][] Footer_Text_Validation(){
        String [][] footers ={
                                {"BOOKMYSHOW APP","BOOKMYSHOW NEWS","EXCLUSIVES", "HELP"}
                             };
        return footers;
    }

}
