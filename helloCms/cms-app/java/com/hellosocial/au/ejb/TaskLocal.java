/**
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hellosocial.au.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.kie.api.task.model.TaskSummary;

@Local
public interface TaskLocal {
    public List<TaskSummary> retrieveTaskList(String actorId) throws Exception;

    public void approveTask(String actorId, long taskId) throws Exception;

	public void claimTask(long taskId, String name) throws Exception;

	public List<TaskSummary> retrieveClaimedTaskList(String user) throws Exception;

	public void claimTask(String taskId, String name) throws  Exception;

	Map<String, Object> getTaskVariable(int taskId);
}
