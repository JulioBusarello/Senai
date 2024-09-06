function exibirSelecionados(){
    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked')
    var checkValues = [];
    checkboxes.forEach((checkbox) =>  {
        checkValues.push(checkbox.value);
    });

    // Coletando a seleção de radio button
    var radioButtons = document.querySelectorAll('input[name="experience"]:checked');
    var radioValue = radioButtons ? radioButtons[0].value : "Nenhum";

    // Coletando a seleção do select (combo box)
    var selectValue = document.getElementById("country").value || "Nenhum";

    var output = document.getElementById("output");
    output.innerHTML = "<strong>Navegadores Selecionados:</strong>" + (checkValues.length > 0 ? checkValues.join(", ") : "Nenhuma") + "<br><strong> Nível de Experiência:</strong> " + radioValue + "<br><strong>País Selecionado: </strong> " + selectValue;
}