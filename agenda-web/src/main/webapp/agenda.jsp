<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<% 
	@SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos"); 
%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Agenda de Contatos</title>
		<link rel="icon" href="img/icon-phone.png">
		<link rel="stylesheet" href="estilo.css">
	</head>
	<body>
		<h1>Agenda de Contatos</h1>
		<a href="novo.html" class="Botao1">Novo Contato</a>
		<a href="report" class="Botao2">Relatório</a>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>E-mail</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>		
				<% 
					try{
						for(int i = 0; i < lista.size(); i++){				
				%>
					<tr>
						<td><%= lista.get(i).getId() %></td>
						<td><%= lista.get(i).getNome() %></td>
						<td><%= lista.get(i).getFone() %></td>
						<td><%= lista.get(i).getEmail() %></td>
						<td>
							<a href="select?id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
							<a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="Botao2">Excluir</a>
						</td>
					</tr>
				<% 		
						} 
					} catch(Exception ex){
						System.out.println(ex);
				%>
					<tr>
						<td>Falha na execução</td>
					</tr>
				<%
					}
				%>	
			</tbody>
		</table>
		<script src="scripts/confirmador.js"></script>
	</body>
</html>