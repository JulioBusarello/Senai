programa
{
	
	funcao inicio()
	{
		// Inicialização de cada atividade
		
		atividade1()
		atividade2()
		atividade3()
	}
	funcao atividade1()
	{
		// Variáveis
		cadeia vendedor
		real salario, vendas, final

		// Nomeando exercício
		escreva("========= Exercício 1 =========\n\n")

		// Pedindo valores
		escreva("Qual o nome do vendedor? ")
		leia(vendedor)
		escreva("Qual o salário do vendedor? ")
		leia(salario)
		escreva("Qual foi o valor de vendas que este vendedor obteve? ")
		leia(vendas)

		// Comissao
		final = salario+(vendas*0.15)

		// Retorno
		escreva("O ", vendedor ," tem um salário fixo de R$ ", salario, " vendeu R$", vendas," e obteve um salário final de R$ ", final)
	}
	funcao atividade2()
	{
		// Variáveis
		real c, f

		// Nomeando exercício
		escreva("\n\n========= Exercício 2 =========\n\n")

		// Pedindo temperatura
		escreva("Qual a temperatura em graus Celcius? ")
		leia(c)
		
		// Cálculo 
		f = (9*c+160)/5

		// Retorno
		escreva("A temperatura ", c,"°C convertida em Fahrenheit é de: ", f)
	}
	funcao atividade3()
	{
		// Variáveis
		cadeia status = ""
		inteiro l1, l2, l3
		
		// Nomeando código
		escreva("\n\n========= Exercício 3 =========\n\n")

		// Pedindo Valores
		escreva("Qual o primeiro valor? ")
		leia(l1)
		escreva("Qual o segundo valor? ")
		leia(l2)
		escreva("Qual o terceiro valor? ")
		leia(l3)

		// Verificando possíbilidade
		se(l1 > l2+l3){
			escreva("\nImpossível formar um triângulo")
		}
		senao se(l2 > l1+l3){
			escreva("\nImpossível formar um triângulo")
		}
		senao se(l3 > l1+l2){
			escreva("\nImpossível formar um triângulo")
		}
		senao{
			escreva("\nPossível formar um triângulo")
			status = "possivel"
		}
		
		// Tipo de triângulo
		se(status == "possivel"){
			se(l1 == l2 e l1 == l3){
				escreva("\nO polígono é equilátero")
			}
			senao se(l1 != l2 e l1 != l3 e l2 != l3){
				escreva("\nO polígono é escaleno")
			}
			senao{
				escreva("\nO polígono é isósceles")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 721; 
 * @DOBRAMENTO-CODIGO = [11, 34, 52];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */