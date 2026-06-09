package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjasRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos os meus ninjas por ID
    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjasRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjasExistentes = ninjasRepository.findById(id);
        if (ninjasExistentes.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjasRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);

        }
        return null;
    }


}
