#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.servicios;

import com.zaimella.corporative.apex.modelo.Modulo;
import com.zaimella.corporative.apex.modelo.UsuarioCorporativo;
import com.zaimella.modelbase.modelo.SesionUsuario;
import ${package}.controlador.NavegacionControlador;
import com.zaimella.webbase.servicios.ServicioInterface;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dcueva
 */
@Named(value = "servicioControlador")
@SessionScoped
public class ServicioControlador implements Serializable, ServicioInterface{
 
    @Inject
    private NavegacionControlador navegacionControlador;
        
    @Override
    public void iniciaSesion(UsuarioCorporativo usuario, Modulo modulo, SesionUsuario sesionUsuario) {
        // Inicio la sesión
        navegacionControlador.iniciaSesionDeUsuario(sesionUsuario);
    }

    @Override
    public void paginaInicial() {
        navegacionControlador.irAPantallaMain();
    }

        
}
