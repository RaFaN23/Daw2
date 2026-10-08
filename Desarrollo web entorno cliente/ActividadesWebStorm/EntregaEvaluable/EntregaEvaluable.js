// Rafael J. Villavicencio Indacochea / 2º DAW  / Desarrollo web entorno cliente

function ejercicio1() {
    let frase = prompt("Introduce una frase de 5 palabras");
    let palabra = frase.split(" ");
    while (palabra.length < 5) {
        alert("La frase tiene que tener al menos 5 palabras");
        frase = prompt("Introduce una frase de 5 palabras");
        palabra = frase.split(" ");
    }

    let caracteres = 0;
    for (let i = 0; i < frase.length; i++) {

        if (frase[i] !== " ") {
            caracteres++;
        }
    }

    let vocales = "";
    for (let i = 0; i < frase.length; i++) {
        if ("aeiou".includes(frase[i].toLowerCase())) {
            vocales = vocales + "*";
        } else {
            vocales = vocales + frase[i];
        }
    }

    let frasePares = "";
    let posicion = 1;
    for (let i = 0; i < frase.length; i++) {
        if (frase[i] !== " ") {
            if (posicion % 2 === 0) {
                frasePares = frasePares + "_";
            } else {
                frasePares = frasePares + frase[i];
            }
            posicion++;
        } else {
            frasePares = frasePares + " ";
        }
    }

    console.log("Frase original: " + frase);
    console.log("Número de caracteres sin espacios: " + caracteres);
    console.log("Frase con las vocales sustituidas: " + vocales);
    console.log("Frase con los elementos pares sustituidos: " + frasePares);
}

function ejercicio2() {
    let frase = prompt("Introduce una frase de 7 palabras variadas de mayusculas a minusculas (alguna de 4 o menos letras)");
    frase = frase.toLowerCase()
    let palabra = frase.split(" ");
    while (palabra.length < 7) {
        alert("La frase tiene que tener al menos 7 palabras");
        frase = prompt("Introduce una frase de 7 palabras");
        frase = frase.toLowerCase()
        palabra = frase.split(" ");
    }

    let palabrasAptas = []



    for (let i = 0; i < palabra.length; i++) {
        if (palabra[i].length > 4) {
            palabrasAptas.push(palabra[i]);
        }
    }
    alert(palabrasAptas.sort())

    let palabraPrueba = prompt("Introduce una palabra");
    palabraPrueba = palabraPrueba.toLowerCase()

    if (palabrasAptas.includes(palabraPrueba)){
       console.info("La palabra esta en el listado");
    }else {
        palabrasAptas.push(palabraPrueba)
        alert(palabrasAptas.sort())
    }
}