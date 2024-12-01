package interface_adapter.get_details;

import interface_adapter.ViewModel;

public class GetDetailsViewModel extends ViewModel<GetDetailsState> {
    public GetDetailsViewModel() {
        super("get details");
        setState(new GetDetailsState());
    }
}
