package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by TuanKul on 9/23/2017.
 */
public class ListenGuidelineDTO implements Serializable {
    private Integer listenguidelineId;
    private String title;
    private String image;
    private String context;
    private Timestamp createdDate;
    private Timestamp modifieddate;

    public Integer getListenguidelineId() {
        return listenguidelineId;
    }

    public void setListenguidelineId(Integer listenguidelineId) {
        this.listenguidelineId = listenguidelineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }
}
