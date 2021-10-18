package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;
import com.empresa.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService {

	@Autowired
	private ModalidadRepository repositorio;

	@Override
	public Modalidad insertaActualizaModalidad(Modalidad obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Modalidad> listaModalidad() {
		return repositorio.findAll();
	}


	@Override
	public List<Modalidad> ListaModalidadNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreContaining(nombre);
	}


	@Override
	public List<Modalidad> ListaModalidadFiltro(FiltroModalidad filtro) {
		// TODO Auto-generated method stub
		return repositorio.listaPorFiltro(filtro);
	}

		

}
