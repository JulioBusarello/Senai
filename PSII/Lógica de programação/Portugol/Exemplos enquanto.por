programa
{
	
	funcao inicio()
	{
		//ex1()
		//ex2()
		//ex3()	
	}
	// Exemplo 01
	funcao ex1()
	{
		logico controle = falso
		caracter res
		
		enquanto(controle != verdadeiro){
			escreva("Estou executando o laço\n\n")

			escreva("Deseja continuar o laço?(S ou N)\n")
			leia(res)

			se(res == 'S' ou res == 's'){
				controle = falso
			}
			senao{
				controle = verdadeiro
			}
		}	
	}
	// Exemplo 02
	funcao ex2()
	{
		inteiro valor = -1, soma = 0

		enquanto(valor != 0){

			escreva("Forneça um valor diferente de 0: \n")
			leia(valor)

			soma = soma + valor

		}
		escreva("A soma é: ", soma, "\n\n")
	}
	// Exemplo 03
	funcao ex3()
	{
		logico continuar = verdadeiro
		inteiro soma = 0

		escreva("Deseja iniciar o laço? (verdadeiro ou falso)\n")
		leia(continuar)

		enquanto(continuar == verdadeiro){
			
			soma += 100
			escreva("\nSoma = ", soma, "\n")
			
			escreva("Continuar? (verdadeiro ou falso) \n")
			leia(continuar)

			se(continuar != verdadeiro){
				continuar = falso
			}
		}
		escreva("A soma total foi: ", soma)
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 653; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */