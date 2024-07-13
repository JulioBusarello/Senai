programa
{
	
	funcao inicio()
	{
		cadeia nome_status[5][2]
		real notas[5][4]

		para(inteiro i = 0; i < 2; i++){
			escreva("Nome do aluno ",i+1," :")
			leia(nome_status[i][0])
			para(inteiro a =0; a < 3; a++){
				escreva("Qual a nota ", a+1," :")
				leia(notas[i][a])
			}
			limpa()

			notas[i][3] = ( notas[i][0] + notas[i][1] + notas [i][2] ) / 3

			se(notas[i][3] >= 7.0) nome_status[i][1] = "Aprovado"
			senao se(notas[i][3] < 5) nome_status[i][1] = "Reprovado"
			senao nome_status[i][1] = "Em recuperação"
		}
		escreva("=== Status do aluno ===")
		para(inteiro i = 0; i < 2; i++){
			escreva("\nAluno: ", nome_status[i][0], " o aluno está: ", nome_status[i][1])
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 623; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nome_status, 6, 9, 11}-{notas, 7, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */