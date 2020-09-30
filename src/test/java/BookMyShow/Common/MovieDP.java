package BookMyShow.Common;

import org.testng.annotations.DataProvider;

public class MovieDP {
//    @DataProvider (name = "Moviename")

//    public static Object[][] MovieDP(){
//        String movie [][] = {   {"Kochi","Fantasy island"},
//                                {"Kochi","qq"}
//                             //   {"Kochi","Onward"}
//                            };
//        return movie;
//    }
    @DataProvider (name = "Moviename1")
    public static Object[] MovieDP(){
        String movie [] = {   "Fantasy island", "qq"
                            };
        return movie;
    }
}
