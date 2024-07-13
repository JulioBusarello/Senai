programa
{
	inclua biblioteca Texto --> t
	inclua biblioteca Matematica --> m
	cadeia nome_status[999][2]
	real notas[999][4]
	inteiro numero = 0
	
	funcao inicio()
	{
		//forma1()
		forma2()
	}
	funcao forma1()
	{
		escreva("Numero de alunos: ")
		leia(numero)
		limpa()
		para(inteiro i = 0; i < numero; i++){
			escreva("Nome do aluno ",i+1,": ")
			leia(nome_status[i][0])
			para(inteiro a =0; a < 3; a++){
				escreva("Qual a nota ", a+1,": ")
				leia(notas[i][a])
			}
			limpa()
			
			notas[i][3] = (notas[i][0] + notas[i][1] + notas [i][2] ) / 3
			
			se(notas[i][3] >= 7.0) nome_status[i][1] = "Aprovado"
			senao se(notas[i][3] < 5) nome_status[i][1] = "Reprovado"
			senao nome_status[i][1] = "Em recuperação"
		}
		escreva("========== Status dos alunos ==========\n")
		escreva("Aluno\tNota 1\tNota 2\tNota 3\tMédia \n")
		escreva("=======================================")
		para(inteiro i = 0; i < numero; i++){
			escreva("\n",nome_status[i][0], "\t ", notas[i][0], "\t ", notas[i][1], "\t ", notas[i][2], "\t ", m.arredondar(notas[i][3],2))
			//escreva("\nAluno: ", nome_status[i][0], " o aluno está: ", nome_status[i][1], " com média final: ", m.arredondar(notas[i][3], 2))
		}
		escreva("\n")
	}
	funcao forma2()
	{
		logico continuar = verdadeiro
		cadeia resposta = ""
		inteiro index = 0
		enquanto(continuar == verdadeiro){
			limpa()
			escreva("Nome do aluno ", index+1 ,": ")
			leia(nome_status[index][0])
			para(inteiro a =0; a < 3; a++){
				escreva("Qual a nota ", a+1,": ")
				leia(notas[index][a])
			}
			notas[index][3] = (notas[index][0] + notas[index][1] + notas[index][2]) / 3

			se(notas[index][3] >= 7.0) nome_status[index][1] = "Aprovado"
			senao se(notas[index][3] < 5) nome_status[index][1] = "Reprovado"
			senao nome_status[index][1] = "Recuperação"
			
			escreva("Continuar? (s/n) ")
			leia(resposta)
			resposta = t.caixa_alta(resposta)
			se(resposta == "N"){
				continuar = falso
			}
			index++
		}
		limpa()
		escreva("============== Status dos alunos ==============\n")
		escreva("Aluno\tNota 1\tNota 2\tNota 3\tMédia \tStatus \n")
		escreva("===============================================")
		para(inteiro i = 0; i < index; i++){
			escreva("\n",nome_status[i][0], "\t ", notas[i][0], "\t ", notas[i][1], "\t ", notas[i][2], "\t ", m.arredondar(notas[i][3],1), "\t", nome_status[i][1])
		}
		escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2372; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */