//package test.use_case;
//
//import use_case.search_city.SearchCityInputBoundary;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SearchCityInputBoundaryTest {
//
//    private SearchCityInputBoundary searchCityInputBoundary;
//
//    @BeforeEach
//    void setUp() {
//        searchCityInputBoundary = new SearchCityInputBoundary();
//    }
//
//    @Test
//    void testSearchCityByName() {
//
//        String cityName = "Toronto";
//
//
//        boolean result = searchCityInputBoundary.searchCity(cityName);
//
//
//        assertTrue(result, "应该成功找到城市Toronto");
//    }
//    // test 2
//    @Test
//    void testSearchNonExistingCity() {
//
//        String cityName = "NonExistingCity";
//
//
//        boolean result = searchCityInputBoundary.searchCity(cityName);
//
//
//        assertFalse(result, "应该找不到不存在的城市");
//    }
//}

// 这是用于 SearchCityInputBoundary 的简单测试类
// 接下来我会为其他类编写相应的测试。
