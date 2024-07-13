programa
{
	
	funcao inicio()
	{
		inteiro codigo, digitoV, a,b,c,d,ee , s

		escreva("Escreva o código\n")
		leia(codigo)

		a = codigo / 10000
		b = codigo / 1000 % 10
		c = codigo / 100 % 10
		d = codigo / 10 % 10
		ee = codigo % 10

		s = 6 * a + 5 * b + 4 * c + 3 * d + 2 * ee

		digitoV = s % 7

		escreva("Digito verificador: ", digitoV)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 348; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */