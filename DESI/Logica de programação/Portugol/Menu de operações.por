/* 1- Escreva um software que solicite 2 números e realize os seguintes cálculos
   
   - Subtração
   - Adição
   - Multiplicação
   - Divisão
   - Média
   - Porcentagem
 */
 
programa
{	
		inteiro op
		
	funcao inicio()
	{
		real n1, n2, answer

		

			escreva("Informe primeiro número: \n\n")
			leia(n1)

			limpa()

			escreva("Informe segundo número: \n\n")
			leia(n2)

			limpa()
			
			escreva("|=====================MENU========================|\n")
			escreva("| 1- Subtração     2- Adição     3- Multiplicação |\n")
			escreva("| 4- Divisão       5- Média      6- Porcentagem   |\n")
			escreva("|=================================================|\n")
			leia(op)

			limpa()
			
			escolha(op){
				
			caso 1:
				answer = n1 - n2
					escreva("Subtração = ", answer, "\n")
			pare
			
			caso 2:
				answer = n1 + n2
					escreva("Soma = ", answer, "\n")
			pare
				
			caso 3:
				answer = n1 * n2
					escreva("Multiplicação = ", answer, "\n")
			pare
			
			caso 4:
				answer = n1 / n2
					escreva("Divisão = ", answer, "\n")
			pare
				
			caso 5:
				answer = (n1 + n2) / 2
					escreva("Média = ", answer, "\n")
			pare
				
			caso 6:
				answer = (n1 * n2) / 100
					escreva("Porcentagem = ", answer, "\n")	
			pare
		}	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 204; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */