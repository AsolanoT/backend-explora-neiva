package com.corhuila.app_explora_neiva.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.app_explora_neiva.Entity.SitioTuristico;
import com.corhuila.app_explora_neiva.IService.ISitioTuristicoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/sitioTuristico")
public class SitioTuristicoController extends ABaseController<SitioTuristico, ISitioTuristicoService> {

    public SitioTuristicoController(ISitioTuristicoService service) {
        super(service, "SitioTuristico");
    }
}
/*
 * Anotación @CrossOrigin: Permite solicitudes desde cualquier origen (origins =
 * "*") para habilitar CORS (Cross-Origin Resource Sharing). Esto es útil cuando
 * el frontend y el backend están en dominios diferentes.
 * 
 * Anotación @RestController: Marca esta clase como un controlador REST, lo que
 * significa que manejará solicitudes HTTP y devolverá respuestas en formato
 * JSON o similar.
 * 
 * Anotación @RequestMapping: Define la ruta base para todas las solicitudes que
 * manejará este controlador. En este caso, todas las rutas comenzarán con
 * api/v1/continent.
 * 
 * Herencia de ABaseController: La clase extiende ABaseController, lo que
 * sugiere que hereda funcionalidad genérica para manejar entidades del tipo
 * Continent. Esto incluye operaciones comunes como crear, leer, actualizar y
 * eliminar (CRUD).
 * 
 * Constructor: El constructor recibe un servicio (IContinentService) que se
 * pasa a la clase base (ABaseController). Este servicio probablemente contiene
 * la lógica de negocio para manejar la entidad Continent.
 * 
 * En resumen, este controlador actúa como un intermediario entre las
 * solicitudes HTTP y la lógica de negocio para la entidad Continent.
 */