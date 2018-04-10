package repository;

import entity.UserEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getByLogin(String login){
        return userRepository.getByLogin(login);
    }
}
