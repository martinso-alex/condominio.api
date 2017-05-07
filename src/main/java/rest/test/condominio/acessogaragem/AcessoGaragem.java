/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.acessogaragem;

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

import rest.test.condominio.controle.Controle;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "ACESSO_GARAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoGaragem.findAll", query = "SELECT a FROM AcessoGaragem a")
    , @NamedQuery(name = "AcessoGaragem.findByIdACESSOGARAGEM", query = "SELECT a FROM AcessoGaragem a WHERE a.idACESSOGARAGEM = :idACESSOGARAGEM")
    , @NamedQuery(name = "AcessoGaragem.findByHora", query = "SELECT a FROM AcessoGaragem a WHERE a.hora = :hora")})
public class AcessoGaragem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idACESSO_GARAGEM")
    private Integer idACESSOGARAGEM;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @JoinColumn(name = "CONTROLE_idCONTROLE", referencedColumnName = "idCONTROLE")
    @ManyToOne(optional = false)
    private Controle cONTROLEidCONTROLE;

    public AcessoGaragem() {
    }

    public AcessoGaragem(Integer idACESSOGARAGEM) {
        this.idACESSOGARAGEM = idACESSOGARAGEM;
    }

    public AcessoGaragem(Integer idACESSOGARAGEM, Date hora) {
        this.idACESSOGARAGEM = idACESSOGARAGEM;
        this.hora = hora;
    }

    public Integer getIdACESSOGARAGEM() {
        return idACESSOGARAGEM;
    }

    public void setIdACESSOGARAGEM(Integer idACESSOGARAGEM) {
        this.idACESSOGARAGEM = idACESSOGARAGEM;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Controle getCONTROLEidCONTROLE() {
        return cONTROLEidCONTROLE;
    }

    public void setCONTROLEidCONTROLE(Controle cONTROLEidCONTROLE) {
        this.cONTROLEidCONTROLE = cONTROLEidCONTROLE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idACESSOGARAGEM != null ? idACESSOGARAGEM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoGaragem)) {
            return false;
        }
        AcessoGaragem other = (AcessoGaragem) object;
        if ((this.idACESSOGARAGEM == null && other.idACESSOGARAGEM != null) || (this.idACESSOGARAGEM != null && !this.idACESSOGARAGEM.equals(other.idACESSOGARAGEM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.AcessoGaragem[ idACESSOGARAGEM=" + idACESSOGARAGEM + " ]";
    }
    
}
