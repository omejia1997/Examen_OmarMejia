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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gdc_contenido_version")
public class ContenidoVersion implements Serializable {

    private static final long serialVersionUID = 12323L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "cod_contenido_version", nullable = false)
    private Integer codContenidoVersion;
    
    @Column(name = "hash_archivo", nullable = false, length = 64)
    private String hashArchivo;
    
    @Column(name = "nombre_archivo", nullable = false, length = 256)
    private String nombreArchivo;
    
    @Column(name = "tamanio", nullable = false)
    private Integer tamanio;
   
    @Column(name = "version", nullable = false, precision = 4, scale = 2)
    private BigDecimal version;
    @Column(name = "comentario", length = 500)
    private String comentario;
    
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @Column(name = "cod_usuario_creacion", nullable = false)
    private Integer codUsuarioCreacion;
    @JoinColumn(name = "cod_contenido", referencedColumnName = "cod_contenido", nullable = false)
    @ManyToOne(optional = false)
    private Contenido codContenido;

    public ContenidoVersion() {
    }

    public ContenidoVersion(Integer codContenidoVersion) {
        this.codContenidoVersion = codContenidoVersion;
    }

    public Integer getCodContenidoVersion() {
        return codContenidoVersion;
    }

    public void setCodContenidoVersion(Integer codContenidoVersion) {
        this.codContenidoVersion = codContenidoVersion;
    }

    public String getHashArchivo() {
        return hashArchivo;
    }

    public void setHashArchivo(String hashArchivo) {
        this.hashArchivo = hashArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCodUsuarioCreacion() {
        return codUsuarioCreacion;
    }

    public void setCodUsuarioCreacion(Integer codUsuarioCreacion) {
        this.codUsuarioCreacion = codUsuarioCreacion;
    }

    public Contenido getCodContenido() {
        return codContenido;
    }

    public void setCodContenido(Contenido codContenido) {
        this.codContenido = codContenido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codContenidoVersion != null ? codContenidoVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContenidoVersion)) {
            return false;
        }
        ContenidoVersion other = (ContenidoVersion) object;
        if ((this.codContenidoVersion == null && other.codContenidoVersion != null) || (this.codContenidoVersion != null && !this.codContenidoVersion.equals(other.codContenidoVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.examen.gestorcontenido.model.GdcContenidoVersion[ codContenidoVersion=" + codContenidoVersion + " ]";
    }
    
}
