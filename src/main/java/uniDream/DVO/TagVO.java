package uniDream.DVO;

import uniDream.entities.Tag;

public class TagVO {
    public Integer id;
    public String name;

    public TagVO(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getBody();
    }
}
