package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer> {

	public abstract List<Modalidad> findByNombreContaining(@Param("p_nom") String nombre);

	@Query("select m from Modalidad m where "
			+ "( :#{#fil.nombre} is '' or m.nombre like :#{#fil.nombre} ) and "
			+ "( :#{#fil.numHombres} is 0 or m.numHombres = :#{#fil.numHombres} ) and "
			+ "( :#{#fil.sede} is ''  or m.sede like :#{#fil.sede} ) ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);
}
