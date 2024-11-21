$(document).ready(function () {
    $('#cpf').mask('000.000.000-00');
    $('#telefone').mask('(00) 0 0000-0000');
});

function preencherModalEdit(id) {
    fetch(`/alunos/editar/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("alunoForm").action = `/alunos/atualizar/${data.id}`;

            document.getElementById("nome").value = data.nome;
            document.getElementById("dataNascimento").value = data.dataNascimento;
            document.getElementById("cpf").value = data.cpf;
            document.getElementById("telefone").value = data.telefone;

            document.getElementById("alunoModalLabel").innerText = "Editar Aluno - " + data.id;

            new bootstrap.Modal(document.getElementById("alunoModal")).show();
        })
        .catch(error => console.error('Erro ao preencher o modal:', error));
}

function limparModalAluno() {
    document.getElementById("nome").value = '';
    document.getElementById("dataNascimento").value = '';
    document.getElementById("cpf").value = '';
    document.getElementById("telefone").value = '';

    document.getElementById("alunoModalLabel").innerText = "Adicionar Aluno";
}