public class Context {

    public static State getState (String name) {
        switch (name){
            case "CHANGE_NAME":
                return new ChangeUserName();
            case "CHANGE_PASSWORD":
                return new ChangePassword();
            case "RANDOM_STATE":
                return new RandomState();
            default:
                return null;
        }
    }

}
