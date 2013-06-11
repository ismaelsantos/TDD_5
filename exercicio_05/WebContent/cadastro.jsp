<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="livroController" method="post">
		<label>Titulo:</label> <input type="text" name="titulo" /> <label>Descrição:</label>
		<input type="text" name="descricao" /> <label>Autor:</label> <input
			type="text" name="autor" /> <label>Tipo:</label>
			<select name="opcao" onchange="js/index.js:showHide()">
				<option selected="selected" value="comboColecao">Livro</option>
				<option value="colecao">Coleção</option>
			</select>
		<label>Volume:</label>
		<input type="text" name="volume" id="volume"/>
		<label>Quantidade:</label>
		<input type="text" name="qtdLivros" id="qtdLivros"/>	
		<input type="submit" />
	</form>
</body>
</html>

<a href="index.jsp">Voltar</a>