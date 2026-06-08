package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjasRepository;
    private NinjaMapper ninjaMapper;

    @Autowired
    public NinjaService(NinjaRepository ninjasRepository, NinjaMapper ninjaMapper){
        this.ninjasRepository = ninjasRepository;
        this.ninjaMapper = ninjaMapper;
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

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjasRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    //Deletar o ninja - Tem que ser um metodo VOID
    public void deletarNinjaPorId(Long id){
        ninjasRepository.deleteById(id);
    }

    //Atualiza ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if(ninjasRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjasRepository.save(ninjaAtualizado);
        }
        return null;
    }


}
