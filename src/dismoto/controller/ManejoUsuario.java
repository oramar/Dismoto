package dismoto.controller;

import dismoto.views.formularios.FrmPrincipal;
import dismoto.views.formularios.FrmUsuarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class ManejoUsuario implements ActionListener {

    private FrmPrincipal frmPrincipal ;
    private FrmUsuarios frmUsuarios;
    private ManejoGeneral manejoGeneral;

    public ManejoUsuario(FrmUsuarios frmUsuarios) {
        frmPrincipal = FrmPrincipal.instanciaFormulario();
        this.frmUsuarios = frmUsuarios; 
        manejoGeneral = new ManejoGeneral();
        initComponents();
    }

    private void initComponents() {
        this.frmUsuarios.getBtnSalir().addActionListener(this);
        this.frmPrincipal.getMnuArchivoUsuarios().addActionListener(this);
//        this.frmPrincipal.getMnuArchivoClientes().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if (ae.getSource().equals(frmPrincipal.getMnuArchivoUsuarios())) {
//            frmUsuarios = new FrmUsuarios();
            System.out.println("Ingreso aqui");
            frmPrincipal.getDpnZonaTrabajo().add(frmUsuarios);           
            activarMenus(false);
            manejoGeneral.tamanoFormulario(frmPrincipal);
            manejoGeneral.centrarFormulario(frmUsuarios);
            frmUsuarios.show();
            try {
                this.frmUsuarios.setClosed(false);

            } catch (PropertyVetoException ex) {
                Logger.getLogger(ManejoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(ae.getSource().equals(frmUsuarios.getBtnSalir())){
            System.out.println("Ingreso aqui salir");
            activarMenus(true);
            int valor = this.frmUsuarios.getDefaultCloseOperation();
            System.out.println("el valor de cerrado es "+valor);
            try {
                this.frmUsuarios.setClosed(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ManejoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        

    }

    public void activarMenus(boolean estado) {
        if (estado) {
            frmPrincipal.getMnuArchivo().setEnabled(estado);
            frmPrincipal.getMnuMovimiento().setEnabled(estado);
            frmPrincipal.getMnuAyuda().setEnabled(estado);
        } else {
            frmPrincipal.getMnuArchivo().setEnabled(estado);
            frmPrincipal.getMnuMovimiento().setEnabled(estado);
            frmPrincipal.getMnuAyuda().setEnabled(estado);
        }
    }
    
  

}
