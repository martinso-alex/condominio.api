/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.apto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rest.test.condominio.controle.Controle;
import rest.test.condominio.morador.Morador;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "APTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apto.findAll", query = "SELECT a FROM Apto a")
    , @NamedQuery(name = "Apto.findByIdAPTO", query = "SELECT a FROM Apto a WHERE a.idAPTO = :idAPTO")})
public class Apto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idAPTO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aPTOidAPTO")
    private Collection<Controle> controleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aPTOidAPTO")
    private Collection<Morador> moradorCollection;

    public Apto() {
    }

    public Apto(Integer idAPTO) {
        this.idAPTO = idAPTO;
    }

    public Integer getIdAPTO() {
        return idAPTO;
    }

    public void setIdAPTO(Integer idAPTO) {
        this.idAPTO = idAPTO;
    }
    
    @JsonIgnore
    @XmlTransient
    public Collection<Controle> getControleCollection() {
        return controleCollection;
    }

    public void setControleCollection(Collection<Controle> controleCollection) {
        this.controleCollection = controleCollection;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<Morador> getMoradorCollection() {
        return moradorCollection;
    }

    public void setMoradorCollection(Collection<Morador> moradorCollection) {
        this.moradorCollection = moradorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAPTO != null ? idAPTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apto)) {
            return false;
        }
        Apto other = (Apto) object;
        if ((this.idAPTO == null && other.idAPTO != null) || (this.idAPTO != null && !this.idAPTO.equals(other.idAPTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.Apto[ idAPTO=" + idAPTO + " ]";
    }
    
}
