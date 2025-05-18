package com.corhuila.app_explora_neiva.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_explora_neiva.Entity.Cliente;
import com.corhuila.app_explora_neiva.IRepository.IBaseRepository;
import com.corhuila.app_explora_neiva.IRepository.IClienteRepository;
import com.corhuila.app_explora_neiva.IService.IClienteService;

/**
 * Servicio para la gestión de continentes en la aplicación.
 * 
 * Esta clase extiende de ABaseService y utiliza el repositorio
 * IContinentRepository
 * para realizar operaciones CRUD sobre la entidad Continent.
 * Métodos:
 * - getRepository(): Retorna el repositorio específico para la entidad
 * Continent.
 * Anotaciones:
 * - @Service: Marca esta clase como un componente de servicio en el contexto de
 * Spring.
 * - @Autowired: Inyecta automáticamente la dependencia del repositorio
 * IContinentRepository.
 * Implementa:
 * - IContinentService: Interfaz que define las operaciones específicas para
 * continentes.
 */
@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService {

    @Override
    protected IBaseRepository<Cliente, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IClienteRepository repository;
}
