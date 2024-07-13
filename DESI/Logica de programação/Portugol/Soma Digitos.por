programa
{
	
	funcao inicio()
	{
		inteiro valor, a, b, c, d, f

		escreva("Digite um valor com 4 digitos\n")
		leia(valor)

		a = valor / 1000
		b = valor / 100 % 10
		c = valor / 10 % 10
		d = valor % 10

		f = a + b + c + d

		escreva("A soma é: ", f)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 258; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {a, 6, 17, 1}-{b, 6, 20, 1}-{c, 6, 23, 1}-{d, 6, 26, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */