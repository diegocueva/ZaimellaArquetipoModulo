#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.logica;


import ${package}.datos.BorrameDatos;
import ${package}.modelo.Borrame;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Capa de negocio
 * 
 * @author dcueva
 */
@Stateless
@LocalBean
public class BorrameLogica {

    @EJB
    private BorrameDatos borrameDatos;

    public Borrame persiste(Borrame borrame){
        Date fecha = new Date();
        if(borrame.getFecha() == null){
            borrame.setFecha(fecha);
        }
        return borrameDatos.persiste(borrame);
    }

    public List<Borrame> recuperaTodosLosBorrames(String codEmpresa){
        return borrameDatos.recuperaTodosLosBorrames(codEmpresa);
    }

    public Borrame recuperaBorrame(Integer id){
        return borrameDatos.recuperaBorrame(id);
    }
    
    public void eliminaBorrame(Borrame borrame){
        borrameDatos.eliminaBorrame(borrame);
    }
}
