package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.model.Categoria;
import java.util.List;
import br.com.pedroaragoni.inventario.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.exception.CategoriaJaCadastradaException;
import br.com.pedroaragoni.inventario.exception.CategoriaNaoEncontradaException;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    public Categoria cadastrar(String nome) {
        if (categoriaRepository.existsByNome(nome)) {
            throw new CategoriaJaCadastradaException();
        }

        Categoria categoria = new Categoria(nome);
        return categoriaRepository.save(categoria);
    }
}