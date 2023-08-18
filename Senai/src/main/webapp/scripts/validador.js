/**
 * 
 */

function validar(){
	let nome = frmUsuario.nome.value
	let endereco = frmUsuario.endereco.value
	let documento = frmUsuario.endereco.value
	if (nome === "") {
		alert('Preencha o nome do usuário!')
		frmUsuario.nome.focus()
		return false
	} else if (endereco === "") {
		alert('Preencha o endereço do usuário!')
		frmUsuario.endereco.focus()
		return false
	} else if (documento === "") {
		alert('Preencha o documento do usuário!')
		frmUsuario.documento.focus()
		return false
	} else {
		document.forms["frmUsuario"].submit()
	}
}