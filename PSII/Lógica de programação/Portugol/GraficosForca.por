programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Teclado --> t
	inclua biblioteca Texto --> txt
	inclua biblioteca Graficos --> g

	cadeia palavras = "", pEscolhida[2][999], pPreenchida = "", alfabeto[26] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}, numero[10] = {"0","1","2","3","4","5","6","7","8","9"}
	inteiro nLetras, ver = 0, chances = 6
	cadeia letra, palpites = ""
	logico venceu = falso, fim = falso
	inteiro forca = g.carregar_imagem("/forca.png")
	
	funcao inicio()
	{
		palavra()
		u.aguarde(500)
		g.iniciar_modo_grafico(verdadeiro)
		g.definir_dimensoes_janela(900,600)
		g.definir_titulo_janela("CARRO BICHO")
		enquanto(nao t.tecla_pressionada(t.TECLA_ESC)){
			grafico()
			respostas()
		}
	}
	funcao palavra()
	{
		inteiro index = 0
		escreva("Qual a palavra? ")
		leia(palavras)
		limpa()
		palavras = txt.caixa_alta(palavras)
		nLetras = txt.numero_caracteres(palavras)
		faca{
			para(inteiro i = 0; i < nLetras; i++ ){
				pEscolhida[0][i] = txt.extrair_subtexto(palavras, i, i+1)
				pEscolhida[1][i] = " _"
				index++
				se(pEscolhida[0][i] == "-" ou pEscolhida[0][i] == " "){
					pEscolhida[1][i] = pEscolhida[0][i]
					ver += 1
				}
				pPreenchida = pPreenchida + pEscolhida[1][i]
			}
		}enquanto(index < nLetras)
	}
	funcao grafico()
	{
		g.definir_cor(g.criar_cor(150,150,150))
		g.limpar()
		g.desenhar_imagem(0, 0, forca)
		g.definir_cor(g.criar_cor(255,255,255))
		g.definir_estilo_texto(falso, verdadeiro, falso)
		g.definir_tamanho_texto(30.0)
		boneco()
		g.definir_tamanho_texto(30.0)
		verificacao()
		g.definir_tamanho_texto(17.0)
		escritas()
		g.desenhar_texto(15, 530, pPreenchida)
		g.renderizar()
	}
	funcao respostas()
	{
		inteiro v1 = t.ler_tecla()
		logico auxiliar = falso
		se(fim == falso){
			se(v1 >= 65 e v1 <= 90){
				v1 -= 65
				letra = alfabeto[v1]
				palpites += letra
			}
			se(v1 >= 48 e v1 <= 57){
				v1 -= 48
				letra = numero[v1]
				palpites += letra
			}
			se(v1 >= 96 e v1 <= 105){
				v1 -= 96
				letra = numero[v1]
				palpites += letra
			}
		}
		pPreenchida = ""
		para(inteiro i = 0; i < nLetras; i++){
			se(letra == pEscolhida[0][i]){
				se(pEscolhida[1][i] == letra){
					auxiliar = verdadeiro
				}
				senao{
					pEscolhida[1][i] = letra
					auxiliar = verdadeiro
					ver = ver +1
				}
			}se(ver == nLetras){
				venceu = verdadeiro
			}
		}
		para(inteiro i = 0; i < nLetras; i++){
			pPreenchida += pEscolhida[1][i]
			grafico() 
		}
		se(auxiliar == falso) chances = chances-1
	}
	funcao verificacao()
	{
		se(venceu == verdadeiro){
			g.definir_cor(g.criar_cor(0,255,0))
			g.desenhar_texto(150,300, "VOCÊ VENCEU")
			fim = verdadeiro
		}
		se(chances <= 0){
			g.definir_cor(g.criar_cor(255,0,0))
			g.desenhar_texto(150,300, "VOCÊ PERDEU")
			fim = verdadeiro
		}
	}
	funcao boneco()
	{
		escolha(chances){
			caso 6:
				
			pare
			caso 5:
				g.desenhar_texto(553, 200, "( )")
			pare
			caso 4:
				g.desenhar_texto(553, 200, "( )")
				g.desenhar_texto(551, 230, " |")
			pare
			caso 3:
				g.desenhar_texto(553, 200, "( )")
				g.desenhar_texto(545, 230, "/|")
			pare
			caso 2:
				g.desenhar_texto(553, 200, "( )")
				g.desenhar_texto(545, 230, "/|\\")
			pare
			caso 1:
				g.desenhar_texto(553, 200, " ( )")
				g.desenhar_texto(545, 230, " /|\\")
				g.desenhar_texto(553, 260, "  |")
				g.desenhar_texto(558, 290, "/")
			pare
			caso 0:
				g.desenhar_texto(553, 200, " ( )")
				g.desenhar_texto(545, 230, " /|\\")
				g.desenhar_texto(553, 260, "  |")
				g.desenhar_texto(558, 290, "/ \\")
			pare
			caso contrario:
				g.desenhar_texto(553, 200, " ( )")
				g.desenhar_texto(545, 230, " /|\\")
				g.desenhar_texto(553, 260, "  |")
				g.desenhar_texto(558, 290, "/ \\")
		}
	}
	funcao escritas()
	{
		g.desenhar_texto(20,20, "Chances: " + chances)
		g.desenhar_texto(20,50, "Palpites: " + palpites)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2047; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pEscolhida, 8, 23, 10}-{pPreenchida, 8, 43, 11}-{letra, 10, 8, 5}-{v1, 65, 10, 2};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */