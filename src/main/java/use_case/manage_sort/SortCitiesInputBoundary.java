package use_case.manage_sort;

/**
 * Input boundary for the sort cities use case.
 */
public interface SortCitiesInputBoundary {
    /**
     * Sorts the saved cities based on the given criteria.
     * @param sortBy the criteria to sort by (e.g., temperature, condition, humidity).
     */
    void sortCities(String sortBy);
}
