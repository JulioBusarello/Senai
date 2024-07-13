programa
{
	
	funcao inicio()
	{
		inteiro numero1,numero2,numero3,numero4,numero5, media2
		
		escreva("Qual o numero? ")
		leia(numero1)
		escreva("Qual o numero? ")
		leia(numero2)
		escreva("Qual o numero? ")
		leia(numero3)
		escreva("Qual o numero? ")
		leia(numero4)
		escreva("Qual o numero? ")
		leia(numero5)
		media2 = media(numero1, numero2, numero3, numero4, numero5)
		limpa()
		escreva("Media é: ", media2)
	}

	funcao inteiro media(inteiro n1, inteiro n2, inteiro n3, inteiro n4, inteiro n5)
	{
		inteiro media = 0
		media = (n1+n2+n3+n4+n5) / 5
		retorne media
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 424; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */