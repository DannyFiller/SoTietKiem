package data;

import java.io.Serializable;

public class User implements Serializable {



    int id;
    int money;
    String userName;
    String password;
    String email;
    int phoneNumber;

    public User(int id,String userName, String password,  int phoneNumber,String email,int money) {
        this.id =id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password,String money) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.money = Integer.parseInt(money);
    }

    public User(String userName)
    {
        this.userName = userName;
    }

    public User(int money)
    {
        this.money = money;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    String avatar;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
