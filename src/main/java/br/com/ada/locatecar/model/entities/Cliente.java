package br.com.ada.locatecar.model.entities;

import br.com.ada.locatecar.model.types.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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

    @NotEmpty(message = "Por favor, informe o tipo de cadastro do cliente")
    private String tipoDeCadastro;
    @NotEmpty(message = "Por favor, informe o nome do cliente")
    private String nome;
    @NotEmpty(message = "Por favor, informe o número do documento do cliente")
    @Digits(message = "Esse campo deve possuir apenas números", integer = 999999999, fraction = 0)
    @Column(unique = true)
    private String documento;
    @NotEmpty(message = "Por favor, informe o telefone de contato do cliente")
    @Digits(message = "Esse campo deve possuir apenas números", integer = 999999999, fraction = 0)
    @Size(min = 10, max = 11, message = "Atenção! Um telefone válido possui 10 ou 11 números")
    private String telefone;
    @Email(message = "Atenção! Informe um email válido")
    @NotEmpty(message = "Por favor, informe o email de contato do cliente")
    private String email;

    //TODO: private Endereco endereco;

}
