package BookMyShow.Common;
//Class for Log4j Utilities
import org.apache.log4j.Logger;

public class logUtilities {
    private static Logger log = Logger.getLogger("BookMyShow TestLog:");

    public static void information(String information){
        log.info(information);
    }

    public static void warning (String information){
        log.warn(information);
    }

    public static void error (String information){
        log.error (information);
    }
}
