package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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



}
