package arioch.divij.appnavigation;

import com.google.gson.JsonObject;

import arioch.divij.appnavigation.Enums.ActivityType;

/**
 * Created by divijdurve on 4/15/14.
 */
public class FeedItem {

    ActivityType activityType;
    String activityDate;
    String comment;
    String id;
    String student;
    String subject;
    String uploadedBy;
    String uploadedDate;

    public String getMediaUrl() {
        return mediaUrl;
    }

    String mediaUrl;

    public FeedItem(JsonObject jsonObject)
    {
        if(jsonObject.has("id") && !jsonObject.get("id").isJsonNull())
        {
            this.id = jsonObject.get("id").getAsString();
        }
        else
        {
        this.id = "Not Returned";
        }

        if(jsonObject.has("activity") && !jsonObject.get("activity").isJsonNull())
        {
            this.activityType = ActivityType.extractEnumFromString(jsonObject.get("activity").getAsString());
        }
        else
        {
            this.activityType = ActivityType.UNKNOWN;
        }


        if(jsonObject.has("comment") && !jsonObject.get("comment").isJsonNull())
        {
            this.comment = jsonObject.get("comment").getAsString();

        }
        else
        {
            this.comment = "N/A";
        }

        if(jsonObject.has("activity_date") && !jsonObject.get("activity_date").isJsonNull())
        {
            this.activityDate =  jsonObject.get("activity_date").getAsString();

        }
        else
        {
            this.activityDate = "Not Available";
        }

        if(jsonObject.has("student") && !jsonObject.get("student").isJsonNull())
        {
            this.student =  jsonObject.get("student").getAsString();

        }
        else
        {
            this.student = "Not Available";
        }

        if(jsonObject.has("subject") && !jsonObject.get("subject").isJsonNull())
        {
            this.subject = jsonObject.get("subject").getAsString();

        }
        else
        {
            this.student = "Not Available";
        }

        if(jsonObject.has("uploaded_by") && !jsonObject.get("uploaded_by").isJsonNull())
        {
            this.uploadedBy = jsonObject.get("uploaded_by").getAsString();

        }
        else
        {
            this.uploadedBy = "Not Available";

        }

        if(jsonObject.has("uploaded_date") && !jsonObject.get("uploaded_date").isJsonNull())
        {
            this.uploadedDate = jsonObject.get("uploaded_date").getAsString();

        }
        else
        {
            this.uploadedDate = "not available";
        }

        if(jsonObject.has("mediaurl") && !jsonObject.get("mediaurl").isJsonNull())
        {
            this.mediaUrl = jsonObject.get("mediaurl").getAsString();
        }
        else
        {
            this.mediaUrl = "http://www.billboard.com/files/styles/promo_650/public/stylus/108790-eminem_cover_617-409.jpg";
        }
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }
}
