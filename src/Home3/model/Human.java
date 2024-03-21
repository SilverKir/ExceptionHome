package Home3.model;

import Home3.service.CheckUserData;
import Home3.service.IllegalParameterException;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Human implements CheckUserData{
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthday;
    private Long phoneNumber;
    private char gender;

    public Human(String firstName, String secondName, String lastName, Date birthday, Long phoneNumber, char gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Human(String[] userData) {
        this.firstName=checkName(userData[1],"имя");
        this.secondName=checkName(userData[2],"отчество");
        this.lastName=checkName(userData[0],"фамилия");
        this.birthday = checkData(userData[3]);
        this.phoneNumber=checkPhoneNumber((userData[4]));
        this.gender=checkGender(userData[5]);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("<%s> <%s> <%s> <%s> <%s> <%s>",
                lastName,
                firstName,
                secondName,
                simpleDateFormat.format(birthday),
                phoneNumber,
                gender);
    }

    @Override
    public String checkName(String userData, String type) {

        for (int i = 0; i < userData.length(); i++) {
            if(userData.length()<2||Character.isDigit(userData.charAt(i))){
               throw new IllegalParameterException(type);
            }
        }
        return userData;
    }

    @Override
    public Date checkData(String userData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd.MM.yyyy");
        try {
            Date result = simpleDateFormat.parse(userData);
            Date currentDate= new Date();
            if (result.after(currentDate)){
                throw new IllegalParameterException("дата рождения "+userData+" больше текущей даты");
            }
            return result;
        } catch (ParseException e) {
            throw new IllegalParameterException("дата "+userData+" введена некорректно ");
        }
    }

    @Override
    public Long checkPhoneNumber(String userData) {
        if (userData.length()!=11){
            throw new IllegalParameterException("число цифр в номере телефона " + userData + " должно быть 11");
        }
        try {
            return Long.parseLong(userData);
        } catch (RuntimeException e) {
            throw new IllegalParameterException("номер телефона " + userData + " должен содержать цифры ");
        }
    }

    @Override
    public char checkGender(String userData) {

        if (userData.length() ==1 && (userData.charAt(0)=='f'|| userData.charAt(0)=='m')){
            return userData.charAt(0);
        }
        throw new IllegalParameterException("пол " + userData + " должен обозначается символ латиницей f или m");
    }
}
