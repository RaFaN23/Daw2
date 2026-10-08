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

function ejercicio3() {
    let alumnos = {
        "Rafa": 8.50,
        "Lopez": 6.75,
        "Massi": 9.25,
        "Gonzy": 7.00
    };
    let mensaje = "Alumnos registrados:\n";
    for (let nombre in alumnos) {
        mensaje = mensaje + nombre + ": " + alumnos[nombre] + "\n";
    }
    alert(mensaje);
   let nombre = prompt("Introduce el nombre de un estudiante:");

    let encontrado = false;

    for (let alumno in alumnos) {

        if (alumno == nombre) {

            alert("La nota de " + nombre + " es: " + alumnos[alumno]);
            encontrado = true;
        }
    }

    if (encontrado == false) {

        alert("El estudiante no estaba registrado.");

        let nota = prompt("Introduce la nota del alumno (entre 0 y 10):");

        while (nota < 0 || nota > 10) {
            alert("La nota debe estar entre 0 y 10.");
            nota = prompt("Introduce la nota del alumno (entre 0 y 10):");
        }

        alumnos[nombre] = nota;

        alert("Alumno añadido correctamente.");
    }
}

function ejercicio4() {

    let multiplos2 = [];
    let multiplos3 = [];
   for (let i = 0; i <= 30; i++) {
        if (i % 2 == 0) {
            multiplos2.push(i);
        }
    }
    for (let i = 0; i <= 30; i++) {
        if (i % 3 == 0) {
            multiplos3.push(i);
        }
    }
    alert("Mira el log para ver el resultado");

    let union = [];

    for (let i = 0; i < multiplos2.length; i++) {
        union.push(multiplos2[i]);
    }

    for (let i = 0; i < multiplos3.length; i++) {
        if (!union.includes(multiplos3[i])) {
            union.push(multiplos3[i]);
        }
    }
    console.log("Unión:", union);
    let interseccion = [];

    for (let i = 0; i < multiplos2.length; i++) {
        if (multiplos3.includes(multiplos2[i])) {
            interseccion.push(multiplos2[i]);
        }
    }
    console.info("Intersección:", interseccion);

    let diferencia1 = [];

    for (let i = 0; i < multiplos2.length; i++) {
        if (!multiplos3.includes(multiplos2[i])) {
            diferencia1.push(multiplos2[i]);
        }
    }

    console.warn("Diferencia 1 - 2:", diferencia1);

    let diferencia2 = [];

    for (let i = 0; i < multiplos3.length; i++) {
        if (!multiplos2.includes(multiplos3[i])) {
            diferencia2.push(multiplos3[i]);
        }
    }

    console.error("Diferencia 2 - 1:", diferencia2);

    let exclusion = [];

    for (let i = 0; i < diferencia1.length; i++) {
        exclusion.push(diferencia1[i]);
    }

    for (let i = 0; i < diferencia2.length; i++) {
        exclusion.push(diferencia2[i]);
    }

    console.debug("Exclusión:", exclusion);
}


function ejercicio5() {

    let numeros;
    let correcto = false;

    while (correcto == false) {

        let texto = prompt("Introduce números separados por comas:");

        numeros = texto.split(",");

        correcto = true;

        for (let i = 0; i < numeros.length; i++) {

            if (isNaN(numeros[i])) {
                correcto = false;
            }
        }

        if (correcto == false) {
            alert("Has introducido un valor que no es numérico.");
        }
    }

    let unicos = [];

    for (let i = 0; i < numeros.length; i++) {

        let veces = 0;

        for (let j = 0; j < numeros.length; j++) {

            if (numeros[i] == numeros[j]) {
                veces++;
            }
        }

        if (veces == 1) {
            unicos.push(numeros[i]);
        }
    }

    let suma = 0;

    for (let i = 0; i < unicos.length; i++) {
        suma = suma + Number(unicos[i]);
    }

    let media = suma / unicos.length;

    alert("Valores que aparecen una sola vez: " + unicos);
    alert("Media: " + media);
}
function ejercicio6() {

    let frase = prompt("Introduce una palabra o frase:");
    frase = frase.toLowerCase();
    //Esto de aqui abajo me lo enseño chat gpt que la "NFD" es para quitale los acento en 2 partes y el replace es como otro codigo
    frase = frase.normalize("NFD").replace(/[\u0300-\u036f]/g, "");

    let fraseLimpia = "";

    for (let i = 0; i < frase.length; i++) {

        if ((frase[i] >= "a" && frase[i] <= "z") || frase[i] == "ñ") {
            fraseLimpia = fraseLimpia + frase[i];
        }
    }

    let invertida = "";

    for (let i = fraseLimpia.length - 1; i >= 0; i--) {
        invertida = invertida + fraseLimpia[i];
    }

    if (fraseLimpia == invertida) {
        alert("Es un palíndromo");
    } else {
        alert("No es un palíndromo");
    }
}


function ejercicio7() {

    let tareas = [];
    let estados = [];

    let opcion = 0;

    while (opcion != 6) {

        opcion = prompt(
            "GESTOR DE TAREAS\n\n" +
            "1. Agregar tarea\n" +
            "2. Completar tarea\n" +
            "3. Eliminar tarea\n" +
            "4. Mostrar lista\n" +
            "5. Mostrar pendientes\n" +
            "6. Salir\n\n" +
            "Elige una opción:"
        );

        if (opcion == 1) {

            let tarea = prompt("Introduce la tarea:");

            let existe = false;

            for (let i = 0; i < tareas.length; i++) {

                if (tareas[i] == tarea) {
                    existe = true;
                }
            }

            if (existe == true) {

                alert("Esa tarea ya existe.");

            } else {

                tareas.push(tarea);
                estados.push("pendiente");

                alert("Tarea añadida correctamente.");
            }
        }

        if (opcion == 2) {

            let tarea = prompt("Introduce la tarea que quieres completar:");

            let encontrada = false;

            for (let i = 0; i < tareas.length; i++) {

                if (tareas[i] == tarea) {

                    estados[i] = "completada";
                    encontrada = true;
                }
            }

            if (encontrada == true) {

                alert("Tarea completada.");

            } else {

                alert("La tarea no existe.");
            }
        }

        if (opcion == 3) {

            let tarea = prompt("Introduce la tarea que quieres eliminar:");

            let encontrada = false;

            for (let i = 0; i < tareas.length; i++) {

                if (tareas[i] == tarea) {

                    tareas.splice(i, 1);
                    estados.splice(i, 1);

                    encontrada = true;
                }
            }

            if (encontrada == true) {

                alert("Tarea eliminada.");

            } else {

                alert("La tarea no existe.");
            }
        }

        if (opcion == 4) {

            let mensaje = "LISTA DE TAREAS\n\n";

            for (let i = 0; i < tareas.length; i++) {

                mensaje = mensaje + tareas[i] + " - " + estados[i] + "\n";
            }

            alert(mensaje);
        }

        if (opcion == 5) {

            let mensaje = "TAREAS PENDIENTES\n\n";

            for (let i = 0; i < tareas.length; i++) {

                if (estados[i] == "pendiente") {

                    mensaje = mensaje + tareas[i] + "\n";
                }
            }

            alert(mensaje);
        }
    }
}