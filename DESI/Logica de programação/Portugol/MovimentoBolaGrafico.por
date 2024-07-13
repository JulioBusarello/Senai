programa
{
	inclua biblioteca Teclado --> t
	inclua biblioteca Graficos --> g

	inteiro bolaX = 385, bolaY = 285
	
	funcao movimento()
	{
		se(t.tecla_pressionada(t.TECLA_SETA_DIREITA)){
			bolaX++
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ESQUERDA)){
			bolaX--
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ABAIXO)){
			bolaY++
		}
		se(t.tecla_pressionada(t.TECLA_SETA_ACIMA)){
			bolaY--
		}

		se(bolaX > 770) bolaX = 770
		se(bolaX < 0) bolaX = 0
		se(bolaY > 570) bolaY = 570
		se(bolaY < 0) bolaY = 0
	}

	funcao grafico()
	{
		g.definir_cor(g.COR_BRANCO)
		g.limpar()

		g.definir_cor(g.COR_PRETO)
		g.desenhar_elipse(bolaX, bolaY, 30, 30, verdadeiro)
		movimento()
		
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
 * @POSICAO-CURSOR = 422; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */