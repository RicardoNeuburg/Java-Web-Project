<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Usuário</title>
<link rel="icon" href="https://cdn4.iconfinder.com/data/icons/origami-23/64/Cat_origami_paper_craft_creative-256.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Usuário</h1>
	<form name="frmUsuario" action="update">
		<table>
			<tr>
				<td><input type="text" name="matricula" class="CaixaImutavel" readonly value="<%out.print(request.getAttribute("matricula"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" class="Caixa" value="<%out.print(request.getAttribute("endereco"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="documento" class="Caixa" value="<%out.print(request.getAttribute("documento"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>