package com.corhuila.app_explora_neiva.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_explora_neiva.Entity.Factura;
import com.corhuila.app_explora_neiva.Entity.Reservacion;
import com.corhuila.app_explora_neiva.IRepository.IBaseRepository;
import com.corhuila.app_explora_neiva.IRepository.IFacturaRepository;
import com.corhuila.app_explora_neiva.IService.IFacturaService;
import com.corhuila.app_explora_neiva.IService.IReservacionService;

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
public class FacturaService extends ABaseService<Factura> implements IFacturaService {

    @Override
    protected IBaseRepository<Factura, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IFacturaRepository repository;

    /**
     * Servicio para gestionar las operaciones relacionadas con las facturas.
     * Extiende de ABaseService y utiliza un repositorio específico para Factura.
     * 
     * Métodos principales:
     * - save(Factura factura): Guarda una factura en la base de datos. Calcula el
     * monto total
     * basado en el precio del sitio turístico y la cantidad de personas en la
     * reservación.
     * También genera un número de factura único y establece la fecha de emisión.
     * - generarNumeroFactura(): Genera un número de factura único en formato
     * "FA-xxx
     * donde xxx es incremental basado en la cantidad de facturas
     * existentes.
     * 
     * Notas:
     * - Si la reservación o el sitio turístico asociado a la factura es nulo, se
     * lanza una excepción.
     * - Utiliza inyección de dependencias para acceder al repositorio
     * IFacturaRepository.
     */
    @Autowired
    private IReservacionService reservacionService;

    @Override
    public Factura save(Factura entity) throws Exception {
        if (entity.getReservacion() == null || entity.getReservacion().getId() == null) {
            throw new Exception("La reservación no puede ser nula.");
        }
        Long reservacionId = entity.getReservacion().getId();

        // Validación: ya existe una factura para esta reservación
        if (((IFacturaRepository) repository).existsByReservacionId(reservacionId)) {
            throw new Exception("Ya existe una factura asociada a esta reservación.");
        }

        // ✅ Obtén la reservación completa usando el servicio
        Reservacion reservacion = reservacionService.findById(entity.getReservacion().getId());

        // Asegúrate de que tenga un sitio turístico
        if (reservacion.getSitioTuristico() == null) {
            throw new Exception("La reservación no tiene un sitio turístico asociado.");
        }

        // Calcula el monto total
        double montoTotal = reservacion.getSitioTuristico().getPrice() * reservacion.getNumeroPersonas();
        entity.setMontoTotal(montoTotal);

        // Genera el número de factura y fecha
        entity.setNumeroFactura(generarNumeroFactura());
        entity.setFechaEmision(LocalDateTime.now());

        return repository.save(entity);
    }

    @Override
    public String generarNumeroFactura() {
        long count = repository.count(); // cantidad actual
        long siguiente = count + 1;
        return String.format("FA-%03d", siguiente); // FA-001, FA-002...
    }

}
