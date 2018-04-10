package spring;
import entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserD implements UserDetails {

    private UserEntity baseUser;

    public UserD(UserEntity user){baseUser = user;}


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }


    public String getPassword() {return baseUser.getPassword();}


    public String getUsername() {return baseUser.getLogin();}


    public boolean isAccountNonExpired() {return true;}


    public boolean isAccountNonLocked() {return true;}


    public boolean isCredentialsNonExpired() {return true;}


    public boolean isEnabled() {return true;}

    public UserEntity getBaseUser() {return baseUser;}
}