package com.hellosocial.au.dao;

import java.util.List;

import javax.ejb.Local;

import com.hellosocial.au.entity.Client;
import com.hellosocial.au.entity.ContentCatogory;
import com.hellosocial.au.entity.Rule;

@Local
public interface ContentCatogoryDao {

	void addContentCatogory(ContentCatogory contentCatogory);

	List<ContentCatogory> getContentCatogories(Client client);

	List<ContentCatogory> getContentCatogories(int clientId);

	ContentCatogory getContentCatogory(int contentCatogoryId);

	List<Rule> getRuleList(int contentCatogoryId);

}
