programa
{
	inclua biblioteca Util
	funcao inicio()
	{
		//vetor1()
		vetor2()
	}
	funcao vetor1()
	{
		inteiro vetor[9] = {1,5,6,9,7,10,598,218,55} , tamanho = 9, j, indice, auxiliar

		escreva("Vetor original: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(j=1; j<=tamanho; j++){
			para(inteiro i=0; i<tamanho-1; i++){
				se(vetor[i] > vetor[i+1]){
					auxiliar=vetor[i]
					vetor[i]=vetor[i+1]
					vetor[i+1]=auxiliar
				}
			}
		}
		escreva("Vetor crescente: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i]," ")
		}
		escreva("\n")
		
		para(j=1; j<=tamanho; j++){
			para(inteiro i=0; i<tamanho-1; i++){
				se(vetor[i] < vetor[i+1]){
					auxiliar=vetor[i]
					vetor[i]=vetor[i+1]
					vetor[i+1]=auxiliar
				}
			}
		}
		escreva("Vetor decrescente: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i]," ")
		}
	}
	funcao vetor2()
	{
		inteiro vetor[8] = {58,15,2,0,1,8,30,100} , tamanho = 8, j, indice, auxiliar

		escreva("Vetor original: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i], " ")
		}
		escreva("\n")

		para(j=1; j<=tamanho; j++){
			para(inteiro i=0; i<tamanho-1; i++){
				se(vetor[i] > vetor[i+1]){
					auxiliar=vetor[i]
					vetor[i]=vetor[i+1]
					vetor[i+1]=auxiliar
				}
			}
		}
		escreva("Vetor crescente: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i]," ")
		}
		escreva("\n")
		
		para(j=1; j<=tamanho; j++){
			para(inteiro i=0; i<tamanho-1; i++){
				se(vetor[i] < vetor[i+1]){
					auxiliar=vetor[i]
					vetor[i]=vetor[i+1]
					vetor[i+1]=auxiliar
				}
			}
		}
		escreva("Vetor decrescente: ")
		para(inteiro i=0; i<tamanho; i++){
			escreva(vetor[i]," ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 59; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */