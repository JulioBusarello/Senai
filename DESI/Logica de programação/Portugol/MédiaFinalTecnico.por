programa
{
	
	funcao inicio()
	{
		nota()
	}
	funcao nota()
	{
		// Banner
		escreva("=========================\n")
		escreva("=  Cálculo Média Final  =\n")
		escreva("=========================\n")
		
		// Definindo variáveis
		real n1, n2, n3, mf
		cadeia status = ""
		
		// Pedindo notas
		escreva("Qual a 1ª nota do aluno? ")
		leia(n1)
		escreva("Qual a 2ª nota do aluno? ")
		leia(n2)
		escreva("Qual a 3ª nota do aluno? ")
		leia(n3)
		
		// Calculando média final
		mf = (n1+n2+n3)/3
		
		// Verificando notas
		se(mf >= 7){
			status = "APROVADO"
		}
		senao se(mf < 5){
			status = "REPROVADO"
		}
		senao{
			status = "EM RECUPERAÇÃO"
		}

		// Retorna média e status
		escreva("O aluno está ", status, " com média final de ", mf)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 329; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */