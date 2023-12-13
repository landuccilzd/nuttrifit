package br.com.landucci.nuttrifit.service.atendimento;

import java.util.List;

import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.Pessoa;
import br.com.landucci.nuttrifit.service.ServiceException;

public interface AtendimentoService {
	public Atendimento buscar(Long id) throws ServiceException;
	public List<Atendimento> listar() throws ServiceException;
	public List<Atendimento> listarPorPaciente(Pessoa paciente) throws ServiceException;
	public List<Atendimento> listarPorNutricionista(Pessoa nutricionista) throws ServiceException;
	public void salvar(Atendimento atendimento) throws ServiceException;
	public void alterar(Atendimento atendimento) throws ServiceException;
	public void excluir(Atendimento atendimento) throws ServiceException;
}