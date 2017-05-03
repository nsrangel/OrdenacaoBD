/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

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
public interface Item {
        
    public int compara (Item it);
    public void alteraChave (Object chave);
    public Object recuperaChave();
    
    
}
