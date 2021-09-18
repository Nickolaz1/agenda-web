/**
 * Confirmar a exclusao de um contato
 * 
 * @author Nickolas Alexandre
 * @param id
 */

function confirmar(id) {
	let resposta = confirm("Confirma a exclusão deste contato ?")
	if (resposta === true) {
		window.location.href = "delete?id=" + id
	}
}