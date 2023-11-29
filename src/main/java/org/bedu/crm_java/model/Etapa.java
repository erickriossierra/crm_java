package org.bedu.crm_java.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="Etapas")
@Entity
@NoArgsConstructor
public class Etapa {
    @PositiveOrZero(message = "El identificador de la etapa no puede ser un número negativo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    @NotEmpty(message = "El nombre de la etapa no puede estar en blanco.")
    @Size(min = 4, max = 30, message = "El nombre de la etapa debe tener entre 4 y 30 letras.")
    private String nombre;

    @Positive(message = "La etapa debe tener un orden positivo mayor a cero")
    private int orden;
}
