package br.com.landucci.nuttrifit.dao.atendimento;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import br.com.landucci.nuttrifit.dao.DAOException;
import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.Pessoa;

@Repository
public class AtendimentoDAOImpl implements AtendimentoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void salvar(Atendimento atendimento) throws DAOException {
		this.manager.persist(atendimento);
	}
	
	@Override
	public void alterar(Atendimento atendimento) throws DAOException {
		this.manager.merge(atendimento);
	}
	
	@Override
	public void excluir(Atendimento atendimento) {
		this.manager.remove(atendimento);
	}

	@Override
	public Atendimento buscar(Long id) throws DAOException {
		return (Atendimento) this.manager.find(Atendimento.class, id);
	}

	@Override
	public List<Atendimento> listar() throws DAOException {
		return this.manager.createQuery("from Atendimento atendimento", Atendimento.class).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Atendimento> listarPorPaciente(Pessoa paciente) throws DAOException {
		StringBuffer sbHql = new StringBuffer("");
		sbHql.append("select atendimento");
		sbHql.append("  from Atendimento atendimento");
		sbHql.append(" where atendimento.paciente = :paciente");
		sbHql.append(" order by atendimento.data desc");
		
		Query query = this.manager.createQuery(sbHql.toString(), Atendimento.class);
		query.setParameter("paciente", paciente);
		List<Atendimento> retorno = query.getResultList();
		for (Atendimento atendimento: retorno) {
			Hibernate.initialize(atendimento.getComentarioList());
			Hibernate.initialize(atendimento.getPerguntaList());
			Hibernate.initialize(atendimento.getArquivoList());
		}
		return retorno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Atendimento> listarPorNutricionista(Pessoa nutricionista) throws DAOException {
		StringBuffer sbHql = new StringBuffer("");
		sbHql.append("select atendimento");
		sbHql.append("  from Atendimento atendimento");
		sbHql.append(" where atendimento.nutricionista = :nutricionista");
		sbHql.append(" order by atendimento.data desc");
		
		Query query = this.manager.createQuery(sbHql.toString(), Atendimento.class);
		query.setParameter("nutricionista", nutricionista);
		return query.getResultList();
	}	
}