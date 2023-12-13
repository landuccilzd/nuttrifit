package br.com.landucci.nuttrifit.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class MailHelper {
	
	public void enviarEmailTexto(String remetente, String[] destinatarios, String[] copias, String[] copiasOcultas, String assunto, String mensagem) throws UtilException {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			Session mailSession = (Session) envContext.lookup("mail/nuttrifit");
			Properties properties = mailSession.getProperties();
			
			Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
			SimpleEmail email = new SimpleEmail();
			email.setMailSession(mailSession);
			email.setFrom((remetente != null) ? remetente : properties.getProperty("mail.smtp.user"), "Sistema Nuttrifit");
			
			for (String destinatario: destinatarios) {
				email.addTo(destinatario);
			}
			for (String copia: copias) {
				email.addCc(copia);
			}
			for (String copiaOculta: copiasOcultas) {
				email.addBcc(copiaOculta);
			}
			
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.setSentDate(c.getTime());
			email.send();
		} catch(Exception e) {
			throw new UtilException(e);
		}
	}
	
	public void enviarEmailHTML(String remetente, String[] destinatarios, String[] copias, String[] copiasOcultas, String assunto, String mensagem) throws UtilException {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			Session mailSession = (Session) envContext.lookup("mail/nuttrifit");
			Properties properties = mailSession.getProperties();
			
			Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
			HtmlEmail email = new HtmlEmail();
			email.setMailSession(mailSession);
			email.setFrom((remetente != null) ? remetente : properties.getProperty("mail.smtp.user"), "Sistema Nuttrifit");
			
			for (String destinatario: destinatarios) {
				email.addTo(destinatario);
			}
			for (String copia: copias) {
				email.addCc(copia);
			}
			for (String copiaOculta: copiasOcultas) {
				email.addBcc(copiaOculta);
			}
			
			email.setSubject(assunto);
			email.setHtmlMsg(mensagem);
			email.setSentDate(c.getTime());
			email.send();
		} catch(Exception e) {
			throw new UtilException(e);
		}
	}
	
	public void enviarEmailHTML(String remetente, String[] destinatarios, String[] copias, String[] copiasOcultas, String assunto, File template, Map<String, String> parametros) throws UtilException {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			Session mailSession = (Session) envContext.lookup("mail/nuttrifit");
			Properties properties = mailSession.getProperties();
			
			Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
			HtmlEmail email = new HtmlEmail();
			email.setMailSession(mailSession);
			email.setFrom((remetente != null) ? remetente : properties.getProperty("mail.smtp.user"), "Sistema Nuttrifit");
			
			for (String destinatario: destinatarios) {
				email.addTo(destinatario);
			}
			for (String copia: copias) {
				email.addCc(copia);
			}
			for (String copiaOculta: copiasOcultas) {
				email.addBcc(copiaOculta);
			}

			String mensagem = getMessageFromFile(template, parametros);
			
			email.setSubject(assunto);
			email.setHtmlMsg(mensagem);
			email.setSentDate(c.getTime());
			email.send();
		} catch(Exception e) {
			throw new UtilException(e);
		}
	}
	
	@SuppressWarnings("resource")
	private String getMessageFromFile(File template, Map<String, String> parametros) throws UtilException {
		try {
			StringBuffer retorno = new StringBuffer();
			if (template == null) {
				throw new UtilException("O template informado n�o existe.");	
			}
			
			FileReader fr = new FileReader(template);
			BufferedReader br = new BufferedReader(fr);
			
			var linha = br.readLine();
			while (!NuttrifitHelper.isNulo(linha)) {
				for (String chave: parametros.keySet()) {
					String key = "@{" + chave + "}";
					if (linha.contains(key)) {
						linha = linha.replaceAll("@\\{" + chave + "\\}", parametros.get(chave));
					}
				}
				retorno.append(linha);
				linha = br.readLine();
			}
			return retorno.toString();
		} catch (IOException e) {
			throw new UtilException("O template informado n�o existe ou est� inacess�vel.");
		}
	}
}