/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Random;

/**
 *
 * @author Bono
 */
public class Bubblesort {
    private static int BUBBLE_SORT = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        int sort = BUBBLE_SORT;
        int[] cijfers = new int[100];
        Random random = new Random();
        
        for(int i = 0; i < cijfers.length; i++){
            cijfers[i] = random.nextInt();
        }
        
        switch(sort){
            case 0:
                cijfers = bubbleSort(cijfers);
                break;
        }
        
        display(cijfers);
    }
    
    private static int[] bubbleSort(int[] cijfers){        
        for(int current = 0; current < cijfers.length; current++){
            for(int next = (current + 1); next < cijfers.length; next++){
                if(cijfers[current] > cijfers[next]){
                    int tmp = cijfers[next];
                    cijfers[next] = cijfers[current];
                    cijfers[current] = tmp;
                }
            }
        }
        
        return cijfers;
    }
    
    private static void display(int[] cijfers){
        for(int cijfer : cijfers){
            System.out.println(cijfer);
        }
    }
}
