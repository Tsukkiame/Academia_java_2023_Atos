<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="Models.Produto" %>
<%@page import="java.util.ArrayList" %>
    
    <%
    	@SuppressWarnings("unchecked")
    	ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("listaProdutos");
    	
    %>


<!DOCTYPE html>
<html lang="en">
  <head>
  <title>Atos S.A</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style2.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />    
    
  </head>
  <body>
  <div id="wrapper">
    <div class="header"></div>
    <div class="nome-app">
      <div class="img"></div>
      <div class="nome">- Controle de Estoque - Todos Produtos</div>
      <div class="novo-produto"> <a href="/projeto-backend/novoproduto"> Novo Produto </a></div>
      <div class="home"> <a href="/projeto-backend/home"> Home </a></div>
    </div>
    <div class="divisor"></div>
    <div class="container">
    <%for(int i=lista.size()-1; i>=0; i--){ %>
      <div class="cadastrar">
        <div class="imagem-produto"></div>
        <div class="dados-produtos">
          <div class="nome"> <%=lista.get(i).getNome()%> </div>
          <div class="nome preco"><%=lista.get(i).getValor()%> </div>
        </div>
        <div class="excluir-alterar">
          <div class="excluir" onclick="deletar('<%=lista.get(i).getId()%>')" ><span class="material-symbols-outlined">
            delete
            </span></div>
            <a href="/projeto-backend/alterarproduto?id=<%=lista.get(i).getId()%>">
          <div class="alterar" onclick="alterar('<%=lista.get(i).getId()%>')"><span class="material-symbols-outlined">
            edit_square
            </span></div></a>
        </div>
      </div>
      <%} %>
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
