#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controlador;

import com.zaimella.commons.log.Log;
import com.zaimella.corporative.apex.logica.EntidadGeneralLogica;
import com.zaimella.corporative.apex.modelo.Empresa;
import com.zaimella.modelbase.modelo.SesionUsuario;
import com.zaimella.corporative.apex.modelo.UsuarioCorporativo;
import com.zaimella.modelbase.controlador.ComunControlador;
import com.zaimella.webbase.controlador.ModuloControlador;
import com.zaimella.commons.log.Log;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;



/**
 * Contro de toda la navegación del proyecto
 *
 * @author dcueva
 */
@Named(value = "navegacionControlador")
@SessionScoped
public class NavegacionControlador extends ComunControlador implements Serializable {

    @EJB
    private EntidadGeneralLogica entidadGeneralLogica;
    
    @Inject
    private ModuloControlador moduloControlador;

    /** Empresa en curso */
    private Empresa empresa;
    
    // ------------------------------------------------------------------
    @PostConstruct
    public void postConstruct(){

    }
    
    public UsuarioCorporativo getUsuarioLogeado(){
        return moduloControlador.getUsuario();
    }
    
    public void iniciaSesionDeUsuario(SesionUsuario sesionUsuario) {
        this.empresa = sesionUsuario.getEmpresa();
        Log.debug("Iniciada sesión en el Módulo" + moduloControlador.getUsuario() + "  " + this.empresa);
        
    }
    
    public void irAPantallaMain(){
        Log.debug("Preparando datos para la mesa de trabajo");
        
    }

}
