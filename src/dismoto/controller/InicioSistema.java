
package dismoto.controller;

import dismoto.views.formularios.FrmUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class InicioSistema implements ActionListener{
    private FrmUsuario frmUsuario;

    public InicioSistema(FrmUsuario frmUsuario) {
        this.frmUsuario = frmUsuario;
        this.frmUsuario.getBtnAceptar().addActionListener( this);
    }
    
    
    public static void main(String[] args) {
        FrmUsuario miLogin = new FrmUsuario();
        InicioSistema usuario = new InicioSistema(miLogin);        
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);
        
        //pagina descargar iconos
       
    }
    
    public void validadUsuario(){
        
        if(frmUsuario.getTxtUsuario().getText().equals("Oramar")&& frmUsuario.getTxtClave().getText().equals("861106")){
            FrmInicio frmIncio = new FrmInicio();
            frmIncio.setVisible(true);
            frmIncio.setLocationRelativeTo(null);
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
