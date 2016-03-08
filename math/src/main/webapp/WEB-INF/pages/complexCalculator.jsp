<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="totalDesc" var="totalDesc" />
<spring:message code="numeratorDesc" var="numeratorDesc" />
<spring:message code="denominatorDesc" var="denominatorDesc" />
<spring:message code="decimalPowerDesc" var="decimalPowerDesc" />
<spring:message code="sendButton" var="sendButton" />
<spring:message code="resetButton" var="resetButton" />

<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet" href="/css/bootstrap.mini.css">
<script type="text/javascript" src="/js/main.js"></script>

</head>

<body>
	<div>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/home">Home</a> <a class="navbar-brand" href="/fractionCalculator">Fraction</a> <a
						class="navbar-brand" href="/bigFractionCalculator">BigFraction</a>
					<div class="navbar-brand">Complex</div>
				</div>
			</div>
		</nav>
	</div>

<br><br>Complex
</body>