package uniDream.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import uniDream.DVO.UniversityVO;

import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Universities")
public class University {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer students;

    private String name;

    private String city;

    private String country;

    private String major_field;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="university_id", referencedColumnName="id")
    private List<Program> programs = new ArrayList<Program>();

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

    public Iterable<Program> setProgram(List<Program> programs) {
        return this.programs = programs;
    }
    public Iterable<Program> getProgram() {
        return programs;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getMajorField() {
        return major_field;
    }

    public Integer getStudents() {
        return students;
    }

    public UniversityVO getVO() {
        return new UniversityVO(this);
    }
}