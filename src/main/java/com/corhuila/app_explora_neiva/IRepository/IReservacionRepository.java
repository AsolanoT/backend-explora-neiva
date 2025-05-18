package com.corhuila.app_explora_neiva.IRepository;

import org.springframework.stereotype.Repository;

import com.corhuila.app_explora_neiva.Entity.Reservacion;

@Repository
public interface IReservacionRepository extends IBaseRepository<Reservacion, Long> {
    // Aquí puedes agregar métodos específicos para la entidad Reservacion si es
    // necesario
    // Por ejemplo, si necesitas un método para encontrar reservaciones por fecha o
    // usuario, puedes definirlo aquí.

}