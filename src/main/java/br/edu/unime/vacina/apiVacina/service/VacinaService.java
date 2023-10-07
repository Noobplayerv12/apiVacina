package br.edu.unime.vacina.apiVacina.service;

import br.edu.unime.vacina.apiVacina.entity.Vacina;
import br.edu.unime.vacina.apiVacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;
    public List<Vacina> obterTodos(){
        return vacinaRepository.findAll();
    }

    public Vacina encontrarVacina(String id) throws Exception {

        Optional<Vacina> vacinaOptional = vacinaRepository.findById(id);

        if (vacinaOptional.isEmpty()) {
            throw new Exception("Vacina não encontrada!");
        }

        return vacinaOptional.get();
    }

    public void inserir(Vacina vacina){
        vacinaRepository.insert(vacina);
    }

    public Vacina atualizar(String id, Vacina vacina) throws Exception {
        Vacina vacinaAntigo = encontrarVacina(id);

        vacinaAntigo.setFabricante(vacina.getFabricante());
        vacinaAntigo.setLote(vacina.getLote());
        vacinaAntigo.setIntervaloDeDoses(vacina.getIntervaloDeDoses());
        vacinaAntigo.setDataDeValidade(vacina.getDataDeValidade());
        vacinaAntigo.setNumeroDeDoses(vacina.getNumeroDeDoses());

        vacinaRepository.save(vacinaAntigo);

        return vacinaAntigo;
    }

    public void deletar(String id) throws Exception {
        Vacina vacina = encontrarVacina(id);

        vacinaRepository.delete(vacina);

    }

}