<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<link rel="stylesheet" href="fractionCalculator.css" />
</head>

<body>
	<h2>Spring's form tags example</h2>

	<form:form method="POST" commandName="myData">

		<table>
			<tr>
				<td>total1 :</td>
				<td><form:input path="total1" /></td>
				<td>numerator1 :</td>
				<td><form:input path="numerator1" /> /</td>
				<td>denominator1 :</td>
				<td><form:input path="denominator1" />* 10 ^</td>
				<td>decimalPower1 :</td>
				<td><form:input path="decimalPower1" /></td>
			</tr>

			<tr>
				<td>operation :</td>
				<td>
					<form:radiobutton path="operation" value="+" />+
					<form:radiobutton path="operation" value="-" />-
					<form:radiobutton path="operation" value="*" />*
					<form:radiobutton path="operation" value="/" />/
				</td>
			</tr>

			<tr>
				<td>total2 :</td>
				<td><form:input path="total2" /></td>
				<td>numerator2 :</td>
				<td><form:input path="numerator2" /> / </td>
				<td>denominator2 :</td>
				<td><form:input path="denominator2" />* 10 ^</td>
				<td>decimalPower2 :</td>
				<td><form:input path="decimalPower2" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

	<br>
	<c:if test="${not empty result}">
		Result=${result}
	</c:if>

</body>
</html>