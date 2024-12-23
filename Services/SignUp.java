package bd.edu.seu.bdcash.Services;

public class SignUp {
    private String mobail;
    private String password;

public SignUp(){

}
    public SignUp(String mobail, String password) {
        this.mobail = mobail;
        this.password = password;


    }

    public String getMobail() {
        return mobail;
    }

    public void setMobail(String mobail) {
        this.mobail = mobail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
