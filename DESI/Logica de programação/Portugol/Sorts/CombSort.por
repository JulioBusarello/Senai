programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro notas[999], tamanho = 10, auxiliar, indice,i, j, gap = 10, aux, resp
		cadeia nome[999]
		real fator = 1.3
		logico trocado = verdadeiro, continuar = verdadeiro

		i = 0
		enquanto(continuar){
			escreva("Nome do ",i+1," aluno: \n")
			leia(nome[i])
			escreva("Continuar? (0, 1)")
			leia(resp)
			i++
			se(resp == 0) continuar = falso
			limpa()
		}
		
		para(i =0; i < tamanho; i++){
			notas[i] = u.sorteia(10,50)
		}

		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto( i + gap < tamanho){
				se(notas[i] < notas[i + gap]){
					auxiliar = notas[i]
					notas[i] = notas[i + gap]
					notas[i + gap] = auxiliar
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		/*escreva("Vetor ordenado: ")
		para(i = 0; i < tamanho; i++){
			escreva(vetor[i] + " ")
		}*/
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 356; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */