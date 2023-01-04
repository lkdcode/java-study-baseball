package user;

public class UserStatusHandler {
    private static final UserStatusHandler instance = new UserStatusHandler();
    private UserStatus userStatus = UserStatus.PLAY;

    private UserStatusHandler() {
    }

    public static UserStatusHandler getInstance() {
        return instance;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
