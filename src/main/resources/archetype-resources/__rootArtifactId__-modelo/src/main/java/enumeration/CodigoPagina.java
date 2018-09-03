#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.enumeration;

import com.zaimella.commons.abstracto.CodigoPaginaBase;
import com.zaimella.commons.enumeration.ModuloCorporativo;

/**
 *
 * @author dcueva
 */
public enum CodigoPagina implements CodigoPaginaBase{

    // MESA DE TRABAJO
    XXXXMAIN0(ModuloCorporativo.QCPS, "Mesa de trabajo", null, "/", "main"),
    // ADMINISTRACIÓN
    XXXXADMIN(ModuloCorporativo.QCPS, "Administración del módulo", "Administración", "/corporativa",  "/moduloAdmin"),
    ;
    
    private final ModuloCorporativo modulo;
    private final String            nombre;
    private final String            opcionMenu;
    private final String            path;
    private final String            pageName;

    private CodigoPagina(ModuloCorporativo modulo, String nombre, String opcionMenu, String path, String pageName) {
        this.modulo     = modulo;
        this.nombre     = nombre;
        this.opcionMenu = opcionMenu;
        this.path       = path;
        this.pageName   = pageName;
    }

    public String getPath() {
        return path;
    }

    public String getPageName() {
        return pageName;
    }

    public String getAccess(){
        // Log.debug("Página Solicitada: "+ this.pageName+" : " +(path+pageName+".xhtml"));
        if(path==null && pageName==null) return null;
        return path+pageName+".xhtml";
    }
    
    public String getAccessRedirect(){
        return getAccess()+FACES_REDIRECT;
    }
    
    public String getAccessSinExtension(){
        if(path==null && pageName==null) return null;
        return path+pageName;
    }    
    
    public String getCode(){
        return this.name();
    }

    public ModuloCorporativo getModulo() {
        return modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOpcionMenu() {
        return opcionMenu;
    }
    
}
