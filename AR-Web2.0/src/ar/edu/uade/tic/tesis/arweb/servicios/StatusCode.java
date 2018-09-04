package ar.edu.uade.tic.tesis.arweb.servicios;

public enum StatusCode {
	Success(200),
	NotContent(204),
	Unauthorized(401),
	Badrequest(400),
	InternalServerError(500);
	        
	        
	private int codigo;
		
	StatusCode(int cod){
		codigo = cod;
	}
	
	public int codigo() {
        return codigo;
    }
	
}
