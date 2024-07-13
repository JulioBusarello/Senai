programa
{
	inteiro ver = 0
	funcao inicio()
	{
		inteiro numeros = 10, numeroD, vezes

		faca{
			escreva("Qual o numero? ")
			leia(numeroD)
			contar(numeroD)
			numeros--
		}enquanto(numeros > 0)
		limpa()
		escreva(contar(numeroD),"/10 foram digitados acima de 5\n")
	}
	funcao inteiro contar(inteiro n1)
	{
		se(n1 > 5) ver += 1
		retorne ver
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 242; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {n1, 17, 31, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */