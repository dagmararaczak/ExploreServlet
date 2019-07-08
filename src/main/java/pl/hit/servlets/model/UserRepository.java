package pl.hit.servlets.model;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

    private ConcurrentHashMap<String, User> usersMap = new ConcurrentHashMap<>();

    public void addUser(String login, User user) {
        User currentValue = usersMap.putIfAbsent(login, user);
        if (currentValue != null) {
            throw new IllegalStateException("Użytkownik pod loginem " + login + " już jest zapisany!");
        }
    }

    public User getUser(String login) {
        return usersMap.get(login);
    }

    public void updateUser(String login, User user) {
        User replaced = usersMap.replace(login, user);
        if (replaced == null) {
            throw new IllegalStateException("Użytkownik pod loginem " + login
                    + " nie jest zapisany i nie może zostać zastąpiony!");
        }
    }

    public Set<String> getUserLogins() {
        return usersMap.keySet();
    }

    public Collection<User> getUsers() {
        return usersMap.values();
    }

}