programa
{
	inclua biblioteca Util --> u

	// ATIVIDADE 6, 10 VALORES INTEIROS, CRESCENTE, DECRESCENTE USANDO VETOR
	funcao inicio()
	{
		inteiro vetor[10], vetorInvertido[10], tam = 10, aux, index

		para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(vetor[i])
		}
		/*para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}*/
		limpa()
		
		escreva("Vetor original: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i]," ")
		}
		escreva("\n")

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
		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i< tam; i++){
			escreva(vetor[i], " ")
		}

		inteiro auxiliar = 0
		para(inteiro i = tam-1; i >= 0; i--){
			vetorInvertido[auxiliar] = vetor[i]
			auxiliar++
		}

		escreva("\nVetor decrescente: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetorInvertido[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 293; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */