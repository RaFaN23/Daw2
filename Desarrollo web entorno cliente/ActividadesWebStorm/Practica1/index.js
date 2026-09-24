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