programa
{
	
	funcao inicio()
	{
		atividade1()
	}
	
	funcao atividade1()
	{
		inteiro n1, n2, n3, maior

		escreva("==========================\n")
		escreva("= Maior valor entre três =\n")
		escreva("==========================\n")
		
		escreva("Qual o 1º número? ")
		leia(n1)
		escreva("Qual o 2º número? ")
		leia(n2)
		escreva("Qual o 3º número? ")
		leia(n3)

		se(n1 > n2 e n1 > n3){
			maior = n1
		} senao se(n2 > n1 e n2 > n3){
			maior = n2
		} senao maior = n3

		escreva("\n",maior," é o maior número\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 436; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */