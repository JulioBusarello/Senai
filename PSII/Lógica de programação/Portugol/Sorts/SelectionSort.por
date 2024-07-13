/*
    SELECTION SORT
    Sua ideia consiste em ordenar a lista “selecionando” a cada interação o menor item possíveis
    e os colocam da esquerda para a direita.
    
    Estado Inicial: [5, 3, 1, 2, 4]
    Após a primeira seleção : [1, 3, 5, 2, 4]
    Após a segunda seleção: [1, 2, 5, 3, 4]
    Após a terceira seleção: [1, 2, 3, 5, 4]
    Após a quarta seleção: [1, 2, 3, 4, 5]
*/
programa
{

	inclua biblioteca Util --> u

	funcao inicio()
	{
		inteiro vetor[10], tam = 10, aux, index

		para(inteiro i = 0; i < tam; i++){
			vetor[i] = u.sorteia(10, 50)
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
		escreva("Vetor ordenado: ")
		para(inteiro i = 0; i< tam; i++){
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 957; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */