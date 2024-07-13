programa
{
	
	funcao inicio()
	{
		//variaveis
		real peso, altura, imc
		cadeia nome, status = ""

		//inicializar variáveis

		escreva("Qual seu nome? \n")
		leia(nome)

		escreva("Qual seu peso, em KG? \n")
		leia(peso)
		
		escreva("Qual sua altura, em M? \n")
		leia(altura)

		//calcular imc
		imc = peso / (altura * altura)

		//retornar resultado
		se(imc <= 16.9){
			status = "Muito abaixo do peso"
		}
		senao se(imc <= 18.4){
			status = "Abaixo do peso"
		}
		senao se(imc <= 24.9){
			status = "Peso normal"
		}
		senao se(imc <= 29.9){
			status = "Acima do peso"
		}
		senao se(imc <= 34.9){
			status = "Obesidade grau I"
		}
		senao se(imc <= 40.0){
			status = "Obesidade grau II"
		}
		senao se(imc > 40.0){
			status = "Obesidade grau III"
		}

		//retorno

		escreva(nome, " seu IMC é: ", imc, " ou seja você está: ", status)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 377; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */