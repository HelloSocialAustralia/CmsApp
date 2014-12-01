package com.hellosocial.au.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.hellosocial.au.dao.ClientDao;
import com.hellosocial.au.entity.Client;

@Stateless
public class ClientServiceImpl implements ClientService {
	@Inject
	private ClientDao clientDao;

	@Override
	public Client getClient(String clientId) {

		return clientDao.getClient(clientId);
	}

}
