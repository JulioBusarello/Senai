programa
{
	inclua biblioteca Util --> u
	
	const inteiro tamanhoV = 8

	// APLICAR O ALGORITMO NO ALGORITMO 80 50 10 30 550 111 112 231

	funcao merge(inteiro vetor[], inteiro inicio, inteiro fim){
		inteiro meio, i, j, k, auxiliar[tamanhoV]

		se(inicio < fim){
			meio = (inicio + fim) / 2
			merge(vetor, inicio, meio)
			merge( vetor, meio+1, fim)
			i = inicio
			j = meio+1
			k = inicio
			enquanto(i <= meio e j <= fim){
				se(vetor[i] < vetor[j]){
					auxiliar[k] = vetor[i]
					i++
				}
				senao{
					auxiliar[k] = vetor[j]
					j++
				}
				k++
			}
			enquanto(i <= meio){
				auxiliar[k] = vetor[i]
				i++
				k++
			}
			enquanto(j <= fim){
				auxiliar[k] = vetor[j]
				j++
				k++
			}
			para(i = inicio; i <= fim; i++){
				vetor[i] = auxiliar[i]
			}
		}
	}
	
	funcao inicio()
	{
		inteiro vetor[] = {80,50,10,30,550,111,112,231}
		inteiro tamanho = tamanhoV, i

		escreva("Vetor Original: ")
		para(i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		//ordenação
		merge(vetor, 0, tamanhoV-1)

		escreva("Vetor Ordenado: ")
			para(i = 0; i < tamanho; i++){
				escreva(vetor[i], " ")
			}
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 70; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */