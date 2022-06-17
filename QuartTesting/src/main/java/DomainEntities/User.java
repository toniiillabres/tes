package DomainEntities;

import JavaTesting.Resources.PasswordUtils;

public class User {
    private String name;
    private String password; // password in hash mode and salted
    private String salt; // van canviant a cada usuari
    // password == Hash (password_real + salt);

    public User(){
        this("Tomeu","secret");
    }

    public User(String name, String password){
        this.name = name;
        //this.password = password;
        this.salt = PasswordUtils.genSalt();
        // Falta fer hash amb salt del password!
        this.password = PasswordUtils.hashedPassword(password,this.salt);
    }

    public String getName(){
        return name;
    }

    public boolean verifyPassword(String passwordEntered) {
        return PasswordUtils.verifyUserPassword(passwordEntered, salt, password);
    }

    public void setName(){
        this.name = name;
    }

    public void setPassword(){
        this.password = PasswordUtils.hashedPassword(password,salt);
    }
}
