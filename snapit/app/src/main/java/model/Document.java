package model;

import com.google.gson.JsonObject;
/**
 * Created by srgopalakrishnan on 5/7/14.
 */
public class Document {

    private String activity;
    private String activity_date;
    private String comment;
    private String document_id;
    private String mediaurl;
    private String student;
    private String subject;
    private String uploaded_by;
    private String uploaded_date;


    public Document(JsonObject jsonObject)
    {
        if(jsonObject.has("id") && !jsonObject.get("id").isJsonNull())
        {
            this.document_id = jsonObject.get("id").getAsString();
        }
        if(jsonObject.has("activity") && !jsonObject.get("activity").isJsonNull())
        {
            this.activity = jsonObject.get("activity").getAsString();
        }
        if(jsonObject.has("comment") && !jsonObject.get("comment").isJsonNull())
        {
            this.comment = jsonObject.get("comment").getAsString();

        }
        if(jsonObject.has("activity_date") && !jsonObject.get("activity_date").isJsonNull())
        {
            this.activity_date =  jsonObject.get("activity_date").getAsString();

        }
        if(jsonObject.has("student") && !jsonObject.get("student").isJsonNull())
        {
            this.student =  jsonObject.get("student").getAsString();

        }
        if(jsonObject.has("subject") && !jsonObject.get("subject").isJsonNull())
        {
            this.subject = jsonObject.get("subject").getAsString();

        }
        if(jsonObject.has("uploaded_by") && !jsonObject.get("uploaded_by").isJsonNull())
        {
            this.uploaded_by = jsonObject.get("uploaded_by").getAsString();

        }
        if(jsonObject.has("uploaded_date") && !jsonObject.get("uploaded_date").isJsonNull())
        {
            this.uploaded_date = jsonObject.get("uploaded_date").getAsString();

        }
        if(jsonObject.has("mediaurl") && !jsonObject.get("mediaurl").isJsonNull())
        {
            this.mediaurl = jsonObject.get("uploaded_date").getAsString();
        }
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(String uploaded_date) {
        this.uploaded_date = uploaded_date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
