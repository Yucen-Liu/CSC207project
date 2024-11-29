package interface_adapter.signup;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewModel extends ViewModel<SignupState> {

    public static final String TITLE_LABEL = "Sign Up";
    public static final String USERNAME_LABEL = "Username";
    public static final String PASSWORD_LABEL = "Password";
    public static final String REPEAT_PASSWORD_LABEL = "Confirm Password";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String BACK_BUTTON_LABEL = "Back";


    public SignupViewModel() {
        super("sign up");
        setState(new SignupState());
    }

}

