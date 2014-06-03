package gerenciadordeprovas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristiano
 */
@Entity
@XmlRootElement
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String enunciado;
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
    private List<Alternativa> alternativasErradas;
    @OneToOne(cascade = CascadeType.ALL)
    private Alternativa alternativaCorreta;

    public Alternativa getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Alternativa alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
        alternativaCorreta.setQuestao(this);
    }

    public List getAlternativasErradas() {
        return alternativasErradas;
    }

    public void setAlternativasErradas(List alternativasErradas) {
        this.alternativasErradas = alternativasErradas;
    }

    public void addAlternativaErrada(Alternativa a) {
        if (this.alternativasErradas == null) {
            this.alternativasErradas = new ArrayList<Alternativa>();
        }
        this.alternativasErradas.add(a);
        a.setQuestao(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", enunciado=" + enunciado + ", alternativasErradas=" + alternativasErradas + ", alternativaCorreta=" + alternativaCorreta + '}';
    }

    

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

}
