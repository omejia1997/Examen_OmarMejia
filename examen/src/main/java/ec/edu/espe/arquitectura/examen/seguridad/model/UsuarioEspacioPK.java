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
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Omar
 */
@Embeddable
public class UsuarioEspacioPK implements Serializable {

    
    @Column(name = "cod_espacio", nullable = false)
    private Integer codEspacio;
    
    @Column(name = "cod_usuario", nullable = false)
    private Integer codUsuario;

    public UsuarioEspacioPK() {
    }

    public UsuarioEspacioPK(Integer codEspacio, Integer codUsuario) {
        this.codEspacio = codEspacio;
        this.codUsuario = codUsuario;
    }

    public Integer getCodEspacio() {
        return codEspacio;
    }

    public void setCodEspacio(Integer codEspacio) {
        this.codEspacio = codEspacio;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codEspacio;
        hash += (int) codUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioEspacioPK)) {
            return false;
        }
        UsuarioEspacioPK other = (UsuarioEspacioPK) object;
        if (this.codEspacio != other.codEspacio) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegUsuarioEspacioPK[ codEspacio=" + codEspacio + ", codUsuario=" + codUsuario + " ]";
    }
    
}
