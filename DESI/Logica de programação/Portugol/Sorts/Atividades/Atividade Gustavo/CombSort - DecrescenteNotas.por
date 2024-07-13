programa
{
	inclua biblioteca Util --> u
	
	funcao inicio()
	{
		inteiro tamanho, indice,i, j, gap = 10, aux
		cadeia nome[999], auxNome
		real nota[999], auxNota
		caracter resp
		real fator = 1.3
		logico trocado = verdadeiro, continuar = verdadeiro

		i = 0
		enquanto(continuar){
			escreva("Nome do ",i+1," aluno: \n")
			leia(nome[i])
			escreva("Qual a nota: ")
			leia(nota[i])
			escreva("Continuar? (s/n) ")
			leia(resp)
			i++
			se(resp == 'n') continuar = falso
			limpa()
		}
		tamanho = i

		enquanto(gap > 1 ou trocado){
			gap = (gap / fator)
			se(gap < 1){
				gap = 1
			}
			trocado = falso
			i = 0
			enquanto( i + gap < tamanho){
				se(nota[i] < nota[i + gap]){
					auxNota = nota[i]
					auxNome = nome[i]
					
					nota[i] = nota[i + gap]
					nome[i] = nome[i + gap]
					
					nota[i + gap] = auxNota
					nome[i + gap] = auxNome
					
					trocado = verdadeiro
				}
				i = i + 1
			}
		}
		para(i = 0; i < tamanho; i++){
			escreva("Nome: ",nome[i],"\tNota: ",nota[i])
			escreva("\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 149; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */