package com.corhuila.app_explora_neiva.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.app_explora_neiva.Entity.ABaseEntity;

@Repository
public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long> {

}
