package dev.lara.learning.repository;

import dev.lara.learning.model.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
    //No se necesita implementar métodos, Spring Data JPA los genera solo.
}

/*
 * JpaRepository<Tarea, Long>
 *  Tarea: Tipo de entidad
 *  Long: Tipo de clave primaria
 */