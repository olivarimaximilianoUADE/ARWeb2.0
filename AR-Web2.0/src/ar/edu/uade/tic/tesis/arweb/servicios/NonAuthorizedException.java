package ar.edu.uade.tic.tesis.arweb.servicios;

public class NonAuthorizedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonAuthorizedException() {
	}
	
	public NonAuthorizedException(String message)
    {
		super(message);
    }
	
	public NonAuthorizedException(String message, Throwable throwable)
    {
		super(message, throwable);
    }
}
