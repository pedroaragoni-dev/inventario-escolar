package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Modelo;
import java.util.List;
import br.com.pedroaragoni.inventario.model.Fabricante;
import br.com.pedroaragoni.inventario.model.Categoria;
import br.com.pedroaragoni.inventario.exception.ModeloJaCadastradoException;
import br.com.pedroaragoni.inventario.exception.ModeloNaoEncontradoException;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final FabricanteService fabricanteService;
    private final CategoriaService categoriaService;

    public ModeloService(
            ModeloRepository modeloRepository,
            FabricanteService fabricanteService,
            CategoriaService categoriaService) {

        this.modeloRepository = modeloRepository;
        this.fabricanteService = fabricanteService;
        this.categoriaService = categoriaService;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public Modelo cadastrar(String nome, Long fabricanteId, Long categoriaId) {
        Fabricante fabricante = fabricanteService.buscarPorId(fabricanteId);
        Categoria categoria = categoriaService.buscarPorId(categoriaId);

        if (modeloRepository.existsByNomeAndFabricante_IdAndCategoria_Id(
                nome, fabricanteId, categoriaId)) {
            throw new ModeloJaCadastradoException();
        }

        Modelo modelo = new Modelo(nome, fabricante, categoria);
        return modeloRepository.save(modelo);
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ModeloNaoEncontradoException(id));
    }

    public Modelo alterarNome(Long id, String nome) {
        Modelo modelo = buscarPorId(id);

        if (modeloRepository.existsByNomeAndFabricante_IdAndCategoria_IdAndIdNot(
                nome,
                modelo.getFabricante().getId(),
                modelo.getCategoria().getId(),
                id)) {
            throw new ModeloJaCadastradoException();
        }

        modelo.alterarNome(nome);
        return modeloRepository.save(modelo);
    }

    public Modelo inativar(Long id) {
        Modelo modelo = buscarPorId(id);
        modelo.inativar();
        return modeloRepository.save(modelo);
    }

    public Modelo reativar(Long id) {
        Modelo modelo = buscarPorId(id);
        modelo.reativar();
        return modeloRepository.save(modelo);
    }

    public List<Modelo> listarAtivos() {
        return modeloRepository.findByAtivoTrue();
    }
}