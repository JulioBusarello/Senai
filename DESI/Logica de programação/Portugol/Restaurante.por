programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		real valorF = 0.0, valor
		logico verificacao = falso
		caracter v = ' '

		faca{
			escreva("Qual o valor do item consumido? ")
			leia(valor)

			valorF += valor
			
			escreva("Algo mais?(s/n) ")
			leia(v)

			se(v == 'n') verificacao = verdadeiro
			
		}enquanto(verificacao == falso)

		valorF += valorF * 0.10

		escreva("o valor final da conta é de R$", m.arredondar(valorF, 2))
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 185; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */