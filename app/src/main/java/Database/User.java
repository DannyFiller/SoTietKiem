package Database;

import java.net.PasswordAuthentication;

public class User {
    private long id;
    private String userName;
    private String passWord;
    private String name;

    public long getId(){
        return id;
    }

    public void setId(long newId)
    {
        this.id = newId;
    }

    public String getUserName(){
        return  userName;
    }

    public void setUserName(String newUsername)
    {
        this.userName = newUsername;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassword(String newPass)
    {
        this.passWord = newPass;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

}
