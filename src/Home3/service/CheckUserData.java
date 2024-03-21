package Home3.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface CheckUserData {
    public String checkName(String userData, String type);
    public Date checkData (String userData);
    public  Long checkPhoneNumber(String userData);
    public  char checkGender(String userData);
}
