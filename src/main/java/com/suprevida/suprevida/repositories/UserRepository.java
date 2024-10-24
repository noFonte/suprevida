package com.suprevida.suprevida.repositories;

import com.suprevida.suprevida.entyties.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity findByLogin(String login);

}
