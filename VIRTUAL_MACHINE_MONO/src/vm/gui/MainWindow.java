/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on 11/09/2010, 11:08:03
 */

package vm.gui;

import java.io.IOException;

import vm.business.DataPath;
import vm.business.FileLoader;

/**
 *
 * @author cadi
 */
public class MainWindow extends javax.swing.JFrame {

	
	private DataPath dataPath = new DataPath();
	private String filePath = null;
	private MemoryWindow memoryWindow = new MemoryWindow();
	private RegisterWindow registerWindow = new RegisterWindow();

	
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        
		this.registerWindow.updateTable(this.dataPath.getRegisterSet());
		this.memoryWindow.updateTable(this.dataPath.getDataMemory());
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
        upPanel = new javax.swing.JPanel();
        descPC = new javax.swing.JLabel();
        labelPC = new javax.swing.JLabel();
        descInstruAtual = new javax.swing.JLabel();
        labelInstruAtual = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        buttonExecute = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        dsRegDst = new javax.swing.JLabel();
        labelRegDst = new javax.swing.JLabel();
        dsJump = new javax.swing.JLabel();
        labelJump = new javax.swing.JLabel();
        dsBranch = new javax.swing.JLabel();
        labelBranch = new javax.swing.JLabel();
        dsMemRead = new javax.swing.JLabel();
        labelMemRead = new javax.swing.JLabel();
        dsMentoReg = new javax.swing.JLabel();
        labelMemtoReg = new javax.swing.JLabel();
        dsALUOp = new javax.swing.JLabel();
        labelALUOp = new javax.swing.JLabel();
        dsMemWrite = new javax.swing.JLabel();
        labelMemWrite = new javax.swing.JLabel();
        dsALUSrc = new javax.swing.JLabel();
        labelALUSrc = new javax.swing.JLabel();
        dsRegWrite = new javax.swing.JLabel();
        labelRegWrite = new javax.swing.JLabel();
        dsZero = new javax.swing.JLabel();
        labelZero = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuItemAbrir = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();
        menuExibir = new javax.swing.JMenu();
        menuItemRegistradores = new javax.swing.JMenuItem();
        menuItemMemoria = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAQUINA VIRTUAL MONOCICLO MUITO LOCA");
        setResizable(false);

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mainPanel.setLayout(new java.awt.BorderLayout(2, 2));

        upPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 5, 1, 1));
        upPanel.setLayout(new java.awt.GridLayout(2, 2, 0, 12));

        descPC.setText("PC :");
        upPanel.add(descPC);

        labelPC.setText("0");
        upPanel.add(labelPC);

        descInstruAtual.setText("Instrução executada :");
        upPanel.add(descInstruAtual);

        labelInstruAtual.setText("None");
        upPanel.add(labelInstruAtual);

        mainPanel.add(upPanel, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setLayout(new java.awt.GridLayout(1, 2, 25, 0));

        status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        status.setText("Aguardando...");
        bottomPanel.add(status);

        buttonExecute.setText("Executar");
        buttonExecute.setMaximumSize(new java.awt.Dimension(47, 7));
        buttonExecute.setMinimumSize(new java.awt.Dimension(47, 7));
        buttonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuteActionPerformed(evt);
            }
        });
        bottomPanel.add(buttonExecute);

        mainPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        leftPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        leftPanel.setLayout(new java.awt.GridLayout(10, 2, 5, 0));

        dsRegDst.setText("RegDst:");
        leftPanel.add(dsRegDst);

        labelRegDst.setText("0");
        leftPanel.add(labelRegDst);

        dsJump.setText("Jump:");
        leftPanel.add(dsJump);

        labelJump.setText("0");
        leftPanel.add(labelJump);

        dsBranch.setText("Branch:");
        leftPanel.add(dsBranch);

        labelBranch.setText("0");
        leftPanel.add(labelBranch);

        dsMemRead.setText("MemRead:");
        leftPanel.add(dsMemRead);

        labelMemRead.setText("0");
        leftPanel.add(labelMemRead);

        dsMentoReg.setText("MemtoReg:");
        leftPanel.add(dsMentoReg);

        labelMemtoReg.setText("0");
        leftPanel.add(labelMemtoReg);

        dsALUOp.setText("ALUOp:");
        leftPanel.add(dsALUOp);

        labelALUOp.setText("00");
        leftPanel.add(labelALUOp);

        dsMemWrite.setText("MemWrite:");
        leftPanel.add(dsMemWrite);

        labelMemWrite.setText("0");
        leftPanel.add(labelMemWrite);

        dsALUSrc.setText("ALUSrc:");
        leftPanel.add(dsALUSrc);

        labelALUSrc.setText("0");
        leftPanel.add(labelALUSrc);

        dsRegWrite.setText("RegWrite:");
        leftPanel.add(dsRegWrite);

        labelRegWrite.setText("0");
        leftPanel.add(labelRegWrite);

        dsZero.setText("Zero:");
        leftPanel.add(dsZero);

        labelZero.setText("0");
        leftPanel.add(labelZero);

        mainPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vm_imagem.png"))); // NOI18N
        centerPanel.add(labelImage);

        mainPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        menuArquivo.setMnemonic('a');
        menuArquivo.setText("Arquivo");

        menuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuItemAbrir.setMnemonic('a');
        menuItemAbrir.setText("Carregar Instruções");
        menuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemAbrir);

        menuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSair.setMnemonic('s');
        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemSair);

        menuBar.add(menuArquivo);

        menuExibir.setMnemonic('e');
        menuExibir.setText("Exibir");

        menuItemRegistradores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRegistradores.setMnemonic('r');
        menuItemRegistradores.setText("Registradores");
        menuItemRegistradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegistradoresActionPerformed(evt);
            }
        });
        menuExibir.add(menuItemRegistradores);

        menuItemMemoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemMemoria.setMnemonic('m');
        menuItemMemoria.setText("Memória");
        menuItemMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMemoriaActionPerformed(evt);
            }
        });
        menuExibir.add(menuItemMemoria);

        menuBar.add(menuExibir);

        menuAjuda.setMnemonic('j');
        menuAjuda.setText("Ajuda");
        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("Vamo que vamo grupo Herança");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public static void setStatus(String s) {
    	
    	if (status != null) {
    		status.setText(s);
    	}
    	
    }
    
    
    private void buttonExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteActionPerformed
    	
    	if (this.filePath == null) {
    		System.out.println("é necessario carregar um arquivo com as instruçoes primeiro");
    		MainWindow.setStatus("Carregue um arquivo primeiro!");
    	} 
    	else {
    		MainWindow.setStatus("Executando Instrução");
    		
    		this.dataPath.run();
    		this.updateComponets();
    		this.registerWindow.updateTable(this.dataPath.getRegisterSet());
    		this.memoryWindow.updateTable(this.dataPath.getDataMemory());
    		
    		MainWindow.setStatus("Instrução Executada");
    	}
    	
    }//GEN-LAST:event_buttonExecuteActionPerformed

    
    
    
    /**
	 * 
	 */
	private void updateComponets() {
		
		//PC
		this.labelPC.setText(this.dataPath.PC.toString());
		
		//Instruçao atual
		this.labelInstruAtual.setText(this.dataPath.getCurrentInstruction());
		
		//RegDst
		this.labelRegDst.setText(this.dataPath.getRegDst());
		//Jump
		this.labelJump.setText(this.dataPath.getJump());
		//Branch
		this.labelBranch.setText(this.dataPath.getBranch());
		//MemRead
		this.labelMemRead.setText(this.dataPath.getMemRead());
		//MemToReg
		this.labelMemtoReg.setText(this.dataPath.getMemtoReg());
		//ALUOp
		this.labelALUOp.setText(this.dataPath.getALUOp());
		//MemWrite
		this.labelMemWrite.setText(this.dataPath.getMemWrite());
		//ALUSrc
		this.labelALUSrc.setText(this.dataPath.getALUSrc());
		//RegWrite
		this.labelRegWrite.setText(this.dataPath.getRegWrite());
		//Zero
		this.labelZero.setText(this.dataPath.getZero());
		
	}

	
	
	private void menuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirActionPerformed
		
		try {
			
			this.filePath = FileLoader.chooseFile();
			this.dataPath.setInstructionMemory(FileLoader.load(this.filePath));
			
			MainWindow.setStatus("Arquivo carregado com sucesso!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MainWindow.setStatus("Falha ao carregar arquivo!");
			e.printStackTrace();
		}
    	
    }//GEN-LAST:event_menuItemAbrirActionPerformed

    
    
    
    private void menuItemMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMemoriaActionPerformed
    	
		this.memoryWindow.setVisible(true);
    	
    	
    }//GEN-LAST:event_menuItemMemoriaActionPerformed

    
    
    
    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
    
    	MainWindow.setStatus("Bye Bye");
    	System.exit(NORMAL);
    
    }//GEN-LAST:event_menuItemSairActionPerformed

    
    
    private void menuItemRegistradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegistradoresActionPerformed

		this.registerWindow.setVisible(true);
    	
    }//GEN-LAST:event_menuItemRegistradoresActionPerformed

    
    
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton buttonExecute;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel descInstruAtual;
    private javax.swing.JLabel descPC;
    private javax.swing.JLabel dsALUOp;
    private javax.swing.JLabel dsALUSrc;
    private javax.swing.JLabel dsBranch;
    private javax.swing.JLabel dsJump;
    private javax.swing.JLabel dsMemRead;
    private javax.swing.JLabel dsMemWrite;
    private javax.swing.JLabel dsMentoReg;
    private javax.swing.JLabel dsRegDst;
    private javax.swing.JLabel dsRegWrite;
    private javax.swing.JLabel dsZero;
    private javax.swing.JLabel labelALUOp;
    private javax.swing.JLabel labelALUSrc;
    private javax.swing.JLabel labelBranch;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelInstruAtual;
    private javax.swing.JLabel labelJump;
    private javax.swing.JLabel labelMemRead;
    private javax.swing.JLabel labelMemWrite;
    private javax.swing.JLabel labelMemtoReg;
    private javax.swing.JLabel labelPC;
    private javax.swing.JLabel labelRegDst;
    private javax.swing.JLabel labelRegWrite;
    private javax.swing.JLabel labelZero;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuExibir;
    private javax.swing.JMenuItem menuItemAbrir;
    private javax.swing.JMenuItem menuItemMemoria;
    private javax.swing.JMenuItem menuItemRegistradores;
    private javax.swing.JMenuItem menuItemSair;
    private static javax.swing.JLabel status;
    private javax.swing.JPanel upPanel;
    // End of variables declaration//GEN-END:variables

}
