<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page 
 	import="br.com.lanchonete.dao.LancheDao" %>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cont" 
		class="br.com.lanchonete.dao.LancheDao">

	<form method="post" action="LancheServlet">
		Lanche:
		<select name="cboLanche">
			<c:forEach var="sanduba" items="${cont.listar() }">
				
				<option value="${sanduba.codigo }">
					${sanduba.nome }
				</option>
			
			</c:forEach>
		
			
			
			
		</select>
		
		Quantidade:
		<input type="number" name="txtQuantidade" />
		
		<input type="submit" value="Ok" />
	</form>
</jsp:useBean>




</body>
</html>