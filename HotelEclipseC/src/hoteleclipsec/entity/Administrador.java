package hoteleclipsec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrador {
		@Id
		private Long id;
		private String nome;
		private String senha;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
	}

