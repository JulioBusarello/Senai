programa
{
	inclua biblioteca Matematica --> m 
	
	funcao inicio()
	{
		// Definição de variável
		real a = -1.0, b = -1.0, c = -1.0, delta, x1, x2
		logico continuar = verdadeiro

		// Loop
		enquanto(continuar==verdadeiro){
			// Entrada de dados
			escreva("Qual o valor de A: ")
			leia(a)
			escreva("Qual o valor de B: ")
			leia(b)
			escreva("Qual o valor de C: ")
			leia(c)

			// Verificar continuidade do loop
			se(a == 0 e b ==0){
				continuar = falso
			}

			// Calculo do delta
			delta = m.potencia(b, 2.0) - 4*a*c

			// Verificando possibilidade
			se(delta < 0){
				escreva("Não é possível fazer o cálculo, o delta é negativo! \n")
			}
			senao{
				// Calculo
				x1 = (-b + m.raiz(delta, 2.0))/ 2*a
				x2 = (-b - m.raiz(delta, 2.0))/ 2*a
				// Retorno valores
				escreva("\nX1: ", m.arredondar(x1, 2) , "\nX2: ", m.arredondar(x2, 2),"\n")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 787; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */