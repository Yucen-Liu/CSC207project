package use_case.manage_sort;

/**
 * Input data for the SortCities use case.
 */
public class SortCitiesInputData {
    private final String criterion;

    public SortCitiesInputData(String criterion) {
        this.criterion = criterion;
    }

    public String getCriterion() {
        return criterion;
    }
}
