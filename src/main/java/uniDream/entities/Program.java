package uniDream.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Lazy;
import uniDream.DVO.ProgramVO;

import java.util.List;

@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;

    public String documents;

    public String start_date;

    public String documents_deadline;

    public Integer places;

    public String stage;
    @Lazy
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private University university;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private List<Tag> tags;

//    @ManyToOne
//    @JoinColumn(name = "university_id")
//    private University university;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getDocuments() {
        return documents;
    }

    public String getStartDate() {
        return start_date;
    }

    public String getDocumentsDeadline() {
        return documents_deadline;
    }

    public Integer getPlaces() {
        return places;
    }

    public String getStage() {
        return stage;
    }

    public String getDescription() {
        return description;
    }

    public ProgramVO getVO() {
        return new ProgramVO(this);
    }
}
