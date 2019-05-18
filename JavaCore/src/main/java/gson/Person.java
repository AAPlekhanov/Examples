package gson;

public class Person {

    private String name;
    private int age;
    private int phone;
    private Address address;

    public Person(String name, int age, int phone, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }
}
