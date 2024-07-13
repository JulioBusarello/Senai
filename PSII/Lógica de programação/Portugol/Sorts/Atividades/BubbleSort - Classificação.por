programa
{
	
	funcao inicio()
	{
		// Criando variáveis
		real pontos[100], auxiliar
		inteiro index = 0
		logico continuar = verdadeiro

		// Loop
		faca{
			escreva("Qual a pontuação do ", (index+1) ,"º candidato? ")
			leia(pontos[index])
			auxiliar = pontos[index]
			se(auxiliar == 0) continuar = falso
			index++
		}
		enquanto(continuar) // Condição continuação do loop

		// Organizando valores (crescente)
		para(inteiro a=1; a<=index; a++){
			para(inteiro i=0; i<index-1; i++){
				se(pontos[i] < pontos[i+1]){
					auxiliar = pontos[i]
					pontos[i] = pontos[i+1]
					pontos[i+1] = auxiliar
				}
			}
		}
		// Retornando as posições
		para(inteiro i=0; i<10; i++){
			escreva((i+1) ,"º lugar: \t", pontos[i] ," \n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 735; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */