package br.com.crudwebservice.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.crudwebservice.bean.Pessoa;
import br.com.crudwebservice.business.PessoaBusiness;

@Path("/pessoaResource")
public class PessoaResource {

	@Inject
	private PessoaBusiness pessoaBusiness;

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String adicionaPessoa(Pessoa pessoa) {
		pessoaBusiness.insert(pessoa);
		return "Adicionado com sucesso";
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaPessoa(Pessoa pessoa, @PathParam("id") int id) {
		Pessoa p = pessoaBusiness.findByPk(id);
		p.setNome(pessoa.getNome());
		pessoaBusiness.update(p);
		return "Atualizado com sucesso";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removePessoa(@PathParam("id") int id) {
		Pessoa pessoa = pessoaBusiness.findByPk(id);
		pessoaBusiness.delete(pessoa);
		return "Deletado com sucesso";
	}

	@Path("/getAll")
	@GET
	@Produces("application/json")
	public List<Pessoa> getAll() {
		return pessoaBusiness.findAll();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Pessoa findByPK(@PathParam("id") int id) {
		return pessoaBusiness.findByPk(id);
	}

}
