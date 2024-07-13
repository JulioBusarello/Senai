programa
{
	
	funcao inicio()
	{
		inteiro matricula, ano, s, d

		escreva("Escreva a matricula do aluno em formato AASDDD\n")
		leia(matricula)

		ano = matricula / 10000
		s = matricula / 1000 % 10
		d = matricula % 1000

		escreva("Ano: ", ano, " Semestre: ", s," ", d)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 274; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {ano, 6, 21, 3}-{s, 6, 26, 1}-{d, 6, 29, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */