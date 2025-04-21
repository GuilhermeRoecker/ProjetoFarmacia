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

    // Função para abrir o formulário

    
    // Função para fechar o formulário
    function fecharFormulario() {
        document.getElementById("menuLateral").classList.remove("aberto");
    }

    // Função para calcular o preço de venda com base na margem de lucro
    function calcularPrecoVenda() {
        const precoCusto = parseFloat(document.getElementById('precoCusto').value);
        const margemLucro = parseFloat(document.getElementById('margemLucro').value);

        if (precoCusto && margemLucro) {
            const precoVenda = precoCusto + (precoCusto * (margemLucro / 100));
            document.getElementById('precoVenda').value = precoVenda.toFixed(2);
        }
    }

    // Evento para enviar o cadastro de produto
    document.getElementById('formCadastro').addEventListener('submit', function(event) {
        event.preventDefault();  // Impede o envio do formulário para demonstração
        
        // Calcular o preço de venda antes de cadastrar
        calcularPrecoVenda();

        // Coletando os dados do formulário
        const formData = new FormData(this);
        const produto = {};

        formData.forEach((value, key) => {
            produto[key] = value;
        });

        // Corrige para enviar o Fornecedor como objeto
        produto.fornecedor = {
            id: parseInt(produto.fornecedorId)
        };
        delete produto.fornecedorId;

        // Envia os dados para o servidor (alterar a URL conforme necessário)
        fetch('/produto/cadastrar', {
            method: 'POST',
            body: JSON.stringify(produto),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.text())
        .then(mensagem => {
            alert(mensagem || 'Produto cadastrado com sucesso!');
            document.getElementById('formCadastro').reset();  // Limpa o formulário
            fecharFormulario();
            carregarTabelaInsumos();  // Recarrega a tabela de insumos após cadastro
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            alert('Erro ao cadastrar produto.');
        });
    });

    // Função para carregar a tabela de insumos
    async function carregarTabelaInsumos() {
        const resposta = await fetch('/produto/listar');
        const insumos = await resposta.json();
        const tabela = document.getElementById('tabelaInsumos');
        tabela.innerHTML = ''; // Limpar tabela antes de preencher

        insumos.forEach(insumo => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${insumo.nome}</td>
                <td>${insumo.tipo}</td>
                <td>${insumo.fabricante}</td>
                <td>${insumo.fornecedor.nome}</td>
                <td>${insumo.validade}</td>
                <td>${insumo.precoVenda}</td>
                <td>
                    <button class="action-btn edit" onclick="editarInsumo(${insumo.id})">Editar</button>
                    <button class="action-btn delete" onclick="excluirInsumo(${insumo.id})">Excluir</button>
                </td>
            `;
            tabela.appendChild(tr);
        });
    }

    carregarTabelaInsumos();
});
function abrirFormulario() {
    document.getElementById("menuLateral").classList.add("aberto");
}