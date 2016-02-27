<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<link rel="stylesheet" href="/css/fractionCalculator.css" />
</head>

<body>
	<h2>Fraction and mixed number's calculator.</h2>

	<form:form method="POST" commandName="myData">
	
	<form:errors path="*" class="errorblock" element="div"/>

		<table>
			<tr>
				<td><form:input path="total1" placeholder="total" /></td>
				<td><form:input path="numerator1" placeholder="numerator" /> /</td>
				<td><form:input path="denominator1" placeholder="denominator" />* 10 ^</td>
				<td><form:input path="decimalPower1" placeholder="decimalPower" /></td>
			</tr>

			<tr>
				<td>operation :</td>
				<td  colspan="3">
					<form:radiobutton path="operation" value="+" />+
					<form:radiobutton path="operation" value="-" />-
					<form:radiobutton path="operation" value="*" />*
					<form:radiobutton path="operation" value="/" />/
				</td>
			</tr>

			<tr>
				<td><form:input path="total2" placeholder="total"/></td>
				<td><form:input path="numerator2" placeholder="numerator" /> / </td>
				<td><form:input path="denominator2" placeholder="denominator"/>* 10 ^</td>
				<td><form:input path="decimalPower2" placeholder="decimalPower"/></td>
			</tr>

			<tr>
				<td><input type="submit" /></td>
	</form:form>
	<form:form method="GET" commandName="myData">
				<td colspan="3"><input type="submit" value="Resetuj" /></td>
			</tr>
		</table>
	</form:form>

	<br>
	<c:if test="${not empty result}">
		Result=${result}
	</c:if>

</body>
</html>