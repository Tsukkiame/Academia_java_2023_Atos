// login gerado automaticamente, em letras minúsculas usando nome e o sobrenome. !!no exato momento em que cada caractere for digitado!!

// Chegando no valor do nome + campo do login
// => login = nome + . + sobrenome

// TENTATIVA 1 SEM CONHECER O .oninput //
// document.querySelector('#login').value = `${document.querySelector('#nome').value.toLowerCase().replace(/\s/g, '')}.${document.querySelector('#sobrenome').value.toLowerCase().replace(/\s/g, '')}`


// TENTATIVA DE RECUPERAR OS VALORES SEM IF APENAS COM &&(AND) E || (OR) //
// document.querySelector('#nome' && '#sobrenome').oninput = function(event) {
//     document.querySelector('#login').value = `${document.querySelector('#nome').value.toLowerCase().replace(/\s/g, '')}.${document.querySelector('#sobrenome').value.toLowerCase().replace(/\s/g, '')}`;
// }

window.oninput = function(event){ //quando houver um input do teclado
   
    var campo = event.target.id; // pega o id do campo que chamou o evento
    
    if(campo == "nome"){ //se for o campo nome recebndo input
       document.querySelector('#login').value = `${document.querySelector('#nome').value.toLowerCase().replace(/\s/g, '')}.${document.querySelector('#sobrenome').value.toLowerCase().replace(/\s/g, '')}`; //insere o formato que desejamos de login (no valor del .value)
       // editamos com .toLowerCase() para rstringir as letras em minúsculas
       // .replace(/\s/g, '') "retira" todos os espaços em branco
    }else if(campo == "sobrenome"){ //se o campo for sobrenome recebeno input
        document.querySelector('#login').value = `${document.querySelector('#nome').value.toLowerCase().replace(/\s/g, '')}.${document.querySelector('#sobrenome').value.toLowerCase().replace(/\s/g, '')}`;
    }

};

// javascript da API de cep https://viacep.com.br/ //

function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('endereco').value=("");
    document.getElementById('bairro').value=("");
    document.getElementById('cidade').value=("");
    document.getElementById('estado').value=("");
    document.getElementById('complemento').value=("");
}

function meu_callback(conteudo) {
if (!("cep-erro" in conteudo)) {
    //Atualiza os campos com os valores.
    document.getElementById('endereco').value=(conteudo.logradouro);
    document.getElementById('bairro').value=(conteudo.bairro);
    document.getElementById('cidade').value=(conteudo.localidade);
    document.getElementById('estado').value=(conteudo.uf);
    document.getElementById('complemento').value=(conteudo.complemento);
} //end if.
else {
    //CEP não Encontrado.
    limpa_formulário_cep();
    alert("CEP não encontrado.");
}
}

function pesquisacep(valor) {

//Nova variável "cep" somente com dígitos.
var cep = valor.replace(/\D/g, '');

//Verifica se campo cep possui valor informado.
if (cep != "") {

    //Expressão regular para validar o CEP.
    var validacep = /^[0-9]{8}$/;

    //Valida o formato do CEP.
    if(validacep.test(cep)) {

        //Preenche os campos com "..." enquanto consulta webservice.
        document.getElementById('endereco').value="...";
        document.getElementById('bairro').value="...";
        document.getElementById('cidade').value="...";
        document.getElementById('estado').value="...";
        document.getElementById('complemento').value="...";

        //Cria um elemento javascript.
        var script = document.createElement('script');

        //Sincroniza com o callback.
        script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

        //Insere script no documento e carrega o conteúdo.
        document.body.appendChild(script);

    } //end if.
    else {
        //cep é inválido.
        limpa_formulário_cep();
        alert("Formato de CEP inválido.");
    }
} //end if.
// Ainda falta o teste se pode ser feito o envio de 
// else {
//     //cep sem valor, limpa formulário.
//     limpa_formulário_cep();
// }
}; //end pesquisacep

function limpaFormulario() {
    //Limpa valores do formulário
    document.getElementById('nome').value=("");
    document.getElementById('sobrenome').value=("");
    document.getElementById('email').value=("");
    document.getElementById('login').value=("");
    document.getElementById('senha').value=("");
    document.getElementById('cep').value=("");
    document.getElementById('endereco').value=("");
    document.getElementById('bairro').value=("");
    document.getElementById('cidade').value=("");
    document.getElementById('estado').value=("");
    document.getElementById('complemento').value=("");
    document.getElementById('github').value=("");
    document.getElementById('academia').value = document.getElementById('academia').options[0].value;
    document.getElementById('professor').value = document.getElementById('professor').options[0].value;
    document.getElementById('termos').checked = false;
}


// ENVIO DOS DADOS PARA A TABELA //

// Função carregando os dados para os campos da tabela //
function enviaDados() {
    //falta if para checar os campos obrigatórios

    document.getElementById('t-nome').innerText = document.getElementById('nome').value;
    document.getElementById('t-sobrenome').innerText = document.getElementById('sobrenome').innerText;
    document.getElementById('t-email').innerText = document.getElementById('email').value;
    document.getElementById('t-login').innerText = document.getElementById('login').value;
    document.getElementById('t-senha').innerText = document.getElementById('senha').value;
    document.getElementById('t-cep').innerText = document.getElementById('cep').value;
    document.getElementById('t-endereco').innerText = document.getElementById('endereco').value;
    document.getElementById('t-bairro').innerText = document.getElementById('bairro').value;
    document.getElementById('t-cidade').innerText = document.getElementById('cidade').value;
    document.getElementById('t-estado').innerText = document.getElementById('estado').value;
    document.getElementById('t-complemento').innerText = document.getElementById('complemento').value;
    document.getElementById('t-github').innerText = document.getElementById('github').value;
    document.getElementById('t-academia').innerText = document.getElementById('academia').value;
    document.getElementById('t-professor').innerText = document.getElementById('professor').value;
    document.getElementById('t-termos').innerText = document.getElementById('termos').checked;
    if (document.getElementById('info-sim').checked) {
        document.getElementById('t-termos').value = true;       
    } else {
        document.getElementById('t-termos').value = false;
    }

    alert("Dados enviados com sucesso."); //Alerta de envio

    
    document.getElementById('tabela-dados').classList.remove('d-none');

    // Usando https://stackoverflow.com/questions/195951/how-can-i-change-an-elements-class-with-javascript
    
    //document.getElementById("MyElement").classList
    //document.getElementById("MyElement").classList.remove('MyClass');
    //if ( document.getElementById("MyElement").classList.contains('MyClass') )
    // document.getElementById("MyElement").classList.toggle('MyClass');

    limpaFormulario(); //Limpa o formulário
}

// EVENT LISTENER PARA ATIVAÇÃO DO ENVIA DADOS //
document.getElementById('btn-salvar').addEventListener("click", enviaDados, true);
