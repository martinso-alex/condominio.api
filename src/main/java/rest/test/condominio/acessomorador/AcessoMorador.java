/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.acessomorador;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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

import rest.test.condominio.morador.Morador;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "ACESSO_MORADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoMorador.findAll", query = "SELECT a FROM AcessoMorador a")
    , @NamedQuery(name = "AcessoMorador.findByIdACESSO", query = "SELECT a FROM AcessoMorador a WHERE a.idACESSO = :idACESSO")
    , @NamedQuery(name = "AcessoMorador.findByHora", query = "SELECT a FROM AcessoMorador a WHERE a.hora = :hora")
    , @NamedQuery(name = "AcessoMorador.findByTipo", query = "SELECT a FROM AcessoMorador a WHERE a.tipo = :tipo")})
public class AcessoMorador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idACESSO;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    private int tipo;
    @JoinColumn(name = "MORADOR_idMORADOR", referencedColumnName = "idMORADOR")
    @ManyToOne(optional = false)
    private Morador mORADORidMORADOR;

    public AcessoMorador() {
    }

    public AcessoMorador(Integer idACESSO) {
        this.idACESSO = idACESSO;
    }

    public AcessoMorador(Integer idACESSO, Date hora, int tipo) {
        this.idACESSO = idACESSO;
        this.hora = hora;
        this.tipo = tipo;
    }

    public Integer getIdACESSO() {
        return idACESSO;
    }

    public void setIdACESSO(Integer idACESSO) {
        this.idACESSO = idACESSO;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Morador getMORADORidMORADOR() {
        return mORADORidMORADOR;
    }

    public void setMORADORidMORADOR(Morador mORADORidMORADOR) {
        this.mORADORidMORADOR = mORADORidMORADOR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idACESSO != null ? idACESSO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoMorador)) {
            return false;
        }
        AcessoMorador other = (AcessoMorador) object;
        if ((this.idACESSO == null && other.idACESSO != null) || (this.idACESSO != null && !this.idACESSO.equals(other.idACESSO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.AcessoMorador[ idACESSO=" + idACESSO + " ]";
    }
    
}
