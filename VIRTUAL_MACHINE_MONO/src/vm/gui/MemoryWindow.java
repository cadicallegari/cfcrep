/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MemoryWindow.java
 *
 * Created on 11/09/2010, 16:43:43
 */

package vm.gui;

import vm.bo.DataMemory;

/**
 *
 * @author cadi
 */
public class MemoryWindow extends javax.swing.JFrame {

    /** Creates new form MemoryWindow */
    public MemoryWindow() {
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

        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoryWindow().setVisible(true);
            }
        });
    }

	/**
	 * @param dataMemory
	 */
	public void updateTable(DataMemory dataMemory) {
		//TODO
		System.out.println("atualizar tabela da memoria");
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
