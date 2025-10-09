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

#8) Define una función factorial(n) que devuelva el factorial de n y úsala para un número pedido
#al usuario.
def ejercicio8():
    numero = input("di numero ")
    donde = input("di donde ")
    return numero + (donde-1)
ejercicio8()