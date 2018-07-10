package nanjingdaxue.denglu.bean;

public class admin {
    //管理者ID
    private Integer Id;
    //管理者用户姓名
    private String Name;
    //管理者账户
    private String Account;
    //管理者密码
    private String Password;
    //管理者用户权限
    private String Role;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name.toString().trim();
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAccount() {
        return Account.toString().trim();
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password.toString().trim();
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}