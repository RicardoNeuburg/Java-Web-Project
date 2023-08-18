function confirmar(matricula){
	let resposta = confirm("Tem certeza que quer exluir esse usuário?")
	if(resposta === true) {
		window.location.href = "delete?matricula=" + matricula
	}
}