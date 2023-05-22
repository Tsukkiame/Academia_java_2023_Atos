function deletar (id) {
    var result = confirm("Deseja excluir o produto ??");
    if (result == true) {
		fetch('http://localhost:8080/projeto-backend/produtos?id=' + id, { method: 'DELETE',}).then(res => res.text()).then(res => {
			location.reload()
			console.log(res)
			})
    	console.log(id)
    } else {
    	console.log("Cancelado!")
    }
	
}

function alterar (id) {
	fetch('http://localhost:8080/projeto-backend/alterarproduto?id=' + id, { method: 'GET',})

    	console.log(id)
	
}