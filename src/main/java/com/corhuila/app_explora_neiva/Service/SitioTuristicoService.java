package com.corhuila.app_explora_neiva.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_explora_neiva.Entity.SitioTuristico;
import com.corhuila.app_explora_neiva.IRepository.IBaseRepository;
import com.corhuila.app_explora_neiva.IRepository.ISitioTuristicoRepository;
import com.corhuila.app_explora_neiva.IService.ISitioTuristicoService;

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
public class SitioTuristicoService extends ABaseService<SitioTuristico> implements ISitioTuristicoService {

    @Override
    protected IBaseRepository<SitioTuristico, Long> getRepository() {
        return repository;
    }

    @Autowired
    private ISitioTuristicoRepository repository;

    @Override
    public SitioTuristico save(SitioTuristico entity) {
        try {
            if (entity.getCode() == null || entity.getCode().isEmpty()) {
                entity.setCode(generateSiteCode(entity.getTitle()));
            }
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el sitio turístico", e);
        }
    }

    private String generateSiteCode(String title) {
        // Limpiar el título (remover acentos y caracteres especiales)
        String cleanedTitle = title.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        // Obtener las primeras 3 letras (o menos si el título es corto)
        String prefix = cleanedTitle.substring(0, Math.min(cleanedTitle.length(), 3));

        // Rellenar con X si el título tiene menos de 3 caracteres
        while (prefix.length() < 3) {
            prefix += "X";
        }

        // Obtener el timestamp y tomar los últimos 4 dígitos
        String timestamp = String.valueOf(System.currentTimeMillis());
        String suffix = timestamp.substring(timestamp.length() - 4);

        return prefix + "-" + suffix;
    }

}
