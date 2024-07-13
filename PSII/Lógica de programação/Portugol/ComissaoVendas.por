programa
{
	
	funcao inicio()
	{
		real vendas, salarioBase = 1800.0, salarioFinal

		/*escreva("Qual o salário base? ")
		leia(salarioBase)*/
		escreva("Qual o valor de vendas? ")
		leia(vendas)

		se(vendas >= 20000 e vendas < 35000){
			salarioFinal = salarioBase + (vendas * 0.012)
		}senao se(vendas < 50000 ){
			salarioFinal = salarioBase + (vendas * 0.015)
		}senao se(vendas < 80000 ){
			salarioFinal = salarioBase + (vendas * 0.018)
		}senao se(vendas >= 80000){
			salarioFinal = salarioBase + (vendas * 0.025)
		}senao{
			salarioFinal = salarioBase
		}
		escreva("O salário final é R$", salarioFinal)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 73; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */