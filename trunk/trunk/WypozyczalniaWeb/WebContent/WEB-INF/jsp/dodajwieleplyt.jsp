<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodawanie nowej plyty</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<script type='text/javascript' src='jquery-1.2.6.min.js'></script>
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

<h5>Wypelnij formularz dodawania wielu egzemplarzy tego samego filmu:</h5>

<br/>
Dodawanie egzemplarzy do filmu ${film.tytul }
<form action='dodajPlyte.html' method='post'>
		<label>Ile plyt chcesz dodac:</label>
		<input type='text' name='iledodac'/><br/>
		<input type='hidden' name='ile' value='wiele'>
		<input type='hidden' name='fid' value='${film.id }'>
		<input type='submit' value='Dodaj plyty' class='button'/>
</form>
<br/>

</div>

<div class="left"> 

<h2>Filmy ::</h2>
<ul>
<li><a href="twoje.html">Zamowie przez Ciebie</a></li> 
<li><a href="filmy.html">Wszystkie dostepne</a></li> 
<li><a href=dodajFilm.html>Dodaj</a></li> 
</ul>


</div>


<div style="clear: both;"> </div>

<div id="footer">
<a href='dodajFilm.html'>Dodaj film</a> | <a href='filmy.html'>Dostepne filmy</a> | <a href='twoje.html'>Zamowione przez Ciebie</a>
<br/>
Designed by <a href="http://www.free-css-templates.com/">Free CSS Templates</a>, Thanks to <a href="http://www.dubaiapartments.biz/villas/" title="Dubai Apartments offers quality furnished hotel apartments, villas, and furnished properties on short term rental basis" target="_blank">Dubai Villas</a>
</div>

</div>
</body>
</html>