#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zaimella.commons.enumeration.Estado;
import com.zaimella.commons.util.annotation.Columna;
import com.zaimella.commons.util.annotation.Tabla;
import com.zaimella.corporative.apex.modelo.UsuarioCorporativo;
import com.zaimella.corporative.tablasgenerales.modelo.EntidadTablaGeneral;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Ejemplo de codificación de una entidad
 * 
 * @author 
 */
@Entity
@Table(name = "T_${CODIGO_MODULO}_BORRAME")
@JsonIgnoreProperties(ignoreUnknown = true)
@Tabla(comentario = "Ejemplo de entidad de base de datos")
@NamedQueries({
    @NamedQuery(name = "Borrame.todosLosBorrames",  query = "FROM Borrame borrame where borrame.estado=com.zaimella.commons.enumeration.Estado.ACTIVO and borrame.codEmpresa=:codEmpresa"),
})
public class Borrame implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    private Integer id;
    
    @Column(nullable = false, length = 10)
    @Columna(comentario = "Código de la empresa")
    private String codEmpresa;
    
    @Column(nullable = false, length = 40)
    @Columna(comentario = "Nombre para identificar")
    private String nombre;
    
    @Column(nullable = false)
    @Columna(comentario = "Cantidad entera")
    private Integer cantidad;
    
    // TABLAS GENERALES: INSTRUMENTO DE MEDICIÓN 
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "INSTRUMENTOMEDICIONCAB", referencedColumnName="id_tgralcab", foreignKey = @ForeignKey(name = "FK_BORRAME_INSTMEDCAB")),
        @JoinColumn(name = "INSTRUMENTOMEDICION",    referencedColumnName="id_tabla",    foreignKey = @ForeignKey(name = "FK_BORRAME_INSTMED"))
    })
    @Columna(comentario = "Instrumento de medición de tablas generales")
    private EntidadTablaGeneral instrumentoMedicion;
    
    @OneToOne()
    @JoinColumn(nullable = true, name = "usuario")
    @Columna(comentario = "Usuario")
    private UsuarioCorporativo usuario;
    
    @Column(nullable = false, length = 40)
    @Enumerated(EnumType.STRING)
    @Columna(comentario = "ACTIVO, ELIMINADO")
    private Estado estado;
    
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Columna(comentario = "Fecha del registro")
    private Date fecha;

    public Borrame() {
        this.estado = Estado.ACTIVO;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public UsuarioCorporativo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCorporativo usuario) {
        this.usuario = usuario;
    }

    public EntidadTablaGeneral getInstrumentoMedicion() {
        return instrumentoMedicion;
    }

    public void setInstrumentoMedicion(EntidadTablaGeneral instrumentoMedicion) {
        this.instrumentoMedicion = instrumentoMedicion;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Generado automáticamente por NetBeans
     * 
     */    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Generado automáticamente por NetBeans
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Borrame other = (Borrame) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Generado automáticamente por NetBeans
     * 
     */    
    @Override
    public String toString() {
        return "Borrame{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }    
    
}
