<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet" href="/css/bootstrap.mini.css">

</head>

<body>
	<div>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<div class="navbar-brand">Home</div>
					<a class="navbar-brand" href="/fractionCalculator">Fraction</a> <a class="navbar-brand"
						href="/bigFractionCalculator">BigFraction</a> <a class="navbar-brand" href="/complexCalculator">Complex</a>
				</div>
			</div>
		</nav>
	</div>

	<div id="outer">
		<br>
		<h2>
			<spring:message code="home.page.title" />
		</h2>
		<div id="innerText">
			<br> <br>
			<p>
				<spring:message code="home.page.text1" />
				<a href="https://sourceforge.net/projects/rssfiz" target="_blank">https://sourceforge.net/projects/rssfiz</a>
			</p>
			<p>
				<spring:message code="home.page.text2" />
			</p>
			<p>
				<spring:message code="home.page.text3" />
			</p>

			<br> <br>
		</div>

		<div id="inner">
			<pre>
				<code>
	&lt;dependency&gt;
		&lt;groupId&gt;pl.wr.rss&lt;/groupId&gt;
		&lt;artifactId&gt;rssfiz.math&lt;/artifactId&gt;
		&lt;version&gt;1.0.2&lt;/version&gt;
		&lt;type&gt;jar&lt;/type&gt;
	&lt;/dependency&gt;
		
	&lt;repositories&gt;
		&lt;repository&gt;
			&lt;id&gt;rss_repository&lt;/id&gt;
			&lt;name&gt;RodakSoftStudio&lt;/name&gt;
			&lt;url&gt;https://sourceforge.net/projects/rssfiz/files/maven2/&lt;/url&gt;
			&lt;layout&gt;default&lt;/layout&gt;
		&lt;/repository&gt;
	&lt;/repositories&gt;	
		</code>
			</pre>
		</div>
		<br> <br> <br>
	</div>
</body>