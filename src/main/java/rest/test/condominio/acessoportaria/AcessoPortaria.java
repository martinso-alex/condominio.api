/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.acessoportaria;

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

import rest.test.condominio.funcionario.Funcionario;
import rest.test.condominio.morador.Morador;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "ACESSO_PORTARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoPortaria.findAll", query = "SELECT a FROM AcessoPortaria a")
    , @NamedQuery(name = "AcessoPortaria.findByIdACESSOPORTARIA", query = "SELECT a FROM AcessoPortaria a WHERE a.idACESSOPORTARIA = :idACESSOPORTARIA")
    , @NamedQuery(name = "AcessoPortaria.findByHora", query = "SELECT a FROM AcessoPortaria a WHERE a.hora = :hora")})
public class AcessoPortaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idACESSO_PORTARIA")
    private Integer idACESSOPORTARIA;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @JoinColumn(name = "FUNCIONARIO_idFUNCIONARIO", referencedColumnName = "idFUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario fUNCIONARIOidFUNCIONARIO;
    @JoinColumn(name = "MORADOR_idMORADOR", referencedColumnName = "idMORADOR")
    @ManyToOne(optional = false)
    private Morador mORADORidMORADOR;

    public AcessoPortaria() {
    }

    public AcessoPortaria(Integer idACESSOPORTARIA) {
        this.idACESSOPORTARIA = idACESSOPORTARIA;
    }

    public AcessoPortaria(Integer idACESSOPORTARIA, Date hora) {
        this.idACESSOPORTARIA = idACESSOPORTARIA;
        this.hora = hora;
    }

    public Integer getIdACESSOPORTARIA() {
        return idACESSOPORTARIA;
    }

    public void setIdACESSOPORTARIA(Integer idACESSOPORTARIA) {
        this.idACESSOPORTARIA = idACESSOPORTARIA;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Funcionario getFUNCIONARIOidFUNCIONARIO() {
        return fUNCIONARIOidFUNCIONARIO;
    }

    public void setFUNCIONARIOidFUNCIONARIO(Funcionario fUNCIONARIOidFUNCIONARIO) {
        this.fUNCIONARIOidFUNCIONARIO = fUNCIONARIOidFUNCIONARIO;
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
        hash += (idACESSOPORTARIA != null ? idACESSOPORTARIA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoPortaria)) {
            return false;
        }
        AcessoPortaria other = (AcessoPortaria) object;
        if ((this.idACESSOPORTARIA == null && other.idACESSOPORTARIA != null) || (this.idACESSOPORTARIA != null && !this.idACESSOPORTARIA.equals(other.idACESSOPORTARIA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.AcessoPortaria[ idACESSOPORTARIA=" + idACESSOPORTARIA + " ]";
    }
    
}
