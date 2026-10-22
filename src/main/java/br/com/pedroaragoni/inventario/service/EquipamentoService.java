package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.model.Equipamento;
import br.com.pedroaragoni.inventario.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.exception.EquipamentoJaCadastradoException;
import br.com.pedroaragoni.inventario.model.Modelo;
import br.com.pedroaragoni.inventario.model.Localizacao;
import br.com.pedroaragoni.inventario.model.StatusFuncionamento;
import org.springframework.transaction.annotation.Transactional;
import java.util.Locale;
import br.com.pedroaragoni.inventario.exception.EquipamentoNaoEncontradoException;
import java.util.List;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ModeloService modeloService;
    private final LocalizacaoService localizacaoService;

    public EquipamentoService(
            EquipamentoRepository equipamentoRepository,
            ModeloService modeloService,
            LocalizacaoService localizacaoService) {

        this.equipamentoRepository = equipamentoRepository;
        this.modeloService = modeloService;
        this.localizacaoService = localizacaoService;
    }

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    @Transactional
    public Equipamento cadastrar(
            String numeroSerie,
            Long modeloId,
            Long localizacaoId,
            StatusFuncionamento statusFuncionamento,
            String observacoes) {

        Modelo modelo = modeloService.buscarPorId(modeloId);
        Localizacao localizacao = localizacaoService.buscarPorId(localizacaoId);

        if (equipamentoRepository.existsByNumeroSerie(numeroSerie)) {
            throw new EquipamentoJaCadastradoException();
        }

        Long numero = equipamentoRepository.obterProximoNumeroCodigo();
        String codigo = String.format(Locale.ROOT, "EQ-%06d", numero);

        Equipamento equipamento = new Equipamento(
                codigo,
                numeroSerie,
                modelo,
                localizacao,
                statusFuncionamento,
                observacoes
        );

        return equipamentoRepository.save(equipamento);
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new EquipamentoNaoEncontradoException(id));
    }

    public Equipamento buscarPorCodigo(String codigo) {
        return equipamentoRepository.findByIdentificadorInterno(codigo)
                .orElseThrow(() -> new EquipamentoNaoEncontradoException(codigo));
    }
}