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
public class ABB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MetodosABB obj = new MetodosABB();
        Scanner entrada;
        int op, num;
        do {            
            op=obj.menu();
            switch(op){
                case 1: System.out.println("Elemento a insertar: ");
                    num= obj.entrada.nextInt();
                    obj.raiz=obj.insertar(obj.raiz,num);
                    break;
                case 2: 
                    obj.inOrden(obj.raiz);
                    System.out.println(" \n");
                    obj.preOrden(obj.raiz);
                    System.out.println(" \n");
                    obj.posOrden(obj.raiz);
                    System.out.println(" \n");
                    break;
                case 3:System.out.println("Elemento a eliminar:");
                num = obj.entrada.nextInt();
                    System.out.println(obj.raiz.dato+"dato");
                    obj.eliminar(obj.raiz, num);
                break;
                default:break;
            }
        } while (op!=0);
        
    }
    
}
