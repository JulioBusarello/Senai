programa
{
	inclua biblioteca Util --> u
	
	inteiro vetor2[50], t = 50, elementoAtual, indice
	
	funcao inicio()
	{
		//atividade2()
		//atividade3()
		atividade4()
	}

	funcao atividade2()
	{
		inteiro vetor[8], tamanho = 8

		para(inteiro i = 0; i < tamanho; i++){
			escreva("Qual o valor do ",i+1,"º vetor? ")
			leia(vetor[i])
		}
		limpa()
		
		escreva("Vetor original: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(inteiro i = 1; i < tamanho; i++){
			elementoAtual = vetor[i]
			indice = i 
			enquanto( indice > 0 e vetor[indice-1] > elementoAtual){
				vetor[indice] = vetor[indice-1]
				indice--
			}
			vetor[indice] = elementoAtual
		}
		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
	}


	
	funcao atividade3()
	{
		inteiro vetor[5], tamanho = 5

		para(inteiro i = 0; i < tamanho; i++){
			escreva("Qual o valor do ",i+1,"º vetor? ")
			leia(vetor[i])
		}
		limpa()
		
		escreva("Vetor original: ")
		para(inteiro i = 0; i < tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(inteiro i = 1; i < tamanho; i++){
			elementoAtual = vetor[i]
			indice = i 
			enquanto( indice > 0 e vetor[indice-1] > elementoAtual){
				vetor[indice] = vetor[indice-1]
				indice--
			}
			vetor[indice] = elementoAtual
		}
		escreva("Vetor decrescente: ")
		para(inteiro i = 4; i >= 0; i--){
			escreva(vetor[i], " ")
		}
	}


	
	funcao atividade4()
	{
		para(inteiro i = 0; i < t; i++){
			vetor2[i] = u.sorteia(1, 200)
		}
		
		escreva("Vetor original: ")
		para(inteiro i = 0; i < t; i++){
			escreva(vetor2[i], " ")
		}
		escreva("\n")
		insertion(vetor2)
	}
	
	funcao insertion(inteiro vet[])
	{
		para(inteiro i = 1; i < t; i++){
			elementoAtual = vet[i]
			indice = i 
			enquanto( indice > 0 e vet[indice-1] > elementoAtual){
				vet[indice] = vet[indice-1]
				indice--
			}
			vet[indice] = elementoAtual
		}
		
		escreva("Vetor crescente: ")
		para(inteiro i = 0; i < t; i++){
			escreva(vet[i], " ")
		}
		escreva("\n")
		
		escreva("Vetor decrescente: ")
		para(inteiro i = 49; i >= 0; i--){
			escreva(vet[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1472; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */