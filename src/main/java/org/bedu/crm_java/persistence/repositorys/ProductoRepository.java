package org.bedu.crm_java.persistence.repositorys;

import org.bedu.crm_java.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    
}
