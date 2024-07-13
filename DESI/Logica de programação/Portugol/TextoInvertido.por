programa
{
	inclua biblioteca Texto --> t
	
	cadeia texto, palavra[999]
	inteiro nLetras
	
	funcao inicio()
	{
		escreva("Qual o texto? ")
		leia(texto)
		nLetras = t.numero_caracteres(texto)

		para(inteiro i =0; i < nLetras; i++){
			palavra[i] = t.extrair_subtexto(texto, i, i+1)
		}
		
		limpa()
		
		escreva("Texto original: ", texto)
		escreva("\nTexto invertido: ")
		para(inteiro i=nLetras; i>=0; i--){
			escreva(palavra[i])
			se(palavra[i] == " "){
				nLetras -= 1
			}
		}
		escreva("\nNúmero de caracteres: ", nLetras)
		escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 476; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {palavra, 5, 15, 7}-{nLetras, 6, 9, 7};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */