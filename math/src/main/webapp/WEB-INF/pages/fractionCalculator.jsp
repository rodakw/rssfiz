<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="totalDesc" var="totalDesc" />
<spring:message code="numeratorDesc" var="numeratorDesc" />
<spring:message code="denominatorDesc" var="denominatorDesc" />
<spring:message code="decimalPowerDesc" var="decimalPowerDesc" />

<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<link rel="stylesheet" href="/css/fractionCalculator.css" />
<script type="text/javascript" src="/js/main.js"></script>

</head>

<body>

	<div id="outer">
		<br>
		<h2>
			<spring:message code="page.title" />
		</h2>
		<div id="innerText">
			<br> <br>
			<spring:message code="page.text" />
			<br> <br>
		</div>

		<div id="inner">

			<form:form method="POST" commandName="myData">

				<form:errors path="*" class="errorblock" element="div" />

				<table>
					<tr>
						<td><form:input path="total1" placeholder="${totalDesc}" /></td>
						<td><form:input path="numerator1" placeholder="${numeratorDesc}" /> /</td>
						<td><form:input path="denominator1" placeholder="${denominatorDesc}" />* 10 ^</td>
						<td><form:input path="decimalPower1" placeholder="${decimalPowerDesc}" /></td>
					</tr>

					<tr>
						<td><spring:message code="operationDesc" /> :</td>
						<td colspan="3">
							<form:radiobutton path="operation" value="+" />+ 
							<form:radiobutton path="operation" value="-" />- 
							<form:radiobutton path="operation" value="*" />* 
							<form:radiobutton path="operation" value="/" />/
						</td>
					</tr>

					<tr>
						<td><form:input path="total2" placeholder="${totalDesc}" /></td>
						<td><form:input path="numerator2" placeholder="${numeratorDesc}" /> /</td>
						<td><form:input path="denominator2" placeholder="${denominatorDesc}" />* 10 ^</td>
						<td><form:input path="decimalPower2" placeholder="${decimalPowerDesc}" /></td>
					</tr>

					<tr>
						<td><input type="submit" /></td>

						<td colspan="3"><input type="reset" onclick="resetForm();" /></td>
					</tr>
				</table>
			</form:form>
			
			<form id="resetForm" action="/new/fractionCalculator" method="get"></form>

			<br>
			<c:if test="${not empty result}">
				<div class="newline">Result = ${result}</div>
			</c:if>
			<div class="fat">
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

				<c:if test="${not empty approximate}">
					<div class="newline">result is approximate!</div>
				</c:if>

				<div class="newline">${doubleResult}</div>
			</div>
		</div>
		<br> <br> <br>
	</div>
</body>
</html>