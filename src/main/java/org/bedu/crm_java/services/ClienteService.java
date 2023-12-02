package org.bedu.crm_java.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bedu.crm_java.controller.mappers.ClienteMapper;
import org.bedu.crm_java.model.Cliente;
import org.bedu.crm_java.persistence.repositorys.ClienteRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public Cliente guardarCliente(Cliente cliente){
        return clienteMapper.clienteEntityToClienteModel(
                    clienteRepository.save(
                        clienteMapper.clienteModelToClienteEntity(
                            cliente)));
    }

    public List<Cliente> obtenerClientes(){
        return clienteRepository
            .findAll()
            .stream()
            .map(cliente -> clienteMapper
                .clienteEntityToClienteModel(cliente))
                .collect(Collectors.toList());
    }

    public Optional<Cliente> obtenerCliente(Long id){
        return clienteRepository.findById(id)
        .map(cliente -> Optional.of(
            clienteMapper
                .clienteEntityToClienteModel(cliente)))
        .orElse(Optional.empty())
        ;
    }

    public void eliminnarCliente(Long id){
       clienteRepository.deleteById(id);
    }

    public Cliente actualizarCliente(Cliente cliente){
        return clienteMapper
            .clienteEntityToClienteModel(clienteRepository
                .save(clienteMapper
                    .clienteModelToClienteEntity(cliente))
        );
    }

    public Long contadorClientes(){
        return clienteRepository.count();
    }

}
