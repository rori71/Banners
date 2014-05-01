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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xamp
 */
@Entity
@Table(name = "inserzione")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Inserzione.findAll", query = "SELECT i FROM Inserzione i"),
    @NamedQuery(name = "Inserzione.findById", query = "SELECT i FROM Inserzione i WHERE i.id = :id"),
    @NamedQuery(name = "Inserzione.findByNumeroPagine", query = "SELECT i FROM Inserzione i WHERE i.numeroPagine = :numeroPagine")
})
public class Inserzione implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_pagine")
    private int numeroPagine;
    @JoinColumn(name = "id_banner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Banner idBanner;
    @JoinColumn(name = "id_campagna_pub", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CampagnaPub idCampagnaPub;

    public Inserzione()
    {
    }

    public Inserzione(Integer id)
    {
        this.id = id;
    }

    public Inserzione(Integer id, int numeroPagine)
    {
        this.id = id;
        this.numeroPagine = numeroPagine;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public int getNumeroPagine()
    {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine)
    {
        this.numeroPagine = numeroPagine;
    }

    public Banner getIdBanner()
    {
        return idBanner;
    }

    public void setIdBanner(Banner idBanner)
    {
        this.idBanner = idBanner;
    }

    public CampagnaPub getIdCampagnaPub()
    {
        return idCampagnaPub;
    }

    public void setIdCampagnaPub(CampagnaPub idCampagnaPub)
    {
        this.idCampagnaPub = idCampagnaPub;
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
        if (!(object instanceof Inserzione))
        {
            return false;
        }
        Inserzione other = (Inserzione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "it.engim.banners.db.Inserzione[ id=" + id + " ]";
    }
    
}
