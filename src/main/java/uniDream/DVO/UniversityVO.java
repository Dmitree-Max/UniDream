package uniDream.DVO;

import uniDream.entities.University;

public class UniversityVO {
    public Integer id;
    public String name;
    public String city;
    public String country;

    public String major_field;

    public Integer students;

    public UniversityVO(University university) {
        id = university.getId();
        name = university.getName();
        city = university.getCity();
        country = university.getCountry();
        major_field = university.getMajorField();
        students = university.getStudents();
    }
}
