package com.rechecking.service.impl;

import com.rechecking.entity.User;
import com.rechecking.repository.UserRepository;
import com.rechecking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User login(User user) {
        return userRepository.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    
    @Override
    public User getUserByUId(Integer id) {
        return userRepository.getOne(id);
    }
    
    @Override
    @Transactional
    public User register(User user) {
        return userRepository.save(user);
    }
    
}
