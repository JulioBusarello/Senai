programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	
	inteiro imagem = g.carregar_imagem("/nave.png"), fundo = g.carregar_imagem("/fundo.png")
	inteiro x = 150, y = 250, x2 = 200, y2 = 325
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800,600)
		g.definir_titulo_janela("IMAGEM")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			grafico()
			movimento()
			tiro()
			u.aguarde(00002)
		}
	}
	funcao grafico()
	{
		g.limpar()
		g.definir_cor(g.criar_cor(255,255,255))
		g.desenhar_retangulo(x2, y2, 20, 5, verdadeiro, verdadeiro)
		g.desenhar_imagem(0,0, fundo)
		g.definir_cor(g.criar_cor(255,255,255))
		g.desenhar_retangulo(x2, y2, 20, 5, verdadeiro, verdadeiro)
		g.desenhar_imagem(x,y,imagem)
		g.definir_cor(g.criar_cor(255,255,255))
		g.definir_estilo_texto(falso, verdadeiro, falso)
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(730, 20, "X " + x)
		g.desenhar_texto(730, 50, "Y " + y)
		g.renderizar()
	}
	funcao movimento()
	{
		se(t.tecla_pressionada(t.TECLA_W) ou t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			y -= 1
		}
		se(t.tecla_pressionada(t.TECLA_A) ou t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			x -= 1
		}
		se(t.tecla_pressionada(t.TECLA_D) ou t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			x += 1
		}
		se(t.tecla_pressionada(t.TECLA_S) ou t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			y += 1
		}
		se(x > 850) x = 0
		se(x < -50) x = 800
		se(y > 650) y = 0
		se(y < -50) y = 600
	}
	funcao tiro()
	{
		y2 = y+75
		x2 = x+50
		se(t.tecla_pressionada(t.TECLA_ESPACO)){
			faca{
				x2 += 3
				grafico()
				movimento()
				u.aguarde(00002)
			}enquanto (x2 < 820)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1041; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */