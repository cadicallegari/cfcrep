/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegisterWindow.java
 *
 * Created on 11/09/2010, 16:26:33
 */

package vm.gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vm.bo.RegisterSet;

/**
 *
 * @author cadi
 */
public class RegisterWindow extends javax.swing.JFrame {

	DefaultTableModel modeloTabela;
	
    /** Creates new form RegisterWindow */
    public RegisterWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setTitle("Registradores");
        setResizable(false);

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registradores"));
        jScrollPane1.setAutoscrolls(true);

        tabela.setAutoCreateColumnsFromModel(false);
        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, new java.awt.Color(1, 1, 1)));
        
        String[] colunas = new String[] { "Registrador", "Valor Inteiro", "Valor Binario"};
		String[][] dados = new String[][] {};

		modeloTabela = new DefaultTableModel(dados, colunas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabela = new JTable(modeloTabela);
		modeloTabela = (DefaultTableModel) tabela.getModel();
        
		this.initTable();
		
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
	 * 
	 */
	private void initTable() {
		String str;
		
		for (int i = 0; i < 8; i++) {
			modeloTabela.addRow(new String[] { "" ,"", ""});	
		}
		
		for (int i = 8; i < 16; i++) {
			str = "$t" + (i - 8);
			modeloTabela.addRow(new String[] { str ,"", ""});	
		}

		for (int i = 16; i < 24; i++) {
			str = "$s" + (i - 16);
			modeloTabela.addRow(new String[] { str ,"", ""});	
		}
		
	}

	/**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterWindow().setVisible(true);
            }
        });
    }


   public void updateTable(RegisterSet rs) {	   
		

   
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
