package com.user.service.services.impl;

import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private  UserRepository userRepository;



    /**
     * @param user
     * @return
     */
    @Override
    public User SaveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}