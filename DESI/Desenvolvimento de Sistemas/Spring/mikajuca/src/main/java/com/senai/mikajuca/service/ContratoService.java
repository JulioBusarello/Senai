package com.senai.mikajuca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.senai.mikajuca.prototype.DocumentoTexto;
import com.senai.mikajuca.model.Contrato;
import com.senai.mikajuca.repository.ContratoRepository;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepo;

    private DocumentoTexto prototipo = new DocumentoTexto(
            "Contrato Padrão",
            """
                    IDENTIFICAÇÃO DAS PARTES:
                    [nome, documentos, endereço]

                    OBJETO:
                    [o que está sendo contratado]

                    OBRIGAÇÕES:
                    [quem faz o quê]

                    PREÇO E PAGAMENTO:
                    [se houver]

                    PRAZO/VIGÊNCIA:
                    [data]

                    ASSINATURAS:
                    [assinatura das partes]
                    """);

    public ContratoService(ContratoRepository repo) {
        this.contratoRepo = repo;
    }

    public Contrato criarContrato(String conteudoCustomizado, String usuario) {
        DocumentoTexto clone = (DocumentoTexto) prototipo.clonar();
        clone.setConteudo(conteudoCustomizado);

        Contrato contrato = new Contrato();
        contrato.setTitulo(clone.getTitulo());
        contrato.setConteudo(clone.getConteudo());
        contrato.setCriadoPor(usuario);
        return contratoRepo.save(contrato);
    }

    public List<Contrato> listarContratos(String usuario) {
        return contratoRepo.findByCriadoPor(usuario);
    }
}