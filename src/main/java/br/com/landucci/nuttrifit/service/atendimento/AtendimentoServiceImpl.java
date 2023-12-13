package br.com.landucci.nuttrifit.service.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.dao.DAOException;
import br.com.landucci.nuttrifit.dao.atendimento.AtendimentoDAO;
import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.Pessoa;
import br.com.landucci.nuttrifit.service.ServiceException;

@Service
public class AtendimentoServiceImpl implements AtendimentoService {
	
	@Autowired
	private AtendimentoDAO atendimentoDao;
	
	public Atendimento buscar(Long id) throws ServiceException {
		try {
			return this.atendimentoDao.buscar(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Atendimento> listar() throws ServiceException {
		try {
			return this.atendimentoDao.listar();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Atendimento> listarPorPaciente(Pessoa paciente) throws ServiceException {
		try {
			return this.atendimentoDao.listarPorPaciente(paciente);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Atendimento> listarPorNutricionista(Pessoa nutricionista) throws ServiceException {
		try {
			return this.atendimentoDao.listarPorNutricionista(nutricionista);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}	

	public void salvar(Atendimento atendimento) throws ServiceException {
		try {
			this.atendimentoDao.salvar(atendimento);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void alterar(Atendimento atendimento) throws ServiceException {
		try {
			this.atendimentoDao.alterar(atendimento);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void excluir(Atendimento atendimento) throws ServiceException {
		try {
			this.atendimentoDao.excluir(atendimento);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}