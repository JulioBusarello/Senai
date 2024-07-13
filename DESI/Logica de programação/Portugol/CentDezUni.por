programa
{
	
	funcao inicio()
	{
		inteiro n, m, u, c, d, nNumeros
		cadeia numero

		escreva("Qual o numero ")
		leia(n)

		u = n % 10
		c = n / 100
		d = n / 10 % 10

		se(c >= 1 e c < 10){
			m = u * 100 + d * 10 + c
			escreva(m)
		}
		senao{
			escreva("O código não aceita este número")
			escreva("\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 322; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */