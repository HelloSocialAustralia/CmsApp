<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hellosocial.au.entity.ContentCatogory" %>
<%@ page import="com.hellosocial.au.entity.Client" %>
<%@ page import="com.hellosocial.au.entity.Rule" %>
<%@ page import="org.json.JSONObject" %>

<%

  JSONObject ruleList = (JSONObject)request.getAttribute("jsonObj");
    out.print(ruleList);
    out.flush();
    
  %>