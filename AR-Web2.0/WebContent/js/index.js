//var urlBase = "http://ec2-34-219-116-80.us-west-2.compute.amazonaws.com:8080/AR-Web2.0/Services/";
var urlBase = "http://localhost:8080/AR-Web2.0/Services/";
var data;
// ////////////////////////////////////////////////////////////////////
function validarUrl() {
	var urlValidar = $('[id$="txtUrlValidar"]').val();
	var pattern = /^(http|https)\:\/\/[a-z0-9\.-]+\.[a-z]{2,4}/gi;
	if (urlValidar.match(pattern)) {
		$('[id$="divTxtUrlValidar"]')[0].classList.remove('has-error');
	} else {
		$('[id$="divTxtUrlValidar"]')[0].classList.add('has-error');
		return false;
	}
	
	var ddlNivel = $('[id$="ddlNivel"]').val();
	if(ddlNivel == "0"){
		$('[id$="divDdlNivel"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlNivel"]')[0].classList.remove('has-error');
	}
	
	$('[class$="loader"]').show();
	$.ajax({
		type : "POST",
		url : urlBase + "ValidarAccesibilidadService/validarUrl",
		headers : {
			'token' : '123456789'
		},
		data : '{"url": "' + urlValidar + '"}',
		contentType : "application/json",
		dataType : "json",
		success : function(msg) {
			if (msg.statusCode == "Success") {
				$('#cmbURLs').append($('<option>', {
					value : 0,
					text : 'Seleccione la Url a validar'
				}));
				for (x = 0; x < msg.data.length; x++) {
					$('#cmbURLs').append($('<option>', {
						value : msg.data[x],
						text : msg.data[x]
					}));
				}
				$('#divError').empty();
				$('#divError').hide();
				$('[class$="loader"]').hide();
				// Lo llevo al tab de seleccion de url a validar
				$('#tabs li a').eq(3).tab('show');
				if(msg.data.length == 1){
					$('#cmbURLs').val(msg.data[0]);
					$('#btnValidar').click();
				}
			} else {
				$('#divError').empty();
				$('#divError').append(
						'<strong>' + msg.statusCode + '</strong> '
								+ msg.message);
				$('#divError').show();
				$('[class$="loader"]').hide();
			}
			return true;
		},
		failure : function(response) {
			$('#divError').empty();
			$('#divError')
					.append('<strong>Error!</strong> ' + response.message);
			$('#divError').show();
			$('[class$="loader"]').hide();
			return false;
		}
	});
}
// ////////////////////////////////////////////////////////////////////
function validarArchivo() {
	var file = $('#archivoFileUpload').val();
	if (file != '') {
		$('[id$="divArchivoFileUpload"]')[0].classList.remove('has-error');
	} else {
		$('[id$="divArchivoFileUpload"]')[0].classList.add('has-error');
		return false;
	}
	
	var ddlNivel = $('[id$="ddlNivel"]').val();
	if(ddlNivel == "0"){
		$('[id$="divDdlNivel"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlNivel"]')[0].classList.remove('has-error');
	}

	var principios = '';
	$('input[name="principios"]:checked').each(function() {
		if (principios == '')
			principios = $(this).val();
		else
			principios += ',' + $(this).val();
	});

	if (principios == '') {
		$('#divError').empty();
		$('#divError')
				.append(
						'<strong>Error!</strong> Debe seleccionar al menos un Principio');
		$('#divError').show();
		return false;
	} else {
		$('#divError').empty();
		$('#divError').hide();
	}
	
	var ddlVersion = $('[id$="ddlVersion"]').val();
	if(ddlVersion == "0"){
		$('[id$="divDdlVersion"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlVersion"]')[0].classList.remove('has-error');
	}
	
	$('[class$="loader"]').show();
	var reader = new FileReader();
	reader.onload = function(e) {
		var fileBase64 = e.target.result;
		$.ajax({
			type : "POST",
			url : urlBase + "ValidarAccesibilidadService/validarByFile",
			headers : {
				'token' : '123456789'
			},
			data : '{"url": "' + fileBase64 + '", "principios":"' + principios + ',"nivel": "' + ddlNivel + '","versionWCAG":"' + ddlVersion + '"}',
			contentType : "application/json",
			dataType : "json",
			success : function(msg) {
				if (msg.statusCode == "Success") {
					data = msg.data;
					setResults();
					$('#divError').empty();
					$('#divError').hide();
				} else {
					$('#divError').empty();
					$('#divError').append(
							'<strong>' + msg.statusCode + '</strong> '
									+ msg.message);
					$('#divError').show();
				}
				$('[class$="loader"]').hide();
				return true;
			},
			failure : function(response) {
				$('#divError').empty();
				$('#divError').append(
						'<strong>Error!</strong> ' + response.message);
				$('#divError').show();
				$('[class$="loader"]').hide();
				return false;
			}
		});
	};
	reader.readAsDataURL($('#archivoFileUpload')[0].files[0]);
}

function validarHTML() {
	var html = $('[id$="txtCodigoHTML"]').val();
	if (html != '') {
		$('[id$="divTxtCodigoHTML"]')[0].classList.remove('has-error');
	} else {
		$('[id$="divTxtCodigoHTML"]')[0].classList.add('has-error');
		return false;
	}
	
	var ddlNivel = $('[id$="ddlNivel"]').val();
	if(ddlNivel == "0"){
		$('[id$="divDdlNivel"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlNivel"]')[0].classList.remove('has-error');
	}

	var principios = '';
	$('input[name="principios"]:checked').each(function() {
		if (principios == '')
			principios = $(this).val();
		else
			principios += ',' + $(this).val();
	});

	if (principios == '') {
		$('#divError').empty();
		$('#divError')
				.append(
						'<strong>Error!</strong> Debe seleccionar al menos un Principio');
		$('#divError').show();
		return false;
	} else {
		$('#divError').empty();
		$('#divError').hide();
	}
	
	var ddlVersion = $('[id$="ddlVersion"]').val();
	if(ddlVersion == "0"){
		$('[id$="divDdlVersion"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlVersion"]')[0].classList.remove('has-error');
	}
	
	$('[class$="loader"]').show();
	$.ajax({
		type : "POST",
		url : urlBase + "ValidarAccesibilidadService/validarByHTML",
		headers : {
			'token' : '123456789'
		},
		data : '{"url": "' + html + '", "principios":"' + principios + ',"nivel": "' + ddlNivel + '","versionWCAG":"' + ddlVersion + '"}',
		contentType : "application/json",
		dataType : "json",
		success : function(msg) {
			if (msg.statusCode == "Success") {
				data = msg.data;
				setResults();
				$('#divError').empty();
				$('#divError').hide();
			} else {
				$('#divError').empty();
				$('#divError').append(
						'<strong>' + msg.statusCode + '</strong> '
								+ msg.message);
				$('#divError').show();
			}
			$('[class$="loader"]').hide();
			return true;
		},
		failure : function(response) {
			$('#divError').empty();
			$('#divError')
					.append('<strong>Error!</strong> ' + response.message);
			$('#divError').show();
			$('[class$="loader"]').hide();
			return false;
		}
	});
}

function validarByUrl() {
	var urlAValidar = $('[id$="cmbURLs"]').val();
	if (urlAValidar != null && urlAValidar != '0') {
		$('[id$="divCmbURLs"]')[0].classList.remove('has-error');
	} else {
		$('[id$="divCmbURLs"]')[0].classList.add('has-error');
		return false;
	}
	
	var ddlNivel = $('[id$="ddlNivel"]').val();
	if(ddlNivel == "0"){
		$('[id$="divDdlNivel"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlNivel"]')[0].classList.remove('has-error');
	}

	var principios = '';
	$('input[name="principios"]:checked').each(function() {
		if (principios == '')
			principios = $(this).val();
		else
			principios += ',' + $(this).val();
	});

	if (principios == '') {
		$('#divError').empty();
		$('#divError')
				.append(
						'<strong>Error!</strong> Debe seleccionar al menos un Principio');
		$('#divError').show();
		return false;
	} else {
		$('#divError').empty();
		$('#divError').hide();
	}
	
	var ddlVersion = $('[id$="ddlVersion"]').val();
	if(ddlVersion == "0"){
		$('[id$="divDdlVersion"]')[0].classList.add('has-error');
		return false;
	}
	else{
		$('[id$="divDdlVersion"]')[0].classList.remove('has-error');
	}
	
	$('[class$="loader"]').show();
	$.ajax({
		type : "POST",
		url : urlBase + "ValidarAccesibilidadService/validarByUrl",
		headers : {
			'token' : '123456789'
		},
		data : '{"url": "' + urlAValidar + '","principios":"' + principios	+ '","nivel":"' + ddlNivel + '","versionWCAG":"' + ddlVersion + '"}',
		contentType : "application/json",
		dataType : "json",
		success : function(msg) {
			if (msg.statusCode == "Success") {
				data = msg.data;
				setResults();
				$('#divError').empty();
				$('#divError').hide();
			} else {
				$('#divError').empty();
				$('#divError').append(
						'<strong>' + msg.statusCode + '</strong> '
								+ msg.message);
				$('#divError').show();
			}
			$('[class$="loader"]').hide();
			return true;
		},
		failure : function(response) {
			$('#divError').empty();
			$('#divError')
					.append('<strong>Error!</strong> ' + response.message);
			$('#divError').show();
			$('[class$="loader"]').hide();
			return false;
		}
	});
}

function setResults() {
	// Detalle
	$('[id$="divRecurso"]')[0].innerHTML = data.detalle.recurso;
	$('[id$="divFechaHora"]')[0].innerHTML = data.detalle.fechaHora;
	$('[id$="divPautas"]')[0].innerHTML = data.detalle.pautas;
	$('[id$="divPrincipios"]')[0].innerHTML = data.detalle.principios;
	$('[id$="divNivelAccesibilidad"]')[0].innerHTML = $('[id$="ddlNivel"]').val();
	$('[id$="divCantProblemas"]')[0].innerHTML = data.detalle.cantProblemas;
	$('[id$="divCantAdvertencias"]')[0].innerHTML = data.detalle.cantAdvertencias;
	$('[id$="divCantNoVerificados"]')[0].innerHTML = data.detalle.cantNoVerificados;
	if (data.detalle.puntos > 50) {
		$('[id$="spanPuntos"]')[0].innerHTML = data.detalle.puntos
				+ ' - ACCESIBLE';
		$('[id$="spanPuntos"]')[0].style.color = 'green';
	} else {
		$('[id$="spanPuntos"]')[0].innerHTML = data.detalle.puntos
				+ ' - NO ACCESIBLE';
		$('[id$="spanPuntos"]')[0].style.color = 'red';
	}
	if ($('[id$="ddlNivel"]').val() != "A") 
		$('[id$="divPuntajeNivelA"]')[0].style.display = 'none';
	else
		$('[id$="divPuntajeNivelA"]')[0].style.display = '';
	
	// Historico
	$('[id$="divRecursoHistorico"]')[0].innerHTML = data.historico.recurso;
	$('[id$="divFechaHoraHistorico"]')[0].innerHTML = data.historico.fechaHora;
	$('[id$="divPautasHistorico"]')[0].innerHTML = data.historico.pautas;
	$('[id$="divNivelAccesibilidadHistorico"]')[0].innerHTML = data.historico.nivelAccesibilidad;
	$('[id$="divTecnologiasHistorico"]')[0].innerHTML = data.historico.tecnologias;
	$('[id$="divPrincipiosHistorico"]')[0].innerHTML = data.historico.principios;
	$('[id$="divCantProblemasHistorico"]')[0].innerHTML = data.historico.cantProblemas;
	$('[id$="divCantAdvertenciasHistorico"]')[0].innerHTML = data.historico.cantAdvertencias;
	$('[id$="divCantNoVerificadosHistorico"]')[0].innerHTML = data.historico.cantNoVerificados;
	if((data.historico.nivelAccesibilidad.match(new RegExp("A", "g")) || []).length == 1) {
		if ((data.historico.puntos * 1) > 0) {
			if ((data.historico.puntos * 1) > 50) {
				$('[id$="spanPuntosHistorico"]')[0].innerHTML = data.historico.puntos
						+ ' - ACCESIBLE';
				$('[id$="spanPuntosHistorico"]')[0].style.color = 'green';
			} else {
				$('[id$="spanPuntosHistorico"]')[0].innerHTML = data.historico.puntos
						+ ' - NO ACCESIBLE';
				$('[id$="spanPuntosHistorico"]')[0].style.color = 'red';
			}
		}
		$('[id$="divPuntajeNivelAHistorico"]')[0].style.display = '';
	}
	else
		$('[id$="divPuntajeNivelAHistorico"]')[0].style.display = 'none';
	if (data.historico.id > 0)
		$('[id$="divBotonesHistorico"]')[0].style.display = '';
	else
		$('[id$="divBotonesHistorico"]')[0].style.display = 'none';

	try {
		var resultado = '';
		// Principios
		for (i = 0; i < data.resultadoEvaluacion.length; i++) {
			resultado += '<tr>';
			if (data.resultadoEvaluacion[i].principio != "")
				resultado += '<td>'
						+ data.resultadoEvaluacion[i].principio
						+ ' <a href="javascript:viewDetail('
						+ data.resultadoEvaluacion[i].id
						+ ',\'Principio\');" data-toggle="Ver Detalle Principio"><img alt="Ver Detalle Principio" src="images/help.png"></a></td>';
			else
				resultado += '<td></td>';
			if (data.resultadoEvaluacion[i].pauta != "")
				resultado += '<td>'
						+ data.resultadoEvaluacion[i].pauta
						+ ' <a href="javascript:viewDetail('
						+ data.resultadoEvaluacion[i].id
						+ ',\'Pauta\');" data-toggle="Ver Detalle Pauta"><img alt="Ver Detalle Pauta" src="images/help.png"></a></td>';
			else
				resultado += '<td></td>';
			if (data.resultadoEvaluacion[i].criterio != "")
				resultado += '<td>'
						+ data.resultadoEvaluacion[i].criterio
						+ ' <a href="javascript:viewDetail('
						+ data.resultadoEvaluacion[i].id
						+ ',\'Criterio\');" data-toggle="Ver Detalle Criterio"><img alt="Ver Detalle Criterio" src="images/help.png"></a></td>';
			else
				resultado += '<td></td>';
			resultado += '<td>' + data.resultadoEvaluacion[i].nivelAccesibilidad + '</td>';
			resultado += '<td>' + data.resultadoEvaluacion[i].nivel + '</td>';
			if (data.resultadoEvaluacion[i].tecnica != "")
				resultado += '<td>'
						+ data.resultadoEvaluacion[i].tecnica
						+ ' <a href="javascript:viewDetail('
						+ data.resultadoEvaluacion[i].id
						+ ',\'Tecnica\');" data-toggle="Ver Detalle Técnica"><img alt="Ver Detalle Técnica" src="images/help.png"></a></td>';
			else
				resultado += '<td></td>';
			resultado += '<td>' + data.resultadoEvaluacion[i].tipologia
					+ '</td>';
			if (data.resultadoEvaluacion[i].verificaciones != "")
				resultado += '<td>'
						+ data.resultadoEvaluacion[i].verificacionNombre
						+ ' <a href="javascript:viewVerificacion('
						+ data.resultadoEvaluacion[i].id
						+ ');" data-toggle="Ver Detalle Verificaciones"><img alt="Ver Detalle Verificaciones" src="images/help.png"></a></td>';
			else
				resultado += '<td></td>';
			resultado += '<td><img alt"" src="images/'
					+ data.resultadoEvaluacion[i].resultado + '"></td>';
			resultado += '<td>' + data.resultadoEvaluacion[i].inc + '</td>';
			resultado += '<td>' + data.resultadoEvaluacion[i].linea + '</td>';
			resultado += '</tr>';
		}
		$('[id$="tableResultado"]')[0].innerHTML = resultado;
	} catch (e) {
		$('#divError').empty();
		$('#divError').append('<strong>Error</strong> ' + e.message);
		$('#divError').show();
	}

	$('#divValidacion').hide();
	$('#divResultado').show();
}
// ////////////////////////////////////////////////////////////////////
function viewDetail(id, tipo) {
	switch (tipo) {
	case "Principio":
		$('[id$="tituloDetalleElemento"]')[0].innerHTML = "Principio "
				+ data.resultadoEvaluacion[id].principioNumero;
		$('[id$="nombreDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].verificacionNombre;
		$('[id$="descripcionDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].principioDescripcion;
		$('#divDetalleElemento').modal('show');
		break;
	case "Pauta":
		$('[id$="tituloDetalleElemento"]')[0].innerHTML = "Pauta "
				+ data.resultadoEvaluacion[id].pautaNumero;
		$('[id$="nombreDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].pautaNombre;
		$('[id$="descripcionDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].pautaDescripcion;
		$('#divDetalleElemento').modal('show');
		break;
	case "Criterio":
		$('[id$="tituloDetalleElemento"]')[0].innerHTML = "Criterio "
				+ data.resultadoEvaluacion[id].criterioNumero;
		$('[id$="nombreDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].criterioNombre;
		$('[id$="descripcionDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].criterioDescripcion;
		$('#divDetalleElemento').modal('show');
		break;
	case "Tecnica":
		$('[id$="tituloDetalleElemento"]')[0].innerHTML = "Técnica "
				+ data.resultadoEvaluacion[id].tecnicaNumero;
		$('[id$="nombreDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].tecnicaNombre;
		$('[id$="descripcionDetalleElemento"]')[0].innerHTML = data.resultadoEvaluacion[id].tecnicaDescripcion
				+ "<br /><a href='https://www.w3.org/TR/WCAG20-TECHS/"
				+ data.resultadoEvaluacion[id].tecnicaNumero
				+ "' target='_blank'>https://www.w3.org/TR/WCAG20-TECHS/"
				+ data.resultadoEvaluacion[id].tecnicaNumero + "</a>";
		$('#divDetalleElemento').modal('show');
		break;
	}
}

function viewVerificacion(id) {
	$('[id$="nombreDetalleVerificacion"]')[0].innerHTML = data.resultadoEvaluacion[id].verificacionNombre;
	$('[id$="descripcionDetalleVerificacion"]')[0].innerHTML = data.resultadoEvaluacion[id].verificacionDescripcion;
	$('[id$="recomendacionDetalleVerificacion"]')[0].innerHTML = data.resultadoEvaluacion[id].verificacionRecomendacion;
	$('#divDetalleVerificacion').modal('show');
}// ////////////////////////////////////////////////////////////////////
function exportar(tabla, extension, tipo, button) {
	var idAnalisis = 0;
	$('[id$="' + button + '"]')[0].innerHTML = '<i class="fa fa-spinner fa-spin"></i> Exportando';
	if (tipo == 'Detalle')
		idAnalisis = data.analisisId;
	else
		idAnalisis = data.historico.id;
	$.ajax({
		type : "GET",
		url : urlBase + "ValidarAccesibilidadService/getArchivo/" + tabla + "/"
				+ idAnalisis,
		headers : {
			'token' : '123456789'
		},
		contentType : "application/json",
		dataType : "json",
		success : function(msg) {
			$('[id$="' + button + '"]')[0].innerHTML = '<span class="glyphicon glyphicon-download-alt"></span> Exportar <span class="caret"></span>';
			if (msg.statusCode == "Success") {
				var blob;
				if (extension == '.pdf')
					blob = b64toBlob(msg.data, 'application/pdf');
				else
					blob = b64toBlob(msg.data, 'application/vnd.ms-excel');
				var blobUrl = URL.createObjectURL(blob);

				// IE doesn't allow using a blob object directly as link href
				// instead it is necessary to use msSaveOrOpenBlob
				if (window.navigator && window.navigator.msSaveOrOpenBlob) {
					window.navigator.msSaveOrOpenBlob(blob);
					return;
				}

				// For other browsers:
				// Create a link pointing to the ObjectURL containing the blob.
				const data = window.URL.createObjectURL(blob);
				var link = document.createElement('a');
				link.href = data;
				link.download = tabla + extension;
				link.click();
				setTimeout(function() {
					// For Firefox it is necessary to delay revoking the
					// ObjectURL
					window.URL.revokeObjectURL(data);
				}, 100);
			}
			return false;
		},
		failure : function(response) {
			$('[id$="' + button + '"]')[0].innerHTML = '<span class="glyphicon glyphicon-download-alt"></span> Exportar <span class="caret"></span>';
			$('#divError').empty();
			$('#divError')
					.append('<strong>Error!</strong> ' + response.message);
			$('#divError').show();
			return false;
		}
	});
}
function verCodigoHTML() {
	$('[id$="textCodigoHTML"]')[0].innerHTML = data.codigoHTML;
	$('#divCodigoHTML').modal('show');
}

function b64toBlob(b64Data, contentType, sliceSize) {
	contentType = contentType || '';
	sliceSize = sliceSize || 512;

	var byteCharacters = atob(b64Data);
	var byteArrays = [];

	for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
		var slice = byteCharacters.slice(offset, offset + sliceSize);

		var byteNumbers = new Array(slice.length);
		for (var i = 0; i < slice.length; i++) {
			byteNumbers[i] = slice.charCodeAt(i);
		}

		var byteArray = new Uint8Array(byteNumbers);

		byteArrays.push(byteArray);
	}

	var blob = new Blob(byteArrays, {
		type : contentType
	});
	return blob;
}