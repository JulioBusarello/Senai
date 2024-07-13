programa
{
	inclua biblioteca Graficos --> g

	inteiro pontos[4][2] = {
		{210, 300},
		{400, 160},
		{590, 300},
		{400, 440}
	}

	funcao shapes()
	{
		g.definir_cor(g.criar_cor(0,150,0))
		g.desenhar_retangulo(200, 150, 400, 300, falso, verdadeiro)

		g.definir_cor(g.criar_cor(200,200,0))
		g.desenhar_poligono(pontos ,verdadeiro)

		g.definir_cor(g.criar_cor(0,0,200))
		g.desenhar_elipse(400-70, 300-70, 140, 140, verdadeiro)
	}

	funcao grafico()
	{
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		shapes()
		
		g.renderizar()
	}
	
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800,600)
		g.definir_titulo_janela("Usando Modo Gráfico")
		enquanto(verdadeiro){
			grafico()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 398; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */