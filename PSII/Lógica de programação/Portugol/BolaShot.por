programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Graficos --> g
	inclua biblioteca Teclado --> t

	inteiro vel = 1, bola_x = 750, bola_y = 425
	inteiro fundo = g.criar_cor(50,50,100), bola = g.criar_cor(200,200,200), texto = g.criar_cor(255,255,255)
	
	funcao desenho()
	{
		g.definir_cor(fundo)
		g.limpar()
		g.definir_cor(bola)
		g.desenhar_elipse(bola_x, bola_y, 50, 50, verdadeiro)
		g.definir_cor(texto)
		g.definir_tamanho_texto(30.0)
		g.definir_estilo_texto(falso, verdadeiro, falso)
		g.desenhar_texto(20, 10, "X: " + bola_x)
		g.desenhar_texto(20, 40, "Y: " + bola_y)
		g.desenhar_texto(20, 70, "Velocidade: " + vel)
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
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			enquanto(bola_x < 1501){
				bola_x += vel 
				desenho()
			}
		}
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
		g.definir_titulo_janela("ROÇADEIRA BALLS")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			desenho()
			movimento()
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 154; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */