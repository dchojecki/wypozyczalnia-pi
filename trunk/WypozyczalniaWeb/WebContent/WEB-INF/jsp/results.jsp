<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Wypozyczalnia</title>
<meta http-equiv="Content-Language" content="Polish" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<script type='text/javascript' src='jquery-1.2.6.min.js'></script>
<script type='text/javascript' src='script.js'></script>
</head>
<body>

<div id="wrap">

<div id="header">
<h1><a href="#">Pozycz.Se</a></h1>
<h2>Najlepsza Wypozyczalnia pod Sloncem!</h2>
</div>


<div id="contentbar"> 

<div class="contentbarleft">Menu</div>

<div class="contentbarright">Co chcialbys dzis obejrzec?</div>

</div>


<div id="content">

<div class="right">

${title} (${ile}):
<div class='results'>
	<ul>
	<c:forEach var="film" items="${films}">
		<li><strong>${film.tytul}</strong> (${film.rok})
		<a href='#' class='slider r-arr' onclick='return slideDiv(this);'>Opis</a>
		<div style='display: none;'>${film.opis}</div>
		<div>Dostepne: <b>${film.ileWolnych}</b></div>
		<div class='act'>
			<c:if test="${act_zamow}"><a href='zamow.html?fid=${film.id}'>Zamow</a></c:if>
			<c:if test="${act_anuluj}"><a href='anuluj.html?fid=${film.id}'>Anuluj rezerwacje</a></c:if>
		</div></li>
	</c:forEach>
	</ul>
</div>

</div>

<div class="left"> 

<h2>Filmy ::</h2>
<ul>
<li><a href="twoje.html">Zamowie przez Ciebie</a></li> 
<li><a href="filmy.html">Wszystkie dostepne</a></li> 
</ul>


</div>


<div style="clear: both;"> </div>

</div>

<div id="footer">
<a href='index.html'>Strona glowna</a> | <a href='filmy.html'>Dostepne filmy</a> | <a href='twoje.html'>Zamowione przez Ciebie</a>
<br/>
Designed by <a href="http://www.free-css-templates.com/">Free CSS Templates</a>, Thanks to <a href="http://www.dubaiapartments.biz/villas/" title="Dubai Apartments offers quality furnished hotel apartments, villas, and furnished properties on short term rental basis" target="_blank">Dubai Villas</a>
</div>

</div>

</body>
</html>