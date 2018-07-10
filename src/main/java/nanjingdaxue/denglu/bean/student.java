package nanjingdaxue.denglu.bean;

public class student {
    //学生ID
    private Integer id;
    //学生姓名
    private String name;
    //学生身份证
    private String IdCard;
    //学生录取号
    private String enroll;
    //学生所属院系
    private String department;
    //学生权限
    private Integer role;
    //学生照片
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toString().trim();
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard.toString().trim();
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll.toString().trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department.toString().trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
