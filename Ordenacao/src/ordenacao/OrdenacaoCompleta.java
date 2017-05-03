/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

import java.util.Random;

/**
 *
 * @author Nícolas
 * Versão: 1.0
 * Objetivo: Objetivo: Desenvolver algoritmos de ordenação (Sort) para 
 * indexação, definindo métricas de qualidade entre eles, como forma de reduzir
 * MIPs em acessos a grande quantidade de dados. 
 * 
 * Versão 1.1
 *  - Melhoria de código
 * Possíveis aplicações em Bancos de Dados NoSQL, SQL para Big Data.
 */
public class OrdenacaoCompleta {
    /**********************************************************************
    Abaixo, foram utilizados 4 metodos de ordenação: Bubble Sort, Selection 
    Sort, Insert Sort, Quick Sort de modo não recursivo. Todos os dados estão
    com estimativas de tempo em milisegundos.
    ***********************************************************************/
    
    /************************************************************************* 
    Método responsável pelo Bubble Sort. A ideia é percorrer o vetor diversas
    vezes, a cada passagem fazendo flutuar para o topo o maior elemento 
    da sequência.
    *************************************************************************/
    public static void bubbleSort (Item v[], int n) {
        int i, j;
        for (i = 0; i < n-1; i++){
            for (j = 0; j < n-i-1; j++){
                if (v[j+1] == null){
                    Item aux = v[j];
                }
                    else if (v[j].compara(v[j+1]) > 0) {
                    Item aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
    
    /************************************************************************* 
    Método responsável pelo selectionsort. A ideia é se passar sempre o menor 
    valor do vetor para a primeira posição ou o maior e depois o de segundo 
    menor/maior valor para a segunda posição, e assim é feito sucessivamente
    com os n − 1 elementos restantes, até os últimos dois elementos.
    *************************************************************************/
    public static void selecao (Item v[], int n){
        for (int i=0; i < n-1; i++){
            int min = i;
            for (int j = i +1; j < n; j++) {
                if (v[j].compara(v[min]) < 0) min = j;
            }
            Item x = v[min];
            v[min] = v[i];
            v[i] = x;
           
        }
    }    
    
    /************************************************************************* 
    Método responsável pelo Insertion Sort. A idéia é construir uma matriz
    final com um elemento de cada vez, uma inserção por vez. Extremamente 
    eficiente para algoritmos de pequena entrada.
    *************************************************************************/
    public static void insercao (Item v[], int n) {
        int j;
        for (int i = 1; i < n; i++) {
            Item x = v[i];
            j = i - 1;
            while (j >= 0 && x.compara(v[j]) < 0) {
                v[j+1] = v[j]; 
                j--;
            }
            v[j + 1] = x;
        }
        
    }
    /************************************************************************* 
    Método responsável pelo Quick Sort. A idéia é rearranjar as chaves de modo
    que as chaves "menores" precedam as chaves "maiores". Para isso, é 
    necessario encontrar o meio, ou pivô.
    Em seguida o Quicksort ordena as duas sublistas de chaves menores e maiores
    recursivamente até que a lista completa se encontre ordenada.
    *************************************************************************/
    private static void quickSort(Item v[], int i, int f){
        if (i < f) {
            int div = particao(v, i, f);
            quickSort(v, i, div-1);
            quickSort(v, div+1, f);
        }
    }
    //Método para percorrer todo o arranjo e encontrar o elemento do meio (pivo)
    private static int particao (Item v[], int i, int f) {
        Item pivo = v[f]; //pivo sera o ultimo elemento
        Item aux;
        int a = i-1; // ainda não foi encontrado nenhum elemento <= pivo
        
        for (int b = i; b < f; b++){
            if (v[b].compara(pivo) <= 0) {
                a++;
                aux = v[a];
                v[a] = v[b];
                v[b] = aux;
            }
        }
        //Posiciona pivo
        aux = v[a+1];
        v[a+1] = v[f];
        v[f] = aux;
        return a+1; //retorna indice(posição) do pivo
    }
    
    public static void qSort(Item v[], int n){
        quickSort(v, 0, n-1);
    }
    
    /************************************************************************* 
    Método responsável pelo cópia do vetor. Como o arranjo é ordenado varias 
    vezes, é feita uma cópia do vetor original logo após ele ser criado com o
    arranjo aleátorio, pois não é valido medir a velocidade dos algoritimos com 
    arranjos diferentes.
    *************************************************************************/
    public static void copia (Item orig[], Item dest[], int n){
        for (int i=0; i < n; i++){
            dest[i] = orig[i];
        }
    }
    
    //imprime os valores no console
    public static void imprime (Item v[], int n){
        System.out.print("[");
        for (int i=0; i < n; i++){
            System.out.print(" " + v[i].recuperaChave());
           }
        System.out.println("] ");
    }

    public static void main(String[] args) {
        int tam = 10000; //Variável que determina o tamanho do arranjo
        long t0 = 0; // Tempo inicial antes do sort
        long t1 = 0; // Tempo final após o sort
            
        MeuItem a[] = new MeuItem[tam];
        MeuItem b[] = new MeuItem[tam];
        Random rand = new Random(); //sorteia numeros aleatorios
        for (int i = 0; i < tam; i++) {
            a[i] = new MeuItem (rand.nextInt(1000)); //restringe de 0 a 999
        }    
            //imprime vetor com numeros aleatorios
            System.out.println("Vetor Desordenado");
            imprime(a, tam);
            //faz cópia do vetor na memória
            copia(a, b, tam);
            
            //Executa selectsort
            //t0 e t1 são tempos antes e depois do sort
            System.out.println("\nSeleçao: ");
            t0 = System.currentTimeMillis();
            selecao (b, tam);
            t1 = System.currentTimeMillis();
            imprime (b, tam);
            System.out.println("Tempo Seleçao: " + (t1-t0));
            
            //volta vetor desordenado
            copia (a, b, tam);
            //executa insertsort
            System.out.println("\nInserção");
            t0 = System.currentTimeMillis();
            insercao(b, tam);
            t1 = System.currentTimeMillis();
            imprime (b, tam);
            System.out.println("Tempo Inserção: " + (t1-t0));
            
            //volta vetor desordenado
            copia (a, b, tam);
            
            System.out.println("\nBubble Sort");
            t0 = System.currentTimeMillis();
            bubbleSort(b, tam);
            t1 = System.currentTimeMillis();
            imprime (b, tam);
            System.out.println("Tempo Bubble Sort: " + (t1-t0));
            
            copia (a, b, tam);
            System.out.println("\nQuickSort");
            t0 = System.currentTimeMillis();
            qSort(b, tam);
            t1 = System.currentTimeMillis();
            imprime (b, tam);
            System.out.println("Tempo QuickSort: " + (t1-t0));           
        }
        
    }