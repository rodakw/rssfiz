<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="realDesc" var="realDesc" />
<spring:message code="imaginaryDesc" var="imaginaryDesc" />
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
					<a class="navbar-brand" href="/home">Home</a> <a
						class="navbar-brand" href="/fractionCalculator">Fraction</a> <a
						class="navbar-brand" href="/bigFractionCalculator">BigFraction</a>
					<div class="navbar-brand">Complex</div>
				</div>
			</div>
		</nav>
	</div>

	<div id="outer">
		<br>
		<h2>
			<spring:message code="complex.page.title" />
		</h2>
		<div id="innerText">
			<br> <br>
			<p>
				<spring:message code="complex.page.text1" />
				<a href="https://sourceforge.net/projects/rssfiz" target="_blank">https://sourceforge.net/projects/rssfiz</a>
			</p>
			<p>
				<spring:message code="complex.page.text2" />
			</p>
			<p>
				<spring:message code="complex.page.text3" />
				<a href="/bigFractionCalculator">BigFraction</a>
			</p>
			<br> <br>
		</div>

		<div id="inner">
			<br>

			<form:form method="POST" commandName="myData">

				<form:errors path="*" class="errorblock" element="div" />

				<table>
					<tr>
						<td><form:input path="real1" placeholder="${realDesc}"
								cssClass="longWidth" /> &nbsp;&nbsp;&nbsp;</td>
						<td><form:input path="imaginary1"
								placeholder="${imaginaryDesc}" cssClass="intWidth" /></td>
					</tr>

					<tr>
						<td class="right"><spring:message code="operationDesc" />:</td>
						<td><form:radiobutton path="operation" value="+" />+ &nbsp;<form:radiobutton
								path="operation" value="-" />- &nbsp;<form:radiobutton
								path="operation" value="*" />* &nbsp;<form:radiobutton
								path="operation" value="/" />/</td>
					</tr>

					<tr>
						<td><form:input path="real2" placeholder="${realDesc}"
								cssClass="longWidth" /> &nbsp;&nbsp;&nbsp;</td>
						<td><form:input path="imaginary2"
								placeholder="${imaginaryDesc}" cssClass="intWidth" /></td>
					</tr>

					<tr></tr>
					<tr>
						<td><input type="submit" value="${sendButton}" /></td>

						<td colspan="3"><input type="button" value="${resetButton}"
							onclick="resetForm();" /></td>
					</tr>
				</table>
			</form:form>

			<form id="resetForm" action="/complexCalculator" method="get"></form>

			<br>
			<c:if test="${not empty result}">
				<div class="newline">
					<spring:message code="resultDesc" />
					= ${result}
				</div>
			</c:if>

			<c:if test="${not empty doubleResult}">
				<div class="newline">
					<spring:message code="resultDesc" />
					double = ${doubleResult}
				</div>
			</c:if>

		</div>
		<br> <br> <br>
	</div>
</body>