package cz.muni.fi.pa165.sportsclub.enumeration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

/**
 * @author Fabian Norbert
 */
public class AgeGroupTest {

    @DataProvider
    public static Object[][] getByDateDataProvider() {
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

    @Test(dataProvider = "getByDateDataProvider")
    public void getByDateTest(int years, int deviation, AgeGroup expected) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, deviation);
        cal.add(Calendar.YEAR, - years);

        AgeGroup result = AgeGroup.getByDate(cal.getTime());

        Assert.assertEquals(result, expected);
    }

    @DataProvider
    public static Object[][] getByLabelDataProvider() {
        return new Object[][] {
                {AgeGroup.JUVENILE.getLabel(), AgeGroup.JUVENILE},
                {AgeGroup.JUNIOR.getLabel(), AgeGroup.JUNIOR},
                {AgeGroup.YOUTH.getLabel(), AgeGroup.YOUTH},
                {AgeGroup.ADULT.getLabel(), AgeGroup.ADULT},
                {AgeGroup.SENIOR.getLabel(), AgeGroup.SENIOR},
                {AgeGroup.NOT_CATEGORIZED.getLabel(), AgeGroup.NOT_CATEGORIZED},
                {"Some random label", AgeGroup.NOT_CATEGORIZED}
        };
    }

    @Test(dataProvider = "getByLabelDataProvider")
    public void getByLabelTest(String label, AgeGroup expected) {
        AgeGroup result = AgeGroup.getByLabel(label);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void getAllLabels() {
        List<String> result = AgeGroup.getAllLabels();

        Assert.assertEquals(6, result.size());
        Assert.assertTrue(result.contains(AgeGroup.JUVENILE.getLabel()));
        Assert.assertTrue(result.contains(AgeGroup.JUNIOR.getLabel()));
        Assert.assertTrue(result.contains(AgeGroup.YOUTH.getLabel()));
        Assert.assertTrue(result.contains(AgeGroup.ADULT.getLabel()));
        Assert.assertTrue(result.contains(AgeGroup.SENIOR.getLabel()));
        Assert.assertTrue(result.contains(AgeGroup.NOT_CATEGORIZED.getLabel()));
    }
}
