programa
{
	inclua biblioteca Graficos --> g

	inteiro pontos[3][2] = {
		{100,200},
		{200,100},
		{300,200}
	}
	
	funcao texto()
	{
		g.definir_cor(g.criar_cor(30, 100, 90))
		g.definir_tamanho_texto(30.0)
		g.desenhar_texto(20,20,"TESTE DE USO DA FUNÇÃO DESENHAR TEXTO")
	}

	funcao shapes()
	{
		g.desenhar_poligono(pontos ,verdadeiro)
	}

	funcao grafico()
	{
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		g.definir_cor(g.COR_AZUL)
		g.desenhar_retangulo(200, 150, 400, 300, falso, verdadeiro)
		g.definir_cor(g.criar_cor(0, 100, 0))
		g.desenhar_elipse(250, 350, 150, 100, verdadeiro)

		texto()
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
 * @POSICAO-CURSOR = 90; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pontos, 5, 9, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */