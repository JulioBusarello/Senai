programa
{
	
	funcao inicio()
	{
		ex1()
	}
	funcao ex1()
	{
		inteiro a  = 10
		para(inteiro cont = 2; cont <= 50; cont+=2){
			se(cont < 10){
				escreva("0", cont, " ")
			}
			senao se(a == cont){
				escreva(cont, "\n")
				a += 10
			}
			senao{
				escreva(cont ," ")
			}
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 40; 
 * @DOBRAMENTO-CODIGO = [7];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */