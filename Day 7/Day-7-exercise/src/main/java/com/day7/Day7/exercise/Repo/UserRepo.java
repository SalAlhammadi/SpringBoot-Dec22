package com.day7.Day7.exercise.Repo;

import com.day7.Day7.exercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


}
