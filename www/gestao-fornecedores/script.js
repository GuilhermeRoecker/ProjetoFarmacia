function setupAuth() {
    const authToken = sessionStorage.getItem("auth_token") || localStorage.getItem("auth_token");

    if (!authToken) {
        // Sem token? Redireciona para login
        window.location.href = "../login/index.html";
        return;
    }

    // Intercepta o fetch globalmente para sempre mandar Authorization
    const originalFetch = window.fetch;
    window.fetch = function (url, options = {}) {
        options.headers = options.headers || {};
        options.headers["Authorization"] = "Bearer " + authToken;

        return originalFetch(url, options);
    };
}

setupAuth();

async function buscarFornecedores() {
    const tipo = document.getElementById("tipoBusca").value;
    const valor = document.getElementById("valorBusca").value.trim();
    const tabela = document.getElementById("tabelaFornecedores");
    tabela.innerHTML = ""; 

    let url = "http://localhost:8080/fornecedores";

    if (tipo && valor) {
        switch (tipo) {
            case "id":
                url += `/fornecedores/${valor}`;
                break;
            case "nome":
                url += `/buscar/nome?nome=${encodeURIComponent(valor)}`;
                break;
            case "documento":
                url += `/buscar/documento?documento=${encodeURIComponent(valor)}`;
                break;
            case "telefone":
                url += `/buscar/telefone?telefone=${encodeURIComponent(valor)}`;
                break;
            case "email":
                url += `/buscar/email?email=${encodeURIComponent(valor)}`;
                break;
        }
    }

    try {
        const response = await fetch(url);
        if (response.status === 204) {
            tabela.innerHTML = "<tr><td colspan='5'>Nenhum fornecedor encontrado.</td></tr>";
            return;
        }

        const data = await response.json();
        const fornecedores = Array.isArray(data) ? data : [data];

        fornecedores.forEach(p => {
            const idade = calcularIdade(p.dtNascimento);
            tabela.innerHTML += `
                <tr>
                    <td>${p.nome}</td>
                    <td>${idade} anos</td>
                    <td>${p.telefone}</td>
                    <td>${p.email || "-"}</td>
                    <td>
                        <button onclick="editarfornecedor(${p.id})">Editar</button>
                        <button onclick="excluirfornecedor(${p.id})">Excluir</button>
                    </td>
                </tr>
            `;
        });
    } catch (error) {
        console.error("Erro ao buscar fornecedores:", error);
        tabela.innerHTML = "<tr><td colspan='5'>Erro ao buscar fornecedores.</td></tr>";
    }
}

function calcularIdade(dataNascimento) {
    const hoje = new Date();
    const nascimento = new Date(dataNascimento);
    let idade = hoje.getFullYear() - nascimento.getFullYear();
    const m = hoje.getMonth() - nascimento.getMonth();
    if (m < 0 || (m === 0 && hoje.getDate() < nascimento.getDate())) {
        idade--;
    }
    return idade;
}

function editarfornecedor(id) {
    alert("Função de editar ainda não implementada para ID " + id);
}

function excluirfornecedor(id) {
    if (confirm("Deseja realmente excluir este fornecedor?")) {
        fetch(`http://localhost:8080/fornecedores/${id}`, {
            method: "DELETE"
        })
        .then(res => {
            if (res.ok) {
                alert("fornecedor excluído com sucesso!");
                buscarFornecedores();
            } else {
                alert("Erro ao excluir fornecedor.");
            }
        })
        .catch(err => console.error(err));
    }
}

// Carrega todos os fornecedores ao abrir a página
window.onload = buscarFornecedores;

function abrirCadastro() {
    document.getElementById("cadastroOffcanvas").classList.add("open");
}

function fecharCadastro() {
    document.getElementById("cadastroOffcanvas").classList.remove("open");
}

document.getElementById("formCadastro").addEventListener("submit", async function(e) {
    e.preventDefault();
    const form = e.target;

    const fornecedor = {
        nome: form.nome.value,
        dtFundacao: form.nascimento.value, // Renomeado para refletir melhor a finalidade
        tipoPessoa: form.tipoPessoa.value,
        documento: form.documento.value,
        razaoSocial: form.razaoSocial.value,
        inscricaoEstadual: form.inscricaoEstadual.value,
        telefone: form.telefone.value,
        email: form.email.value,
        observacoes: form.observacoes ? form.observacoes.value : null,
        endereco: {
            rua: form.rua.value,
            numero: form.numero.value,
            bairro: form.bairro.value,
            cidade: form.cidade.value,
            estado: form.estado.value,
            cep: form.cep.value
        }
    };
    

    try {
        const response = await fetch("http://localhost:8080/fornecedores", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(fornecedor)
        });

        if (response.ok) {
            alert("Fornecedor cadastrado com sucesso!");
            fecharCadastro();
            buscarFornecedores();
            form.reset();
        } else {
            const erro = await response.text();
            alert("Erro ao cadastrar fornecedor: " + erro);
        }
    } catch (error) {
        console.error("Erro:", error);
        alert("Erro ao enviar os dados.");
    }
});



