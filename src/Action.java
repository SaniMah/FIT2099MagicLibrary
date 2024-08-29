public abstract class Action {

    /**
     * Executes the action.
     *
     * @param user the user on whom the action is performed.
     * @return a String representing the result of the action.
     */
    public abstract String execute(User user);

    /**
     * Provides a description of the action for display in a menu.
     *
     * @return a String representing how the action should be shown in a menu.
     */
    public abstract String menuDescription();
}


