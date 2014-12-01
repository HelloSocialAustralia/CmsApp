package com.hellosocial.au.service;

import javax.ejb.Local;

@Local
public interface ProcessService {

	long startProcess(String clientId) throws Exception;

}
