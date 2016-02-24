<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
	<style>
	.error {
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding:8px;
		margin:16px;
	}

	</style>
</head>

<body>
    <h2>Spring's form tags example</h2>

    <form:form method="POST" commandName="myData">

	<form:errors path="*" cssClass="errorblock" element="div"/>

        <table>
            <tr>
                <td>param1 :</td>
                <td><form:input path="param1" /></td>
                <td><form:errors path="param1" cssClass="error" /></td>
            </tr>
            <tr>
                <td>param2 :</td>
                <td><form:input path="param2" /></td>
                <td><form:errors path="param2" cssClass="error" /></td>
            </tr>

            <tr>
                <td>param3 :</td>
                <td><form:radiobutton path="param3" value="X" /> Param x <form:radiobutton path="param3" value="Y" />Param y</td>
            </tr>


            <form:hidden path="param4" value="cos"/>

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