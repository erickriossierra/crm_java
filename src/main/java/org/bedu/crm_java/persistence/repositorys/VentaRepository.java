package org.bedu.crm_java.persistence.repositorys;

import org.bedu.crm_java.persistence.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
    
}
