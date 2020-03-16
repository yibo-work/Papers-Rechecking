package com.rechecking.service;

import com.rechecking.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {
    
    User login(User user);
    
    User getUserByUId(Integer id);
    
    
    User register(User user);
    
}
