package org.bedu.crm_java.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "CLIENTES")
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteId")
    private Long id;

    private String nombre;

    @Column(name = "correo_contacto", nullable = false)
    private String correoContacto;

    @Column(name = "numero_empleados")
    private String numeroEmpleados;

    private String direccion;
    
}
