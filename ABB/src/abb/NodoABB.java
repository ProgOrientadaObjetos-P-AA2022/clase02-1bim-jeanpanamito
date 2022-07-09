/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author PERSONAL
 */
public class NodoABB {
    int dato;
    NodoABB izq;
    NodoABB der;

    public NodoABB(int _dato) {
        this.dato=_dato;
        this.izq=null;
        this.der=null;
    }
    
}
