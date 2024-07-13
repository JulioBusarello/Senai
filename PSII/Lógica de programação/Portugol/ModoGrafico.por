programa
{
	//  _______   	/		 o   ______
	//     | 	  |    | |	 |  |     |
	//     |	  |    | |	 |  |     |
	// |   |	  |	  | |	 |  |	|
	// \__/	  |____| |____  |  |_____|
	
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	inteiro bola_x = 668, bola_y = 385, vel = 1
	inteiro fundo = g.criar_cor(100, 100, 100), amarelo = g.criar_cor(200, 200, 0), preto2 = g.criar_cor(15, 15, 15)
	funcao grafico()
	{
		g.definir_cor(fundo)
		g.limpar()
		g.definir_cor(g.COR_AMARELO)
		g.desenhar_retangulo(bola_x+20, bola_y-80, 180, 100, verdadeiro, verdadeiro)
		g.desenhar_retangulo(bola_x, bola_y-30, 23, 50, verdadeiro, verdadeiro)
		g.definir_cor(amarelo)
		g.desenhar_retangulo(bola_x+70, bola_y-70, 120, 45, verdadeiro ,verdadeiro)
		g.definir_cor(preto2)
		g.desenhar_retangulo(bola_x, bola_y-19, 30, 40, verdadeiro, verdadeiro)
		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(bola_x+80, bola_y-60, "SEDEX")
		g.definir_estilo_texto(falso,verdadeiro,falso)
		g.definir_tamanho_texto(30.0)
		g.desenhar_retangulo(bola_x+20, bola_y-80, 40, 50, verdadeiro, verdadeiro)
		g.desenhar_elipse(bola_x, bola_y, 50, 50, verdadeiro)
		g.desenhar_elipse(bola_x+150, bola_y, 50, 50, verdadeiro)
		g.definir_cor(g.COR_BRANCO)
		g.desenhar_elipse(bola_x+7, bola_y+7, 36, 36, verdadeiro)
		g.desenhar_elipse(bola_x+157, bola_y+7, 36, 36, verdadeiro)
		g.desenhar_texto(20, 10, "X: " + bola_x)
		g.desenhar_texto(20, 50, "Y: " + bola_y)
		g.desenhar_texto(20, 90, "Velocidade: " + vel)
		g.renderizar()
	}
	funcao movimento()
	{
		// Velocidade
		se(t.tecla_pressionada(t.TECLA_SUBTRACAO)){
			u.aguarde(70)
			vel -= 1
		}
		se(t.tecla_pressionada(t.TECLA_ADICAO)){
			u.aguarde(70)
			vel += 1
		}
		se(vel <= 0) vel = 1
		// Teclas movimentação
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA)) bola_y -= vel
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)) bola_x -= vel
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA)) bola_x += vel
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO)) bola_y += vel
		// Fora da tela
		se(bola_x > 1500) bola_x = 0
		se(bola_x < 0) bola_x = 1500
		se(bola_y > 850) bola_y = 0
		se(bola_y < 0) bola_y = 800
	}
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1500,850)
		g.definir_titulo_janela("ROÇADEIRA")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			grafico()
			movimento()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 844; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */