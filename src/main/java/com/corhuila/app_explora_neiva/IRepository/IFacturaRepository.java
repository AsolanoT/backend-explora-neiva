package com.corhuila.app_explora_neiva.IRepository;

import org.springframework.stereotype.Repository;

import com.corhuila.app_explora_neiva.Entity.Factura;

@Repository
public interface IFacturaRepository extends IBaseRepository<Factura, Long> {
    // Aquí puedes agregar métodos específicos para la entidad Factura si es
    // necesario

    boolean existsByReservacionId(Long reservacionId);

}
