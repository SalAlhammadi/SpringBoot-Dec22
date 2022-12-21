package com.day7.Day7.exercise.Repo;

import com.day7.Day7.exercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findUserById(Integer id);


    User findUserByUsername(String username);
    User findUserByEmail(String email);
    List<User> findByRoleContaining(String role);
    List<User> findByAgeGreaterThanEqual(Integer age);
}
