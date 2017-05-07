/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.acessoexterno;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import rest.test.condominio.externo.Externo;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "ACESSO_EXTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoExterno.findAll", query = "SELECT a FROM AcessoExterno a")
    , @NamedQuery(name = "AcessoExterno.findByIdACESSOEXTERNOS", query = "SELECT a FROM AcessoExterno a WHERE a.idACESSOEXTERNOS = :idACESSOEXTERNOS")
    , @NamedQuery(name = "AcessoExterno.findByHora", query = "SELECT a FROM AcessoExterno a WHERE a.hora = :hora")})
public class AcessoExterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idACESSO_EXTERNOS")
    private Integer idACESSOEXTERNOS;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @JoinColumn(name = "EXTERNO_idEXTERNO", referencedColumnName = "idEXTERNO")
    @ManyToOne(optional = false)
    private Externo eXTERNOidEXTERNO;

    public AcessoExterno() {
    }

    public AcessoExterno(Integer idACESSOEXTERNOS) {
        this.idACESSOEXTERNOS = idACESSOEXTERNOS;
    }

    public AcessoExterno(Integer idACESSOEXTERNOS, Date hora) {
        this.idACESSOEXTERNOS = idACESSOEXTERNOS;
        this.hora = hora;
    }

    public Integer getIdACESSOEXTERNOS() {
        return idACESSOEXTERNOS;
    }

    public void setIdACESSOEXTERNOS(Integer idACESSOEXTERNOS) {
        this.idACESSOEXTERNOS = idACESSOEXTERNOS;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Externo getEXTERNOidEXTERNO() {
        return eXTERNOidEXTERNO;
    }

    public void setEXTERNOidEXTERNO(Externo eXTERNOidEXTERNO) {
        this.eXTERNOidEXTERNO = eXTERNOidEXTERNO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idACESSOEXTERNOS != null ? idACESSOEXTERNOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoExterno)) {
            return false;
        }
        AcessoExterno other = (AcessoExterno) object;
        if ((this.idACESSOEXTERNOS == null && other.idACESSOEXTERNOS != null) || (this.idACESSOEXTERNOS != null && !this.idACESSOEXTERNOS.equals(other.idACESSOEXTERNOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.AcessoExterno[ idACESSOEXTERNOS=" + idACESSOEXTERNOS + " ]";
    }
    
}
