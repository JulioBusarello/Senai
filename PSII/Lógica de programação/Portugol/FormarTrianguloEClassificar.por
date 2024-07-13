programa
{
	
	funcao inicio()
	{
		// Criando variáveis
		inteiro p1 = 0, p2= 0, p3= 0
		cadeia status = ""

		// Banner
		escreva("================================\n")
		escreva("= Teste de formar um triângulo =\n")
		escreva("================================\n")
		
		// Pedindo valores
		escreva("Qual o primeiro valor? ")
		leia(p1)
		escreva("Qual o segundo valor? ")
		leia(p2)
		escreva("Qual o terceiro valor? ")
		leia(p3)

		// Verificando possibilidade de formar
		se(p1 > p2 e p1 > p3){
			se(p1 < p2+p3){
				escreva("\nPossível formar um triângulo")
				status = "Possivel"
			}senao{
				escreva("\nImpossível formar um triângulo")
			}
		}senao se(p2 > p1 e p2 > p3){
			se(p2 < p1+p3){
				escreva("\nPossível formar um triângulo")
				status = "Possivel"
			}senao{
				escreva("\nImpossível formar um triângulo")
			}
		}senao{
			se(p3 < p1+p2){
				escreva("\nPossível formar um triângulo")
				status = "Possivel"
			}senao{
				escreva("\nImpossível formar um triângulo")
			}
		}
		
		// Verificando tipo de triângulo
		se(status == "Possivel"){
			se(p3 == p2 e p2 == p1){
				escreva("\nO triângulo é Equilátero")
			}senao se(p3 != p2 e p2 != p1){
				escreva("\nO triângulo é Escaleno")
			}senao{
				escreva("\nO triângulo é Isósceles")
			}
		}
		escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1296; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */