/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.controle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rest.test.condominio.acessogaragem.AcessoGaragem;
import rest.test.condominio.apto.Apto;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "CONTROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controle.findAll", query = "SELECT c FROM Controle c")
    , @NamedQuery(name = "Controle.findByIdCONTROLE", query = "SELECT c FROM Controle c WHERE c.idCONTROLE = :idCONTROLE")
    , @NamedQuery(name = "Controle.findByPlaca", query = "SELECT c FROM Controle c WHERE c.placa = :placa")})
public class Controle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCONTROLE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String placa;
    @JoinColumn(name = "APTO_idAPTO", referencedColumnName = "idAPTO")
    @ManyToOne(optional = false)
    private Apto aPTOidAPTO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cONTROLEidCONTROLE")
    private Collection<AcessoGaragem> acessoGaragemCollection;

    public Controle() {
    }

    public Controle(Integer idCONTROLE) {
        this.idCONTROLE = idCONTROLE;
    }

    public Controle(Integer idCONTROLE, String placa) {
        this.idCONTROLE = idCONTROLE;
        this.placa = placa;
    }

    public Integer getIdCONTROLE() {
        return idCONTROLE;
    }

    public void setIdCONTROLE(Integer idCONTROLE) {
        this.idCONTROLE = idCONTROLE;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Apto getAPTOidAPTO() {
        return aPTOidAPTO;
    }

    public void setAPTOidAPTO(Apto aPTOidAPTO) {
        this.aPTOidAPTO = aPTOidAPTO;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<AcessoGaragem> getAcessoGaragemCollection() {
        return acessoGaragemCollection;
    }

    public void setAcessoGaragemCollection(Collection<AcessoGaragem> acessoGaragemCollection) {
        this.acessoGaragemCollection = acessoGaragemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCONTROLE != null ? idCONTROLE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controle)) {
            return false;
        }
        Controle other = (Controle) object;
        if ((this.idCONTROLE == null && other.idCONTROLE != null) || (this.idCONTROLE != null && !this.idCONTROLE.equals(other.idCONTROLE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.Controle[ idCONTROLE=" + idCONTROLE + " ]";
    }
    
}
