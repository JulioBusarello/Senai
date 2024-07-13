programa
{
	inclua biblioteca Util --> u

	funcao inicio()
	{
		atividade1()
		//atividade2()
		//atividade3()
	}

	// ATIVIDADE 1, 10 NUMEROS, INTEIROS, LER, ORDENADO
	funcao atividade1()
	{
		inteiro vetor[10], tam = 10, aux, index, valor

		para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
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

		para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
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

		para(inteiro i = 0; i < tam; i++){
			escreva("Qual o ",i+1,"º número: \n")
			leia(valor)
			vetor[i] = valor
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
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 64; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */