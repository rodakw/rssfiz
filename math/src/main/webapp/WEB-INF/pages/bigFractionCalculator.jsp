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
					<a class="navbar-brand" href="/home">Home</a> <a class="navbar-brand" href="/fractionCalculator">Fraction</a>
					<div class="navbar-brand">BigFraction</div>
					<a class="navbar-brand" href="/complexCalculator">Complex</a>
				</div>
			</div>
		</nav>
	</div>

	<div id="outer">
		<br>
		<h2>
			<spring:message code="bigFraction.page.title" />
		</h2>
		<div id="innerText">
			<br> <br>
			<p>
				<spring:message code="bigFraction.page.text1" />
				<a href="https://sourceforge.net/projects/rssfiz" target="_blank">https://sourceforge.net/projects/rssfiz</a>
			</p>
			<p>
				<spring:message code="bigFraction.page.text2" />
			</p>
			<p>
				<spring:message code="bigFraction.page.text3" />
				<a href="/fractionCalculator">Fraction</a>
			</p>
			<br> <br>
		</div>

		<div id="inner">
			<br>

			<form:form method="POST" commandName="myData">

				<form:errors path="*" class="errorblock" element="div" />

				<table>
					<tr>
						<td><form:input path="total1" placeholder="${totalDesc}" cssClass="longWidth" /> &nbsp;&nbsp;&nbsp;</td>
						<td><form:input path="numerator1" placeholder="${numeratorDesc}" cssClass="bigIntWidth" />/</td>
						<td><form:input path="denominator1" placeholder="${denominatorDesc}" cssClass="bigIntWidth" /> * 10^</td>
						<td><form:input path="decimalPower1" placeholder="${decimalPowerDesc}" cssClass="intWidth" /></td>
					</tr>

					<tr>
						<td class="right"><spring:message code="operationDesc" />:</td>
						<td colspan="3"><form:radiobutton path="operation" value="+" />+ &nbsp;<form:radiobutton path="operation"
								value="-" />- &nbsp;<form:radiobutton path="operation" value="*" />* &nbsp;<form:radiobutton path="operation"
								value="/" />/</td>
					</tr>

					<tr>
						<td><form:input path="total2" placeholder="${totalDesc}" cssClass="longWidth" /> &nbsp;&nbsp;&nbsp;</td>
						<td><form:input path="numerator2" placeholder="${numeratorDesc}" cssClass="bigIntWidth" />/</td>
						<td><form:input path="denominator2" placeholder="${denominatorDesc}" cssClass="bigIntWidth" /> * 10^</td>
						<td><form:input path="decimalPower2" placeholder="${decimalPowerDesc}" cssClass="intWidth" /></td>
					</tr>

					<tr></tr>
					<tr>
						<td><input type="submit" value="${sendButton}" /></td>

						<td colspan="3"><input type="button" value="${resetButton}" onclick="resetForm();" /></td>
					</tr>
				</table>
			</form:form>

			<form id="resetForm" action="/bigFractionCalculator" method="get"></form>

			<br>
			<c:if test="${not empty result}">
				<div class="newline">
					<spring:message code="resultDesc" />
					= ${result}
				</div>
			</c:if>
			<div class="fat">
				<c:if test="${not empty isResult}">
					<div class="inline">
						<spring:message code="resultDesc" />
						=
					</div>
				</c:if>
				<c:if test="${not empty longResult}">
					<div class="inline">${longResult}</div>
				</c:if>

				<c:if test="${not empty numerator}">
					<c:if test="${denominator==1}">
						<div class="inline">${numerator}</div>
					</c:if>
					<c:if test="${denominator!=1}">
						<div class="inline">
							<sup>${numerator}</sup>&frasl;<sub>${denominator}</sub>
						</div>
					</c:if>
				</c:if>

				<c:if test="${not empty decimalPower}">
					<div class="inline">
						*10<sup>${decimalPower}</sup>
					</div>
					<c:if test="${not empty numeratorExt}">
						<div class="inline">
							(
							<c:if test="${not empty longResult}">
					${longResult}&nbsp;
				</c:if>
							<sup>${numeratorExt}</sup>&frasl;<sub>${denominatorExt}</sub> )
						</div>
					</c:if>
				</c:if>

				<c:if test="${not empty doubleResult}">
					<div class="newline">
						<spring:message code="resultDesc" />
						double = ${doubleResult}
					</div>
				</c:if>

				<c:if test="${not empty approximate}">
					<div class="newline">
						<spring:message code="approximate" />
					</div>
				</c:if>
				<br>
			</div>
		</div>
		<br> <br> <br>
	</div>
</body>