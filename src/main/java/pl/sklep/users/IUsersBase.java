package pl.sklep.users;

import java.util.Collection;
import java.util.Map;

public interface IUsersBase {

    public void addLoginAndPassword();
    public Collection<Users> getUsers();
    public void addUser(String[] vars);
    public void setUsers(Map<String, Users> users);
    public void setUserRole();
}
