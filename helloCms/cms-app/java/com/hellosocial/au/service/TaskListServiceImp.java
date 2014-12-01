package com.hellosocial.au.service;

import java.util.List;

import javax.inject.Inject;

import org.kie.api.task.model.TaskSummary;

import com.hellosocial.au.ejb.TaskLocal;

public class TaskListServiceImp implements TaskListService {
    
	@Inject
	private TaskLocal taskbean;
	@Override
	public List<TaskSummary> retrieveTaskList(String user) throws Exception {
		return taskbean.retrieveTaskList(user);
	}
	@Override
	public void claimTask(String taskId, String name) throws Exception {
		taskbean.claimTask(taskId, name);
		
	}
	@Override
	public List<TaskSummary> retrieveClaimedTaskList(String user)
			throws Exception {
		// TODO Auto-generated method stub
		return taskbean.retrieveClaimedTaskList(user);
	}

}
