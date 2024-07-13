function calcularMedia() {
    var num1 = parseFloat(document.getElementById("numero1").value);
    var num2 = parseFloat(document.getElementById("numero2").value);
    //var num3 = parseFloat(document.getElementById("numero3").value);
    var aluno = document.getElementById("aluno").value;
    
    var media = (num1 + num2) / 2;

    var status = "";

    if(media >= 7){
      status = "aprovado"
    }else if(media > 5){
      status = "em recuperação"
    }else{
      status = "reprovado"
    }

    alert("A média é: "+media.toFixed(2)+" e "+aluno+" está "+status);
    console.log(aluno)
    console.log(media);
    console.log(status);
  }