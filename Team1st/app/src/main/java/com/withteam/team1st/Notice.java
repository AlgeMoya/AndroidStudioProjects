package com.withteam.team1st;

public class Notice {
    String ID, NoticeName, Location, Department1, WorkMethod, CurrentPerson, MaxPerson, Dday, StartDate, EndDate, Univ, Department2, Grade, Description;

    public Notice(String ID, String NoticeName, String Location, String Department1, String WorkMethod, String CurrentPerson, String MaxPerson, String Dday, String StartDate, String EndDate, String Univ, String Department2, String Grade, String Description ) {
        this.ID = ID;
        this.NoticeName = NoticeName;
        this.Location = Location;
        this.Department1 = Department1;
        this.WorkMethod = WorkMethod;
        this.CurrentPerson = CurrentPerson;
        this.MaxPerson = MaxPerson;
        this.Dday = Dday;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Univ = Univ;
        this.Department2 = Department2;
        this.Grade = Grade;
        this.Description = Description;
    }
}
