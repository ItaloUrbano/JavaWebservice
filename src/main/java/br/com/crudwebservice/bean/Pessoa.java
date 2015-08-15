package br.com.crudwebservice.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pessoa")
	@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
	private Integer id;

	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
