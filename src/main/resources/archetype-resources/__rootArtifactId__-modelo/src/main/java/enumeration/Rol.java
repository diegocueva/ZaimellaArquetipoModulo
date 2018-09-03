#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.enumeration;

/**
 *
 * @author dcueva
 */
public enum Rol {
    XXXX_ADMIN("ADMINISTRADOR"),
;
    
    private final String descripcion;

    private Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
