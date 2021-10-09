
package dismoto.controller;

import dismoto.views.formularios.FrmPrincipal;
import dismoto.views.formularios.FrmUsuario;
import dismoto.views.formularios.FrmUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class InicioSistema implements ActionListener{
    private FrmUsuario frmUsuario;
    private ManejoGeneral manejoGeneral;
    FrmPrincipal principal = FrmPrincipal.instanciaFormulario(); 


    public InicioSistema(FrmUsuario frmUsuario) {
        this.frmUsuario = frmUsuario;
        this.manejoGeneral = new ManejoGeneral();
        this.frmUsuario.getBtnAceptar().addActionListener( this);
    }
    
    
    public static void main(String[] args) {
        FrmUsuario miLogin = new FrmUsuario();          
        InicioSistema usuario = new InicioSistema(miLogin);         
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);
      
//        FrmPrincipal principal = new FrmPrincipal();
        FrmUsuarios frmUsuarios = new FrmUsuarios();
        ManejoUsuario manejoUsuario = new ManejoUsuario(frmUsuarios);
        
//        frmUsuarios.setVisible(true);
      
    
       
        
       
    }
    
  
    
    public void validadUsuario(){
        
        if(frmUsuario.getTxtUsuario().getText().equals("")&& frmUsuario.getTxtClave().getText().equals("")){
                       
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
         
            manejoGeneral.agregarImagenEscalar(principal.getDpnZonaTrabajo(),"/dismoto/utils/imagenes/fondo.jpg");
            principal.setVisible(true);
              manejoGeneral.tamanoFormulario(principal); 
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);
            frmUsuario.dispose();
            
        
        }else{
           JOptionPane.showMessageDialog(null,"Usuario o clave incorrecto");
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        validadUsuario();
    }
}
