package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Localizacao;
import java.util.List;
import br.com.pedroaragoni.inventario.exception.LocalizacaoJaCadastradaException;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    public List<Localizacao> listarTodas() {
        return localizacaoRepository.findAll();
    }

    public Localizacao cadastrar(String codigo, String nome, String descricao) {
        if (localizacaoRepository.existsByCodigo(codigo)) {
            throw new LocalizacaoJaCadastradaException();
        }

        Localizacao localizacao = new Localizacao(codigo, nome, descricao);
        return localizacaoRepository.save(localizacao);
    }
}
