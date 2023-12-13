package br.com.landucci.nuttrifit.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.landucci.nuttrifit.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landucci.nuttrifit.service.antropometria.GrupoMedicaoService;
import br.com.landucci.nuttrifit.service.antropometria.ItemMedicaoService;
import br.com.landucci.nuttrifit.service.antropometria.PerfilMedicaoService;
import br.com.landucci.nuttrifit.service.atendimento.AtendimentoService;
import br.com.landucci.nuttrifit.service.pessoa.PessoaService;
import br.com.landucci.nuttrifit.service.regra.RegraService;
import br.com.landucci.nuttrifit.service.usuario.UsuarioService;

@Service
public class DataCreationService {
    PessoaService pessoaService;
    UsuarioService usuarioService;
    PerfilMedicaoService perfilMedicaoService;
    AtendimentoService atendimentoService;
    ItemMedicaoService itemMedicaoService;
    GrupoMedicaoService grupoMedicaoService;
    RegraService regraService;

    @Autowired
    public DataCreationService(PessoaService pessoaService, UsuarioService usuarioService, PerfilMedicaoService perfilMedicaoService,
                               AtendimentoService atendimentoService, ItemMedicaoService itemMedicaoService, GrupoMedicaoService grupoMedicaoService,
                               RegraService regraService) {
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.perfilMedicaoService = perfilMedicaoService;
        this.atendimentoService = atendimentoService;
        this.itemMedicaoService = itemMedicaoService;
        this.grupoMedicaoService = grupoMedicaoService;
        this.regraService = regraService;
    }

    public Pessoa createPessoa(String nome, Date dataNascimento, String cpf, String rg, String sexo, String endereco, String numero,
                               String complemento, String bairro, String cidade, String estado, String cep, String estadoCivil, Integer qtdeFilhos, String telefone,
                               String celular, String email, String tipo, Float altura, String login, String senha, Regra[] regras) {

        String slug = nome.substring(0, nome.indexOf(" ")) + "-" + nome.substring(nome.lastIndexOf(' ') + 1);

        var pessoa = new Pessoa();
        pessoa.setAvatar(slug + ".jpg");
        pessoa.setNome(nome);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setCpf(cpf);
        pessoa.setRg(rg);
        pessoa.setSexo(sexo);
        pessoa.setEndereco(endereco);
        pessoa.setEnderecoNumero(numero);
        pessoa.setEnderecoComplemento(complemento);
        pessoa.setEnderecoBairro(bairro);
        pessoa.setEnderecoCidade(cidade);
        pessoa.setEnderecoEstado(estado);
        pessoa.setEnderecoCep(cep);
        pessoa.setEstadoCivil(estadoCivil);
        pessoa.setQtdeFilhos(qtdeFilhos);
        pessoa.setTelefone(telefone);
        pessoa.setCelular(celular);
        pessoa.setEmail(email);
        pessoa.setFacebook("http://www.facebook.com/" + slug);
        pessoa.setTwitter("http://www.twitter.com/" + slug);
        pessoa.setTipo(tipo);
        pessoa.setAltura(altura);
        try {
            pessoaService.salvar(pessoa);
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }

        var usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setAtivo(true);
        usuario.setBloqueado(false);
        usuario.setPessoa(pessoa);

        for (Regra regra : regras) {
            usuario.getRegras().add(regra);
        }

        try {
            usuarioService.salvar(usuario);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        pessoa.setUsuario(usuario);
        try {
            pessoaService.salvar(pessoa);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return pessoa;
    }

    public PerfilMedicao createPerfilMedicao(String descricao) {
        var perfilMedicao = new PerfilMedicao();
        perfilMedicao.setDescricao(descricao);

        try {
            perfilMedicaoService.salvar(perfilMedicao);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return perfilMedicao;
    }

    public GrupoMedicao createGrupoMedicao(PerfilMedicao perfilMedicao, String descricao, Integer ordem) {
        var grupoMedicao = new GrupoMedicao();
        grupoMedicao.setPerfilMedicao(perfilMedicao);
        grupoMedicao.setDescricao(descricao);
        grupoMedicao.setOrdem(ordem);

        try {
            grupoMedicaoService.salvar(grupoMedicao);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return grupoMedicao;
    }

    public ItemMedicao createItemMedicao(GrupoMedicao grupoMedicao, String descricao, Integer ordem) {
        var itemMedicao = new ItemMedicao();
        itemMedicao.setGrupoMedicao(grupoMedicao);
        itemMedicao.setDescricao(descricao);
        itemMedicao.setOrdem(ordem);

        try {
            itemMedicaoService.salvar(itemMedicao);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return itemMedicao;
    }

    public Atendimento createAtendimento(Pessoa nutricionista, Pessoa paciente) {
        var atendimento = new Atendimento();

        var localDateTime = LocalDateTime.now();
        atendimento.setObservacao("Criado com o gerador de massa de dados");
        atendimento.setObservacaoRestrita("Criado com o gerador de massa de dados - Restrito");
        atendimento.setCardapio(null);
        atendimento.setData(localDateTime);
        atendimento.setNutricionista(nutricionista);
        atendimento.setPaciente(paciente);
        atendimento.setMedicao(null);

        try {
            atendimentoService.salvar(atendimento);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return atendimento;
    }

    public Regra createRegra(String rule) {
        var regra = new Regra(rule);
        try {
            regraService.salvar(regra);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return regra;
    }
}