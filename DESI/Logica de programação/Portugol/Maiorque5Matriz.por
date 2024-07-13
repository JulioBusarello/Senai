programa{
	funcao inicio(){
		inteiro numeroD = 0, numero[10][2], valor = 0
		para(inteiro i = 0; i < 10; i++){
			escreva("Qual o numero? ")
			leia(numero[i][0])
			se(numero[i][0] > 5) numero[i][1] = 1
			valor += numero[i][1]
		}
		escreva(valor,"/10 foram digitados acima de 5\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 8; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */