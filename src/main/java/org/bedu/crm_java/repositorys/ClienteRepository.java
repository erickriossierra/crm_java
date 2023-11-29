package org.bedu.crm_java.repositorys;

import org.bedu.crm_java.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
