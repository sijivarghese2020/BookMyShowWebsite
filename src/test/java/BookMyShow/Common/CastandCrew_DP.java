package BookMyShow.Common;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class CastandCrew_DP {

    @DataProvider (name = "CastandCrew")
    public static Object[][] CastandCrew(){

//        return new Object[][] {     {"Tom Holland", "Mychael Danna"},
//                                    {"Tom Cruise", "Michael Jackson"}
//                             };
        Object[][] object1 = new Object[1][];
        HashMap <String, String> dataTwo = new HashMap<String, String>();
        dataTwo.put("Cast1","Tom Holland");
        dataTwo.put("Crew1","Mychael Danna");
        dataTwo.put("Cast2","Tom Cruise");
        dataTwo.put("Crew2", "Michael Jackson");
        object1[0] =new Object[]{dataTwo};
        return  object1;

        }

    @DataProvider(name = "LocationandMovie")
    public static Object[][] LocationandMovie () {
//        return new Object[][]{
//                                {"Kochi", "Onward"}
//                            };
        Object[][] object = new Object[1][];
        HashMap <String, String> dataOne = new HashMap<String, String>();
        dataOne.put("Location","Kochi");
        dataOne.put("Movie","Onward");
        object[0] =new Object[]{dataOne};
        return  object;
    }

    @DataProvider (name = "MergedData")
    public static Object[][] MergedDataProvider(){
        HashMap <String, String> Merged = new HashMap<String ,String>();
        Merged.putAll((HashMap<String,String>)LocationandMovie()[0][0]);
        Merged.putAll((HashMap<String,String>)CastandCrew()[0][0]);
        Object[][] Mergedone = new Object[1][];
        Mergedone[0] = new Object[]{Merged};
        return Mergedone;
    }
}
