package ar.edu.uade.tic.tesis.arweb.servicios;

public class Response<T> {
	public StatusCode statusCode;
	public String message;
    public T data;
     
     
    public StatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
