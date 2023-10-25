package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job emptyJob = new Job();
        Job emptyJob2 = new Job();
        assertNotEquals(emptyJob.getId(), emptyJob2.getId(), "these two jobs do not equal each other");
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester",
                  new Employer("ACME"),
                  new Location("Desert"),
                  new PositionType("Quality control"),
                  new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester",
                   new Employer("ACME"),
                   new Location("Desert"),
                   new PositionType("Quality control"),
                   new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester",
                   new Employer("ACME"),
                   new Location("Desert"),
                   new PositionType("Quality control"),
                   new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester",
                  new Employer("ACME"),
                  new Location("Desert"),
                  new PositionType("Quality control"),
                  new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        String jobString = job.toString();
        String[] lines = jobString.split(newLine);

        assertEquals("", lines[0]);
        assertEquals(true, job.toString().endsWith(newLine));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        String jobString = job.toString();
        String[] lines = jobString.split(newLine);

        //assertEquals("ID: 1", lines[1]); //will pass with only this test running
        //assertEquals("ID: 4", lines[1]); //will pass with only all tests running
        assertEquals("Name: Product tester", lines[2]);
        assertEquals("Employer: ACME", lines[3]);
        assertEquals("Location: Desert", lines[4]);
        assertEquals("Position Type: Quality control", lines[5]);
        assertEquals("Core Competency: Persistence", lines[6]);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
        String newLine = System.lineSeparator();
        String jobString = job.toString();
        String[] lines = jobString.split(newLine);


        assertEquals("Employer: Data not available", lines[3]);
        assertEquals("Location: Data not available", lines[4]);
        assertEquals("Position Type: Data not available", lines[5]);
        assertEquals("Core Competency: Data not available", lines[6]);
    }
}
