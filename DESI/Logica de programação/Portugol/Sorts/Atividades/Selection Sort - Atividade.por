programa
{
	inclua biblioteca Util --> u

	funcao inicio()
	{
		//atividade1()
		//atividade2()
		//atividade3()
		//atividade4()
		//atividade5()
		atividade6()
	}

	// ATIVIDADE 1, 10 NUMEROS, INTEIROS, LER, ORDENADO
	funcao atividade1()
	{
		inteiro vetor[10], tam = 10, aux, index, valor

		/*para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
		}*/
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}
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
	}


	// ATIVIDADE 2, 8 NUMEROS, REAL, LER, DECRESCENTE
	funcao atividade2()
	{
		inteiro tam = 8, index
		real vetor[8], valor, aux

		/*para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
		}*/
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}

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
		escreva("Vetor decrescente: ")
		para(inteiro i = tam-1; i > 0; i--){
			escreva(vetor[i], " ")
		}
	}

	// ATIVIDADE 3, 12 NUMEROS, INTEIROS, LER, MENOR VALOR E MAIOR VALOR
	funcao atividade3()
	{
		inteiro vetor[12], tam = 12, aux, index, valor

		/*para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
		}*/
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}
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
		
		escreva("Menor valor: ")
		escreva(vetor[0])
		escreva("\n")
		
		escreva("Maior valor: ")
		escreva(vetor[tam-1])
		escreva("\n")
	}

	// ATIVIDADE 4, Pares e impares, 15 numeros inteiros
	funcao atividade4()
	{
		inteiro vetor[15], tam = 15, aux, index, valor, pares[15], impares[15]

		/*para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
		}*/
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}
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


	// ATIVIDADE 5
	funcao atividade5()
	{
		real vetor[9], aux, media = 0.0
		inteiro tam = 9, index

		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10,100)
		}
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

		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i < tam; i++){
			escreva(vetor[i]," ")
		}

		para(inteiro i =0; i < tam; i++){
			media += (vetor[i])
		}
		media = media / tam

		escreva("\nA média do vetor é: ", media)
	}


	// ATIVIDADE 6
	funcao atividade6()
	{
		inteiro vetor[10], vetorInvertido[10], tam = 10, aux, index, valor

		/*para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
		}*/
		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 100)
		}
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
 * @POSICAO-CURSOR = 4329; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetorInvertido, 219, 21, 14}-{vetor, 219, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */