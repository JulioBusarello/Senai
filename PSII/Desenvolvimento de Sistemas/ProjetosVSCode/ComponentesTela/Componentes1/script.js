function adicionarTexto() {
    var inputText = document.getElementById("inputText").value;
    var textarea = document.getElementById("textarea");

    if(inputText.trim() !== "") {
        textarea.value += inputText + "\n";
        document.getElementById("inputText").value = "";
    }else{
        alert("Por favor, digite algo na caixa de texto.");
    }
}