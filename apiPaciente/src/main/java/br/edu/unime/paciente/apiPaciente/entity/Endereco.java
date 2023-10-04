package br.edu.unime.paciente.apiPaciente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String Logradouro;

    private int Numero;

    private String Bairro;

    private String CEP;

    private String Municipio;

    private String Estado;

}
