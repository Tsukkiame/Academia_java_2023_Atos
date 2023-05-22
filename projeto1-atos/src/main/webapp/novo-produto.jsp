<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Novo Produto - Loja Atos S.A.</title>
		<link rel="stylesheet" type="text/css" href="style4.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" /> 
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />   <!--save register-->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" /> <!--new register-->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" /> <!--barcode scanner-->

	</head>

	<body>
		<div class="header"></div>
		<div class="nome-app">
		<a href="/projeto-backend/produtos" >
    	<div class="voltar" > <div> <span class="material-symbols-outlined">arrow_back_ios</span></div></div></a>
		  <div class="img"></div>
		  <div class="nome">Loja Atos S.A - Novo produto</div>
		  <div class="home"> <a href="/projeto-backend/home"> Home </a></div>
		  
		</div>
		<div class="divisor"></div>
		<div class="container">
		  <div class="cadastrar">
			<div class="imagem-produto"></div>
			<div class="dados-produtos">
				<h1>Cadastrar Novo Produto</h1>
			
				<form action="novoproduto" method="post">
					<fieldset>
						

						<div class="codbar">
						<p><label for="codigo">Codebar:</label>
						<input type="text" id="codigo" name="codigo"></p>
						
						</div>

						<p><label for="nome">Descrição do produto:</label>
						<input type="textarea" id="nome" name="nome"></p>

						<p><label for="categoria">Categoria:</label>
						<input type="text" id="categoria" size="50" name="categoria"></p>
						
						<p><label for="valor">Valor:</label>
						<input type="text" id="valor" name="valor"></p>

						<p><label for="quantidade">Quantidade:</label>
							<input type="number" id="quantidade" name="quantidade"></p>

						<div class="container-botoes" >
							<p class="botoes" ><input type="submit" value="Cadastrar produto">
							
							<p class="botoes"><input type="reset" value="Limpar">
						</div>
					</fieldset>
				</form>

			</div>
		  </div>
		</div>
		<div class="footer">
		  Trabalho realizado para Academia Atos - João | Kamily | Gustavo
		</div>
	</body>
</html>
