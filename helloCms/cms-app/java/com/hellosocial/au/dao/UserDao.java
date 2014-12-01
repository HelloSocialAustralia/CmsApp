package com.hellosocial.au.dao;

import javax.ejb.Local;

import com.hellosocial.au.entity.User;

@Local
public interface UserDao {

	User getUser(int parseInt);

	User getUserbyName(String userId);

	void saveUser(User user);

}
