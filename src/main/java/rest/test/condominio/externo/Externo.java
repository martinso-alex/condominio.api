/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.externo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rest.test.condominio.acessoexterno.AcessoExterno;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "EXTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externo.findAll", query = "SELECT e FROM Externo e")
    , @NamedQuery(name = "Externo.findByIdEXTERNO", query = "SELECT e FROM Externo e WHERE e.idEXTERNO = :idEXTERNO")
    , @NamedQuery(name = "Externo.findByCpf", query = "SELECT e FROM Externo e WHERE e.cpf = :cpf")
    , @NamedQuery(name = "Externo.findByNome", query = "SELECT e FROM Externo e WHERE e.nome = :nome")
    , @NamedQuery(name = "Externo.findByEmpresa", query = "SELECT e FROM Externo e WHERE e.empresa = :empresa")})
public class Externo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idEXTERNO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    private String empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eXTERNOidEXTERNO")
    private Collection<AcessoExterno> acessoExternoCollection;

    public Externo() {
    }

    public Externo(Integer idEXTERNO) {
        this.idEXTERNO = idEXTERNO;
    }

    public Externo(Integer idEXTERNO, String cpf, String nome, String empresa) {
        this.idEXTERNO = idEXTERNO;
        this.cpf = cpf;
        this.nome = nome;
        this.empresa = empresa;
    }

    public Integer getIdEXTERNO() {
        return idEXTERNO;
    }

    public void setIdEXTERNO(Integer idEXTERNO) {
        this.idEXTERNO = idEXTERNO;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<AcessoExterno> getAcessoExternoCollection() {
        return acessoExternoCollection;
    }

    public void setAcessoExternoCollection(Collection<AcessoExterno> acessoExternoCollection) {
        this.acessoExternoCollection = acessoExternoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEXTERNO != null ? idEXTERNO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Externo)) {
            return false;
        }
        Externo other = (Externo) object;
        if ((this.idEXTERNO == null && other.idEXTERNO != null) || (this.idEXTERNO != null && !this.idEXTERNO.equals(other.idEXTERNO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.Externo[ idEXTERNO=" + idEXTERNO + " ]";
    }
    
}
