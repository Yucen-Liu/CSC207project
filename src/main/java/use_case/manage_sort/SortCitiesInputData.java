package use_case.manage_sort;

/**
 * Input data for the SortCities use case.
 */

// InputData 唯一一个携带的东西就是 criterion, which is given by 'View' and through 'Controller' to give to 'InputData'
public class SortCitiesInputData {
    private final String criterion;

    // When initializing the InputData class, we need one input which is a String we called criterion
    public SortCitiesInputData(String criterion) {
        this.criterion = criterion;
    }

    public String getCriterion() {
        return criterion;
    }
}
