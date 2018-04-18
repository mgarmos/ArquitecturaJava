	function validacion() {
		var isbn = document.getElementById("isbn");
		var miFormulario = document.getElementById("isbn")
		if (isbn.value == "") {
			alert("Datos no válidos")
			return false;
		} else {
			miFormulario.submit();
			return true;
		}
	}