<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Zitrus Web</title>
    <link href="styles/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #c7dfc3">
    <div clas="container-fluid">
        <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/zitrusWeb">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/zitrusWeb/formSolicitacao.html">Solicitacao de Autorização</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/zitrusWeb/ListaSolicitacoes">Solicitações autorizadas</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
    </div>
    <article class="container-fluid">
            <section class="row d-flex mt-5 justify-content-center">
                <div class="col-md-6">
                    <h2>Solicitações autorizadas</h2>
                    <div class="form-control">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Paciente</th>
                                    <th>Idade</th>
                                    <th>Sexo</th>
                                    <th>Procedimento</th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                                <c:forEach var="solicitacao" items="${listaSolicitacoes}">
                                    <tr>
                                        <td>${solicitacao.getPaciente()}</td>
                                        <td>${solicitacao.getIdade()}</td>
                                        <td>${solicitacao.getSexo()}</td>
                                        <td>${solicitacao.getProcedimento().getCodigo()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
    </article>
    <footer class="container-fluid">
        <div class="fixed-bottom bg-light text-center">
            Copyright @lucasBraga
        </div>
    </footer>
</body>
</html>