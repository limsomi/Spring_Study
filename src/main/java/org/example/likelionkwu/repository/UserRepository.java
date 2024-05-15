package org.example.likelionkwu.repository;

import org.example.likelionkwu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Boolean existByUserName(String userName);
}
