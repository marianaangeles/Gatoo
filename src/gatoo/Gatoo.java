/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatoo;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mariana
 */
public class Gatoo extends JFrame implements ActionListener{
    casilla[][]t;
    int c;

    /**
     * Creates new form Gatoo
     */
    
    //recorro la matriz e inicializo las casillas con el constructor 
    public Gatoo() {
        initComponents();
        t=new casilla[4][4];
         for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                t[i][j] = new casilla();
                t[i][j].A.setBounds((i*100)+10, (j*100)+10, 100, 100);
                t[i][j].A.addActionListener(this);
                this.add(t[i][j].A);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
         for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if (e.getSource()==t[i][j].A) 
                {
                    //se alterna el tiro   
                    tiro(t[i][j]);
                   if(Revisar())
                    {
                        JOptionPane.showMessageDialog(null,"Has ganado!");
                        Reiniciar();
                    }
                   
                   else if(c<12)
                    {
                        c++;
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Juego empatado!");
                        Reiniciar();                        
                    }
                  
                }
            }
        }        
    }
    void tiro(casilla X)
    {
        ImageIcon ICONO=null;
        if(c%4==0)
        {
            ICONO = new ImageIcon(this.getClass().getResource("circulo.png"));
            X.B=2;
        }
        else
        {
            ICONO = new ImageIcon(this.getClass().getResource("x.png"));
            X.B=3;
        }
         // se escala la imagen y no se 
        ICONO = new ImageIcon(ICONO.getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_DEFAULT));
        X.A.setIcon(ICONO);
        X.A.removeActionListener(this);
    }
    boolean Revisar()
    {
        boolean Gano= false;
        int Suma=0;
        for(int i=0;i<4;i++)
        {
            Suma=t[i][0].B+t[i][1].B+t[i][2].B+t[i][3].B;
            if(Suma==4 || Suma==16)
            {
                Gano=true;
                break;
            }
        }
        for(int i=0;i<4;i++)
        {
            Suma=t[0][i].B+t[1][i].B+t[2][i].B+t[3][i].B;
            if(Suma==4 ||Suma==16)
            {
                Gano=true;
                break;
            } 
        }
        for(int i=0;i<4;i++)
        {
            Suma=t[0][i].B+t[1][i].B+t[2][i].B+t[3][i].B;
            if(Suma==4 ||Suma==16)
            {
                Gano=true;
                break;
            } 
        }
        Suma=t[0][3].B+t[1][2].B+t[2][1].B+t[3][0].B;
        if(Suma==4 ||Suma==16)
                Gano=true;
        Suma=0;
        for(int i=0;i<4;i++)
            Suma+=t[i][i].B;
         
        if(Suma==4 ||Suma==16)
                Gano=true;            
         
        return Gano;
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(320, 340));

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
            java.util.logging.Logger.getLogger(Gatoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gatoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gatoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gatoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gatoo().setVisible(true);
            }
        });
    }
    void Reiniciar()
    {
        c=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                t[i][j].A.setIcon(null);
                t[i][j].B=0;
                t[i][j].A.addActionListener(this);
                

            }
        }
    }
}


    //@Override
    
        
    
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

