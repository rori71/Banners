/*
 * Copyright 2014 xamp.
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

package it.engim.banners.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xamp
 */
@Entity
@Table(name = "campagna_pub")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "CampagnaPub.findAll", query = "SELECT c FROM CampagnaPub c"),
    @NamedQuery(name = "CampagnaPub.findById", query = "SELECT c FROM CampagnaPub c WHERE c.id = :id"),
    @NamedQuery(name = "CampagnaPub.findByNome", query = "SELECT c FROM CampagnaPub c WHERE c.nome = :nome")
})
public class CampagnaPub implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCampagnaPub")
    private Collection<Inserzione> inserzioneCollection;

    public CampagnaPub()
    {
    }

    public CampagnaPub(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Inserzione> getInserzioneCollection()
    {
        return inserzioneCollection;
    }

    public void setInserzioneCollection(Collection<Inserzione> inserzioneCollection)
    {
        this.inserzioneCollection = inserzioneCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampagnaPub))
        {
            return false;
        }
        CampagnaPub other = (CampagnaPub) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "" + id;
    }
    
}
