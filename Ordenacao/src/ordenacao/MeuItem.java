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
public class MeuItem implements Item {
    private int chave;
    //outros atributos
       
    public MeuItem(int chave){
        this.chave = chave;
    }
    
    public int compara (Item it){
        MeuItem item = (MeuItem) it; 
        if (this.chave < item.chave) return -1;
        else if (this.chave > item.chave) return 1;
        else return 0;
    }
    
    public void alteraChave (Object chave) {
        Integer ch = (Integer) chave;
        this.chave = ch.intValue();
    }
    
    public Object recuperaChave(){
        return new Integer (this.chave);
        //int não é classe. Integer é. Então cria-se um novo Integer para poder retornar para Object.
    }
    
    
    
    
    
}
