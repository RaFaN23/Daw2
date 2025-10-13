# 1) Pide al usuario su nombre y muestra un saludo personalizado (por ejemplo: “Hola, Ana”).
from os.path import split


def ejercicio1():
    print("Hola Jose ignacio")
#ejercicio1()

#2) Solicita dos números enteros al usuario y muestra su suma.
def ejercicio2():
    numero = int(input("Introduce un numero: "))
    triple = numero * 3
    print("El triple es: " + str(triple ))
#ejercicio2()

#3) Calcula el área de un triángulo (base * altura / 2) pidiendo base y altura al usuario.
def ejercicio3():
    base = float(int(input("Introduce un numero: ")))
    altura = float(input("Introduce un altura: "))
    area = (base * altura) / 2
    print("El area es: " + str(area))
#ejercicio3()


#4) Pide un número N y muestra los números del 1 al N (inclusive), uno por línea.
def ejercicio4():
    numero = int(input("Introduce un numero: "))
    numero_suma = 0
    while numero_suma <= numero:
        print(numero_suma)
        numero_suma += 1
#ejercicio4()


#5) Pide un número y muestra su tabla de multiplicar del 1 al 10.
def ejercicio5():
    numero = int(input("Introduce un numero: "))
    for i in range (1,11):
        resultado = numero * i
        print("El resultado es: " + str(resultado))
#ejercicio5()


#6) Pide un número y di si es par o impar.
def ejercicio6():
    numero = int(input("Introduce un numero: "))
    if numero % 2 == 0:
        print("El numero es par")
    else:
        print("El numero es impar")
#ejercicio6()


#Pide una lista de enteros separados por espacios y muestra el mayor número.
def ejercicio7():
    entrada = input("Introduce una lista de números separados por espacios: ")
    lista = list(map(int, entrada.split()))
    mayor = max(lista)
    print("El número mayor es:", mayor)

#ejercicio7()

# 8) Define una función factorial(n) que devuelva el factorial de n y úsala para un número pedido al usuario.
def ejercicio8():
    def factorial(n):
        if n == 0 or n == 1:
            return 1
        resultado = 1
        for i in range(1, n + 1):
            resultado *= i
        return resultado

    numero = int(input("Introduce un número para calcular su factorial: "))
    resultado = factorial(numero)
    print("El factorial de " + str(numero) + " es: " + str(resultado))


# ejercicio8()

# 9) Pide una frase y muestra cuántas vocales contiene.
def ejercicio9():
    frase = input("Introduce una frase: ")
    vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ"
    contador = 0
    for letra in frase:
        if letra in vocales:
            contador += 1
    print("La frase contiene " + str(contador) + " vocales")


# ejercicio9()

# 10) Crea una agenda (diccionario) que permita añadir pares nombre->teléfono hasta escribir 'salir'. Luego muestra toda la agenda.
def ejercicio10():
    agenda = {}
    while True:
        nombre = input("Introduce un nombre (o 'salir' para terminar): ")
        if nombre.lower() == "salir":
            break
        telefono = input("Introduce el teléfono de " + nombre + ": ")
        agenda[nombre] = telefono

    print("\n--- AGENDA ---")
    for nombre, telefono in agenda.items():
        print(nombre + ": " + telefono)


# ejercicio10()

# 11) Abre un fichero de texto llamado 'datos.txt' y muestra por pantalla cuántas líneas tiene.
def ejercicio11():
    try:
        with open("datos.txt", "r", encoding="utf-8") as archivo:
            lineas = archivo.readlines()
            print("El archivo tiene " + str(len(lineas)) + " líneas")
    except FileNotFoundError:
        print("El archivo 'datos.txt' no existe")


# ejercicio11()

# 12) Pide dos números y realiza la división segura (a/b). Si el usuario introduce datos no válidos o b es 0, muestra un mensaje adecuado (maneja excepciones).
def ejercicio12():
    try:
        a = float(input("Introduce el primer número (dividendo): "))
        b = float(input("Introduce el segundo número (divisor): "))
        resultado = a / b
        print("El resultado de la división es: " + str(resultado))
    except ValueError:
        print("Error: Debes introducir números válidos")
    except ZeroDivisionError:
        print("Error: No se puede dividir entre cero")


# ejercicio12()

# 13) Crea una clase Rectangulo con base y altura. Implementa métodos area() y perimetro(). Crea un objeto y muestra sus resultados.
def ejercicio13():
    class Rectangulo:
        def __init__(self, base, altura):
            self.base = base
            self.altura = altura

        def area(self):
            return self.base * self.altura

        def perimetro(self):
            return 2 * (self.base + self.altura)

    base = float(input("Introduce la base del rectángulo: "))
    altura = float(input("Introduce la altura del rectángulo: "))

    mi_rectangulo = Rectangulo(base, altura)
    print("Área del rectángulo: " + str(mi_rectangulo.area()))
    print("Perímetro del rectángulo: " + str(mi_rectangulo.perimetro()))


# ejercicio13()

# 14) Pide dos catetos (a y b) y muestra la hipotenusa usando el teorema de Pitágoras (usa el módulo math).
def ejercicio14():
    import math
    a = float(input("Introduce el primer cateto: "))
    b = float(input("Introduce el segundo cateto: "))
    hipotenusa = math.sqrt(a ** 2 + b ** 2)
    print("La hipotenusa es: " + str(hipotenusa))


# ejercicio14()

# 15) Dada una lista de enteros, genera una nueva lista con los cuadrados de los pares (usa comprensiones de listas).
def ejercicio15():
    entrada = input("Introduce una lista de números separados por espacios: ")
    numeros = [int(x) for x in entrada.split()]
    cuadrados_pares = [n ** 2 for n in numeros if n % 2 == 0]
    print("Cuadrados de los números pares: " + str(cuadrados_pares))
# ejercicio15()