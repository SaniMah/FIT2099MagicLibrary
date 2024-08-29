public class ExitAction extends Action {
    @Override
    public String execute(User user){
        user.setComplete(true);
        System.out.println("Thank you for visting Hogwarts Library of FIT2099!");
        System.exit(0);
        System.exit(0);
        return null;
    }

    @Override
    public String menuDescription() {
        return "Exit";
    }
}


