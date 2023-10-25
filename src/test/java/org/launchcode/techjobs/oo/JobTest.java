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

}
