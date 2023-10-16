package br.com.fiap.hospitalconsulta.consulta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "o campo nome paciente é obrigatório")
    String nomePaciente;

    @NotBlank(message = "o campo nome médico é obrigatório")
    String nomeMedico;

    @Size(min = 5, message = "a descrição deve ter pelo menos 5 caracteres")
    String especialidade;

    @NotBlank(message = "o campo título é obrigatório")
    String local;

}
