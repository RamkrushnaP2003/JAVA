public class OOPs {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}

class BankAccount {
    public String username;
    private String password;
    public void setPassword(String pwd) {
        password = pwd;
    }
    protected void getPassword() {
        System.out.println(password);
    }

}

class Pen {
    private String color;
    private int tip;
    //getter
    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }
    //setter
    void setColor(String color) {
        this.color = color;
    }
    void setTip(int tip) {
        this.tip = tip;
    }
}