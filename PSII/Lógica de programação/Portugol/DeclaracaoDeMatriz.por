programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		cadeia aluno[5], status
		real notas[5][4]

		para(inteiro i = 0; i < 2; i++){
			escreva("\nQual o nome do aluno? ")
			leia(aluno[i])
			para(inteiro a = 0; a < 3; a++){
				escreva("Qual a ",(a+1),"º nota do aluno? ")
				leia(notas[i][a])
			}
		}
		limpa()
		escreva("Alunos\t\t| Med.Final\t | Status\n")
		escreva("----------------------------------------------\n")
		para(inteiro i = 0; i <2; i++){
			notas[i][3] = (notas[i][0]+notas[i][1]+notas[i][2])/3
			se(notas[i][3] >= 7) status = "Aprovado"
			senao se(notas[i][3] < 5) status = "Reprovado"
			senao status = "Em Recuperação"
			escreva("Aluno: ", aluno[i] , " \t| ", m.arredondar(notas[i][3],2)," \t\t | ", status ,"\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 631; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {notas, 8, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */