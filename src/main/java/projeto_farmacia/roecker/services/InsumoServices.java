package projeto_farmacia.roecker.services;

import projeto_farmacia.roecker.model.Insumo;
import projeto_farmacia.roecker.repository.InsumoRepository;

public class InsumoServices {

    private final InsumoRepository insumoRepository;

    public InsumoServices(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public Insumo createInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    public Insumo updateInsumo(Integer id, Insumo insumo) {
        if (insumoRepository.existsById(id)) {
            insumo.setId(id);
            return insumoRepository.save(insumo);
        }
        return null;
    }

    public void deleteInsumo(Integer id) {
        insumoRepository.deleteById(id);
    }

    public Insumo getInsumoById(Integer id) {
        return insumoRepository.findById(id).orElse(null);
    }

    public Iterable<Insumo> getAllInsumos() {
        return insumoRepository.findAll();
    }

    public Insumo getInsumoByName(String nome) {
        return insumoRepository.findByNome(nome);
    }

    public Insumo getInsumoByTipo(String tipo) {
        return insumoRepository.findByTipo(tipo);
    }

    public Insumo getInsumoByFabricante(String fabricante) {
        return insumoRepository.findByFabricante(fabricante);
    }

    public Insumo getInsumoByFornecedor(String fornecedor) {
        return insumoRepository.findByFornecedor(fornecedor);
    }
}
