#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.datos;

import com.zaimella.commons.enumeration.Estado;
import ${package}.modelo.Borrame;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Acceso a la base de datos para la entidad
 * 
 * @author dcueva
 */
@Stateless
@LocalBean
public class BorrameDatos {
    
    /** Unidad de persistencia estándar para todos los módulos */
    @PersistenceContext(unitName = "ModulosPU")
    private EntityManager em;    

    public Borrame persiste(Borrame borrame){
        Date hoy = new Date();
        if(borrame.getFecha() == null){
            // Es un registro nuevo
            borrame.setFecha(hoy);
        }

        return this.em.merge(borrame);
    }
    
    public Borrame recuperaBorrame(Integer id){
        Borrame borrame = this.em.find(Borrame.class, id);
        return borrame;
    }    
    
    public List<Borrame> recuperaTodosLosBorrames(String codEmpresa){
        List<Borrame> borrames = this.em
                .createNamedQuery("Borrame.todosLosBorrames", Borrame.class)
                .setParameter("codEmpresa", codEmpresa)
                .getResultList();
        return borrames;
    }
    
    public void eliminaBorrame(Borrame borrame){
        borrame.setEstado( Estado.ELIMINADO );
        persiste(borrame);
    }
    
}
