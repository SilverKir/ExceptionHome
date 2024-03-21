package Home3.controller;

import Home3.model.Human;
import Home3.service.SplitUserData;
import Home3.service.WriteToFile;
import Home3.view.GetData;

public class Controller {
      public GetData getFromConsole = new GetData();
      public SplitUserData splitUserData=new SplitUserData();

      public void Start() {
          String userData=getFromConsole.getUserData("Введите данные, разделенные пробелом:\n"+
                  "Фамилия Имя Отчество, дата рождения, номер телефона, пол\n" +
                  "Форматы данных:\n" +
                  "фамилия, имя, отчество - строки\n" +
                  "дата  рождения - строка формата dd.mm.yyyy\n" +
                  "номер  телефона - целое беззнаковое число без форматирования\n" +
                  "пол символ латиницей f или m.");
          Human human=new Human(splitUserData.splitUserData(userData,6));
          WriteToFile writeToFile=new WriteToFile();
          writeToFile.writeToFile(human);
      }

}
