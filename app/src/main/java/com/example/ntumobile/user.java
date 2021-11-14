package com.example.ntumobile;

public class user {

    String email, name, course, AvatarUrl;

    public user(){

    }


    public user(String email, String name, String course, String AvatarUrl){
        this.name = name;
        this.course= course;
        this.email=email;
        this.AvatarUrl=AvatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {

        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public void setAvatarUrl(String AvatarUrl) {

        this.AvatarUrl = AvatarUrl;
    }
}
