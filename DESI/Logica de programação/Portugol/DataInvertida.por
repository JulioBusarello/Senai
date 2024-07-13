programa
{
	
	funcao inicio()
	{
		inteiro data, dia, ano, mes

		escreva("Escreva a data em formato DDMMAA\n")
		leia(data)

		ano = data % 100
		dia = data / 10000
		mes = data / 100 % 100

		escreva(ano, "/", mes, "/", dia)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 230; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {dia, 6, 16, 3}-{ano, 6, 21, 3}-{mes, 6, 26, 3};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */