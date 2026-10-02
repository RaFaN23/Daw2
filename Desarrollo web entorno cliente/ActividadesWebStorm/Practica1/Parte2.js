function numerosMayoraMenor() {

    let numeros = [];

    for (let i = 0; i < 10; i++) {
        let numero = Number(prompt("Introduce el número " + (i + 1) + ":"));
        numeros.push(numero);
    }

    let mayor = Math.max(...numeros);
    let menor = Math.min(...numeros);

    let suma = 0;

    for (let i = 0; i < numeros.length; i++) {
        suma = suma + numeros[i];
    }

    let media = suma / numeros.length;

    alert("Mayor: " + mayor +
        "\nMenor: " + menor +
        "\nMedia: " + media);
}


function ordenAlfabetico(){

    let nombres = [];

    for (let i = 0; i < 5; i++) {
        let nombre = prompt("introduce nombre; " + (i+1));
        nombres.push(nombre);
    }
    nombres.sort();
    alert("Nombres en orden alfabetico: " + nombres);
    nombres.reverse();
    alert("Nombres en orden alfabetico inverso: " + nombres);
}

function numerosAleatorio() {
    let numeros = [];
    let impares = [];
    for (let i = 0; i < 20; i++) {
        let numero = Math.floor(Math.random() * 100) + 1;
        numeros.push(numero);
    }
    for (let i = 0; i < 20; i++) {
        if (numeros[i] % 2 != 0) {
            impares.push(numeros[i]);
        }
    }
    alert("Numeros : " + impares);
}

