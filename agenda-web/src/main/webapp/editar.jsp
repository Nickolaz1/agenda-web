<%@page import="model.JavaBeans"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<% 
	JavaBeans contato = (JavaBeans) request.getAttribute("contato");
%>
<html>
<head>
	<meta charset="utf-8">
	<title>Agenda de contatos - Editar</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly value="<%= contato.getId()%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" value="<%= contato.getNome()%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="Caixa2" value="<%= contato.getFone()%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" value="<%= contato.getEmail()%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>