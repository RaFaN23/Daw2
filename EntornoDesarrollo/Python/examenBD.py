
def sumar():
    suma = 0
    contador = 0

    while contador < 10:
        numero = int(input(f"Ingrese el número par {contador + 1}: "))
        if numero % 2 == 0:
            suma += numero
            contador += 1
        else:
            print("No par")

    print("La suma de los numeros pares:", suma)
#sumar()

def sumar_numeros(lista):
    suma = 0
    i = 0
    while i < len(lista):
        suma += lista[i]
        i += 1
    return suma
numeros = [10, 20 ,30, 40]
#resultado = sumar_numeros(numeros)
#print("La suma de los numeros es :", resultado)


#frase = input("Introduce una frase: ")
#letra = input("Introduce una letra: ")
#contador = 0
#for i in frase:
#    if i == letra:
#        contador += 1
#print("La letra '%s' aparece %2i veces en la frase '%s'." % (letra, contador, frase))











Pokemons = []
def agregar_pokemon():
    nombre = input("Ingrese el nombre del pokemon: ")
    tipo = input("Ingrese el tipo del pokemon: ")
    nivel = int(input("Ingrese el nivel del pokemon: "))
    Pokemons.append({"nombre": nombre, "tipo": tipo, "nivel": nivel})
    print("pokemon agregado con éxito.")

def mostrar_Pokemons():
    if not Pokemons:
        print("No tienes nada(Noob).")
    else:
        print("Lista de pokemon capturados:")
        for p in Pokemons:
            print(f"Nombre: {p['nombre']}, Tipo: {p['tipo']}, Nivel: {p['nivel']}")
        print()

def buscar_por_tipo():
    tipo = input("Ingrese el tipo de pokemon a buscar: ")
    encontrados = [p for p in Pokemons if p["tipo"].lower() == tipo.lower()]
    if encontrados:
        print("pokemon encontrados:")
        for p in encontrados:
            print(f"Nombre: {p['nombre']}, Tipo: {p['tipo']}, Nivel: {p['nivel']}")
    else:
        print("No tienes.")
    print()

def eliminar_pokemon():
    nombre = input("Que quieres eliminar: ")
    for p in Pokemons:
        if p["nombre"].lower() == nombre.lower():
            Pokemons.remove(p)
            print("Eliminado")
            return
    print("No tienes o no lo has escrito bien")

def subir_nivel():
    nombre = input("Ingrese el nombre del pokemon: ")
    for p in Pokemons:
        if p["nombre"].lower() == nombre.lower():
            incremento = int(input("Ingrese el de niveles que quieres levelear: "))
            p["nivel"] += incremento
            print(f"Nivel actualizado. Nuevo nivel de {p['nombre']}: {p['nivel']}")
            return
    print("No se encontró un pokemon con ese nombre.")

def jugar_Pokemon():
    while True:
        print("1.Agregar un pokemon")
        print("2.Mostrar todos los pokemon")
        print("3.Buscar pokemon por tipo")
        print("4.Eliminar un pokemon")
        print("5.Subir de nivel un pokemon")
        print("6.Salir")
        opcion = input("Seleccione una opción: ")
        if opcion == "1":
            agregar_pokemon()
        elif opcion == "2":
            mostrar_Pokemons()
        elif opcion == "3":
            buscar_por_tipo()
        elif opcion == "4":
            eliminar_pokemon()
        elif opcion == "5":
            subir_nivel()
        elif opcion == "6":
            print("aDIOS ")
            break
        else:
            print("Opción no válida. Intente de nuevo.")

jugar_Pokemon()

