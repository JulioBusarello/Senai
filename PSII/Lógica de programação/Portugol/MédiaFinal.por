programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		// Definição de variáveis
		real nota[999], mf = 0.0
		cadeia status
		inteiro nNotas
		
		// Número de notas
		escreva("Quantas notas? ")
		leia(nNotas)

		// Pedindo notas
		para(inteiro i = 0; i<nNotas; i++){
			escreva("Qual a ",i+1,"ª nota? ")
			leia(nota[i])
		}
		
		// Calcular média final
		para(inteiro i = 0; i< nNotas; i++){
			mf = nota[i] + mf
		}
		mf = mf/nNotas

		// Retornar resultado
		se(mf >= 7.0){
			status = "APROVADO"
		}
		senao se(mf < 5.0){
				status = "REPROVADO"
		}
		senao{
			status = "EM RECUPERAÇÃO"
		}

		// Retorno
		escreva("O aluno está ", status, " com média final de ", m.arredondar(mf,2))
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 611; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */