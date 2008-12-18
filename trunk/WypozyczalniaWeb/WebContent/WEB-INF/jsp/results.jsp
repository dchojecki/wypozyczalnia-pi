<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filmy</title>
</head>
<body>
${title} (${ile}):
<div id='results'>
	<ul>
	<c:forEach var="film" items="${films}">
		<li><h3>${film.tytul}</h3>${film.rok}<div>${film.opis}</div><div>Dostepne: <b>${film.ileWolnych}</b></div>
		<div>
			<c:if test="${act_zamow}"><a href='zamow?fid=${film.id}'>Zamow</a></c:if>
			<c:if test="${act_anuluj}"><a href='anuluj?fid=${film.id}'>Anuluj rezerwacje</a></c:if>
		</div></li>
	</c:forEach>
	</ul>
</div>

<div>
<a href='/WypozyczalniaWeb'>Strona glowna</a> | <a href='filmy'>Dostepne filmy</a> | <a href='twoje'>Zamowione przez Ciebie</a>
</div>

</body>
</html>