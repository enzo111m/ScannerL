package analex;

import java.awt.Toolkit;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Monroy
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    public Inicio() {
        initComponents();        
        this.setLocationRelativeTo(null);
        setIcon();
    }

    private void analizar() {
        int i = 0;
        
        File file = new File("texto.txt");
        PrintWriter escribir;
        
        aEntrada.setText(tCadena.getText());
        
        try {
            escribir = new PrintWriter(file);
            escribir.print(tCadena.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            Reader lector = new BufferedReader(new FileReader("texto.txt"));
            Lexer lexer = new Lexer(lector);
            String salida = "";
            
            while (true) {
                i++;
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    aSalida.setText(salida);
                    return;
                }
                switch (tokens) {
                    case SIGNO_PUNTUACION:
                        salida += "Token ("+ i + "): "+".,(),{},[],'', " + tokens + "\n";
                        break;
                    case IDENTIFICADOR:
                        salida += "Token ("+ i + "): "+ lexer.lexema + ": " + tokens + "\n";
                        break;
                    case NUMERO:
                        salida += "Token ("+ i + "): "+ lexer.lexema + ": " + tokens + "\n";
                        break;
                    case OR:
                        salida += "Token ("+ i + "): |" + ": " + tokens + "\n";
                        break;
                    case AND:
                        salida += "Token ("+ i + "): &" + ": " + tokens + "\n";
                        break;
                    case NOT:
                        salida += "Token ("+ i + "): !" + ": " + tokens + "\n";
                        break;
                    case IGUAL:
                        salida += "Token ("+ i + "): =" + ": " + tokens + "\n";
                        break;
                    case SEPARADOR:
                        salida += "Token ("+ i + "): ;" + ": " + tokens + "\n";
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tCadena = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bAnalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aEntrada = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        aSalida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Léxico");
        setResizable(false);

        jLabel1.setText("Ingresar texto:");

        bAnalizar.setText("Analizar");
        bAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnalizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Texto ingresado:");

        jLabel3.setText("Resultado:");

        aEntrada.setColumns(20);
        aEntrada.setRows(5);
        jScrollPane1.setViewportView(aEntrada);

        aSalida.setColumns(20);
        aSalida.setRows(5);
        jScrollPane3.setViewportView(aSalida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(bAnalizar))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bAnalizar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnalizarActionPerformed
        if(tCadena.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "INSERTA TEXTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else{
            analizar();            
            tCadena.setText("");
        }
    }//GEN-LAST:event_bAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("uno.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aEntrada;
    private javax.swing.JTextArea aSalida;
    private javax.swing.JButton bAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField tCadena;
    // End of variables declaration//GEN-END:variables
}
