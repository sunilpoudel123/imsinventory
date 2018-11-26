package com.imsnepal.inventory.data;

import com.imsnepal.inventory.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
