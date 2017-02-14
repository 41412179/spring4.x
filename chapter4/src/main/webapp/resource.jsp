<%@ page import="org.springframework.core.io.Resource" %>
<%@ page import="org.springframework.web.context.support.ServletContextResource" %>
<%@ page import="org.springframework.web.util.WebUtils" %>
<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%
    Resource res3 =new ServletContextResource(application, "/WEB-INF/classes/conf/test.txt");
    out.print(res3.getFilename() + "<br/>");
    out.print(WebUtils.getTempDir(application).getAbsolutePath());
%>