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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xamp
 */
@Entity
@Table(name = "banner")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Banner.findAll", query = "SELECT b FROM Banner b"),
    @NamedQuery(name = "Banner.findById", query = "SELECT b FROM Banner b WHERE b.id = :id"),
    @NamedQuery(name = "Banner.findByCodice", query = "SELECT b FROM Banner b WHERE b.codice = :codice"),
    @NamedQuery(name = "Banner.findByArea", query = "SELECT b FROM Banner b WHERE b.area = :area")
})
public class Banner implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codice")
    private String codice;
    @Lob
    @Size(max = 65535)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private float area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanner")
    private Collection<Inserzione> inserzioneCollection;

    public Banner()
    {
    }

    public Banner(Integer id)
    {
        this.id = id;
    }

    public Banner(Integer id, String codice, float area)
    {
        this.id = id;
        this.codice = codice;
        this.area = area;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCodice()
    {
        return codice;
    }

    public void setCodice(String codice)
    {
        this.codice = codice;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public float getArea()
    {
        return area;
    }

    public void setArea(float area)
    {
        this.area = area;
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
        if (!(object instanceof Banner))
        {
            return false;
        }
        Banner other = (Banner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return getCodice()+" (" + getArea()+")";
    }
    
}
