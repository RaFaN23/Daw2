// ===============================
// JS-A1
// ===============================

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


// ===============================
// JS-A2
// ===============================

function ordenAlfabetico() {

    let nombres = [];

    for (let i = 0; i < 5; i++) {
        let nombre = prompt("Introduce el nombre " + (i + 1) + ":");
        nombres.push(nombre);
    }

    nombres.sort();

    alert("Orden alfabético: " + nombres);

    nombres.reverse();

    alert("Orden inverso: " + nombres);
}


// ===============================
// JS-A3
// ===============================

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

    alert("Números impares: " + impares);
}


// ===============================
// JS-A4
// ===============================

function contarPalabras() {

    let frase = prompt("Introduce una frase:");

    let palabras = frase.split(" ");

    let resultado = "";

    for (let i = 0; i < palabras.length; i++) {

        let contador = 0;

        for (let j = 0; j < palabras.length; j++) {

            if (palabras[i].toLowerCase() == palabras[j].toLowerCase()) {
                contador++;
            }
        }

        let yaExiste = false;

        for (let k = 0; k < i; k++) {
            if (palabras[i].toLowerCase() == palabras[k].toLowerCase()) {
                yaExiste = true;
            }
        }

        if (!yaExiste) {
            resultado = resultado + palabras[i] + ": " + contador + "\n";
        }
    }

    alert(resultado);
}


// ===============================
// JS-A5
// ===============================

function positivosNegativosCeros() {

    let numeros = [];
    let positivos = 0;
    let negativos = 0;
    let ceros = 0;

    let cantidad = Number(prompt("¿Cuántos números quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let numero = Number(prompt("Introduce el número " + (i + 1) + ":"));

        numeros.push(numero);

        if (numero > 0) {
            positivos++;
        } else if (numero < 0) {
            negativos++;
        } else {
            ceros++;
        }
    }

    alert("Positivos: " + positivos +
        "\nNegativos: " + negativos +
        "\nCeros: " + ceros);
}


// ===============================
// JS-A6
// ===============================

function diaSemana() {

    let dias = [
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo"
    ];

    let numero = Number(prompt("Introduce un número del 1 al 7:"));

    if (numero >= 1 && numero <= 7) {
        alert("El día es: " + dias[numero - 1]);
    } else {
        alert("Número incorrecto");
    }
}


// ===============================
// JS-A7
// ===============================

function notas() {

    let notas = [];

    for (let i = 0; i < 10; i++) {

        let nota = Number(prompt("Introduce la nota " + (i + 1) + ":"));

        notas.push(nota);
    }

    let mayor = Math.max(...notas);
    let menor = Math.min(...notas);

    let suma = 0;

    for (let i = 0; i < notas.length; i++) {
        suma = suma + notas[i];
    }

    let media = suma / notas.length;

    alert("Media: " + media +
        "\nNota más alta: " + mayor +
        "\nNota más baja: " + menor);
}


// ===============================
// JS-A8
// ===============================

function numerosPares() {

    let numeros = [];

    for (let i = 1; i <= 20; i++) {

        let numero = i * 2;

        numeros.push(numero);
    }

    alert("20 primeros números pares: " + numeros);
}


// ===============================
// JS-A9
// ===============================

function palabrasLargaCorta() {

    let palabras = [];

    for (let i = 0; i < 5; i++) {

        let palabra = prompt("Introduce la palabra " + (i + 1) + ":");

        palabras.push(palabra);
    }

    let larga = palabras[0];
    let corta = palabras[0];

    for (let i = 1; i < palabras.length; i++) {

        if (palabras[i].length > larga.length) {
            larga = palabras[i];
        }

        if (palabras[i].length < corta.length) {
            corta = palabras[i];
        }
    }

    alert("Palabra más larga: " + larga +
        "\nPalabra más corta: " + corta);
}


// ===============================
// JS-A10
// ===============================

function numerosSinMultiplos3() {

    let numeros = [];

    for (let i = 1; i <= 100; i++) {

        if (i % 3 != 0) {
            numeros.push(i);
        }
    }

    alert("Números sin múltiplos de 3: " + numeros);
}


// ===============================
// JS-A11
// ===============================

function nombresVocal() {

    let nombres = [];

    let cantidad = Number(prompt("¿Cuántos nombres quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let nombre = prompt("Introduce el nombre " + (i + 1) + ":");

        nombres.push(nombre);
    }

    let contador = 0;

    for (let i = 0; i < nombres.length; i++) {

        let primeraLetra = nombres[i].charAt(0).toLowerCase();

        if (
            primeraLetra == "a" ||
            primeraLetra == "e" ||
            primeraLetra == "i" ||
            primeraLetra == "o" ||
            primeraLetra == "u"
        ) {
            contador++;
        }
    }

    alert("Nombres que empiezan por vocal: " + contador);
}


// ===============================
// JS-A12
// ===============================

function numerosPrimos() {

    let numeros = [];

    for (let i = 0; i < 10; i++) {

        let numero = Math.floor(Math.random() * 50) + 1;

        numeros.push(numero);
    }

    let primos = [];

    for (let i = 0; i < numeros.length; i++) {

        let numero = numeros[i];
        let esPrimo = true;

        if (numero < 2) {
            esPrimo = false;
        }

        for (let j = 2; j < numero; j++) {

            if (numero % j == 0) {
                esPrimo = false;
            }
        }

        if (esPrimo) {
            primos.push(numero);
        }
    }

    alert("Números generados: " + numeros +
        "\nPrimos: " + primos);
}


// ===============================
// JS-A13
// ===============================

function conjuntoNumeros() {

    let numeros = new Set();

    for (let i = 0; i < 15; i++) {

        let numero = Number(prompt("Introduce el número " + (i + 1) + ":"));

        numeros.add(numero);
    }

    alert("Resultado sin duplicados: " + [...numeros]);
}


// ===============================
// JS-A14
// ===============================

function palabrasDistintas() {

    let palabras = new Set();

    let cantidad = Number(prompt("¿Cuántas palabras quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let palabra = prompt("Introduce la palabra " + (i + 1) + ":");

        palabras.add(palabra);
    }

    alert("Palabras distintas: " + palabras.size);
}


// ===============================
// JS-A15
// ===============================

function paresSinRepetir() {

    let numeros = new Set();

    let cantidad = Number(prompt("¿Cuántos números quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let numero = Number(prompt("Introduce el número " + (i + 1) + ":"));

        if (numero % 2 == 0) {
            numeros.add(numero);
        }
    }

    alert("Pares sin repetir: " + [...numeros]);
}


// ===============================
// JS-A16
// ===============================

function fraseSinRepetir() {

    let frase = prompt("Introduce una frase:");

    let palabras = frase.split(" ");

    let conjunto = new Set(palabras);

    alert("Frase sin palabras repetidas: " + [...conjunto]);
}


// ===============================
// JS-A17
// ===============================

function conjuntoSinMultiplos5() {

    let numeros = new Set();

    for (let i = 1; i <= 20; i++) {
        numeros.add(i);
    }

    for (let numero of numeros) {

        if (numero % 5 == 0) {
            numeros.delete(numero);
        }
    }

    alert("Conjunto sin múltiplos de 5: " + [...numeros]);
}


// ===============================
// JS-A18
// ===============================

function animales() {

    let animales = new Set();

    let cantidad = Number(prompt("¿Cuántos animales quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let animal = prompt("Introduce el animal " + (i + 1) + ":");

        animales.add(animal);
    }

    let buscar = prompt("¿Qué animal quieres buscar?");

    if (animales.has(buscar)) {
        alert("El animal está en el conjunto");
    } else {
        alert("El animal no está en el conjunto");
    }
}


// ===============================
// JS-A19
// ===============================

function letrasDistintas() {

    let palabra = prompt("Introduce una palabra:");

    let letras = new Set(palabra);

    alert("Número de letras distintas: " + letras.size);
}


// ===============================
// JS-A20
// ===============================

function sumaSet() {

    let numeros = new Set();

    let cantidad = Number(prompt("¿Cuántos números quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let numero = Number(prompt("Introduce el número " + (i + 1) + ":"));

        numeros.add(numero);
    }

    let suma = 0;

    for (let numero of numeros) {
        suma = suma + numero;
    }

    alert("Suma total: " + suma);
}


// ===============================
// JS-A21
// ===============================

function personasEdad() {

    let personas = new Map();

    for (let i = 0; i < 5; i++) {

        let nombre = prompt("Introduce el nombre de la persona " + (i + 1) + ":");
        let edad = Number(prompt("Introduce su edad:"));

        personas.set(nombre, edad);
    }

    let nombreJoven = "";
    let edadJoven = Infinity;

    let nombreMayor = "";
    let edadMayor = -Infinity;

    for (let [nombre, edad] of personas) {

        if (edad < edadJoven) {
            edadJoven = edad;
            nombreJoven = nombre;
        }

        if (edad > edadMayor) {
            edadMayor = edad;
            nombreMayor = nombre;
        }
    }

    alert("Persona más joven: " + nombreJoven + " (" + edadJoven + " años)" +
        "\nPersona más mayor: " + nombreMayor + " (" + edadMayor + " años)");
}


// ===============================
// JS-A22
// ===============================

function productos() {

    let productos = new Map();

    for (let i = 0; i < 5; i++) {

        let nombre = prompt("Introduce el producto " + (i + 1) + ":");
        let precio = Number(prompt("Introduce el precio:"));

        productos.set(nombre, precio);
    }

    let productoCaro = "";
    let precioCaro = -Infinity;

    let productoBarato = "";
    let precioBarato = Infinity;

    let suma = 0;

    for (let [producto, precio] of productos) {

        if (precio > precioCaro) {
            precioCaro = precio;
            productoCaro = producto;
        }

        if (precio < precioBarato) {
            precioBarato = precio;
            productoBarato = producto;
        }

        suma = suma + precio;
    }

    let media = suma / productos.size;

    alert("Producto más caro: " + productoCaro + " - " + precioCaro + "€" +
        "\nProducto más barato: " + productoBarato + " - " + precioBarato + "€" +
        "\nPrecio medio: " + media + "€");
}


// ===============================
// JS-A23
// ===============================

function alumnosNotas() {

    let alumnos = new Map();

    let cantidad = Number(prompt("¿Cuántos alumnos quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let nombre = prompt("Introduce el nombre del alumno " + (i + 1) + ":");
        let nota = Number(prompt("Introduce su nota:"));

        alumnos.set(nombre, nota);
    }

    let aprobados = 0;
    let suspendidos = 0;

    for (let [nombre, nota] of alumnos) {

        if (nota >= 5) {
            aprobados++;
        } else {
            suspendidos++;
        }
    }

    alert("Aprobados: " + aprobados +
        "\nSuspendidos: " + suspendidos);
}


// ===============================
// JS-A24
// ===============================

function mapaPalabras() {

    let frase = prompt("Introduce una frase:");

    let palabras = frase.split(" ");

    let mapa = new Map();

    for (let i = 0; i < palabras.length; i++) {

        let palabra = palabras[i];

        if (mapa.has(palabra)) {

            mapa.set(palabra, mapa.get(palabra) + 1);

        } else {

            mapa.set(palabra, 1);
        }
    }

    let resultado = "";

    for (let [palabra, cantidad] of mapa) {

        resultado = resultado + palabra + ": " + cantidad + "\n";
    }

    alert(resultado);
}


// ===============================
// JS-A25
// ===============================

function coches() {

    let coches = new Map();

    for (let i = 0; i < 5; i++) {

        let matricula = prompt("Introduce la matrícula del coche " + (i + 1) + ":");
        let marca = prompt("Introduce la marca:");

        coches.set(matricula, marca);
    }

    let resultado = "";

    for (let [matricula, marca] of coches) {

        resultado = resultado +
            "Matrícula: " + matricula +
            " - Marca: " + marca + "\n";
    }

    alert(resultado);
}


// ===============================
// JS-A26
// ===============================

function paises() {

    let paises = new Map();

    let cantidad = Number(prompt("¿Cuántos países quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let pais = prompt("Introduce el país:");
        let capital = prompt("Introduce su capital:");

        paises.set(pais, capital);
    }

    let buscar = prompt("¿Qué país quieres consultar?");

    if (paises.has(buscar)) {

        alert("La capital de " + buscar + " es " + paises.get(buscar));

    } else {

        alert("Ese país no está en el mapa");
    }
}


// ===============================
// JS-A27
// ===============================

function telefonos() {

    let personas = new Map();

    let cantidad = Number(prompt("¿Cuántas personas quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let nombre = prompt("Introduce el nombre:");
        let telefono = prompt("Introduce el teléfono:");

        personas.set(nombre, telefono);
    }

    let buscar = prompt("¿De quién quieres buscar el teléfono?");

    if (personas.has(buscar)) {

        alert("El teléfono de " + buscar + " es " + personas.get(buscar));

    } else {

        alert("Esa persona no está en el mapa");
    }
}


// ===============================
// JS-A28
// ===============================

function asignaturas() {

    let asignaturas = new Map();

    for (let i = 0; i < 5; i++) {

        let asignatura = prompt("Introduce la asignatura " + (i + 1) + ":");
        let nota = Number(prompt("Introduce la nota:"));

        asignaturas.set(asignatura, nota);
    }

    let suma = 0;

    for (let nota of asignaturas.values()) {

        suma = suma + nota;
    }

    let media = suma / asignaturas.size;

    alert("Media de las asignaturas: " + media);
}


// ===============================
// JS-A29
// ===============================

function empleados() {

    let empleados = new Map();

    let cantidad = Number(prompt("¿Cuántos empleados quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let nombre = prompt("Introduce el nombre del empleado:");
        let salario = Number(prompt("Introduce el salario:"));

        empleados.set(nombre, salario);
    }

    let total = 0;

    for (let salario of empleados.values()) {

        total = total + salario;
    }

    let media = total / empleados.size;

    alert("Salario total: " + total + "€" +
        "\nSalario medio: " + media + "€");
}


// ===============================
// JS-A30
// ===============================

function libros() {

    let libros = new Map();

    let cantidad = Number(prompt("¿Cuántos libros quieres introducir?"));

    for (let i = 0; i < cantidad; i++) {

        let libro = prompt("Introduce el nombre del libro:");
        let autor = prompt("Introduce el autor:");

        if (libros.has(autor)) {

            libros.get(autor).push(libro);

        } else {

            libros.set(autor, [libro]);
        }
    }

    let buscar = prompt("¿De qué autor quieres buscar los libros?");

    if (libros.has(buscar)) {

        alert("Libros de " + buscar + ": " + libros.get(buscar));

    } else {

        alert("Ese autor no está registrado");
    }
}