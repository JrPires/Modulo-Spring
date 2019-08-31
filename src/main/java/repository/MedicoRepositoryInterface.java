package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Medico;

public interface MedicoRepositoryInterface extends JpaRepository<Medico, Long> {

	
}
