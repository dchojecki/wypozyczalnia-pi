<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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

<h3>Witaj, ${uzytkownik.imie}!</h3>

<h5>Jestesmy tu dla Ciebie!</h5>
Jesli masz ochote cos obejrzec, ale nie wiesz jeszce co, skorzystaj z katalogu filmow w menu, po lewej stronie.<br/>
<br/>
Jesli chcesz sprawdzic stan Twoich zamowien, rowniez znajdziesz go w menu.<br/>


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