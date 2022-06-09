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

import ec.edu.espe.arquitectura.examen.seguridad.model.UsuarioEspacio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gdc_espacio")
public class Espacio implements Serializable {

    private static final long serialVersionUID = 121312L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "cod_espacio", nullable = false)
    private Integer codEspacio;
    
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdcEspacio")
    private List<UsuarioEspacio> segUsuarioEspacioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEspacio")
    private List<Contenido> gdcContenidoList;

    public Espacio() {
    }

    public Espacio(Integer codEspacio) {
        this.codEspacio = codEspacio;
    }

    public Espacio(Integer codEspacio, String nombre, Date fechaCreacion) {
        this.codEspacio = codEspacio;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCodEspacio() {
        return codEspacio;
    }

    public void setCodEspacio(Integer codEspacio) {
        this.codEspacio = codEspacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<UsuarioEspacio> getSegUsuarioEspacioList() {
        return segUsuarioEspacioList;
    }

    public void setSegUsuarioEspacioList(List<UsuarioEspacio> segUsuarioEspacioList) {
        this.segUsuarioEspacioList = segUsuarioEspacioList;
    }

    public List<Contenido> getGdcContenidoList() {
        return gdcContenidoList;
    }

    public void setGdcContenidoList(List<Contenido> gdcContenidoList) {
        this.gdcContenidoList = gdcContenidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEspacio != null ? codEspacio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espacio)) {
            return false;
        }
        Espacio other = (Espacio) object;
        if ((this.codEspacio == null && other.codEspacio != null) || (this.codEspacio != null && !this.codEspacio.equals(other.codEspacio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codEspacio=" + codEspacio + " ]";
    }
    
}
