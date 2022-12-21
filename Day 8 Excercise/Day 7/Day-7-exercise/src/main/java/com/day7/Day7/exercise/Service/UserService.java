package com.day7.Day7.exercise.Service;

import com.day7.Day7.exercise.Model.User;
import com.day7.Day7.exercise.Repo.UserRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo users;

    public List<User> getAll(){
        return users.findAll();
    };

    public void addUser(User user){
        users.save(user);
    }


    public boolean isUser(Integer id) {
        List<User> currentUsers = users.findAll();
        for (User user : currentUsers) {
            if (user.getId()==id)
                return true;
        }
        return false;
    }

    public void updateUser(Integer id,User user) {
        users.findAll().set(id,user);
    }

    public void deleteUser(Integer id) {
        users.findAll().remove(id);
    }

    public User getByID(Integer id) {
        return users.findUserById(id);
    }

    public String logIn(String username, String password) {
        User tempUser = users.findUserByUsername(username);
        if(tempUser.getPassword().equals(password))
            return "Welcome!" ;
        else
            return "Wrong Password";

    }

    public List<User> getAllByRole(String role) {
        return users.findByRoleContaining(role);
    }

    public List<User> getByAge(int age) {
        return users.findByAgeGreaterThanEqual(age);
    }

    public User getByEmail(String email) {
        return users.findUserByEmail(email);
    }
}
