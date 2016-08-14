<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * Banner.jsp
 * jsp for banner displayed at top of each page
 -->
 
<%--Peter-Puck icon from http://4.bp.blogspot.com/-4-8MLSvfSmM/Tdk0BpimEbI/AAAAAAAAo_k/rOvYOyAFlCg/s320/Peter-Puck.jpg --%>
<%-- Dice image from http://www.friv1000000online.com/ --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NDPT Hockey Central</title>
        <link rel="icon" href="images/NDPT-icon.png" type="image/x-png" />
        <link rel="stylesheet" href="styles/bootstrap.min.css">
        <style>
        	.headerLinks:hover { color:white !important; }
        	.headerLinks { color:#428bca !important; font-weight:bold !important;}
        </style>
    </head>
    <body style="margin-bottom: 20px;">
    	<header>
	        <div class="navbar navbar-inverse navbar-fixed-top"> 
		        <div class="container">            
		            <div class="navbar-collapse collapse">                
		                <ul class="nav navbar-nav" style="padding-top:10px;">
		                    <li>
		                    	<a class="headerLinks" href="<c:url value='/Arena'>
		                    	</c:url>">Arenas</a>
		                   	</li>
							<li>
								<a class="headerLinks" href="<c:url value='/UpcomingGame'>
								</c:url>">Upcoming Games</a>
							</li>
							<li><a class="headerLinks" href="<c:url value='/Team'>
								</c:url>">Teams</a>
							</li>
		                </ul>
		            </div>
		        </div>
		    </div>       	
	        <h1 style="padding: 70px 0 30px 0;" class="col-sm-offset-3 col-sm-9"><img src="images/Peter-Puck.jpg" width="10%" height="10%" alt="Roll The Dice"/>  NDPT Hockey Central</h1>
		    <div class="row"><br/></div>
	    </header>
	    <div class="col-md-12">