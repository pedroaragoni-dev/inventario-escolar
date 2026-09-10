package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.model.Categoria;
import java.util.List;
import br.com.pedroaragoni.inventario.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria cadastrar(String nome) {
        Categoria categoria = new Categoria(nome);
        return categoriaRepository.save(categoria);
    }
}