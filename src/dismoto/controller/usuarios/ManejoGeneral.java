package dismoto.controller.usuarios;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ManejoGeneral {

    Dimension tamanoDmi;
    Dimension tamanoFormulario;
    Dimension tamanoPantalla;
    private int anchoPantalla;
    private int altoPantalla;
    Toolkit miPantalla;
    JInternalFrame formulario;
    JFrame frmPrincipal;

    public ManejoGeneral() {
        initComponents();
    }

    private void initComponents() {
        //Con toolkit y el metodo getDefaulToolkit() obtenemos acceso a nuestro sistema huespede
        miPantalla = Toolkit.getDefaultToolkit();
        tamanoPantalla = miPantalla.getScreenSize();
        anchoPantalla = tamanoPantalla.width;
        altoPantalla = tamanoPantalla.height;
    }

    public void centrarFormulario(JInternalFrame formulario) {
        tamanoFormulario = formulario.getSize();
        formulario.setLocation((anchoPantalla - tamanoFormulario.width) / 2, (altoPantalla - tamanoFormulario.height) / 4);
    }

    public void tamanoFormulario(JFrame frmPrincipal) {
        frmPrincipal.setBounds(0, 0, anchoPantalla, altoPantalla);
    }
    
    public void ajustarImagen(JLabel contenedor ,String rutaImagen){                                                
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(rutaImagen));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(contenedor.getWidth(),
                contenedor.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        contenedor.setIcon(iconoEscalado);

    }
    
    public void agrtegarImagenFormulario(JInternalFrame formulario,String rutaImagen){
//         ImageIcon imgIcon = new ImageIcon(getClass().getResource(rutaImagen));
//        Image imgEscalada = imgIcon.getImage().getScaledInstance(formulario.getWidth(),
//                formulario.getHeight(), Image.SCALE_REPLICATE);
        Icon iconoEscalado = new ImageIcon(getClass().getResource(rutaImagen));
        formulario.setFrameIcon(iconoEscalado);
    }

    public void agregarImagenEscalar(JDesktopPane contenedor, String rutaImagen) {
       
        class ImagenFondo implements Border {
            public BufferedImage back;
            public ImagenFondo() {
                try {
                    URL imagePath = new URL(getClass().getResource(rutaImagen).toString());
                    back = ImageIO.read(imagePath);
                } catch (Exception ex) {
                }
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.drawImage(back, (x + (width - back.getWidth()) / 2), (y + (height - back.getHeight()) / 2), null);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(0, 0, 0, 0);
            }

            public boolean isBorderOpaque() {
                return false;
            }
        }
        
        contenedor.setBorder(new ImagenFondo());
    }
}
