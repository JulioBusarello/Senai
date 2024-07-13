programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro idade[10], tamanho = 10, auxIdade, indice,i, j, gap = 10, aux
		cadeia nome[10], auxNome
		caracter resp
		real fator = 1.3
		logico trocado = verdadeiro, continuar = verdadeiro

		para(i = 0; i < tamanho; i++){
			escreva("Qual o nome: ")
			leia(nome[i])
			escreva("Qual a idade: ")
			leia(idade[i])
			limpa()
		}

		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto( i + gap < tamanho){
				se(idade[i] < idade[i + gap]){
					auxIdade = idade[i]
					auxNome = nome[i]
					
					idade[i] = idade[i + gap]
					nome[i] = nome[i + gap]
					
					idade[i + gap] = auxIdade
					nome[i + gap] = auxNome
					
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		para(i = 0; i < tamanho; i++){
			escreva("Nome: ",nome[i],"\tIdade: ",idade[i])
			escreva("\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 387; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */