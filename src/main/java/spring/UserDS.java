package spring;

import entity.UserEntity;
import hibernate.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDS implements UserDetailsService {
    private static final Logger log = Logger
            .getLogger(UserDetailsService.class);

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException, DataAccessException {
        Session session = null;
        try {
            log.debug("loadUserByUsername("+login+");");

            session = HibernateUtil.getSessionFactory().openSession();

            UserEntity userEntity = UserRepository.getUserByLogin(login);

            if (userEntity == null)
                throw new UsernameNotFoundException("Login " + login
                        + " doesn't exist!");

            String username = userEntity.getLogin();
            String password = userEntity.getPassword();
            boolean notLocked = true;
            boolean notExpired = true;
            boolean enabled = true;
            GrantedAuthority auth = new GrantedAuthority() {
                private static final long serialVersionUID = 1L;

                public String getAuthority() {
                    return "ROLE_USER";
                }
            };
            Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
            set.add(auth);

            UserDetails details = new User(username, password, enabled,
                    notExpired, true, notLocked, set);
            return details;
        } finally {
            if (session != null && session.isOpen()) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    log.error("Error while closing session");
                }
            }
        }
    }
}
