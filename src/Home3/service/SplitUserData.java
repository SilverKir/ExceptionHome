package Home3.service;

public class SplitUserData {
    public String [] splitUserData(String userData, int dataCount){
        String[] result = userData.trim().split(" ");
       if (result.length!=dataCount){
           throw new WrongDataSizeException(dataCount,result.length);
       }
        return result;
    }
}
