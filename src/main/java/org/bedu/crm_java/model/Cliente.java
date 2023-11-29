package org.bedu.crm_java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Clientes")

@NoArgsConstructor
public class Cliente {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del cliente debe tener al menos 5 letras y ser menor a 30")
    private String nombre;

    @Column(name = "correo_cliente")
    @Email
    private String correoContacto;

    @Column(name = "numero_empleados")
    @Min(value = 10, message = "Los clientes con menos de 10 empleados no son válidos")
    @Max(value = 10000, message = "Los clientes con más de 10000 empleados no son válidos")
    private String numeroEmpleados;

    
    @NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;
}
