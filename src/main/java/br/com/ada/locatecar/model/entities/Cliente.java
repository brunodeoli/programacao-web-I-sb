package br.com.ada.locatecar.model.entities;

import br.com.ada.locatecar.model.types.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = true)
    private String tipoDeCadastro;
    @Column(nullable = true)
    private String nome;
    @Column(unique = true)
    private String documento;
    @Column(nullable = true, length = 11)
    private String telefone;
    private String email;

    //TODO: private Endereco endereco;

}
