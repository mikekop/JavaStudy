package repository;

import entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{
     UserEntity getByLogin(String login );
}
