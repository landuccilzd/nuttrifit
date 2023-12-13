package br.com.landucci.nuttrifit.dao.atendimento;

import java.util.List;

import br.com.landucci.nuttrifit.dao.DAOException;
import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.Pessoa;

public interface AtendimentoDAO {
	public void salvar(Atendimento atendimento) throws DAOException;
	public void alterar(Atendimento atendimento) throws DAOException;
	public void excluir(Atendimento atendimento) throws DAOException;
	public Atendimento buscar(Long id) throws DAOException;
	public List<Atendimento> listar() throws DAOException;
	public List<Atendimento> listarPorPaciente(Pessoa paciente) throws DAOException;
	public List<Atendimento> listarPorNutricionista(Pessoa nutricionista) throws DAOException;
}
