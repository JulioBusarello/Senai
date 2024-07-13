programa
{
	inclua biblioteca Util --> u

	// ATIVIDADE 3, 12 NUMEROS INTEIROS, MENOR E MAIOR ELEMENTO
	funcao inicio()
	{
		inteiro vetor[12], tam = 12, aux, index

		para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(vetor[i])
		}
		/*para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}*/
		limpa()

		para(inteiro i = 0; i < tam; i++){
			index = i
			para(inteiro j = i+1; j < tam; j++){
				se(vetor[j] < vetor[index]){
					index = j
				}
			}
			aux = vetor[i]
			vetor[i] = vetor[index]
			vetor[index] = aux
		}
		
		escreva("Menor valor: ", vetor[0], "\n")
		
		escreva("Maior valor: ", vetor[tam-1], "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 102; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */