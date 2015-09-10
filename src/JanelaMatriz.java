import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JanelaMatriz extends JFrame {
    // Instance attributes used in this example
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;

    public JanelaMatriz(int tamanho) {
        // configura��o do JFrame
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
        	/* Aqui ter� que ser sorteio, preenchi com esses valores s� para testes */
            valores[0][0] = "A";
            valores[0][5] = "A";
            valores[5][9] = "LS";
            valores[9][9] = "LO";
            valores[5][5] = "LS";
            valores[8][7] = "LO";
            valores[7][7] = "O";
            valores[5][5] = "O";
            valores[2][2] = "O";
            
       }
        

        // Cria o JTable
        table = new JTable(valores, colunas);

        // Adiciona o JTable dentro do painel
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

    }
}
