package ar.edu.uade.tic.tesis.arweb.servicios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import ar.edu.uade.tic.tesis.arweb.util.exportador.ExportadorAnexoPDF;
import ar.edu.uade.tic.tesis.arweb.util.exportador.ExportadorDetallePDF;
import ar.edu.uade.tic.tesis.arweb.util.exportador.ExportadorDetalleXLS;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import ar.edu.uade.tic.tesis.arweb.util.utilidades.Utilidades;
import ar.edu.uade.tic.tesis.arweb.controlador.GestorBaseDatos;
import ar.edu.uade.tic.tesis.arweb.controlador.TipoValidacion;
import ar.edu.uade.tic.tesis.arweb.db.AnalisisDAO;
import ar.edu.uade.tic.tesis.arweb.modelo.base.Estructura;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.guia.WCAG20;
import ar.edu.uade.tic.tesis.arweb.modelo.principios.Principio;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;

@Path("/ValidarAccesibilidadService")
public class ValidarAccesibilidadService{
	
	@POST
	@Path("/validarUrl")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<List<String>> validarUrl(@Context HttpHeaders httpheaders, Validacion validacion) {
		Response<List<String>> resp = new Response<List<String>>();
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");
				
			Parseador parseador = null;
			
			if (validacion.getUrl().equals("") || validacion.getUrl().equals("http://"))
				throw new Exception("Complete el campo URL.");
			validacion.setUrl(Utilidades.completarURL(validacion.getUrl()));
			parseador = new Parseador(new URL(validacion.getUrl()));
			
			List<String> listaUrls = new ArrayList<String>();
			
			HashMap<Integer, List<String>> mapaURL = Parseador.getURLs(parseador, 1);
			listaUrls.add(Utilidades.completarURL(validacion.getUrl()));
			for (Integer nivel : mapaURL.keySet()) {
				for (String url : mapaURL.get(nivel))
					if (url.length() <= 120)
						listaUrls.add(url);
			}
			 
			resp.setData(listaUrls);
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		
		return resp;
	}
		
	@POST
	@Path("/validarByUrl")
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Resultado> validarByUrl(@Context HttpHeaders httpheaders, Validacion validacion) {
		Response<Resultado> resp = new Response<Resultado>();
		
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");
				
			//Validacion
			Parseador parseador = null;
			
			if (validacion.getUrl().equals("") || validacion.getUrl().equals("http://"))
				throw new Exception("Complete el campo URL.");
			validacion.setUrl(Utilidades.completarURL(validacion.getUrl()));
			parseador = new Parseador(new URL(validacion.getUrl()));
			
			resp.setData(generarResultado(parseador, validacion, properties, TipoValidacion.PAGINA_WEB));
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		
		return resp;
	}
	
	@POST
	@Path("/validarByFile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Resultado> validarByFile(@Context HttpHeaders httpheaders, Validacion validacion) {
		Response<Resultado> resp = new Response<Resultado>();
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");

			if (validacion.getUrl().equals(""))
				throw new Exception("Complete el campo URL.");
			
			byte[] byteArray = Base64.getEncoder().encode(validacion.getUrl().getBytes());
			
			File tempFile = File.createTempFile("temp", ".temp");
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(byteArray);
			fos.close();
			
			Parseador parseador = null;
			parseador = new Parseador(tempFile);//new File(validacion.getUrl()));
			
			resp.setData(generarResultado(parseador, validacion, properties, TipoValidacion.ARCHIVO));
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		
		return resp;
	}
	
	@POST
	@Path("/validarByHTML")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response<Resultado> validarByHTML(@Context HttpHeaders httpheaders, Validacion validacion) {
		Response<Resultado> resp = new Response<Resultado>();
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");
			
			if (validacion.getUrl().equals(""))
				throw new Exception("Complete el campo URL.");
			
			Parseador parseador = null;
			parseador = new Parseador(validacion.getUrl());
			
			resp.setData(generarResultado(parseador, validacion, properties, TipoValidacion.ARCHIVO));
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		
		return resp;
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/getDetalle")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Estructura> getDetalle(@Context HttpHeaders httpheaders, RequestDetalle request) {

		Response<Estructura> resp = new Response<Estructura>();
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");
			
			if(request.getNombreClase().contains("Tecnica")) {
				Class cl = Class.forName(request.getNombreClase());
				@SuppressWarnings("unchecked")
				Constructor cons = cl.getConstructor(new Class[] {CategoriaTecnica.class});
				Estructura o = (Estructura)cons.newInstance(CategoriaTecnica.SUFICIENTE);
				resp.setData(o);
			}
			else {
				Estructura interfaceType = (Estructura)Class.forName(request.getNombreClase()).newInstance();
				resp.setData(interfaceType);
			}
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");	
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		return resp;
	}
	
	@GET
	@Path("/getArchivo/{archivo}/{idAnalisis}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<String> getArchivo(@Context HttpHeaders httpheaders, @PathParam("archivo")String archivo, @PathParam("idAnalisis")String idAnalisis) {

		Response<String> resp = new Response<String>();
		try {			
			List<String> tokenLst = httpheaders.getRequestHeader("token");
			if (tokenLst == null || tokenLst.size() == 0) {
		        throw new NonAuthorizedException("Don't have authorization");
		    }
			
			Properties properties = new Properties();
			properties.load(ValidarAccesibilidadService.class.getResourceAsStream("/ar/edu/uade/tic/tesis/arweb/configuracion/Config.properties"));
			
			if(!tokenLst.get(0).equals(properties.get("TOKEN")))
				throw new NonAuthorizedException("Don't have authorization");
						
			resp.setData(GestorBaseDatos.seleccionarAnexo(archivo, Long.parseLong(idAnalisis)));
			resp.setStatusCode(StatusCode.Success);
			resp.setMessage("OK");	
		}
		catch(NonAuthorizedException ex) {
			resp.setStatusCode(StatusCode.Unauthorized);
			resp.setMessage(ex.getMessage());
		}
		catch(Exception ex) {
			resp.setStatusCode(StatusCode.InternalServerError);
			resp.setMessage(ex.getMessage());
		}
		return resp;
	}
	
	private Resultado generarResultado(Parseador parseador, Validacion validacion, Properties properties, TipoValidacion tipoValidacion) {
		Resultado resul = new Resultado();
		
		List<ResultadoEvaluacionPrincipio> resultadoValidacionGeneral = new LinkedList<ResultadoEvaluacionPrincipio>();
		for (Principio principio : new WCAG20().getPrincipios())
			if (validacion.getPrincipios().indexOf(principio.getNumero()) != -1) //1,2,3,4
				resultadoValidacionGeneral.add(principio.validarAccesibilidadPorPrincipio(parseador));
		
		List<ResultadoEvaluacion> resultados = new ArrayList<ResultadoEvaluacion>();
		
		String marcaPrincipio = "";
		String marcaPauta = "";
		String marcaCriterio = "";
		String marcaTecnica = "";
		
		Integer cantidadOK = 0;
		Integer cantidadError = 0;
		Integer cantidadManual = 0;
		Integer cantidadImposible = 0;
		Integer id = 0;
		
		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : resultadoValidacionGeneral) {
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio
					.getResultadoEvaluacionPautas()) {
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta
						.getResultadoEvaluacionCriterios()) {
					for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : resultadoEvaluacionCriterio
							.getResultadoEvaluacionTecnicas()) {
						for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : resultadoEvaluacionTecnica.getResultadoEvaluacionTecnicaItems()) {
							ResultadoEvaluacion resultado = new ResultadoEvaluacion();
							resultado.setId(id);
							
							if (!marcaPrincipio.equals(resultadoEvaluacionPrincipio.getPrincipio().toString())) {
								resultado.setPrincipio(resultadoEvaluacionPrincipio.getPrincipio().toString());//, new ImageIcon(this.getClass().getResource(Constantes.PATH_IMAGE_HELP)));
								resultado.setPrincipioNumero(resultadoEvaluacionPrincipio.getPrincipio().getNumero());
								resultado.setPrincipioNombre(resultadoEvaluacionPrincipio.getPrincipio().getNombre());
								resultado.setPrincipioDescripcion(resultadoEvaluacionPrincipio.getPrincipio().getDescripcion());
							}
							else
								resultado.setPrincipio("");
							if (!marcaPauta.equals(resultadoEvaluacionPauta.getPauta().toString())) {
								resultado.setPauta(resultadoEvaluacionPauta.getPauta().toString());//, new ImageIcon(this.getClass().getResource(Constantes.PATH_IMAGE_HELP)));
								resultado.setPautaNumero(resultadoEvaluacionPauta.getPauta().getNumero());
								resultado.setPautaNombre(resultadoEvaluacionPauta.getPauta().getNombre());
								resultado.setPautaDescripcion(resultadoEvaluacionPauta.getPauta().getDescripcion());
							}
							else
								resultado.setPauta("");
							if (!marcaCriterio.equals(resultadoEvaluacionCriterio.getCriterio().toString())) {
								resultado.setCriterio(resultadoEvaluacionCriterio.getCriterio().toString());//, new ImageIcon(this.getClass().getResource(Constantes.PATH_IMAGE_HELP)));
								resultado.setNivel(resultadoEvaluacionCriterio.getPuntosPorCriterio().toString());
								resultado.setCriterioNumero(resultadoEvaluacionCriterio.getCriterio().getNumero());
								resultado.setCriterioNombre(resultadoEvaluacionCriterio.getCriterio().getNombre());
								resultado.setCriterioDescripcion(resultadoEvaluacionCriterio.getCriterio().getDescripcion());
								resultado.setNivelAccesibilidad(resultadoEvaluacionCriterio.getCriterio().getNivelAccesibilidad().getRepresentacion());
							}
							else {
								resultado.setCriterio("");
								resultado.setNivel("");
							}
							if (!marcaTecnica.equals(resultadoEvaluacionTecnica.getTecnica().toString())) {
								resultado.setTecnica(Utilidades.getTextoFormateadoConLongitud(resultadoEvaluacionTecnica.getTecnica().toString(), 6));//, new ImageIcon(this.getClass().getResource(Constantes.PATH_IMAGE_HELP)));
								resultado.setTecnicaNumero(resultadoEvaluacionTecnica.getTecnica().getNumero());
								resultado.setTecnicaNombre(resultadoEvaluacionTecnica.getTecnica().getNombre());
								resultado.setTecnicaDescripcion(resultadoEvaluacionTecnica.getTecnica().getDescripcion());
							}
							else
								resultado.setTecnica("");
							resultado.setTipologia(resultadoEvaluacionTecnicaItem.getTipologia().getRepresentacionString());
							
							
							resultado.setVerificacionNombre(resultadoEvaluacionTecnicaItem.getNombre());//, new ImageIcon(this.getClass().getResource(Constantes.PATH_IMAGE_HELP)));
							resultado.setVerificacionDescripcion(resultadoEvaluacionTecnicaItem.getDescripcion());
							resultado.setVerificacionRecomendacion(resultadoEvaluacionTecnicaItem.getRecomendacion());
							
							resultado.setResultado(resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionPathImagen());
							resultado.setInc(String.valueOf(resultadoEvaluacionTecnicaItem.getIncidencias()));
							if(resultadoEvaluacionTecnicaItem.getLineas().size() == 0)
								resultado.setLinea("");
							else
								resultado.setLinea(resultadoEvaluacionTecnicaItem.getNumeroLineas());
								
							resultados.add(resultado);
							
							marcaPrincipio = resultadoEvaluacionPrincipio.getPrincipio().toString();
							marcaPauta = resultadoEvaluacionPauta.getPauta().toString();
							marcaCriterio = resultadoEvaluacionCriterio.getCriterio().toString();
							marcaTecnica = resultadoEvaluacionTecnica.getTecnica().toString();
							id++;
						}
					}
				}
			}
			cantidadOK += resultadoEvaluacionPrincipio.getCantidadPautasOKPorPrincipio();
			cantidadError += resultadoEvaluacionPrincipio.getCantidadErrorPorPrincipio();
			cantidadManual += resultadoEvaluacionPrincipio.getCantidadManualPorPrincipio();
			cantidadImposible += resultadoEvaluacionPrincipio.getCantidadImposiblePorPrincipio();
		}
		resul.setResultadoEvaluacion(resultados);
		
		//CodigoHtml
		String html = "";
		String [] split = parseador.getOutputDocument().toString().split("\n");
		Hashtable<Integer, List<TipoResultadoEvaluacion>> registroLineas = ResultadoEvaluacionTecnicaItem.getRegistroLinea();
		Integer contadorLinea = 1;
		for (String linea : split) {
			html+= "<b>" + contadorLinea + ".  </b>"; 
			if (registroLineas.containsKey(contadorLinea)){
				for (TipoResultadoEvaluacion tipoResultadoEvaluacion : registroLineas.get(contadorLinea)) 
					html+= "<img src='images/" + tipoResultadoEvaluacion.getRepresentacionPathImagen() + "'>";
			}
			html+= "&emsp;<xmp>" + linea + "</xmp><br />";
			contadorLinea++;
		}
		resul.setCodigoHTML(html);
		
		//Detalle
		Detalle det = new Detalle();
		
		det.setRecurso(validacion.getUrl());
		det.setPrincipios(validacion.getPrincipios());
		det.setFechaHora(new SimpleDateFormat().format(new Date()));
		
		det.setCantProblemas(cantidadError);
		det.setCantAdvertencias(cantidadManual);
		det.setCantNoVerificados(cantidadImposible);
		det.setPuntos(cantidadOK * 4);//properties.get("PUNTAJE_UMBRAL"));
		
		resul.setDetalle(det);
		
		//Historico
		Historico hist = new Historico();
		AnalisisDAO analisisDAO = GestorBaseDatos.seleccionarDB(tipoValidacion, validacion.getUrl());
		hist.setId(analisisDAO.getPrincipios() == "" ? 0 : analisisDAO.getId());
		hist.setRecurso(analisisDAO.getPrincipios() == "" ? "---" : analisisDAO.getUrl());
		hist.setFechaHora(analisisDAO.getPrincipios() == "" ? "---" : analisisDAO.getFechaHora());
		hist.setPautas(analisisDAO.getPrincipios() == "" ? "---" : "WCAG 2.0");
		hist.setPrincipios(analisisDAO.getPrincipios() == "" ? "---" : analisisDAO.getPrincipios());
		hist.setNivelAccesibilidad(analisisDAO.getPrincipios() == "" ? "---" : analisisDAO.getNivelAccesibilidad() + " " + "(umbral: " + analisisDAO.getUmbralString() + " puntos)");
		hist.setTecnologias(analisisDAO.getPrincipios() == "" ? "---" : "HTML, CSS y JavaScript");
		hist.setCantProblemas(analisisDAO.getPrincipios() == "" ? "---" : String.valueOf(analisisDAO.getProblemasString()));
		hist.setCantAdvertencias(analisisDAO.getPrincipios() == "" ? "---" : String.valueOf(analisisDAO.getAdvertenciasString()));
		hist.setCantNoVerificados(analisisDAO.getPrincipios() == "" ? "---" : String.valueOf(analisisDAO.getNoVerificadosString()));
		if (analisisDAO.getPrincipios() == "")
			hist.setPuntos("---");
		else {
			hist.setPuntos(analisisDAO.getAccesibilidad().toString());
		}
		resul.setHistorico(hist);
		
		//Guardo los resultados del analisis
		resul.setAnalisisId(GestorBaseDatos.insertarHistorico(tipoValidacion,
				validacion.getUrl(), validacion.getPrincipios(), "A",
				Integer.parseInt(properties.get("PUNTAJE_UMBRAL").toString()),
				resul.getDetalle().getCantProblemas(),
				resul.getDetalle().getCantAdvertencias(),
				resul.getDetalle().getCantNoVerificados(), resul.getDetalle().getPuntos()));
		
		//Guardo el detalle del analisis
		String criterio= "", nivel = "", tecnica = "", script = "";
		for (ResultadoEvaluacion resultado : resultados) {
			if(resultado.getCriterioNumero() != null)
				criterio = resultado.getCriterioNumero();
			if(resultado.getNivelAccesibilidad() != null)
				nivel = resultado.getNivelAccesibilidad();
			if(resultado.getTecnicaNumero() != null)
				tecnica = resultado.getTecnicaNumero();
			if(script == "")
				script = "INSERT INTO RESULTADO_CRITERIO_TECNICA (Analisis_Id, Criterio_Numero, Nivel, Tecnica_Numero, Resultado) VALUES (" + resul.getAnalisisId() + ",'" + criterio + "','" + nivel + "','" + tecnica + "','" + resultado.getResultado().substring(0, resultado.getResultado().indexOf(".")) + "')";
			else
				script +=  ",(" + resul.getAnalisisId() + ",'" + criterio + "','" + nivel + "','" + tecnica + "','" + resultado.getResultado().substring(0, resultado.getResultado().indexOf(".")) + "')";
		}
		script +=  ";";
		GestorBaseDatos.insertarResultadoCriterioTecnica(tipoValidacion, script);
		
		//Genero Anexo PDF
		try {
			File tempAnexoPDF = null;
			tempAnexoPDF = File.createTempFile("AnexoPDF", ".tmp");		
			new ExportadorAnexoPDF(validacion.getUrl(), resultadoValidacionGeneral, tempAnexoPDF).exportar();
			String anexoPDF = new String(Base64.getEncoder().encode(loadFileAsBytesArray(tempAnexoPDF.getAbsolutePath())));
			GestorBaseDatos.insertarAnexo(tipoValidacion,
					"ANEXO_PDF",
					anexoPDF,
					resul.getAnalisisId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Genero Detalle PDF
		try {
			File tempDetallePDF = null;
			tempDetallePDF = File.createTempFile("DetallePDF", ".tmp"); 
			new ExportadorDetallePDF(validacion.getUrl(), resultadoValidacionGeneral, parseador.getOutputDocument().toString(),tempDetallePDF).exportar();
			String detallePDF = new String(Base64.getEncoder().encode(loadFileAsBytesArray(tempDetallePDF.getAbsolutePath())));
			GestorBaseDatos.insertarAnexo(tipoValidacion,
					"DETALLE_PDF",
					detallePDF,
					resul.getAnalisisId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Genero Detalle XLS
		try {
			File tempDetalleXLS = File.createTempFile("DetalleXLS", ".tmp"); 
			new ExportadorDetalleXLS(validacion.getUrl(), resultadoValidacionGeneral, tempDetalleXLS).exportar();
			String detalleXLS = new String(Base64.getEncoder().encode(loadFileAsBytesArray(tempDetalleXLS.getAbsolutePath())));
			GestorBaseDatos.insertarAnexo(tipoValidacion,
					"DETALLE_XLS",
					detalleXLS,
					resul.getAnalisisId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}
	public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
		 
        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
 
    }
}
