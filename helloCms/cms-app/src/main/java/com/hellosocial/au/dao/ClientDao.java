/**
 * This interface helps to extract information of Clients from Database
 * as Clients Objects.
 */

package com.hellosocial.au.dao;

import java.util.List;

import javax.ejb.Local;

import com.hellosocial.au.entity.Client;

/**
 * 
 * @author Adam
 * 
 */
@Local
public interface ClientDao {
	List<Client> getAllClient();

	public Client getClient(int clientId);

	Client getClient(String clientId);

}
