/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class MetodosABB {

    Scanner entrada;
    NodoABB raiz;

    public MetodosABB() {
        this.entrada = new Scanner(System.in);
        this.raiz = null;
    }

    public int menu() {
        int op;
        System.out.println("Insertar [1]: ");
        System.out.println("Recorrer [2]: ");
        System.out.println("Eliminar [3]: ");
        System.out.println("Salir [0]: ");
        op = entrada.nextInt();
        return op;
    }

    public NodoABB insertar(NodoABB actual, int num) {
        if (actual == null) {
            NodoABB nuevo = new NodoABB(num);
            return nuevo;

        } else {
            if (actual.dato == num) {
                System.out.println("No se pueden insertar datos repetidos...");
            } else if (num > actual.dato) {
                actual.der = insertar(actual.der, num);
            } else {
                actual.izq = insertar(actual.izq, num);
            }

        }
        return actual;
    }

    public void preOrden(NodoABB actual) {
        if (actual != null) {
            System.out.print(actual.dato + " ");
            preOrden(actual.izq);
            preOrden(actual.der);
        }
    }

    public void inOrden(NodoABB actual) {
        if (actual != null) {

            inOrden(actual.izq);
            System.out.print(actual.dato + " ");
            inOrden(actual.der);
        }
    }

    public void reemplazar(NodoABB actual) {
        NodoABB p = actual;
        NodoABB a = actual.izq;
        while (a.der != null) {
            p = a;
            a = a.der;
        }
        actual.dato = a.dato;
        if (p == actual) {
            p.izq = a.izq;

        } else {
            p.der = a.izq;
            actual = a;

        }
    }

    /*public void eliminar(NodoABB actual, int n) {
        System.out.println(actual);
        if (actual == null) {
            System.out.println("El elemento no esta en el arbol...");
        } else if (actual.dato < n) {
            eliminar(actual.der, n);
        } else if (actual.dato > n) {
            eliminar(actual.izq, n);

        } else {
            System.out.println("actual");
            NodoABB auxABB = actual;
            if (auxABB.izq == null) {
                System.out.println("actual 2");
                actual = auxABB.der;
            } else if (auxABB.der == null) {
                System.out.println("actual 3");
                actual = auxABB.izq;
            } else {
                   System.out.println("actual");
                auxABB = null;
                reemplazar(auxABB);
             

            }
        }

    }
*/
    public void eliminar(NodoABB actual, int n) {
        System.out.println(actual.dato + "nodo raiz");
        NodoABB aux = actual;

        if (actual == null) {
            System.out.println("El elemento no esta en el arbol");

        } else {
            if (n < actual.dato) {
                eliminar(actual.izq, n);
                actual.izq = raiz;
            } else {
                if (n > actual.dato) {
                    System.out.println("Dato mayor");
                    eliminar(actual.der, n);
                    actual.der = raiz;
                } else {
                    NodoABB aux1, aux2, aux3;
                    aux3 = actual;
                    if (aux3.der != null) {
                        if (aux3.izq != null) {
                            actual = null;
                        } else {
                            actual = aux3.izq;
                        }
                    } else {
                        if (aux3.izq != null) {
                            actual = aux3.der;
                        } else {
                            aux1 = aux3.izq;
                            aux2 = aux3;
                            while (aux1.der != null) {
                                aux2 = aux1;
                                aux1 = aux1.der;
                            }
                            aux3.dato = aux1.dato;
                            if (aux3 == aux2) {
                                aux3.izq = null;
                            } else {
                                if (aux1.izq != null) {
                                    aux2.der = null;
                                } else {
                                    aux2.der = aux1.izq;
                                }

                            }
                            aux3 = aux1;
                        }

                    }

                }
            }

        }

        raiz = actual;
    }
    public void posOrden(NodoABB actual) {
        if (actual != null) {
            posOrden(actual.izq);
            posOrden(actual.der);
            System.out.print(actual.dato + " ");
        }
    }
}
