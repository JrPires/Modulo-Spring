package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="tb_medico")
@NoArgsConstructor
@EqualsAndHashCode

public class Medico implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Não é Obrigatório")
	private String nome;
	
	@NotBlank(message="Email é obrigatório")
	private String email;
	
	@NotBlank(message="CRM é obrigatório")
	private String crm;

	 
}
