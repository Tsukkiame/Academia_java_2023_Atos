<%@page import="Models.Produto" %>
<%@page import="java.util.ArrayList" %>
    
    <%
    	@SuppressWarnings("unchecked")
    	Produto produto = (Produto) request.getAttribute("produto");
    	
    %>


<!DOCTYPE html>
<html lang="en">
  <head>
  <title>Atos S.A</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style3.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />    
    
  </head>
  <body>
  <div id="wrapper">
    <div class="header"></div>
    <div class="nome-app">
    <a href="/projeto-backend/produtos" >
    	<div class="voltar" > <div> <span class="material-symbols-outlined">arrow_back_ios</span></div></div></a>
      <div class="img"></div>
      <div class="nome">- Controle de Estoque - Atualizar Produto</div>
      <div class="home"> <a href="/projeto-backend/home"> Home </a></div>
    </div>
    <div class="divisor"></div>
		<div class="container">
		  <div class="cadastrar">
			<div class="imagem-produto"></div>
			<div class="dados-produtos">
				<h1>Atualizar Produto</h1>
			
				<form action="alterarproduto" method="post">
					<fieldset>
						
						<input type="hidden" name="id" value="<%=produto.getId() %>" />	
						<div class="codbar">
						<p><label for="codigo">Codebar:</label>
						<input type="text" id="codigo" name="codigo" value="<%=produto.getCodigo() %>"></p>
						
						</div>

						<p><label for="nome">Descrição do produto:</label>
						<input type="textarea" id="nome" size="50" name="nome" value="<%=produto.getNome() %>"></p>

						<p><label for="categoria">Categoria:</label>
						<input type="text" id="categoria" name="categoria" value="<%=produto.getCategoria() %>"></p>
						
						<p><label for="valor">Valor:</label>
						<input type="text" id="valor" name="valor" value="<%=produto.getValorEdicao() %>"></p>

						<p><label for="quantidade">Quantidade:</label>
							<input type="number" id="quantidade" name="quantidade" value="<%=produto.getQuantidade() %>"></p>

						<div>
							<p class="botoes" ><input type="submit" value="Atualizar produto">
							
							<p class="botoes"><input type="reset" value="Limpar">
						</div>
					</fieldset>
				</form>

			</div>
		  </div>
		</div>
    <footer>
    <div class="footer">
      Trabalho realizado para Academia Atos - João | Kamily | Gustavo
    </div>
    </footer>
    </div>
  </body>
  <script type="text/javascript" src="script.js" ></script>
</html>
