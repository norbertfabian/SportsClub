package cz.muni.fi.pa165.sportsclub.enumeration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * @author Fabian Norbert
 */
public class AgeGroupTest {

    @DataProvider
    public static Object[][] getAgeGroupDataProvider() {
        return new Object[][] {
                {5, -1, AgeGroup.JUVENILE},
                {9, +1, AgeGroup.JUVENILE},
                {10, -1, AgeGroup.JUNIOR},
                {14, +1, AgeGroup.JUNIOR},
                {15, -1, AgeGroup.YOUTH},
                {19, +1, AgeGroup.YOUTH},
                {20, -1, AgeGroup.ADULT},
                {34, +1, AgeGroup.ADULT},
                {35, -1, AgeGroup.SENIOR},
                {99, +1, AgeGroup.SENIOR},
                {3, -1, AgeGroup.NOT_CATEGORIZED},
                {10000, -1, AgeGroup.NOT_CATEGORIZED},
                {-300, -1, AgeGroup.NOT_CATEGORIZED}
        };
    }

    @Test(dataProvider = "getAgeGroupDataProvider")
    public void getAgeGroupTest(int years, int deviation, AgeGroup result) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, deviation);
        cal.add(Calendar.YEAR, - years);

        AgeGroup group = AgeGroup.getAgeGroup(cal.getTime());

        Assert.assertEquals(group, result);
    }
}
