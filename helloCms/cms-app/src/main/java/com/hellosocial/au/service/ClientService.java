package com.hellosocial.au.service;

import javax.ejb.Local;

import com.hellosocial.au.entity.Client;

@Local
public interface ClientService {

	Client getClient(String clientId);

}
