package dev.java10x.CadastroDeNinjas.Ninjas;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: JPA = Java Persistence API,

//TODO: Entity ele e transforma uma classe em uma entidade do BD
@Entity

//TODO: tb = vem table - tabela
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    //TODO: @ManyToOne - um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")// Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}
