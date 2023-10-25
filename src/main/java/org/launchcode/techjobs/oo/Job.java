package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private String noData = "Data not available";
    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String checkDataAvailability(String value) {

        return value.isEmpty() ? noData : value;
    }

    @Override
    public String toString() {

        String newLine = System.lineSeparator();
        String idString = "ID: " + id + newLine;
        String nameString = "Name: " + (name.isEmpty() ? noData : name) + newLine;
        String employerString = "Employer: " + checkDataAvailability(employer.getValue()) + newLine;
        String locationString = "Location: " + checkDataAvailability(location.getValue()) + newLine;
        String positionTypeString = "Position Type: " + checkDataAvailability(positionType.getValue()) + newLine;
        String coreCompetencyString = "Core Competency: " + checkDataAvailability(coreCompetency.getValue());

        if (name.isEmpty() & employer.getValue().isEmpty() && location.getValue().isEmpty() && positionType.getValue().isEmpty() && coreCompetency.getValue().isEmpty()) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return newLine + idString + nameString + employerString + locationString + positionTypeString + coreCompetencyString + newLine;
        }
    }
}
