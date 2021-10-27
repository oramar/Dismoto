package dismoto.controller.usuarios;

import dismoto.views.usuarios.FrmPrincipal;
import dismoto.views.usuarios.FrmUsuarios;
import dismoto.views.usuarios.FrmUsuarioss;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

public class ManejoUsuario implements ActionListener {

    private FrmPrincipal frmPrincipal;
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
        this.frmPrincipal.getMnuArchivoSalir().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(frmPrincipal.getMnuArchivoUsuarios())) {
            archivoUsuario();
        } else if (ae.getSource().equals(frmUsuarios.getBtnSalir())) {
            cerrarFormulario(frmUsuarios);
        }else if(ae.getSource().equals(frmPrincipal.getMnuArchivoSalir())){
            System.exit(0);
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

    public void archivoUsuario() {
        frmPrincipal.getDpnZonaTrabajo().add(frmUsuarios);
        manejoGeneral.agrtegarImagenFormulario(frmUsuarios, "/dismoto/utils/imagenes/fondoTituloFormulario.png");
        activarMenus(false);
        manejoGeneral.tamanoFormulario(frmPrincipal);
        manejoGeneral.centrarFormulario(frmUsuarios);
        frmUsuarios.show();
        try {
            this.frmUsuarios.setClosed(false);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(ManejoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarFormulario(JInternalFrame formulario) {
        activarMenus(true);
        try {
            formulario.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ManejoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
