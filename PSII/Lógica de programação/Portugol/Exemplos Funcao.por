programa
{
	
	funcao real media(real n1, real n2, real n3)
	{
		real mf = (n1+n2+n3)/3
		retorne mf
	}
	
	funcao inicio()
	{
		real nota1 = 5.5, nota2 = 8.2, nota3 = 4.5

		escreva(status(media(nota1,nota2,nota3)))
	}

	funcao cadeia status (real mf)
	{
		cadeia stt = ""
		se(mf >= 7.0) stt = "APROVADO"
		senao se(mf < 5.0) stt = "REPROVADO"
		senao stt = "RECUPERAÇÃO"
		retorne stt
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 361; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */