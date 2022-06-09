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

import ec.edu.espe.arquitectura.examen.gestorcontenido.model.Espacio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seg_usuario_espacio")
public class UsuarioEspacio implements Serializable {

    private static final long serialVersionUID = 12213L;
    @EmbeddedId
    private UsuarioEspacioPK segUsuarioEspacioPK;
    
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @JoinColumn(name = "cod_espacio", referencedColumnName = "cod_espacio", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Espacio gdcEspacio;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario segUsuario;

    public UsuarioEspacio() {
    }

    public UsuarioEspacio(UsuarioEspacioPK segUsuarioEspacioPK) {
        this.segUsuarioEspacioPK = segUsuarioEspacioPK;
    }

    public UsuarioEspacio(Integer codEspacio, Integer codUsuario) {
        this.segUsuarioEspacioPK = new UsuarioEspacioPK(codEspacio, codUsuario);
    }

    public UsuarioEspacioPK getSegUsuarioEspacioPK() {
        return segUsuarioEspacioPK;
    }

    public void setSegUsuarioEspacioPK(UsuarioEspacioPK segUsuarioEspacioPK) {
        this.segUsuarioEspacioPK = segUsuarioEspacioPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Espacio getGdcEspacio() {
        return gdcEspacio;
    }

    public void setGdcEspacio(Espacio gdcEspacio) {
        this.gdcEspacio = gdcEspacio;
    }

    public Usuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(Usuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioEspacioPK != null ? segUsuarioEspacioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioEspacio)) {
            return false;
        }
        UsuarioEspacio other = (UsuarioEspacio) object;
        if ((this.segUsuarioEspacioPK == null && other.segUsuarioEspacioPK != null) || (this.segUsuarioEspacioPK != null && !this.segUsuarioEspacioPK.equals(other.segUsuarioEspacioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegUsuarioEspacio[ segUsuarioEspacioPK=" + segUsuarioEspacioPK + " ]";
    }
    
}
