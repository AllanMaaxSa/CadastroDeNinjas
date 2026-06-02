package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjasRepository;

    public NinjaService(NinjaRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }


    //Listar todos os meu ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjasRepository.findAll();
    }

    //Listar todos os meus ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjasRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjasRepository.save(ninja);
    }

    //Deletar o ninja - TEm que ser um metodo VOID
    public void deletarNinjaPorId(Long id){
        ninjasRepository.deleteById(id);
    }


}
