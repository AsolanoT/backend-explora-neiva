package com.corhuila.app_explora_neiva.IRepository;

import org.springframework.stereotype.Repository;

import com.corhuila.app_explora_neiva.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long> {

}
