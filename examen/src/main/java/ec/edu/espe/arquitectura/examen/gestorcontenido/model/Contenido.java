/*
 * Copyright 2022 Omar.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.examen.gestorcontenido.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gdc_contenido")

public class Contenido implements Serializable {

    private static final long serialVersionUID = 132423L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "cod_contenido", nullable = false)
    private Integer codContenido;
    
    @Column(name = "tipo_contenido", nullable = false)
    private Integer tipoContenido;
    
    @Column(name = "nombre", nullable = false, length = 256)
    private String nombre;
    @Column(name = "nombre_archivo", length = 256)
    private String nombreArchivo;
    @Column(name = "version", precision = 4, scale = 2)
    private BigDecimal version;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "codContenidoPadre")
    private List<Contenido> gdcContenidoList;
    @JoinColumn(name = "cod_contenido_padre", referencedColumnName = "cod_contenido")
    @ManyToOne
    private Contenido codContenidoPadre;
    @JoinColumn(name = "cod_espacio", referencedColumnName = "cod_espacio", nullable = false)
    @ManyToOne(optional = false)
    private Espacio codEspacio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codContenido")
    private List<ContenidoVersion> gdcContenidoVersionList;

    public Contenido() {
    }

    public Contenido(Integer codContenido) {
        this.codContenido = codContenido;
    }

    public Integer getCodContenido() {
        return codContenido;
    }

    public void setCodContenido(Integer codContenido) {
        this.codContenido = codContenido;
    }

    public Integer getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(Integer tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Contenido> getGdcContenidoList() {
        return gdcContenidoList;
    }

    public void setGdcContenidoList(List<Contenido> gdcContenidoList) {
        this.gdcContenidoList = gdcContenidoList;
    }

    public Contenido getCodContenidoPadre() {
        return codContenidoPadre;
    }

    public void setCodContenidoPadre(Contenido codContenidoPadre) {
        this.codContenidoPadre = codContenidoPadre;
    }

    public Espacio getCodEspacio() {
        return codEspacio;
    }

    public void setCodEspacio(Espacio codEspacio) {
        this.codEspacio = codEspacio;
    }

    public List<ContenidoVersion> getGdcContenidoVersionList() {
        return gdcContenidoVersionList;
    }

    public void setGdcContenidoVersionList(List<ContenidoVersion> gdcContenidoVersionList) {
        this.gdcContenidoVersionList = gdcContenidoVersionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContenido != null ? codContenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.codContenido == null && other.codContenido != null) || (this.codContenido != null && !this.codContenido.equals(other.codContenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codContenido=" + codContenido + " ]";
    }
    
}
