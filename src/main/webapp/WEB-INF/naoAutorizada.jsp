<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Autorizacao de Procedimento</title>
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
            <section class="row d-flex mt-5 justify-content-center text-center">
                <div class="col-md-6">
                    <div class="alert alert-danger" role="alert">
                      <h2>Solicitação não Autorizada!</h2>
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