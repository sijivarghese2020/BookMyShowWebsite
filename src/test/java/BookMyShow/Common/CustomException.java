package BookMyShow.Common;

public class CustomException extends Exception{
    CustomException(){

    }

    CustomException(String errMsg){
        super(errMsg);
    }
}
