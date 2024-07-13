programa
{
	
	funcao inicio()
	{
		// banner de apresentação
		escreva("==========================\n")
		escreva("= CÁLCULO DA MÉDIA FINAL =\n")
		escreva("==========================\n")

		// variáveis
		real nota1=0.0, nota2=0.0, nota3=0.0, mf=0.0
		cadeia status = ""

		// pedindo as notas
		escreva("Entre a 1º nota:\n")
		leia(nota1)
		escreva("Entre a 2º nota:\n")
		leia(nota2)
		escreva("Entre a 3º nota:\n")
		leia(nota3)

		// cálculo da media final
		mf = (nota1+nota2+nota3)/3

		// status do aluno
		se(mf >= 7.0){
			status = "APROVADO"
		}
		senao se(mf < 5.0){
			status = "REPROVADO"
		}
		senao{
			status = "em RECUPERAÇÃO"
		}

		// retorno
		escreva("O aluno está ", status, " com média final em ", mf)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 460; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */