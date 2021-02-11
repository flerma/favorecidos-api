package br.com.favorecido.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FAVORECIDO")
public class Favorecido implements Serializable {

	private static final long serialVersionUID = 3608378776646013228L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private long codigo;
	
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@NotNull
	@Column(name="CPF_CNPJ")
	private String cpfCnpj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cpf_cnpj", referencedColumnName="cpf_cnpj", insertable=false, updatable=false)
	private Cliente cliente;
	
}
