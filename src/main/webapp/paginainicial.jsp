<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="br.com.fiap.fintech.model.*" import="br.com.fiap.fintech.DataBase.*" 
    import="br.com.fiap.fintech.DAO.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Walletify | Pagina Inicial</title>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Sora:wght@400;500;600&display=swap"
      rel="stylesheet"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />

    <link rel="stylesheet" href="./styles.css" />
  </head>
  <body class="position-relative">
    <header
      class="position-absolute absolute-top d-flex justify-content-between w-100"
    >
      <nav class="nav py-4 px-5 d-flex align-items-center gap-4">
        <a href="/" class="text-decoration-none">
          <img src="./images/logo.svg" alt="Walletify" style="height: 3rem" />
        </a>
      </nav>
      <button id="logoutBtn" class="btn btn-primary m-4">Logout</button>

<script>
    document.getElementById("logoutBtn").addEventListener("click", function() {
        // Redireciona para a página index.html
        window.location.href = "index.html";
    });
</script>
    </header>

    <main
      class="d-flex h-screen pt-5 align-items-center justify-content-center"
    >
      <div class="p-5 d-flex flex-column justify-content-center gap-5 w-50">
        <div>
          <span class="text-body-secondary d-flex align-items-center gap-2">
            Saldo para:
            <div class="dropdown">
              <button
                class="btn btn-sm btn-outline-primary dropdown-toggle"
                type="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                ${conta}
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">${conta}</a></li>
                <li><a class="dropdown-item" href="#">${conta}</a></li>
                <li><a class="dropdown-item" href="#">${conta}</a></li>
              </ul>
            </div>
          </span>
          <h2>R$ <strong id="valor-saldo">${saldo}</strong></h2>
        </div>
        <div>
          <a
            href="/nova-movimentacao.html"
            class="badge rounded-pill text-bg-primary fs-6 fw-normal border-0 px-3 py-2 text-decoration-none"
          >
            Registrar movimentação
          </a>
          <a
            href="/nova-conta.html"
            class="badge rounded-pill text-bg-secondary fs-6 fw-normal border-0 px-3 py-2 text-decoration-none"
          >
            Adicionar conta
          </a>
        </div>
        <div class="row gap-4">
          <div class="bg-body-tertiary rounded p-4 col">
            <figure
              class="bg-success-subtle d-flex align-items-center justify-content-center rounded"
              style="width: 3.5rem; height: 3.5rem"
            >
              <i data-lucide="arrow-up-from-line" class="text-success"></i>
            </figure>
            <span class="fw-semibold text-body-secondary">Entradas do mês</span>
            <h3 class="text-success fw-normal">
              R$ <strong id="valor-entradas">${valor_entradas}</strong>
            </h3>
          </div>
          <div class="bg-body-tertiary rounded p-4 col">
            <figure
              class="bg-danger-subtle d-flex align-items-center justify-content-center rounded"
              style="width: 3.5rem; height: 3.5rem"
            >
              <i data-lucide="arrow-down-from-line" class="text-danger"></i>
            </figure>
            <span class="fw-semibold text-body-secondary">Saídas do mês</span>
            <h3 class="text-danger fw-normal">
              R$ <strong id="valor-saidas">${valor_saidas}</strong>
            </h3>
          </div>
        </div>
        <div class="d-flex flex-column" id="lista-movimentacoes">
          <div class="d-flex w-100 align-items-center gap-4 border-bottom py-4">
            <figure
              class="bg-success-subtle d-flex align-items-center justify-content-center rounded mb-0"
              style="width: 2.5rem; height: 2.5rem"
            >
              <i data-lucide="trending-up" class="text-success"></i>
            </figure>
            <div>
              <h4>${ds_movimentacao}</h4>
              <time class="text-body-secondary">${dt_data}</time>
            </div>
            <div class="text-end flex-grow-1">
              <h5 class="text-success fw-normal">
                + R$ <strong>${vl_movimentacao}</strong>
              </h5>
              <span class="text-body-secondary"
                >Movimentacao ${ds_recorrencia}</span
              >
            </div>
          </div>
          <div class="d-flex w-100 align-items-center gap-4 border-bottom py-4">
            <figure
              class="bg-danger-subtle d-flex align-items-center justify-content-center rounded mb-0"
              style="width: 2.5rem; height: 2.5rem"
            >
              <i data-lucide="trending-down" class="text-danger"></i>
            </figure>
            <div>
              <h4>${ds_movimentacao}</h4>
              <time class="text-body-secondary">${dt_data}</time>
            </div>
            <div class="text-end flex-grow-1">
              <h5 class="text-danger fw-normal">
                - R$ <strong>${vl_movimentacao}</strong>
              </h5>
              <span class="text-body-secondary"
                >Movimentacao ${ds_recorrencia}</span
              >
            </div>
          </div>
        </div>
      </div>
    </main>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <script src="https://unpkg.com/lucide@latest"></script>
    <script>
      lucide.createIcons();
    </script>
  </body>
</html>