programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro vetor[15], tamanho = 15, indice, auxiliar
		
		para(inteiro i = 0; i<tamanho; i++){
			vetor[i] = u.sorteia(10,50)
		}

		escreva("Vetor original: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(inteiro j = 0; j <= tamanho; j++){
			para(inteiro i = 0; i < tamanho-1; i++){
				se(vetor[i] > vetor[i+1]){
					auxiliar = vetor[i]
					vetor[i] = vetor[i+1]
					vetor[i+1] = auxiliar
				}
			}
		}
		
		escreva("Vetor crescente: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i]," ")
		}
		
		escreva("\nVetor decrescente: ")
		para(inteiro i = tamanho-1; i >= 0; i--){
			escreva(vetor[i]," ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 520; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5}-{tamanho, 7, 21, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */