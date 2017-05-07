/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.test.condominio.funcionario;

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

import rest.test.condominio.acessoportaria.AcessoPortaria;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdFUNCIONARIO", query = "SELECT f FROM Funcionario f WHERE f.idFUNCIONARIO = :idFUNCIONARIO")
    , @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf")
    , @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome")
    , @NamedQuery(name = "Funcionario.findByFuncao", query = "SELECT f FROM Funcionario f WHERE f.funcao = :funcao")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idFUNCIONARIO;
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
    @Size(min = 1, max = 45)
    private String funcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fUNCIONARIOidFUNCIONARIO")
    private Collection<AcessoPortaria> acessoPortariaCollection;

    public Funcionario() {
    }

    public Funcionario(Integer idFUNCIONARIO) {
        this.idFUNCIONARIO = idFUNCIONARIO;
    }

    public Funcionario(Integer idFUNCIONARIO, String cpf, String nome, String funcao) {
        this.idFUNCIONARIO = idFUNCIONARIO;
        this.cpf = cpf;
        this.nome = nome;
        this.funcao = funcao;
    }

    public Integer getIdFUNCIONARIO() {
        return idFUNCIONARIO;
    }

    public void setIdFUNCIONARIO(Integer idFUNCIONARIO) {
        this.idFUNCIONARIO = idFUNCIONARIO;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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
        hash += (idFUNCIONARIO != null ? idFUNCIONARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFUNCIONARIO == null && other.idFUNCIONARIO != null) || (this.idFUNCIONARIO != null && !this.idFUNCIONARIO.equals(other.idFUNCIONARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sda.Funcionario[ idFUNCIONARIO=" + idFUNCIONARIO + " ]";
    }
    
}
