package com.exam.Service.Impl;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.Service.UserService;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User is already exists!");
            throw new Exception("User Already Present!");

        }else{
            //User create
            for(UserRole ur:userRoles){
                  roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
            local = this.userRepository.save(user);

        }
        return local;
    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUsername(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


}
