programa
{
	caracter frase[200]
	inteiro letras = 0
		
	funcao inicio()
	{
		inteiro index = 0
		logico continuar = verdadeiro
		
		escreva("Qual sua frase? \n")
		enquanto(continuar == verdadeiro){
			leia(frase[index])
			se(frase[index] == '.') continuar = falso
			index++
			letras++
		}
		escreva("\nFrase digitada: ")
		para(inteiro i = 0; i < index; i++){
			escreva(frase[i])
		}
		escreva("\nFrase digitada ao contrário: ")
		index--
		para(index; index >= 0; index--){
			escreva(frase[index])
		}
		escreva("\nTotal de caracteres: ", letras)
	}	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 555; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */