programa
{
	//  _______   	/		 o   ______
	//     | 	  |    | |	 |  |     |
	//     |	  |    | |	 |  |     |
	// |   |	  |	  | |	 |  |	|
	// \__/	  |____| |____  |  |_____|
	
	inclua biblioteca Texto --> t

	cadeia palavra, ultimoPalpite = ""
	inteiro nLetras = 0, chances = 6, ver = 0
	logico venceu = falso, fim = falso
	caracter letras[999], letra = ' ', palpites[999]
	
	funcao inicio(){
		principio() repeticao() verificar() boneco() finalizar()
	}
	funcao principio()
	{
		escreva("Qual a primeira palavra? ")
		leia(palavra)
		palavra = t.caixa_baixa(palavra)
		nLetras = t.numero_caracteres(palavra)
		para(inteiro i = 0; i < nLetras; i++){
			letras[i] = t.obter_caracter(palavra, i)
			palpites[i] = '_'
		}
	}
	funcao repeticao()
	{
		limpa()
		boneco()
		escreva("\n")
		para(inteiro i = 0; i < nLetras; i++){
			escreva(" ",palpites[i]," ")
		}
		escreva("\n\nNº de letras: ", nLetras)
		escreva("\nChances: ", chances)
		escreva("\nÚltimos palpites : ", ultimoPalpite)
	}
	funcao verificar()
	{
		faca{
			escreva("\n\nDigite uma letra: ")
			leia(letra)
			ultimoPalpite = ultimoPalpite + letra + ' '
			logico auxiliar = falso 
			para(inteiro i = 0; i < nLetras; i++){
				se(letra == letras[i]){
					se(palpites[i] == letra){
						auxiliar = verdadeiro
					}senao{
						palpites[i] = letra
						auxiliar = verdadeiro
						ver = ver +1
					}
				}se(ver == nLetras){
					fim = verdadeiro
					venceu = verdadeiro
					chances = -1
				}
			}
			se(auxiliar == falso) chances = chances-1
			se(chances == 0) fim = verdadeiro
			repeticao()
		}enquanto (fim == falso)
	}
	funcao finalizar()
	{
		se(chances == 0){ 
			limpa()
			escreva("== VOCÊ PERDEU ==\n")
			boneco()
			escreva("\nA palavra era: ", t.caixa_alta(palavra), "\n")
		}
		se(venceu == verdadeiro){
			limpa()
			escreva("== VOCÊ VENCEU ==\n\n")
			escreva("   ()     \n")
			escreva("  /||\\   \n")
			escreva("   /\\    \n")
			escreva("  /  \\   \n")
			escreva("\nA palavra era: ", t.caixa_alta(palavra), "\n")
		}
	}
	funcao boneco()
	{
		escolha(chances){
			caso 6:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("   ___|___\n")
			pare
			caso 5:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("   ___|___\n")
			pare
			caso 4:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva("  ||  |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("   ___|___\n")
			pare
			caso 3:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva(" /||  |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("   ___|___\n")
			pare
			caso 2:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva(" /||\\ |\n")
				escreva("      |\n")
				escreva("      |\n")
				escreva("   ___|___\n")
			pare
			caso 1:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva(" /||\\ |\n")
				escreva("  /   |\n")
				escreva(" /    |\n")
				escreva("   ___|___\n")
			pare
			caso 0:
				escreva(" ______\n")
				escreva("  |   |\n")
				escreva("  ()  |\n")
				escreva(" /||\\ |\n")
				escreva("  /\\  |\n")
				escreva(" /  \\ |\n")
				escreva("   ___|___\n")
			pare
			caso contrario:
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 242; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */