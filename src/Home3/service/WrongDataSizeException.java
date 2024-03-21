package Home3.service;

public class WrongDataSizeException extends IllegalArgumentException{
    public WrongDataSizeException(int i, int j) {
        super (String.format("Ошибка!!! Требуетс ввести %s данных, а введено %s",i,j));
    }
}
