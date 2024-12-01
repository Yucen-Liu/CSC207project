package interface_adapter.check_city;


import use_case.check_city.CheckCityOutputBoundary;

public class CheckCityPresenter implements CheckCityOutputBoundary {
 private final CheckCityViewModel viewModel;

 public CheckCityPresenter(CheckCityViewModel viewModel) {
  this.viewModel = viewModel;
 }

 @Override
 public void presentSuccess(String cityName) {
  viewModel.setCityName(cityName);
  viewModel.setValid(true);
  System.out.println("City validation succeeded: " + cityName);
 }

 @Override
 public void presentFailure(String errorMessage) {
  viewModel.setCityName(null);
  viewModel.setValid(false);
  System.out.println("City validation failed: " + errorMessage);
 }
  
}
