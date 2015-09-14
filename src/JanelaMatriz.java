import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class JanelaMatriz extends JFrame {
    // Instance attributes used in this example
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;

    public JanelaMatriz(int tamanho) {
        // configuração do JFrame
        setTitle("Reciclador");
        setBackground(Color.gray);

        // Cria o painel
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // Cria os nomes das colunas
        

        Object[] colunas = new Object[tamanho];
        for (int i = 0; i < tamanho; i++) {
        	colunas[i] = i+1;
        }
        // Cria os dados, array com 3 linha e 3 colunas

        Object[][] valores = new Object[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
        	/* Aqui terá que ser sorteio, preenchi com esses valores só para testes */
        	/*
            valores[0][0] = "A";
            valores[0][5] = "A";
            valores[5][9] = "LS";
            valores[9][9] = "LO";
            valores[5][5] = "LS";
            valores[8][7] = "LO";
            valores[7][7] = "O";
            valores[5][5] = "O";
            valores[2][2] = "O";
            */
       }
        
       //Coloca as lixeiras em locais pré definidos
        if(tamanho == 10){
        	valores[2][2] = "Ls";
        	valores[7][7] = "Ls";
        	valores[2][7] = "Lo";
        	valores[7][2] = "Lo";
        }
        if(tamanho == 20){
        	valores[3][3] = "Ls";
        	valores[3][10] = "Lo";
        	valores[3][16] = "Ls";
        	valores[16][3] = "Lo";
        	valores[16][10] = "Ls";
        	valores[16][16] = "Lo";

        }
        if(tamanho == 30){
        	valores[3][6] = "Ls";
        	valores[3][15] = "Lo";
        	valores[3][23] = "Ls";
        	valores[16][6] = "Lo";
        	valores[16][23] = "Lo";
        	valores[27][6] = "Lo";
        	valores[27][15] = "Ls";
        	valores[27][23] = "Lo";

        }
        
        //instância um objeto da classe Random usando o construtor padrão
        Random sort = new Random();
        int s1 = sort.nextInt(tamanho);
        int s2 = sort.nextInt(tamanho);
        
        valores[s1][s2] = "A";

        // Cria o JTable
        table = new JTable(valores, colunas);

        // Adiciona o JTable dentro do painel
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

    }
}
