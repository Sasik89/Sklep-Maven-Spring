package pl.sklep.users;

import pl.sklep.item.product.Writable;

public class Users implements Writable {

    private String login;
    private String password;
    private String userRole;

    public Users(){}

    public Users(String login, String password, String userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public Users(String[] vars) {
        this(vars[0], vars[1], vars[2]);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String toCSV(){
        return new StringBuilder().append(getClass().getSimpleName())
                .append(";")
                .append(this.login)
                .append(";")
                .append(this.password)
                .append(";")
                .append(this.userRole)
                .toString();
    }
}
