// Variável global para armazenar fornecedores
let fornecedores = [];

// Função para abrir o menu lateral
function abrirFormulario() {
    document.getElementById("menuLateral").classList.add("aberto");
}

// Função para fechar o menu lateral
function fecharFormulario() {
    document.getElementById("menuLateral").classList.remove("aberto");
}

// Função para abrir o modal de fornecedores
function abrirModalFornecedor() {
    document.getElementById("modalFornecedor").style.display = 'flex';
    carregarFornecedores(); // Carregar os fornecedores quando o modal for aberto
}

// Função para fechar o modal de fornecedores
function fecharModalFornecedor() {
    document.getElementById("modalFornecedor").style.display = 'none';
}

// Função para carregar os fornecedores da API
async function carregarFornecedores() {
    try {
        const resposta = await fetch('http://localhost:8080/fornecedores');
        fornecedores = await resposta.json(); 
        
        if (fornecedores.length === 0) {
            document.getElementById('listaFornecedores').innerHTML = '<p>Nenhum fornecedor encontrado.</p>';
            return;
        }

        const listaFornecedores = document.getElementById('listaFornecedores');
        listaFornecedores.innerHTML = '';

        fornecedores.forEach(fornecedor => {
            const li = document.createElement('li');
            li.classList.add('fornecedor-item');
            li.innerHTML = `
                <span class="nome">${fornecedor.nome}</span> - 
                <span class="documento">${fornecedor.documento}</span> - 
                <span class="telefone">${fornecedor.telefone}</span>
                <button class="select-fornecedor" onclick="selecionarFornecedor(${fornecedor.id})">Selecionar</button>
            `;
            listaFornecedores.appendChild(li);
        });
    } catch (error) {
        console.error('Erro ao carregar fornecedores:', error);
        alert('Erro ao carregar fornecedores.');
    }
}

// Função para selecionar um fornecedor
function selecionarFornecedor(id) {
    const fornecedorSelecionado = fornecedores.find(fornecedor => fornecedor.id === id);

    if (fornecedorSelecionado) {
        document.getElementById('campoFornecedor').value = fornecedorSelecionado.nome;
        document.getElementById('campoFornecedorId').value = fornecedorSelecionado.id;
    }

    fecharModalFornecedor();
}

// Função para carregar a tabela de insumos
function carregarTabelaInsumos() {
    fetch('http://localhost:8080/produto/listar')
        .then(response => response.json())
        .then(informacoes => {
            const tabelaInsumos = document.getElementById('tabelaInsumos');
            tabelaInsumos.innerHTML = '';

            informacoes.forEach(insumo => {
                const linha = document.createElement('tr');
                linha.innerHTML = `
                    <td>${insumo.nome}</td>
                    <td>${insumo.tipo}</td>
                    <td>${insumo.fabricante}</td>
                    <td>${insumo.fornecedor.nome}</td>
                    <td>${insumo.validade}</td>
                    <td>${insumo.precoVenda}</td>
                    <td>
                        <button onclick="excluirInsumo(${insumo.id})">Excluir</button>
                    </td>
                `;
                tabelaInsumos.appendChild(linha);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar insumos:', error);
        });
}

// Função para excluir o insumo
function excluirInsumo(id) {
    fetch(`http://localhost:8080/produto/excluir/${id}`, {
        method: 'DELETE',
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('auth_token'),
            'Content-Type': 'application/json',
        }
    })
    .then(response => response.text())
    .then(mensagem => {
        alert(mensagem);
        carregarTabelaInsumos();
    })
    .catch(error => {
        console.error('Erro na requisição:', error);
        alert('Erro ao excluir produto.');
    });
}

// Aguardar o carregamento do DOM
document.addEventListener("DOMContentLoaded", function () {
    function setupAuth() {
        const authToken = sessionStorage.getItem("auth_token") || localStorage.getItem("auth_token");

        if (!authToken) {
            window.location.href = "../login/index.html";
            return;
        }

        const originalFetch = window.fetch;
        window.fetch = function (url, options = {}) {
            options.headers = options.headers || {};
            options.headers["Authorization"] = "Bearer " + authToken;
            options.headers["Content-Type"] = "application/json";
            return originalFetch(url, options);
        };
    }

    setupAuth();
    carregarTabelaInsumos();

    document.getElementById('formCadastro').addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(this);
        const produto = {};

        formData.forEach((value, key) => {
            produto[key] = value;
        });

        produto.fornecedor = {
            id: parseInt(produto.fornecedorId)
        };
        delete produto.fornecedorId;

        fetch('http://localhost:8080/produto/cadastrar', {
            method: 'POST',
            body: JSON.stringify(produto),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.text())
        .then(mensagem => {
            alert(mensagem || 'Produto cadastrado com sucesso!');
            document.getElementById('formCadastro').reset();
            fecharFormulario();
            carregarTabelaInsumos();
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            alert('Erro ao cadastrar produto.');
        });
    });
});


document.addEventListener("DOMContentLoaded", function () {
    function setupAuth() {
        const authToken = sessionStorage.getItem("auth_token") || localStorage.getItem("auth_token");

        if (!authToken) {
            window.location.href = "../login/index.html";
            return;
        }

        const originalFetch = window.fetch;
        window.fetch = function (url, options = {}) {
            options.headers = options.headers || {};
            options.headers["Authorization"] = "Bearer " + authToken;
            return originalFetch(url, options);
        };
    }

    setupAuth();

    // Lógica da página
    const abrirMenuBtn = document.getElementById("abrirMenuBtn");
    const fecharMenuBtn = document.getElementById("fecharMenuBtn");
    const menuLateral = document.getElementById("menuLateral");
    const formInsumo = document.getElementById("formInsumo");
    const tabelaInsumos = document.getElementById("tabelaInsumos");
    const abrirModalFornecedor = document.getElementById("abrirModalFornecedor");
    const fecharModalFornecedor = document.getElementById("fecharModalFornecedor");
    const modalFornecedor = document.getElementById("modalFornecedor");

    abrirMenuBtn.addEventListener("click", () => {
        menuLateral.classList.add("aberto");
    });

    fecharMenuBtn.addEventListener("click", () => {
        menuLateral.classList.remove("aberto");
    });

    abrirModalFornecedor.addEventListener("click", () => {
        modalFornecedor.style.display = "block";
    });

    fecharModalFornecedor.addEventListener("click", () => {
        modalFornecedor.style.display = "none";
    });

    window.onclick = function(event) {
        if (event.target == modalFornecedor) {
            modalFornecedor.style.display = "none";
        }
    }

    formInsumo.addEventListener("submit", function (e) {
        e.preventDefault();

        const novoInsumo = {
            nome: document.getElementById("nome").value,
            tipo: document.getElementById("tipo").value,
            fabricante: document.getElementById("fabricante").value,
            fornecedor: document.getElementById("fornecedor").value,
            estoqueAtual: document.getElementById("estoqueAtual").value,
            estoqueMinimo: document.getElementById("estoqueMinimo").value
        };

        adicionarInsumoNaTabela(novoInsumo);
        formInsumo.reset();
        menuLateral.classList.remove("aberto");
    });

    function adicionarInsumoNaTabela(insumo) {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${insumo.nome}</td>
            <td>${insumo.tipo}</td>
            <td>${insumo.fabricante}</td>
            <td>${insumo.fornecedor}</td>
            <td>${insumo.estoqueAtual}</td>
            <td>${insumo.estoqueMinimo}</td>
            <td>
                <button class="action-btn edit">Editar</button>
                <button class="action-btn delete">Excluir</button>
            </td>
        `;

        tabelaInsumos.appendChild(tr);
    }
});