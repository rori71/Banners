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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xamp
 */
@Entity
@Table(name = "tariffa_inserzione")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "TariffaInserzione.findAll", query = "SELECT t FROM TariffaInserzione t"),
    @NamedQuery(name = "TariffaInserzione.findById", query = "SELECT t FROM TariffaInserzione t WHERE t.id = :id"),
    @NamedQuery(name = "TariffaInserzione.findByNomeTestata", query = "SELECT t FROM TariffaInserzione t WHERE t.nomeTestata = :nomeTestata"),
    @NamedQuery(name = "TariffaInserzione.findByNomeTariffa", query = "SELECT t FROM TariffaInserzione t WHERE t.nomeTariffa = :nomeTariffa"),
    @NamedQuery(name = "TariffaInserzione.findByAreaMassima", query = "SELECT t FROM TariffaInserzione t WHERE t.areaMassima = :areaMassima"),
    @NamedQuery(name = "TariffaInserzione.findByCosto", query = "SELECT t FROM TariffaInserzione t WHERE t.costo = :costo"),
    @NamedQuery(name = "TariffaInserzione.findBest", query = "SELECT t FROM TariffaInserzione t WHERE t.areaMassima >= :area order by t.costo") 
})
public class TariffaInserzione implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome_testata")
    private String nomeTestata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome_tariffa")
    private String nomeTariffa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area_massima")
    private float areaMassima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private float costo;

    public TariffaInserzione()
    {
    }

    public TariffaInserzione(Integer id)
    {
        this.id = id;
    }

    public TariffaInserzione(Integer id, String nomeTestata, String nomeTariffa, float areaMassima, float costo)
    {
        this.id = id;
        this.nomeTestata = nomeTestata;
        this.nomeTariffa = nomeTariffa;
        this.areaMassima = areaMassima;
        this.costo = costo;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNomeTestata()
    {
        return nomeTestata;
    }

    public void setNomeTestata(String nomeTestata)
    {
        this.nomeTestata = nomeTestata;
    }

    public String getNomeTariffa()
    {
        return nomeTariffa;
    }

    public void setNomeTariffa(String nomeTariffa)
    {
        this.nomeTariffa = nomeTariffa;
    }

    public float getAreaMassima()
    {
        return areaMassima;
    }

    public void setAreaMassima(float areaMassima)
    {
        this.areaMassima = areaMassima;
    }

    public float getCosto()
    {
        return costo;
    }

    public void setCosto(float costo)
    {
        this.costo = costo;
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
        if (!(object instanceof TariffaInserzione))
        {
            return false;
        }
        TariffaInserzione other = (TariffaInserzione) object;
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
