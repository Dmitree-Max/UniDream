package uniDream.DVO;

import uniDream.entities.Program;

public class ProgramVO {
    public Integer id;
    public String name;

    public String university;

    public String documents;

    public String start_date;

    public String documents_deadline;

    public Integer places;

    public String description;

    public String stage;

    public ProgramVO(Program program) {
        id = program.getId();
        name = program.getName();
        university = program.getUniversity().getName();
        documents = program.getDocuments();
        start_date = program.getStartDate();
        documents_deadline = program.getDocumentsDeadline();
        places = program.getPlaces();
        stage = program.getStage();
        description = program.getDescription();
    }
}
