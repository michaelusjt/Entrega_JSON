<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>cerveja.biz - Criar Usuario</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Usuario</h3>
        <!-- Formulario para inclusao de usuarios -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${usuario.nome }">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="cpf">cpf</label>
                    <input type="text" class="form-control" name="cpf" id="cpf" maxlength="11"  placeholder="opcional; cpf no formato 999.999.999.-99" value="${usuario.cpf }">
                </div>
                <div class="form-group col-md-6">
                    <label for="rg">rg</label>
                    <input type="text" class="form-control" name="rg" id="rg" required maxlength="9" placeholder="opcional; rg no formato 99999999-9" value="${usuario.rg }">
                </div>
                <div class="form-group col-md-6">
                    <label for="endereco">endereco</label>
                    <input type="text" class="form-control" name="endereco" id="endereco" required maxlength="100" placeholder="Campo obrigatório" value="${usuario.endereco }">
                </div>
                <div class="form-group col-md-6">
                    <label for="dataDeNascimento">dataDeNascimento</label>
                    <input type="text" class="form-control" name="dataDeNascimento" id="dataDeNascimento" required maxlength="15" placeholder="Campo obrigatório" value="${usuario.dataDeNascimento }">
                </div>
                <div class="form-group col-md-6">
                    <label for="nomeEmpresa">nomeEmpresa</label>
                    <input type="text" class="form-control" name="nomeEmpresa" id="nomeEmpresa" required maxlength="60" placeholder="Campo obrigatório" value="${usuario.nomeEmpresa }">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarUsuario">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>