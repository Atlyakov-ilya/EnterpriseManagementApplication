package com.iatlyakov.ema.service;

import com.iatlyakov.ema.entity.User;

import java.util.List;

public interface IUserService  {

    void save(User user);

    List<User> findAll();

    User getUserById(Long userId);

    void deleteUser(Long userId);

}
