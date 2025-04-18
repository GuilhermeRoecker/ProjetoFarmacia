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

document.addEventListener("DOMContentLoaded", () => {
    carregarMedicos();

    document.querySelector("form").addEventListener("submit", async (e) => {
        e.preventDefault();
        await cadastrarMedico();
    });
});

async function carregarMedicos() {
    try {
        const response = await fetch('http://localhost:8080/usuarios'); // <- Aqui já estava certo
        if (!response.ok) throw new Error("Erro ao buscar médicos.");

        const medicos = await response.json();
        const tabela = document.getElementById("tabela-medicos");
        tabela.innerHTML = "";

        medicos.forEach(medico => {
            const tr = document.createElement("tr");

            tr.innerHTML = `
                <td>${medico.nome}</td>
                <td>${medico.role}</td>
                <td>
                    <button onclick="editarMedico(${medico.id})">Editar</button>
                    <button onclick="excluirMedico(${medico.id})">Excluir</button>
                </td>
            `;
            tabela.appendChild(tr);
        });

    } catch (error) {
        console.error("Erro ao carregar médicos:", error);
    }
}

async function cadastrarMedico() {
    const medico = {
        nome: document.getElementById("nome").value,
        dtNascimento: document.getElementById("dtNascimento").value,
        documento: document.getElementById("documento").value,
        telefone: document.getElementById("telefone").value,
        email: document.getElementById("email").value,
        crm: document.getElementById("crm").value,
        especialidade: document.getElementById("especialidade").value,
        username: document.getElementById("username").value,
        senha: document.getElementById("senha").value,
        role: document.getElementById("cargo").value
    };

    try {
        const response = await fetch('http://localhost:8080/usuarios', { // <- Corrigido aqui
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(medico)
        });

        console.log("Status da resposta:", response.status);
        if (!response.ok) {
            const erroTexto = await response.text();
            console.error("Detalhes do erro:", erroTexto);
            throw new Error("Erro ao cadastrar médico.");
        }

        fecharMenuLateral();
        await carregarMedicos();
    } catch (error) {
        console.error("Erro ao cadastrar médico:", error);
    }
}

async function excluirMedico(id) {
    if (!confirm("Tem certeza que deseja excluir este médico?")) return;

    try {
        const response = await fetch(`http://localhost:8080/usuarios/${id}`, { // <- Corrigido aqui também
            method: "DELETE"
        });

        if (!response.ok) throw new Error("Erro ao excluir médico.");

        await carregarMedicos();
    } catch (error) {
        console.error("Erro ao excluir médico:", error);
    }
}

function editarMedico(id) {
    // Pode-se preencher os campos com os dados do médico para edição futura
    alert("Funcionalidade de edição ainda não implementada.");
}

function abrirMenuLateral() {
    document.getElementById("menuLateral").classList.add("aberto");
}

function fecharMenuLateral() {
    document.getElementById("menuLateral").classList.remove("aberto");
}
