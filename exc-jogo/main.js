'use strict';

const nomeCores = ["Vermelho", "Azul", "Amarelo", "Verde", "Marrom", "Roxo", "Lilás", "Cinza", "Preto"];

const nomeClasseCor = ["cor0", "cor1", "cor2", "cor3", "cor4", "cor5", "cor6", "cor7", "cor8"] //usar dataset para altrar a classe do botão e comparar o resultado

var n;

function d8 () { //rolando um d8 (que contém 0)
    n = parseInt(Math.random() * 9);
    //console.log(n)
}

function sorteiaNome() { //sorteia o nome da cor
    d8();
    var nomeCorSorteada = nomeCores[n];
    console.log(nomeCorSorteada);
    return nomeCorSorteada;
}

function sorteiaCor() { //sorteia a cor do alvo
    d8();
    return nomeClasseCor[n];
}

// function embaralhaCor() {
//     var i = nomeCores.length,
//         j = 0,
//         vetor;

//     while (i--) {
//         j = Math.floor(Math.random() * (i+1));

//         vetor = nomeCores[i]; //coloca a cor na nova array/vetor
//         nomeCores[i] = nomeCores[j]; //troca os valores 
//         nomeCores[j] = vetor; // define o array final com os nomes trocados
//     }

//     return nomeCores;
// }

function embaralhaCor() {
    var i = nomeClasseCor.length,
        j = 0,
        vetor;

    while (i--) {
        j = Math.floor(Math.random() * (i+1));

        vetor = nomeClasseCor[i]; //coloca a cor na nova array/vetor
        nomeClasseCor[i] = nomeClasseCor[j]; //troca os valores 
        nomeClasseCor[j] = vetor; // define o array final com os nomes das classes trocados
    }

    return nomeClasseCor;
}

//alvo
const alvo = document.getElementById('corSorteada')

//soteando o nome e cor do alvo
function sorteiaAlvo() {
    alvo.style.backgroundColor = "transparent";
    alvo.innerText = sorteiaNome();
    alvo.attributes[0].value = sorteiaCor();
    
    return alvo;
}

//variavel para contagem de pontos
var ponto = 0;

//função para checar se a cor clicada é a correta + reset de pontos caso erro
function checaPonto(cor) {
    let corBotao = cor.getAttribute("data-cor")
    if(alvo.attributes[0].value == corBotao) {
        console.log(corBotao);
        console.log(alvo.attributes[0].value);
        ponto = ponto +1;
        sorteiaAlvo();
        return ponto;
    } else {
        console.log(corBotao);
        console.log(alvo.attributes[0].value);
        alert("Você errou! Sua pontuação foi de " +ponto+ " ponto(s).");
        ponto = 0;
        alvo.attributes[0].value = ""
        alvo.innerText = "Cor/texto sorteado"
    }
}

function comecaJogo() {
    if (alvo.attributes[0].value == "") {
     sorteiaAlvo();   
    }
}