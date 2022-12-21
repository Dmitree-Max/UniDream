package uniDream.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String body;

    @Lazy
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tag_program")
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Set<Program> program;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String name) {
        this.body = name;
    }

    public Set<Program> getPrograms() {
        return program;
    }

    public void setProgram(Set<Program> program) {
        this.program = program;
    }
}
