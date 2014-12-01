package com.hellosocial.au.service;

import javax.ejb.Stateless;
import javax.inject.Inject;





import com.hellosocial.au.dao.ClientDao;
import com.hellosocial.au.ejb.ProcessLocal;

@Stateless
public class ProcessServiceImpl implements ProcessService  {
   
	@Inject
	private ProcessLocal processBean;
	@Inject
	private ClientDao clientDao;
	
	@Override
	public long startProcess(String clientId) throws Exception {
		
		return processBean.startProcess(clientDao.getClient(clientId));
	}

}
