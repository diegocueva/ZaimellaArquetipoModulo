#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.enumeration;

/**
 * Roles configurados para el módulo
 * 
 * @author dcueva
 */
public enum Rol {
    ${CODIGO_MODULO}_ADMIN("ADMINISTRADOR"),
;
    
    private final String descripcion;

    private Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
