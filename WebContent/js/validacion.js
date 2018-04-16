	function validacion() {
		var isbn = document.getElementById("isbn");
		var miFormulario = document.getElementById("isbn")
		if (isbn.value == "") {
			alert("Datos no válidos")
		} else {
			miFormulario.submit()
		}
	}