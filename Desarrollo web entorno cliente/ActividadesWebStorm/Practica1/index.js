function sumar() {
    let numero1 = Number(prompt("Introduce el primer número:"));
    let numero2 = Number(prompt("Introduce el segundo numero"));
    let resultado = numero1 + numero2;
    alert(resultado);
}

function multiplicar() {
    let numero1 = Number(prompt("Introduce el primer número:"));
    let numero2 = Number(prompt("Introduce el segundo numero"));
    let resultado = numero1 * numero2;
    alert(resultado);
}

function temperatura() {
    let centigrado = Number(prompt("Pon los grados centigrados"))
    alert("los numeros en centigrados " + centigrado);
    alert("Los numeros en fahrenhes " + (centigrado * 1.8)+32);
    alert("Los grados en kelvin" + (centigrado +273.15));
}

function calcularArea() {
    let lado = Number(prompt("Introduce el lado del cuadrado:"));
    let area = lado * lado;
    alert("El area del cuadrado es: " + area);
}

function calcularAreaCirculo() {
    let radio = Number(prompt("Introduce el radio del circulo:"));
    let area = Math.PI * radio * radio;
    alert("El área del círculo es: " + area);
}

function descuento(){
    let precio = Number(prompt("Introduce el precio :"));
    let descuento = Number(prompt("Introduce el descuento"));
    let ahorro = precio * descuento/100;
    let preciofinal = precio - ahorro;
    alert("El precio iniciales: " + precio );
    alert("El descuento es de : " + descuento+"%");
    alert("Y el precio con descuento: " + preciofinal);
}

function gastosViaje(){
    let gasolina = Number(prompt("Introduce el gasolina:"));
    let hotel = Number(prompt("Introduce el hotel:"));
    let restaurante = Number(prompt("Introduce el restaurante:"));
    let todo = gasolina + hotel + restaurante;
    let porcentajeGasolina = (gasolina / todo) * 100;
    let porcentajeRestaurante = (restaurante / todo) * 100;
    let porcentajeHotel= (hotel / todo) * 100;
    alert("El % de gasolina es : "+ porcentajeGasolina.toFixed(2)+"%");
    alert("El % de restaurante es : "+ porcentajeRestaurante.toFixed(2)+"%");
    alert("EL % de hotel es : "+ porcentajeHotel.toFixed(2)+"%");
}

function esNulo(){
    let numero1 = Number(prompt("Introduce el numero:"));
    if (numero1 == 0) {
        alert("El número es nulo.");
    } else {
        alert("El número no es nulo.");
    }
}

function esPositivo() {
    let numero1 = Number(prompt("Introduce el numero:"));
    if (numero1 > 0) {
        alert("El número es positivo.");
    } else if (numero1 < 0) {
        alert("El número es negativo.");
    } else {
        alert("El número es cero.");
    }
}

function esPositivo2() {
    let numero1 = Number(prompt("Introduce el numero:"));
    let numero2 = Number(prompt("Introduce el segundo numero:"));
    let suma = numero1 + numero2;
    if (suma > 0) {
        alert("La suma es positiva.");
    } else if (suma < 0) {
        alert("La suma es negativa.");
    } else {
        alert("La suma es cero.");
    }
}

function EstoSi() {
    let numero1 = Number(prompt("Introduce el primer número:"));
    let numero2 = Number(prompt("Introduce el segundo numero:"));
    if ((numero1 + numero2) > 10 && (numero1 * numero2) > 50) {
        alert("La suma es mayor que 10 y el producto es mayor que 50.");
    } else {
        alert("La suma no es mayor que 10 o el producto no es mayor que 50.");
    }
}

function edad() {
    let edad = Number(prompt("Introduce tu edad:"));
    if ((edad >= 25) && (edad <= 45)) {
        alert("Nos vale");
    } else {
        alert("No nos vale");
    }
}

function comprobarResultados() {
    let numero1 = Number(prompt("Primer numero"));
    let numero2 = Number(prompt("Segundo numero"));
    let respuestaSuma = Number(prompt("¿Cual es el resultado de la suma?"));
    let respuestaResta = Number(prompt("¿Cual es el resultado de la resta?"));
    let sumaCorrecta = numero1 + numero2;
    let restaCorrecta = numero1 - numero2;
    if (respuestaSuma === sumaCorrecta && respuestaResta === restaCorrecta) {
        alert("Muy bien");
    } else {
        alert("Así no");
    }
}

function comprobarMes() {
    let mes = Number(prompt("Introduce un numero de mes (1-12):"));
    if (mes >= 1 && mes <= 12) {
        alert("Correcto");
    } else {
        alert("No correcto");
    }
}

function ecuacionCuadratica() {
    let a = Number(prompt("Introduce el valor de a:"));
    let b = Number(prompt("Introduce el valor de b:"));
    let c = Number(prompt("Introduce el valor de c:"));

    let discriminante = b * b - 4 * a * c;

    if (discriminante < 0) {
        alert("No tiene solucion real");
    } else {
        let x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        let x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        alert("x1 = " + x1 + "\nx2 = " + x2);
    }
}

function dividir() {
    let numero1 = Number(prompt("Introduce el primer número entero:"));
    let numero2 = Number(prompt("Introduce el segundo número entero:"));

    if (numero2 === 0) {
        alert("No se puede hacer la división");
    } else {
        let cociente = Math.floor(numero1 / numero2);
        let resto = numero1 % numero2;

        alert("Cociente: " + cociente + "\nResto: " + resto);
    }
}

function potencia() {
    let numero = Number(prompt("Introduce el número:"));
    let exponente = Number(prompt("Introduce el exponente:"));

    let resultado = numero ** exponente;

    alert("El resultado es: " + resultado);
}

function ordenarNumeros() {
    let numero1 = Number(prompt("Introduce el primer número:"));
    let numero2 = Number(prompt("Introduce el segundo número:"));
    let numero3 = Number(prompt("Introduce el tercer número:"));

    let aux;

    if (numero1 > numero2) {
        aux = numero1;
        numero1 = numero2;
        numero2 = aux;
    }

    if (numero1 > numero3) {
        aux = numero1;
        numero1 = numero3;
        numero3 = aux;
    }

    if (numero2 > numero3) {
        aux = numero2;
        numero2 = numero3;
        numero3 = aux;
    }

    alert(numero1 + " - " + numero2 + " - " + numero3);
}

function mayorTriangulo() {
    let base1 = Number(prompt("Introduce la base del triángulo 1:"));
    let altura1 = Number(prompt("Introduce la altura del triángulo 1:"));

    let base2 = Number(prompt("Introduce la base del triángulo 2:"));
    let altura2 = Number(prompt("Introduce la altura del triángulo 2:"));

    let base3 = Number(prompt("Introduce la base del triángulo 3:"));
    let altura3 = Number(prompt("Introduce la altura del triángulo 3:"));

    let area1 = (base1 * altura1) / 2;
    let area2 = (base2 * altura2) / 2;
    let area3 = (base3 * altura3) / 2;

    if (area1 >= area2 && area1 >= area3) {
        alert("Base: " + base1 + "\nAltura: " + altura1 + "\nÁrea: " + area1);
    } else if (area2 >= area1 && area2 >= area3) {
        alert("Base: " + base2 + "\nAltura: " + altura2 + "\nÁrea: " + area2);
    } else {
        alert("Base: " + base3 + "\nAltura: " + altura3 + "\nÁrea: " + area3);
    }
}
