function preencherModalEdit(id) {
    fetch(`/atividades/editar/${id}`)
        .then(response => response.json())
        .then(data => {

            document.getElementById("atividadeId").value = data.id;
            document.getElementById("nome").value = data.nome;
            document.getElementById("localizacao").value = data.localizacao;
            document.getElementById("tipo").value = data.tipo;
            document.getElementById("descricao").value = data.descricao;
            document.getElementById("professor").value = data.professor.id;

            document.querySelectorAll("input[name='alunoIds']").forEach(input => {
                input.checked = false;
            });

            data.alunoAtividade.forEach(alunoAtividade => {
                var alunoId = alunoAtividade.alunoId;

                var alunoCheckbox = document.querySelector(`input[name='alunoIds'][value='${alunoId}']`);

                if (alunoCheckbox) alunoCheckbox.checked = true;
            });

            document.getElementById("atividadeModalLabel").innerText = "Editar Atividade - " + data.id;

            new bootstrap.Modal(document.getElementById("atividadeModal")).show();
        })
}


function limparModalAtividade() {
    document.getElementById("nome").value = '';
    document.getElementById("localizacao").value = '';
    document.getElementById("tipo").value = '';
    document.getElementById("descricao").value = '';
    document.getElementById("professor").value = '';

    document.querySelectorAll("input[name='alunoIds']").forEach(input => {
        input.checked = false;
    });

    document.getElementById("atividadeModalLabel").innerText = "Adicionar Atividade";
}