package br.com.landucci.nuttrifit.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.Part;

public class NuttrifitHelper {

	public static final int TIPO_DOCUMENTO_CPF = 1;
	public static final int TIPO_DOCUMENTO_CNPJ = 2;
	
	public static final Locale LOCAL = new Locale("pt", "BR");
	public static final long DIA = 1000 * 60 * 60 * 24;
	private static final DateFormat dfFormatHour = new SimpleDateFormat("HH:mm");
	private static final DateFormat dfFormatDate = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat dfFormatDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static NumberFormat getNumberFormat() {
		return getNumberFormat(2, 2);
	}
	
	public static NumberFormat getNumberFormat(int minFractionDigits, int maxFractionDigits) {
		NumberFormat nfFormat = NumberFormat.getInstance(LOCAL);
		nfFormat.setMinimumFractionDigits(minFractionDigits);
		nfFormat.setMaximumFractionDigits(maxFractionDigits);
		return nfFormat;
	}
	
	public static NumberFormat getCurrencyFormat() {
		return getCurrencyFormat(2, 2);
	}
	
	public static NumberFormat getCurrencyFormat(int minFractionDigits, int maxFractionDigits) {
		NumberFormat nfFormat = NumberFormat.getCurrencyInstance(LOCAL);
		nfFormat.setMinimumFractionDigits(minFractionDigits);
		nfFormat.setMaximumFractionDigits(maxFractionDigits);
		return nfFormat;
	}
	
	public static DateFormat getHourFormat() {
		return dfFormatHour;
	}
	
	public static DateFormat getDateFormat() {
		return dfFormatDate;
	}
	
	public static DateFormat getDateTimeFormat() {
		return dfFormatDateTime;
	}	

	public static boolean isNulo(String valor) {
		return valor == null || valor.length() == 0;
	}

	public static boolean isNulo(Integer valor) {
		return valor == null || valor <= 0;
	}

	public static boolean isValidInteger(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isValidDate(String data) {
		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			return false;
		}
		
		String[] partes = data.split("/");
		int ultimoDia = 31;
		
		if (Integer.parseInt(partes[1]) < 1 || Integer.parseInt(partes[1]) > 12) {
			return false;
		}
		
		if (Integer.parseInt(partes[1]) == 2) {
			ultimoDia = (Integer.parseInt(partes[2]) % 4 == 0) ? 29 : 28;
		} else if (Integer.parseInt(partes[1]) == 4 || Integer.parseInt(partes[1]) == 6 || Integer.parseInt(partes[1]) == 9 || Integer.parseInt(partes[1]) == 11) {
			ultimoDia = 30;
		}
		
		if (Integer.parseInt(partes[0]) < 1 || Integer.parseInt(partes[0]) > ultimoDia) {
			return false;
		}
		
		return true;
	}

	public static Integer getUltimoDiaMes(String mes, String ano) {
		Calendar cal = GregorianCalendar.getInstance();
		int mesValido = isValidMonth(mes) ? Integer.parseInt(mes) : cal.get(Calendar.MONTH);
		int anoValido = isValidInteger(ano) ? Integer.parseInt(ano) : cal.get(Calendar.YEAR);
		cal.set(Calendar.MONTH, mesValido - 1);
		cal.set(Calendar.YEAR, anoValido);
		int ultimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return ultimoDia;
	}

	public static boolean isValidMonth(String valor) {
		boolean retorno = false;
		if (!isNulo(valor) && isValidInteger(valor)) {
			int mes = Integer.parseInt(valor);
			retorno = (mes >= 1 && mes <= 12);
		}
		return retorno;
	}
	
	public static boolean isNulo(Integer[] valor) {
		return valor == null || valor.length == 0;
	}

	public static boolean isValidInteger(Integer[] valor) {
		boolean retorno = false;
		if (!isNulo(valor)) {
			try {
				for (Integer i:valor) {
					Integer.parseUnsignedInt(i.toString());			
					retorno = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				retorno = false;
			}
		}
		return retorno;
	}
	
	public static String formatDocumentoCpf(String documento) {
		return documento.substring(0, 3) + "." + documento.substring(3, 6) + "." + documento.substring(6, 9) + "-" + documento.substring(9);
	}
	
	public static String formatDocumentoCnpj(String documento) {
		return documento.substring(0, 2) + "." + documento.substring(2, 5) + "." + documento.substring(5, 8) + "/" + documento.substring(8, 12) + "-" + documento.substring(12);
	}
	
	public static String removerAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
    
    public static File salvarArquivo(Part arquivo, String dirDestino) throws IOException {
		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		File retorno = null;

        try {
            String filename = getNomeArquivo(arquivo);
            String fileext = getExtensaoArquivo(filename);
            String nomeArquivo = UUID.randomUUID().toString();
            File dir = new File(dirDestino);
            if (!dir.exists()) {
            	dir.mkdirs();
            }

            File file = new File(dir, nomeArquivo + fileext);
            FileOutputStream fos = new FileOutputStream(file);
            inputStream = new BufferedInputStream(arquivo.getInputStream());
            outputStream = new BufferedOutputStream(fos);

            int x;
            while ((x = inputStream.read()) != -1) {
                outputStream.write(x);
            }
            retorno = new File(dirDestino + "/" + nomeArquivo + fileext);
        } finally {
       		outputStream.flush();
       		outputStream.close();
       		inputStream.close();
        }
        return retorno;
    }

    public static void excluirArquivo(File arquivo) throws IOException {
        if (arquivo != null && arquivo.exists()) {
        	arquivo.delete();
        }
    }

	public static String getNomeArquivo(String path) {
		if (path.indexOf(File.separator) < 0) {
			return "";
		}
		return path.substring(path.lastIndexOf(File.separator) + 1);
	}

	public static String getNomeArquivo(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

	public static String getExtensaoArquivo(String nomeArquivo) {
		if (nomeArquivo.indexOf('.') <= 0) {
			return "";
		}
		return nomeArquivo.substring(nomeArquivo.lastIndexOf('.'));
	}
}