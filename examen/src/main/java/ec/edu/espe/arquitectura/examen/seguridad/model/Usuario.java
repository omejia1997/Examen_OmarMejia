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
package ec.edu.espe.arquitectura.examen.seguridad.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Omar
 */
@Entity
@Table(name = "seg_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 112312L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "cod_usuario", nullable = false)
    private Integer codUsuario;
    
    @Column(name = "username", nullable = false, length = 32)
    private String username;
    
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    
    @Column(name = "clave", nullable = false, length = 64)
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<UsuarioEspacio> segUsuarioEspacioList;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(Integer codUsuario, String username, String nombre, String estado, String clave) {
        this.codUsuario = codUsuario;
        this.username = username;
        this.nombre = nombre;
        this.estado = estado;
        this.clave = clave;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<UsuarioEspacio> getSegUsuarioEspacioList() {
        return segUsuarioEspacioList;
    }

    public void setSegUsuarioEspacioList(List<UsuarioEspacio> segUsuarioEspacioList) {
        this.segUsuarioEspacioList = segUsuarioEspacioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ".SegUsuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
