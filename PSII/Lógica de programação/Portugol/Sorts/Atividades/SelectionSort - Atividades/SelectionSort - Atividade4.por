programa
{
	inclua biblioteca Util --> u

	// ATIVIDADE 4, 15 NUMEROS INTEIROS, PARES E IMPARES SEPARADOS
	funcao inicio()
	{
		inteiro vetor[15], tam = 15, aux, index, pares[15], impares[15]

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
		
		inteiro par = 0, impar = 0
		
		para(inteiro i = 0; i < tam; i++){
			se(vetor[i] % 2 == 0){
				pares[par] = vetor[i]
				par++
			}senao{
				impares[impar] = vetor[i]
				impar++
			}
		}

		escreva("Números pares: ")
		para(inteiro i = 0; i < par; i++){
			escreva(pares[i]," ")
		}

		escreva("\nNúmeros impares: ")
		para(inteiro i = 0; i < impar; i++){
			escreva(impares[i]," ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 287; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */