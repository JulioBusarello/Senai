$(document).ready(function () {
    $('#cpf').mask('000.000.000-00');
});

function preencherModalEdit(id) {
    fetch(`/professores/editar/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("professorForm").action = `/professores/atualizar/${data.id}`;

            document.getElementById("nome").value = data.nome;
            document.getElementById("dataNascimento").value = data.dataNascimento;
            document.getElementById("cpf").value = data.cpf;
            document.getElementById("salario").value = data.salario;

            document.getElementById("professorModalLabel").innerText = "Editar Professor - " + data.id;

            new bootstrap.Modal(document.getElementById("professorModal")).show();
        })
        .catch(error => console.error('Erro ao preencher o modal:', error));
}

function limparModalProfessor() {
    document.getElementById("nome").value = '';
    document.getElementById("dataNascimento").value = '';
    document.getElementById("cpf").value = '';
    document.getElementById("salario").value = '';

    document.getElementById("professorModalLabel").innerText = "Adicionar Professor";
}