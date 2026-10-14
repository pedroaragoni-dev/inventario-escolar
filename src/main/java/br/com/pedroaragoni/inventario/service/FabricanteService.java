package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.FabricanteRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Fabricante;
import java.util.List;
import br.com.pedroaragoni.inventario.exception.FabricanteJaCadastradoException;
import br.com.pedroaragoni.inventario.exception.FabricanteNaoEncontradoException;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public List<Fabricante> listarTodos() {
        return fabricanteRepository.findAll();
    }

    public Fabricante buscarPorId(Long id) {
        return fabricanteRepository.findById(id)
                .orElseThrow(() -> new FabricanteNaoEncontradoException(id));
    }

    public Fabricante cadastrar(String nome) {
        if (fabricanteRepository.existsByNome(nome)) {
            throw new FabricanteJaCadastradoException();
        }

        Fabricante fabricante = new Fabricante(nome);
        return fabricanteRepository.save(fabricante);
    }

    public Fabricante alterarNome(Long id, String nome) {
        Fabricante fabricante = buscarPorId(id);

        if (fabricanteRepository.existsByNomeAndIdNot(nome, id)) {
            throw new FabricanteJaCadastradoException();
        }

        fabricante.alterarNome(nome);
        return fabricanteRepository.save(fabricante);
    }
}
