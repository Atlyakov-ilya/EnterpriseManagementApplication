package com.iatlyakov.ema.service.impl;

import com.iatlyakov.ema.entity.User;
import com.iatlyakov.ema.repository.IUserRepository;
import com.iatlyakov.ema.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
      return userRepository.findById(userId).get();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
