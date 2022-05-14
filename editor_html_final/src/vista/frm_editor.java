/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author david
 */
public class frm_editor extends javax.swing.JFrame {

    /**
     * Creates new form frm_editor
     */
    private File ficheroa;

    public frm_editor() {
        initComponents();
    }

    class resaltador extends DefaultHighlighter.DefaultHighlightPainter {

        public resaltador(Color color) {
            super(color);
        }

    }

    Highlighter.HighlightPainter resaltador = new resaltador(Color.orange);

    public void quitarResaltado(JTextComponent txt) {
        Highlighter res = txt.getHighlighter();
        Highlighter.Highlight[] resa = res.getHighlights();
        for (int i = 0; i < resa.length; i++) {
            res.removeHighlight(resa[i]);
        }

    }

    public void resaltar(JTextComponent txt, String palabra) {
        quitarResaltado(txt_entrada);
        try {
            Highlighter res = txt.getHighlighter();
            Document doc = txt.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;
            while ((pos = text.toUpperCase().indexOf(palabra.toUpperCase(), pos)) >= 0) {
                res.addHighlight(pos, pos + palabra.length(), resaltador);
                pos += palabra.length();
            }
        } catch (Exception ex) {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_entrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_abrir = new javax.swing.JMenuItem();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_guardar = new javax.swing.JMenuItem();
        menu_guardarC = new javax.swing.JMenuItem();
        menu_print = new javax.swing.JMenuItem();
        cortar = new javax.swing.JMenuItem();
        pegar = new javax.swing.JMenuItem();
        menu_editar = new javax.swing.JMenu();
        menu_buscar = new javax.swing.JMenuItem();
        menu_replace = new javax.swing.JMenuItem();
        menu_ir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        txt_entrada.setColumns(20);
        txt_entrada.setRows(5);
        jScrollPane1.setViewportView(txt_entrada);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Editor HTML");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        menu_archivo.setText("Archivo");

        menu_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_abrir.setText("Abrir");
        menu_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_abrirActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_abrir);

        menu_nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_nuevo.setText("Nuevo");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_nuevo);

        menu_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_guardar.setText("Guardar");
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_guardar);

        menu_guardarC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_guardarC.setText("Guardar Como");
        menu_guardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarCActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_guardarC);

        menu_print.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_print.setText("Imprimir");
        menu_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_printActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_print);

        cortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cortar.setText("Cortar");
        cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarActionPerformed(evt);
            }
        });
        menu_archivo.add(cortar);

        pegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pegar.setText("Pegar");
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });
        menu_archivo.add(pegar);

        jMenuBar1.add(menu_archivo);

        menu_editar.setText("Editar");

        menu_buscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_buscar.setText("Buscar");
        menu_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_buscarActionPerformed(evt);
            }
        });
        menu_editar.add(menu_buscar);

        menu_replace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_replace.setText("Reemplazar");
        menu_replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_replaceActionPerformed(evt);
            }
        });
        menu_editar.add(menu_replace);

        menu_ir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_ir.setText("Ir a");
        menu_ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_irActionPerformed(evt);
            }
        });
        menu_editar.add(menu_ir);

        jMenuBar1.add(menu_editar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        txt_entrada.setText("");
        ficheroa = null;
    }//GEN-LAST:event_menu_nuevoActionPerformed

    private void menu_irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_irActionPerformed
        // TODO add your handling code here:
        String buscar = JOptionPane.showInputDialog("Ingrese la palabra que quiere buscar");
        Highlighter.HighlightPainter marcador = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

        txt_entrada.getHighlighter().removeAllHighlights();
        int buscando = txt_entrada.getText().indexOf(buscar);
        int longitud = buscar.length();
        while (buscando != -1) {
            try {
                txt_entrada.getHighlighter().addHighlight(buscando, buscando + longitud, marcador);
            } catch (BadLocationException ex) {
                Logger.getLogger(frm_editor.class.getName()).log(Level.SEVERE, null, ex);
            }
            buscando = txt_entrada.getText().indexOf(buscar, buscando + 1);
        }
    }//GEN-LAST:event_menu_irActionPerformed

    private void menu_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_abrirActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".html", "html");
        fc.setFileFilter(filtro);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fc.showOpenDialog(this.getContentPane());
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ficheroa = fc.getSelectedFile();
            try (FileReader fr = new FileReader(this.ficheroa)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }
                txt_entrada.setText(cadena);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_menu_abrirActionPerformed

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed
        if (ficheroa == null) {
            abrirGuardar();
        } else {
            escribirFichero();
        }
    }//GEN-LAST:event_menu_guardarActionPerformed

    private void menu_guardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarCActionPerformed
        abrirGuardar();
    }//GEN-LAST:event_menu_guardarCActionPerformed

    private void menu_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_printActionPerformed

        try {
            Boolean ppt = txt_entrada.print();
            if (ppt) {
                JOptionPane.showMessageDialog(null, "Imprimiedo...");
            } else {
                JOptionPane.showMessageDialog(null, ":c");
            }
        } catch (PrinterException ex) {
            System.out.println("Error... " + ex);
        }
    }//GEN-LAST:event_menu_printActionPerformed

    private void menu_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_buscarActionPerformed
        int conta = 0;
        String elemento;
        StringTokenizer palabras = new StringTokenizer(txt_entrada.getText());
        String buscar = JOptionPane.showInputDialog(rootPane, "Ingrese la palabra que desea buscar:", "Buscar", JOptionPane.PLAIN_MESSAGE);

        while (palabras.hasMoreElements()) {
            elemento = palabras.nextToken();
            if (elemento.toLowerCase().contains(buscar.toLowerCase())) {
                conta++;
            }
        }
        JOptionPane.showMessageDialog(rootPane, Integer.toString(conta) + " coincidencias encontradas", "Coincidencias", JOptionPane.INFORMATION_MESSAGE);
        resaltar(txt_entrada, buscar);
    }//GEN-LAST:event_menu_buscarActionPerformed

    public void resaltarindividual(JTextComponent txt, String palabra, int inicio, int fin) {
        quitarResaltado(txt_entrada);
        try {
            Highlighter res = txt.getHighlighter();
            Document doc = txt.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            res.addHighlight(inicio, fin, resaltador);

            //pos += palabra.length();
        } catch (Exception ex) {
        }
    }

    private void menu_replaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_replaceActionPerformed
        int conta = 0;
        String buscar;
        String palabras[] = new String[100];
        String[] lineas = txt_entrada.getText().split("\\r?\\n");
        txt_entrada.getHighlighter().removeAllHighlights();
        Highlighter.HighlightPainter marcador = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
        buscar = JOptionPane.showInputDialog(rootPane, "Ingrese la palabra que desea buscar:", "Buscar", JOptionPane.PLAIN_MESSAGE);

        for (int i = 0; i < lineas.length; i++) {

            StringTokenizer token_palabras = new StringTokenizer(lineas[i]);

            while (token_palabras.hasMoreElements()) {
                palabras[i] = token_palabras.nextToken();
                if (palabras[i].equals(buscar)) 
                {
                    int posicion = lineas[i].indexOf(palabras[i]) + palabras[i].length();
                    System.out.println("la palabra es: " + palabras[i] + "  el inicio: " + lineas[i].indexOf(palabras[i]) + " el final: " + posicion);
                    txt_entrada.getHighlighter().removeAllHighlights();
                    try {
                        txt_entrada.getHighlighter().addHighlight(lineas[i].indexOf(palabras[i]), posicion, marcador);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(frm_editor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_menu_replaceActionPerformed

    private void cortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarActionPerformed
        // TODO add your handling code here:
        String seleccionar = txt_entrada.getSelectedText();
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection seleccionado = new StringSelection(seleccionar);
        portapapeles.setContents(seleccionado, seleccionado);
        txt_entrada.cut();
        JOptionPane.showMessageDialog(null, "texto cortado: ");
    }//GEN-LAST:event_cortarActionPerformed

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarActionPerformed
        // TODO add your handling code here:
        String pegado = "";
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        //Transferable contenido=portapapeles.getContents(this);

        try {
            pegado = (String) portapapeles.getContents(this).getTransferData(DataFlavor.stringFlavor);
            //pegado = (String) contenido.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException ex) {
            Logger.getLogger(frm_editor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frm_editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //txta_texto.getMousePosition();

        txt_entrada.append(" " + pegado);
        JOptionPane.showMessageDialog(null, "texto pegado: ");
    }//GEN-LAST:event_pegarActionPerformed

    private void abrirGuardar() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt", "txt");
        fc.setFileFilter(filtro);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fc.showSaveDialog(this.getContentPane());
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ficheroa = fc.getSelectedFile();
            escribirFichero();

        }
    }

    private void escribirFichero() {
        try (FileWriter fw = new FileWriter(ficheroa)) {
            fw.write(txt_entrada.getText());
        } catch (IOException ex) {
            Logger.getLogger(frm_editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(frm_editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cortar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_abrir;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenuItem menu_buscar;
    private javax.swing.JMenu menu_editar;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenuItem menu_guardarC;
    private javax.swing.JMenuItem menu_ir;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JMenuItem menu_print;
    private javax.swing.JMenuItem menu_replace;
    private javax.swing.JMenuItem pegar;
    private javax.swing.JTextArea txt_entrada;
    // End of variables declaration//GEN-END:variables
}
