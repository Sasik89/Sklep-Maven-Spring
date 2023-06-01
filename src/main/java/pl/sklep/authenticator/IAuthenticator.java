package pl.sklep.authenticator;

import pl.sklep.users.Users;

import java.util.Collection;

public interface IAuthenticator {
    public boolean authenticator(Collection<Users> users);
    public void check(boolean result);
    public String getLoggedInUserRole();
}
