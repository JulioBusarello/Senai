programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> ma
	inclua biblioteca Teclado --> k
	inclua biblioteca Matematica --> m
	inclua biblioteca Graficos --> g

	// Posição do Mouse
	inteiro xm_pos, ym_pos

	// Marcação da Caixa
	logico q1 = falso, q2 = falso, q3 = falso

	// Desenha as Fórmulas
	inteiro deltai = g.carregar_imagem("/delta.png"), xverticei = g.carregar_imagem("/calculo2.png"), yverticei = g.carregar_imagem("/calculo3.png")

	// Valores Principais para os Cálculos
	real a = 1.0, b = 0.0, c = 0.0
	
	// Valores Para a Parábola
	real delta = 0.0, xvertice = 0.0, yvertice = 0.0

	// Cálculo
	real x1 = 0.0, x2 = 0.0

	// Posição no Gráfico
	real xt[2000], fx[2000]

	// Centro do gráfico
	inteiro orgX = 750, orgY = 330


	//Desenha eixo
	funcao eixo()
	{
		g.definir_cor(g.criar_cor(100,100,100))
		// Eixo X
		g.desenhar_linha(500, 330, 1000, 330)
		// Eixo Y
		g.desenhar_linha(750, 80, 750, 580)
		
		// EIXOX
		para(inteiro x = 500 ; x <= 1000; x += 5){
			 g.desenhar_linha(x, 325, x, 335)
		}
		para(inteiro x = 500 ; x <= 1000; x += 50){
			 g.desenhar_linha(x, 315, x, 345)
		}
		
		// EIXO Y
		para(inteiro i = 80 ; i <= 580; i += 5){
			 g.desenhar_linha(745, i, 755, i)
		}
		para(inteiro i = 80 ; i <= 580; i += 50){
			 g.desenhar_linha(735, i, 765, i)
		}
	}

	//Desenha Grade
	funcao grade()
	{
		g.definir_cor(g.criar_cor(220,220,220))
		// GRADE
		
		// Vertical
		para(inteiro v = 505 ; v < 1000; v += 5){
			 g.desenhar_linha(v, 81, v, 579)
		}
		// Horizontal
		para(inteiro h = 85; h < 580; h += 5){
            	g.desenhar_linha(501, h, 999, h)
        	}
	}

	// Desenha Quadrado e Faz Marcação
	funcao quadrado()
	{
		// POSICAO MOUSE
		xm_pos = ma.posicao_x()
		ym_pos = ma.posicao_y()
		
		//QUADRADO 1
		se(q1 == falso){
			g.definir_cor(g.COR_AZUL)
		}
		senao se(q1 == verdadeiro){
			g.definir_cor(g.COR_VERMELHO)
		}
		g.desenhar_retangulo(40, 105, 50, 30, falso, falso)
		//QUADRADO 2
		se(q2 == falso){
			g.definir_cor(g.COR_AZUL)
		}
		senao se(q2 == verdadeiro){
			g.definir_cor(g.COR_VERMELHO)
		}
		g.desenhar_retangulo(140, 105, 50, 30, falso, falso) 
		// QUADRADO 3
		se(q3 == falso){
			g.definir_cor(g.COR_AZUL)
		}
		senao se(q3 == verdadeiro){
			g.definir_cor(g.COR_VERMELHO)
		}
		g.desenhar_retangulo(240, 105, 50, 30, falso, falso) 

		// BOTAO PRESSIONADO
		se(ma.botao_pressionado(ma.BOTAO_ESQUERDO)){
			// NO QUADRADO 1
			se(xm_pos >= 40 e xm_pos <= 40+50 e ym_pos >= 105 e ym_pos <= 135){
				se(q1 == verdadeiro) q1 = falso
				senao{
					q1 = verdadeiro
					q2 = falso
					q3 = falso
				}
				u.aguarde(100)
			}
			// NO QUADRADO 2
			se(xm_pos >= 140 e xm_pos <= 140+50 e ym_pos >= 105 e ym_pos <= 135){
				se(q2 == verdadeiro) q2 = falso
				senao{
					q1 = falso
					q2 = verdadeiro
					q3 = falso
				}
				u.aguarde(100)
			}
			// NO QUADRADO 3
			se(xm_pos >= 240 e xm_pos <= 240+50 e ym_pos >= 105 e ym_pos <= 135){
				se(q3 == verdadeiro) q3 = falso
				senao{
					q1 = falso
					q2 = falso
					q3 = verdadeiro
				}
				u.aguarde(100)
			}
		}
	}

	// Desenha os Números e Adiciona/Subtrai
	funcao numeros()
	{
		// VALOR PRIMEIRO QUADRADO
		se(q1 == verdadeiro){
			se(k.tecla_pressionada(k.TECLA_ADICAO)){
				a += 1
			}
			senao se(k.tecla_pressionada(k.TECLA_SUBTRACAO)){
				a -= 1
			}
			u.aguarde(100)
		}
		// VALOR SEGUNDO QUADRADO
		se(q2 == verdadeiro){
			se(k.tecla_pressionada(k.TECLA_ADICAO)){
				b += 1
			}
			senao se(k.tecla_pressionada(k.TECLA_SUBTRACAO)){
				b -= 1
			}
			u.aguarde(100)
		}
		// VALOR TERCEIRO QUADRADO
		se(q3 == verdadeiro){
			se(k.tecla_pressionada(k.TECLA_ADICAO)){
				c += 1
			}
			senao se(k.tecla_pressionada(k.TECLA_SUBTRACAO)){
				c -= 1
			}
			u.aguarde(100)
		}
		// ESCREVER OS VALORES
		g.definir_cor(g.COR_PRETO)
		g.definir_tamanho_texto(15.0)
		
		se(a<0) g.desenhar_texto(45, 112, ""+(a*-1))
		senao g.desenhar_texto(45, 112, ""+a)
		
		se(b<0) g.desenhar_texto(145, 112, ""+(b*-1))
		senao g.desenhar_texto(145, 112, ""+b)

		se(c<0) g.desenhar_texto(245, 112, ""+(c*-1))
		senao g.desenhar_texto(245, 112, ""+c)

	}

	// Desenha as Fórmulas Dos Cálculos
	funcao calculosdesenhar()
	{
		g.definir_cor(g.COR_AZUL)
		g.desenhar_imagem(40, 180, deltai)
		g.desenhar_imagem(40, 230, xverticei)
		g.desenhar_imagem(40, 290, yverticei)
		// DELTA
		g.desenhar_retangulo(200, 180, 50, 30, falso, falso)
		// X VERTICE
		g.desenhar_retangulo(200, 240, 50, 30, falso, falso)
		// Y VERTICE
		g.desenhar_retangulo(200, 300, 50, 30, falso, falso)

		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(205, 190, ""+delta)
		g.desenhar_texto(205, 250, ""+xvertice)
		g.desenhar_texto(205, 310, ""+yvertice)
	}

	// Faz os Cálculos
	funcao calcular()
	{
		// DELTA
		delta = (b * b)  - 4 * a * c

		// X VERTICE
		xvertice = - b / 2 * a

		// Y VERTICE
		yvertice = - delta / 4 * a
	}

	// Desenha a Parabola
	funcao parabola()
	{
		se( delta >= 0){
			x1 = (-b+ m.raiz(delta,2.0)) / (2*a)
			x2 = (-b- m.raiz(delta,2.0)) / (2*a)
		}

		real valorX = -5.0
		para(inteiro x = 0; x < 2000; x++){
			valorX += 0.02
			xt[x] = valorX
			fx[x] = (a*m.potencia(xt[x], 2.0)+b * xt[x] + c) * -50

			se(xt[x]+orgX > 500 e xt[x]+orgX < 755 e fx[x]+orgY > 80 e fx[x]+orgY < 580){
				//g.desenhar_ponto(xt[x]*50+orgX, fx[x]+orgY)
				g.desenhar_elipse(xt[x]*50+orgX, fx[x]+orgY, 2, 2, verdadeiro)
			}
		}	
	}

	// Desenha os Textos Necessários
	funcao texto()
	{
		g.definir_cor(g.COR_VERMELHO)
		g.definir_tamanho_texto(20.0)
		se(a < 0) g.desenhar_texto(30, 110, "-")
		
		se(b < 0){
			g.desenhar_texto(100, 110, "X²-")
		}senao{
			g.desenhar_texto(100, 110, "X²+")
		}
		se(c < 0){
			g.desenhar_texto(200, 110, "X -")
		}senao{
			g.desenhar_texto(200, 110, "X +")
		}
		g.desenhar_texto(300, 110, "= 0")

		g.definir_cor(g.COR_PRETO)
		g.desenhar_texto(40, 370, "X1 = "+x1)
		g.desenhar_texto(40, 400, "X2 = "+x2)
	}

	// Faz Todos os Desenhos
	funcao grafico()
	{
		// Cor de fundo
		g.definir_cor(g.COR_BRANCO)
		g.limpar()
		
		// Cor dos retangulos
		g.definir_cor(g.criar_cor(0,0,0))
		// Retangulo do titulo
		g.desenhar_retangulo(20, 5, 980, 70, falso, falso)
		// Retangulo do equação
		g.desenhar_retangulo(20, 80, 450, 500, falso, falso)
		// Retangulo do eixo
		g.desenhar_retangulo(500, 80, 500, 500, falso, falso)
		
		grade()
		eixo()
		texto()
		quadrado()
		calculosdesenhar()
		numeros()
		parabola()
		redefinir()
		
		g.renderizar()
	}

	// Redefine os Valores de A,B e C
	funcao redefinir()
	{
		g.desenhar_retangulo(440, 80, 30, 30, falso, falso)
		g.definir_tamanho_texto(10.0)
		g.desenhar_texto(445, 90, "Reset")
		se(ma.botao_pressionado(ma.BOTAO_ESQUERDO) e xm_pos >= 440 e xm_pos <= 440+30 e ym_pos >= 80 e ym_pos <= 80+30){
			a = 0.0
			b = 0.0
			c = 0.0
		}
	}

	// Inicia tudo
	funcao inicio()
	{
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(1024,600)
		g.definir_titulo_janela("Gráfico de funções")
		enquanto (verdadeiro){
			grafico()
			calcular()
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 755; 
 * @DOBRAMENTO-CODIGO = [34, 60, 76, 143, 191, 211, 224, 245, 269, 297, 310];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */