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

package com.hellosocial.au.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hellosocial.au.entity.ContentCatogory;
import com.hellosocial.au.service.ContentService;

@WebServlet("/createContent")
public class CreateContentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContentService contentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String taskId = req.getParameter("taskId");
		String processId = req.getParameter("processId");
		req.setAttribute("taskId", taskId);
		req.setAttribute("client", contentService.getClient(taskId));
		List<ContentCatogory> list = contentService
				.getContentCatogoriesFromProcess(processId);
		req.setAttribute("contentCatogories", list);
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/createContent.jsp");
		dispatcher.forward(req, res);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String userId = req.getUserPrincipal().getName();
		String taskId = req.getParameter("taskId");
		String contentDescription = req.getParameter("contentDescription");
		String hasGraphics = req.getParameter("hasGraphics");
		String date = req.getParameter("date");
		String contentCatogoryId = req.getParameter("contentCatogoryId");
		String comment = req.getParameter("comment");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("date", date);
		params.put("contentDescription", contentDescription);
		params.put("hasGraphics", hasGraphics);
		params.put("contentCatogoryId", contentCatogoryId);
		params.put("comment", comment);

		try {
			contentService.createContent(userId, taskId, params);
		} catch (Exception e) {

			e.printStackTrace();
		}
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/create.jsp");
		dispatcher.forward(req, res);
		return;

	}
}