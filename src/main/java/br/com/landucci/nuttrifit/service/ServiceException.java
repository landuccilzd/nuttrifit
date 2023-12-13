package br.com.landucci.nuttrifit.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 3593643030339434430L;

	public ServiceException() {}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}