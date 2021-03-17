# This is a sample Python script.

# Press Mayús+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

#SelectorEjercicio
def selector():
    n_ejercicio=int(input("¿Que ejercicio quiere hacer?"))
    if n_ejercicio == 1:
        ejercicio1()
    if n_ejercicio == 2:
        ejercicio2()
    if n_ejercicio == 3:
        ejercicio3()
    if n_ejercicio == 4:
        ejercicio4()
    if n_ejercicio == 5:
        ejercicio5()
#Ejercicio1
def ejercicio1():
    n1 = 7
    tipo1 = type(n1)
    n2 = 8.5
    tipo2 = type(n2)
    n3 = 7
    tipo3 = type(n3)
    print("Numero 1= " + str(tipo1) + ", numero 2= " + str(tipo2) + ", numero 3= " + str(tipo3))
    sumatorio = n1 + n2 + n3
    print("Suma= " + str(sumatorio) + ", Tipo " + str(type(sumatorio)))

#Ejercicio2
def ejercicio2():
    tipo_moneda=int(input("1--Dolares  2--Euros. Escribe a que quieres convertir"))
    if tipo_moneda == 1:
        dol = int(input("Introduzca cantidad de euros"))
        euros = dol * 1.19
        print("")
        print("euros=", euros)
    if tipo_moneda == 2:
        eur = int(input("Introduzca cantidad de dolares"))
        dolares = eur * 0.84
        print("")
        print("dolares=", dolares)

#Ejercicio3
def ejercicio3():
    import random
    n_aleatorio = random.randint(1, 100)
    print(n_aleatorio)
    if n_aleatorio % 2 == 0:
        print('El número', n_aleatorio, 'es par.')
    else:
        print('El número', n_aleatorio, 'es impar.')

#Ejercicio4
def ejercicio4():
    import string
    texto = str(input("Copie y pegue un texto").lower())
    letra_a = "a"
    contador_a = 0
    letra_o = "o"
    contador_o = 0
    for x in texto:
        if letra_a == x:
            contador_a = contador_a + 1
        if letra_o == x:
            contador_o = contador_o + 1
    print('Hay {} A y {} O'.format(contador_a, contador_o))

#Ejercicio5
def ejercicio5():
    nombre_fichero = input("¿Cómo se llama su fichero de notas importantes?")
    mimemoria = open(nombre_fichero + ".txt", "a+")
    mimemoria = open(nombre_fichero + ".txt", "r")
    print(mimemoria.read())
    nota_importante= input("¿Que nota desea escribir?")
    mimemoria = open(nombre_fichero + ".txt", "a+")
    mimemoria.write(nota_importante+"\n")
    mimemoria.close()

def main():
    selector()



if __name__ == '__main__':
    main()


