<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créatio d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>


<c:import url="/inc/menu.jsp"></c:import>
<div>
	<form method="get" action="creationClient">
		<fieldset>
			<legend>Information Client	</legend>
            
            <c:import url="/inc/inc_client_form.jsp"></c:import>
            
        </fieldset>
        <input type="submit" value="Valider"/>
        <input type="reset" value="Remettre à zéro"/>
        <br/>

	</form>
</div>
</body>
</html>