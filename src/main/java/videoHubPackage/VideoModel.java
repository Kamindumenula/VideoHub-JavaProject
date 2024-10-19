package videoHubPackage;

import java.sql.Date;
import java.sql.Time;

public class VideoModel {
    private int videoID;
    private String videoName;
    private String description;
    private Date uploadDate;
    private Time uploadTime;
    private String videoFileName;
    private String thumbnailFileName;
    private int userID; 
    
    public VideoModel() {
    }
    
    public VideoModel(int videoID, String videoName, String description, Date uploadDate, Time uploadTime, String videoFileName, String thumbnailFileName, int userID) {
        this.videoID = videoID;
        this.videoName = videoName;
        this.description = description;
        this.uploadDate = uploadDate;
        this.uploadTime = uploadTime;
        this.videoFileName = videoFileName;
        this.thumbnailFileName = thumbnailFileName;
        this.userID = userID;
    }

 

	// Getters and setters
    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Time getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Time uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    public String getThumbnailFilename() {
        return thumbnailFileName;
    }

    public void setThumbnailFilename(String thumbnailFileName) {
        this.thumbnailFileName = thumbnailFileName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
