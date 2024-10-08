package management_system.classes;

import java.util.List;

import static management_system.classes.User.users;

public class SignUp {
    public final List <User> usersr;

    String msg;
    public SignUp(List <User> users) {
        this.usersr = users;
    }
    public boolean existingEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean register(String username, String email, String password,String role) {
        if (username==null||password==null||email==null){
            setMsg("Some Missing Fields");
            return false;
        }
        if(password.length()<8){
            setMsg("your password is too weak");
            return false;
        }
        if (existingEmail(email)){
            setMsg("Email Already Exists");
            return false;
        }
        User u1=new User(username,email,password,role);
        users.add(u1);
        setMsg("Registration Successful");
        return true;
    }

}
