package br.com.landucci.nuttrifit.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.landucci.nuttrifit.modelo.Atendimento;
import br.com.landucci.nuttrifit.modelo.GrupoMedicao;
import br.com.landucci.nuttrifit.modelo.ItemMedicao;
import br.com.landucci.nuttrifit.modelo.PerfilMedicao;
import br.com.landucci.nuttrifit.modelo.Pessoa;
import br.com.landucci.nuttrifit.modelo.Regra;
import br.com.landucci.nuttrifit.service.DataCreationService;
import br.com.landucci.nuttrifit.util.NuttrifitHelper;

@Controller
@Transactional
@RequestMapping("/")
public class HomeController {


    private DataCreationService service;

    @Autowired
    public HomeController(DataCreationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, name = "index")
	public String index(Model model) {
		return "/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/create-data", method = RequestMethod.GET, name = "createData")
	public ModelAndView createData(RedirectAttributes redirectAttributes) {
		ModelAndView retorno = new ModelAndView("/index");
		
		System.out.println("Iniciando a criação de dados");
		
		System.out.println("Criando regras...");
		Regra regraAdmin = service.createRegra("ROLE_ADMIN");
		Regra regraPaciente = service.createRegra("ROLE_PACIENTE");
		Regra regraNutricionista = service.createRegra("ROLE_NUTRICIONISTA");
		
		System.out.println("Criando usuários...");
		Calendar c = Calendar.getInstance(NuttrifitHelper.LOCAL);
		c.set(1981, Calendar.OCTOBER, 27);
		Pessoa pessoa1 = service.createPessoa("Cristóvão Louzada", c.getTime(), "036.319.419-35", "7.262.587-0", "M", "Rua Ernâni Lacerda de Athayde", "1260",
				"Bl. 12 - Ap. 23", "Gleba Palhano", "Londrina", "PR", "86055-630", "D", 0, "(43) 3322-9799", "(43) 9166-5887",
				"clouzada81@hotmail.com", "P", 1.8f, "clouzada81", DigestUtils.md5DigestAsHex("123".getBytes()), new Regra[] {regraAdmin, regraPaciente});

		c.set(1986, Calendar.JULY, 31);
		Pessoa pessoa2 = service.createPessoa("Bruna Kananda Pereira Sevilha", c.getTime(), "356.051.528-90", "27.676.746-9", "F", "Rua Ernâni Lacerda de Athayde", "1260",
				"Bl. 12 - Ap. 23", "Gleba Palhano", "Londrina", "PR", "86055-630", "S", 0, "(43) 3322-9799", "(43) 9166-0133",
				"brunasevilha@hotmail.com", "P", 1.59f, "bsevilha", DigestUtils.md5DigestAsHex("123".getBytes()), new Regra[] {regraPaciente});
		
		c.set(1981, Calendar.AUGUST, 30);
		Pessoa pessoa3 = service.createPessoa("Silvia Mayumi Adanya", c.getTime(), "517.808.988-00", "1.234.567-8", "M", "Rua Paranaguá", "450",
				"Ap. 1401", "Centro", "Londrina", "PR", "86020-030", "S", 0, "(43) 9999-9999", "(43) 8424-4566",
				"silviamayumi.nutri@gmail.com", "N", 1.75f, "sadanya", DigestUtils.md5DigestAsHex("123".getBytes()), new Regra[] {regraAdmin, regraNutricionista});
		
		System.out.println("Criando perfis de medição...");
        PerfilMedicao pmAntropometria = service.createPerfilMedicao("Antropometria");
        
        System.out.println("Criando grupos de medição...");
        GrupoMedicao gmGeral = service.createGrupoMedicao(pmAntropometria, "Geral", 1);
        GrupoMedicao gmCircunferencia = service.createGrupoMedicao(pmAntropometria, "Circunferências", 2);
        GrupoMedicao gmPregasCutaneas = service.createGrupoMedicao(pmAntropometria, "Pregas Cutâneas", 3);
        GrupoMedicao gmOutros = service.createGrupoMedicao(pmAntropometria, "Outros", 4);
		

        System.out.println("Criando itens de medicacao...");
        ItemMedicao imPeso = service.createItemMedicao(gmGeral, "Peso", 1);
        ItemMedicao imImc = service.createItemMedicao(gmGeral, "IMC", 2);
        ItemMedicao imPesoGorduraCorporal = service.createItemMedicao(gmGeral, "Peso Gordura Corporal", 3);
        ItemMedicao imPesoMassaMuscular = service.createItemMedicao(gmGeral, "Peso Massa Muscular", 4);
        ItemMedicao imGorduraViceral = service.createItemMedicao(gmGeral, "Gordura Viceral", 5);

        ItemMedicao itemMedicao5 = service.createItemMedicao(gmCircunferencia, "Circunferência antebraço direito", 1);
        ItemMedicao itemMedicao6 = service.createItemMedicao(gmCircunferencia, "Circunferência antebraço esquerdo", 2);
        ItemMedicao itemMedicao7 = service.createItemMedicao(gmCircunferencia, "Circunferência braço direito - Relaxado", 3);
        ItemMedicao itemMedicao8 = service.createItemMedicao(gmCircunferencia, "Circunferência braço esquerdo - Relaxado", 4);
        ItemMedicao itemMedicao9 = service.createItemMedicao(gmCircunferencia, "Circunferência braço direito - Contraído", 5);
        ItemMedicao itemMedicao10 = service.createItemMedicao(gmCircunferencia, "Circunferência braço esquerdo - Contraído", 6);
        ItemMedicao itemMedicao11 = service.createItemMedicao(gmCircunferencia, "Circunferência ombro", 7);
        ItemMedicao itemMedicao12 = service.createItemMedicao(gmCircunferencia, "Circunferência cintura", 8);
        ItemMedicao itemMedicao13 = service.createItemMedicao(gmCircunferencia, "Circunferência abdômen", 9);
        ItemMedicao itemMedicao14 = service.createItemMedicao(gmCircunferencia, "Circunferência quadril", 10);
        ItemMedicao itemMedicao15 = service.createItemMedicao(gmCircunferencia, "Circunferência coxa direita", 11);
        ItemMedicao itemMedicao16 = service.createItemMedicao(gmCircunferencia, "Circunferência coxa esquerda", 12);
        ItemMedicao itemMedicao17 = service.createItemMedicao(gmCircunferencia, "Circunferência panturrilha direita", 13);
        ItemMedicao itemMedicao18 = service.createItemMedicao(gmCircunferencia, "Circunferência panturrilha esquerda", 14);

        ItemMedicao itemMedicao19 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas tríceps", 1);
        ItemMedicao itemMedicao20 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas bíceps", 2);
        ItemMedicao itemMedicao21 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas subescapular", 3);
        ItemMedicao itemMedicao22 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas supra iliaca", 4);
        ItemMedicao itemMedicao23 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas abdominal", 5);
        ItemMedicao itemMedicao24 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas axilar", 6);
        ItemMedicao itemMedicao25 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas peitoral", 7);
        ItemMedicao itemMedicao26 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas coxa med", 8);
        ItemMedicao itemMedicao27 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas panturrilha", 9);
        ItemMedicao itemMedicao28 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas axila medial", 10);
        ItemMedicao itemMedicao29 = service.createItemMedicao(gmPregasCutaneas, "Pregas cutâneas abdominal inferior", 11);        
        
        Atendimento atendimento1 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento2 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento3 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento4 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento5 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento6 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento7 = service.createAtendimento(pessoa3, pessoa1);
        Atendimento atendimento8 = service.createAtendimento(pessoa3, pessoa1);
        
		redirectAttributes.addFlashAttribute("msgSucesso", "Massa de dados criada com sucesso.");
		return retorno;        
	}	
}