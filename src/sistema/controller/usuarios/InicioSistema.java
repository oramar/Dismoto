package sistema.controller.usuarios;

import sistema.views.usuarios.FrmPrincipal;
import sistema.views.usuarios.FrmUsuario;
import sistema.views.usuarios.FrmUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InicioSistema implements ActionListener {

    private final FrmUsuario frmUsuario;
    private final ManejoGeneral manejoGeneral;
    FrmPrincipal principal = FrmPrincipal.instanciaFormulario();

    public InicioSistema(FrmUsuario frmUsuario) {
        this.frmUsuario = frmUsuario;
        this.manejoGeneral = new ManejoGeneral();
        initComponents();

    }

    private void initComponents() {
        this.frmUsuario.getBtnAceptar().addActionListener(this);
        this.frmUsuario.getBtnMostrar().addActionListener(this);
    }

    public void validadUsuario() {
        String clave = new String(frmUsuario.getTxtClavePass().getPassword());
        String clave2 = frmUsuario.getTxtClaveTexto().getText();
        String usuario = frmUsuario.getTxtUsuario().getText();

        if (usuario.equals("1") && (clave.equals("1") || clave2.equals("1"))) {
            cargarFormularioPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(frmUsuario.getBtnMostrar())) {
            mostrarContraseña();
        } else if (ae.getSource().equals(frmUsuario.getBtnAceptar())) {
            validadUsuario();
        }

    }

    public void mostrarContraseña() {
        String contraseñaOculta = new String(frmUsuario.getTxtClavePass().getPassword());
        if (frmUsuario.isEstado() == false) {
            frmUsuario.getTxtClaveTexto().setText(contraseñaOculta);
            frmUsuario.getTxtClaveTexto().setVisible(true);
            frmUsuario.getTxtClaveTexto().requestFocus();
            frmUsuario.getTxtClavePass().setVisible(false);
            ImageIcon imgMostrar = new ImageIcon(getClass().getResource("/dismoto/utils/imagenes/show.png"));
            frmUsuario.getBtnMostrar().setIcon(imgMostrar);
            frmUsuario.setEstado(true);
        } else {
            contraseñaOculta = frmUsuario.getTxtClaveTexto().getText();
            frmUsuario.getTxtClavePass().setText(contraseñaOculta);
            frmUsuario.getTxtClaveTexto().setVisible(false);
            frmUsuario.getTxtClavePass().setVisible(true);
            frmUsuario.getTxtClavePass().requestFocus();
            ImageIcon imgOcultar = new ImageIcon(getClass().getResource("/dismoto/utils/imagenes/hide.png"));
            frmUsuario.getBtnMostrar().setIcon(imgOcultar);
            frmUsuario.setEstado(false);
        }

    }

    public void cargarFormularioPrincipal() {
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        manejoGeneral.agregarImagenEscalar(principal.getDpnZonaTrabajo(), "/dismoto/utils/imagenes/fondo.jpg");
        principal.setVisible(true);
        manejoGeneral.tamanoFormulario(principal);
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);
        frmUsuario.dispose();
    }

    public static void main(String[] args) {
        FrmUsuario miLogin = new FrmUsuario();
        InicioSistema usuario = new InicioSistema(miLogin);
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);

        FrmUsuarios frmUsuarios = new FrmUsuarios();
        ManejoUsuario manejoUsuario = new ManejoUsuario(frmUsuarios);

        frmUsuarios.setVisible(true);

    }

}
