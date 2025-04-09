async function buscarPacientes() {
    const tipo = document.getElementById("tipoBusca").value;
    const valor = document.getElementById("valorBusca").value.trim();
    const tabela = document.getElementById("tabelaPacientes");
    tabela.innerHTML = ""; 

    let url = "http://localhost:8080/clientes";

    if (tipo && valor) {
        switch (tipo) {
            case "id":
                url += `/clientes/${valor}`;
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
            tabela.innerHTML = "<tr><td colspan='5'>Nenhum paciente encontrado.</td></tr>";
            return;
        }

        const data = await response.json();
        const pacientes = Array.isArray(data) ? data : [data];

        pacientes.forEach(p => {
            const idade = calcularIdade(p.dtNascimento);
            tabela.innerHTML += `
                <tr>
                    <td>${p.nome}</td>
                    <td>${idade} anos</td>
                    <td>${p.telefone}</td>
                    <td>${p.email || "-"}</td>
                    <td>
                        <button onclick="editarPaciente(${p.id})">Editar</button>
                        <button onclick="excluirPaciente(${p.id})">Excluir</button>
                    </td>
                </tr>
            `;
        });
    } catch (error) {
        console.error("Erro ao buscar pacientes:", error);
        tabela.innerHTML = "<tr><td colspan='5'>Erro ao buscar pacientes.</td></tr>";
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

function editarPaciente(id) {
    alert("Função de editar ainda não implementada para ID " + id);
}

function excluirPaciente(id) {
    if (confirm("Deseja realmente excluir este paciente?")) {
        fetch(`http://localhost:8080/clientes/${id}`, {
            method: "DELETE"
        })
        .then(res => {
            if (res.ok) {
                alert("Paciente excluído com sucesso!");
                buscarPacientes();
            } else {
                alert("Erro ao excluir paciente.");
            }
        })
        .catch(err => console.error(err));
    }
}

// Carrega todos os pacientes ao abrir a página
window.onload = buscarPacientes;

function abrirCadastro() {
    document.getElementById("cadastroOffcanvas").classList.add("open");
}

function fecharCadastro() {
    document.getElementById("cadastroOffcanvas").classList.remove("open");
}

document.getElementById("formCadastro").addEventListener("submit", async function(e) {
    e.preventDefault();
    const form = e.target;

    const paciente = {
        nome: form.nome.value,
        dtNascimento: form.nascimento.value,
        documento: form.documento.value, // Corrigido aqui
        telefone: form.telefone.value,
        email: form.email.value,
        pessoaTipo: form.tipoPessoa.value, // Corrigido para o select
        sexo: form.sexo.value,
        observacoes: form.observacoes ? form.observacoes.value : null, // opcional
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
        const response = await fetch("http://localhost:8080/clientes", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(paciente)
        });

        if (response.ok) {
            alert("Paciente cadastrado com sucesso!");
            fecharCadastro();
            buscarPacientes();
            form.reset();
        } else {
            const erro = await response.text();
            alert("Erro ao cadastrar paciente: " + erro);
        }
    } catch (error) {
        console.error("Erro:", error);
        alert("Erro ao enviar os dados.");
    }
});



