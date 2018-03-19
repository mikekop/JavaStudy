package app.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private UUID id;
    private String login;
    private String password;

    public void setId(UUID id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
