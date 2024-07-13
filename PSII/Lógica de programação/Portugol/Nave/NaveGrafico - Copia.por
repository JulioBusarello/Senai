programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g
	
	inteiro imagem = g.carregar_imagem("/nave.png"), fundo = g.carregar_imagem("/fundo.png"), fim = g.carregar_imagem("/fim.png")
	inteiro x = 150, y = 250, x2 = 200, y2 = 325, xadv = 780, yadv = u.sorteia(50, 550), vidas = 3
	logico nave = verdadeiro
		
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(800,600)
		g.definir_titulo_janela("NAVE")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			grafico()
			movimento()
			tiro()
			adv()
			destruir()
			perdeu()
			u.aguarde(00002)
		}
	}
	funcao grafico()
	{
		g.limpar()
		g.definir_cor(g.criar_cor(255,255,255))
		g.desenhar_imagem(0,0, fundo)
		g.desenhar_texto(10, 15, "Vidas: "+vidas)
		g.definir_cor(g.criar_cor(255,255,255))
		criar()
		g.definir_cor(g.criar_cor(255,255,255))
		g.definir_estilo_texto(falso, verdadeiro, falso)
		g.definir_tamanho_texto(20.0)
		g.desenhar_texto(730, 20, "X " + x)
		g.desenhar_texto(730, 50, "Y " + y)
		perdeu()
		g.renderizar()
	}
	funcao movimento()
	{
		se(nave == verdadeiro){
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
	}
	funcao criar()
	{
		se(nave == verdadeiro){
			g.desenhar_retangulo(x2, y2, 20, 5, verdadeiro, verdadeiro)
			g.desenhar_imagem(x,y,imagem)
			g.desenhar_elipse(xadv, yadv, 100, 50, verdadeiro)
		}
	}
	funcao tiro()
	{
		se(nave == verdadeiro){
			y2 = y+75
			x2 = x+10
			se(t.tecla_pressionada(t.TECLA_ESPACO)){
				faca{
					x2 += 15
					grafico()
					movimento()
					adv()
					u.aguarde(00002)
				}enquanto (x2 < 820)
			}
		}
	}
	funcao adv()
	{
		se(nave == verdadeiro){
			se(xadv > -50){
				xadv -= 1
				grafico()
				movimento()
				u.aguarde(00002)
			}
			senao se(xadv <= -50){
				yadv = u.sorteia(50, 550)
				xadv = 780
			}
		}
	}
	funcao destruir()
	{
		se(x + 50 >= xadv e x -50 <= xadv){
			se(y + 150 >= yadv e y - 50 <= yadv){
				vidas -= 1
				x = 20
				y = 185
				xadv = 780
				yadv = u.sorteia(50, 550)
			}
		}
		se(x2 + 5 >= xadv e x - 5 <= xadv){
			se(y2 >= yadv -10 e y <= yadv -20){
				x2 = x+50 
				xadv = 780
				yadv = u.sorteia(50, 550)
			}
		}
		se(vidas <= 0) nave = falso 
		se(vidas > 0) nave = verdadeiro
	}
	funcao perdeu()
	{
		se(vidas <= 0 e nave == falso){
			g.desenhar_imagem(0,0,fim)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2543; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */