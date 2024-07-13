programa
{
	inclua biblioteca Matematica --> m
	
	cadeia nome_status[100][2]
	real notas[100][4]
	inteiro recno = 0 , op = 1
	
	funcao inicio()
	{
		enquanto(op == 1){
			limpa()
			escreva("========== Cálculo Média Final ==========\n")

			escreva("Entre com o nome do aluno ", recno+1,":\n")
			leia(nome_status[recno][0])
			para(inteiro n = 0; n < 3; n++){
				escreva("Entre com a nota", n+1, ": ")
				leia(notas[recno][n])
				escreva("\n")
			}
			escreva("Deseja continuar? (1-Sim/2-Não)\n")
			leia(op)
			recno++
		}
		escreva("Deseja processar as notas e imprimir a tabela? (1-Sim/2-Não)\n")
		leia(op)

		se(op == 1){
			escreva("============== Status dos alunos =============\n")
			escreva("Aluno\tNota 1\tNota 2\tNota 3\tMédia \tStatus\n")
			escreva("==============================================")
			para(inteiro index = 0; index < recno; index++){
				notas[index][3] = (notas[index][0] + notas[index][1] + notas[index][2]) / 3
				
				se(notas[index][3] >= 7.0) nome_status[index][1] = "Aprovado"
				senao se(notas[index][3] < 5) nome_status[index][1] = "Reprovado"
				senao nome_status[index][1] = "Recuperação"
			}
			para(inteiro i = 0; i < recno; i++){
				escreva("\n",nome_status[i][0], "\t ", notas[i][0], "\t ", notas[i][1], "\t ", notas[i][2], "\t ", m.arredondar(notas[i][3],1), "\t", nome_status[i][1])
			}
		}
		senao{
			escreva("\nO programa será finalizado\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1316; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */