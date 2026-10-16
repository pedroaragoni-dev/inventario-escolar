package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Localizacao;
import java.util.List;
import br.com.pedroaragoni.inventario.exception.LocalizacaoJaCadastradaException;
import br.com.pedroaragoni.inventario.exception.LocalizacaoNaoEncontradaException;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    public List<Localizacao> listarTodas() {
        return localizacaoRepository.findAll();
    }

    public List<Localizacao> listarAtivas() {
        return localizacaoRepository.findByAtivoTrue();
    }

    public Localizacao buscarPorId(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new LocalizacaoNaoEncontradaException(id));
    }

    public Localizacao cadastrar(String codigo, String nome, String descricao) {
        if (localizacaoRepository.existsByCodigo(codigo)) {
            throw new LocalizacaoJaCadastradaException();
        }

        Localizacao localizacao = new Localizacao(codigo, nome, descricao);
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao alterarDados(Long id, String nome, String descricao) {
        Localizacao localizacao = buscarPorId(id);
        localizacao.alterarDados(nome, descricao);
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao inativar(Long id) {
        Localizacao localizacao = buscarPorId(id);
        localizacao.inativar();
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao reativar(Long id) {
        Localizacao localizacao = buscarPorId(id);
        localizacao.reativar();
        return localizacaoRepository.save(localizacao);
    }
}
