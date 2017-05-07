/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.morador;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import rest.test.condominio.acessomorador.AcessoMorador;
import rest.test.condominio.acessoportaria.AcessoPortaria;
import rest.test.condominio.apto.Apto;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "MORADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Morador.fiAcessoSndAll", query = "SELECT m FROM Morador m")
    , @NamedQuery(name = "Morador.findByIdMORADOR", query = "SELECT m FROM Morador m WHERE m.idMORADOR = :idMORADOR")
    , @NamedQuery(name = "Morador.findByDedoPolegar", query = "SELECT m FROM Morador m WHERE m.dedoPolegar = :dedoPolegar")
    , @NamedQuery(name = "Morador.findByDedoIndicador", query = "SELECT m FROM Morador m WHERE m.dedoIndicador = :dedoIndicador")
    , @NamedQuery(name = "Morador.findByDedoMedio", query = "SELECT m FROM Morador m WHERE m.dedoMedio = :dedoMedio")
    , @NamedQuery(name = "Morador.findByDedoAnelar", query = "SELECT m FROM Morador m WHERE m.dedoAnelar = :dedoAnelar")
    , @NamedQuery(name = "Morador.findByDedoMinimo", query = "SELECT m FROM Morador m WHERE m.dedoMinimo = :dedoMinimo")
    , @NamedQuery(name = "Morador.findByTag", query = "SELECT m FROM Morador m WHERE m.tag = :tag")
    , @NamedQuery(name = "Morador.findByCpf", query = "SELECT m FROM Morador m WHERE m.cpf = :cpf")
    , @NamedQuery(name = "Morador.findByNome", query = "SELECT m FROM Morador m WHERE m.nome = :nome")})
public class Morador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idMORADOR;
    @Column(name = "DEDO_POLEGAR")
    private Integer dedoPolegar;
    @Column(name = "DEDO_INDICADOR")
    private Integer dedoIndicador;
    @Column(name = "DEDO_MEDIO")
    private Integer dedoMedio;
    @Column(name = "DEDO_ANELAR")
    private Integer dedoAnelar;
    @Column(name = "DEDO_MINIMO")
    private Integer dedoMinimo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    private String tag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mORADORidMORADOR")
    private Collection<AcessoMorador> acessoMoradorCollection;
    @JoinColumn(name = "APTO_idAPTO", referencedColumnName = "idAPTO")
    @ManyToOne(optional = false)
    private Apto aPTOidAPTO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mORADORidMORADOR")
    private Collection<AcessoPortaria> acessoPortariaCollection;

    public Morador() {
    }

    public Morador(Integer idMORADOR) {
        this.idMORADOR = idMORADOR;
    }

    public Morador(Integer idMORADOR, String tag, String cpf, String nome) {
        this.idMORADOR = idMORADOR;
        this.tag = tag;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Integer getIdMORADOR() {
        return idMORADOR;
    }

    public void setIdMORADOR(Integer idMORADOR) {
        this.idMORADOR = idMORADOR;
    }

    public Integer getDedoPolegar() {
        return dedoPolegar;
    }

    public void setDedoPolegar(Integer dedoPolegar) {
        this.dedoPolegar = dedoPolegar;
    }

    public Integer getDedoIndicador() {
        return dedoIndicador;
    }

    public void setDedoIndicador(Integer dedoIndicador) {
        this.dedoIndicador = dedoIndicador;
    }

    public Integer getDedoMedio() {
        return dedoMedio;
    }

    public void setDedoMedio(Integer dedoMedio) {
        this.dedoMedio = dedoMedio;
    }

    public Integer getDedoAnelar() {
        return dedoAnelar;
    }

    public void setDedoAnelar(Integer dedoAnelar) {
        this.dedoAnelar = dedoAnelar;
    }

    public Integer getDedoMinimo() {
        return dedoMinimo;
    }

    public void setDedoMinimo(Integer dedoMinimo) {
        this.dedoMinimo = dedoMinimo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    @JsonIgnore
    @XmlTransient
    public Collection<AcessoMorador> getAcessoMoradorCollection() {
        return acessoMoradorCollection;
    }

    public void setAcessoMoradorCollection(Collection<AcessoMorador> acessoMoradorCollection) {
        this.acessoMoradorCollection = acessoMoradorCollection;
    }

    public Apto getAPTOidAPTO() {
        return aPTOidAPTO;
    }

    public void setAPTOidAPTO(Apto aPTOidAPTO) {
        this.aPTOidAPTO = aPTOidAPTO;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<AcessoPortaria> getAcessoPortariaCollection() {
        return acessoPortariaCollection;
    }

    public void setAcessoPortariaCollection(Collection<AcessoPortaria> acessoPortariaCollection) {
        this.acessoPortariaCollection = acessoPortariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMORADOR != null ? idMORADOR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Morador)) {
            return false;
        }
        Morador other = (Morador) object;
        if ((this.idMORADOR == null && other.idMORADOR != null) || (this.idMORADOR != null && !this.idMORADOR.equals(other.idMORADOR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.Morador[ idMORADOR=" + idMORADOR + " ]";
    }
    
}
