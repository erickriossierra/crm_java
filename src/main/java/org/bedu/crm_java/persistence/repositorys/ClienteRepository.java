package org.bedu.crm_java.persistence.repositorys;

import org.bedu.crm_java.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
