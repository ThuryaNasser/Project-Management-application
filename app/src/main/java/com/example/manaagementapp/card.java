package com.example.manaagementapp;

//source: https://www.youtube.com/watch?v=Nw9JF55LDzE
public class card {
    private String ProjectName;
    private String Description;
    private String Goal;
    private String StartDate;
    private String EndDate;

    public card (String projectName,String description , String goal, String startDate,String endDate ){
        ProjectName=projectName;
        Description=description;
        Goal= goal;
        StartDate= startDate;
        EndDate= endDate;
    }
    public String getProjectName() {
        return ProjectName;
    }

    public String getDescription() {
        return Description;
    }

    public String getGoal() {
        return Goal;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }
}