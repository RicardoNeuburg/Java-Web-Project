<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Usuários</title>
<link rel="icon" href="https://cdn4.iconfinder.com/data/icons/origami-23/64/Cat_origami_paper_craft_creative-256.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de Usuários</h1>
	<a href="novo.html" class="Botao1">Novo Usuário</a>
	<table id="Tabela">
		<thead>
			<tr>
				<th>Mátricula</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>CPF/CNPJ</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%=lista.get(i).getMatricula()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getEndereco()%></td>
					<td><%=lista.get(i).getDocumento()%></td>
					<td>
					<a href="select?matricula=<%=lista.get(i).getMatricula() %>" class="Botao1">Editar</a>
					<a href="javascript:confirmar(<%=lista.get(i).getMatricula() %>)" class="Botao2">Excluir</a>
					</td>
				</tr>
			<%}%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>