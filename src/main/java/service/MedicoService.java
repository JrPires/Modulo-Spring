package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Medico;
import repository.MedicoRepository;

public class MedicoService {
	
	@Autowired
	private MedicoRepository repository;
	
	public void save(Medico medico) {
		this.repository.save(medico);
	}
	
	public List<Medico> listar(){
		return repository.findAll();
	}
}
