package pattern.creational.builder;
// builder inheritance with recursive generics

class Person2 {
    public String name;

    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder2<SELF extends PersonBuilder2<SELF>> {
    protected Person2 person = new Person2();

    // critical to return SELF here
    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    protected SELF self() {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public Person2 build() {
        return person;
    }
}

class EmployeeBuilder
        extends PersonBuilder2<EmployeeBuilder> {
    public EmployeeBuilder worksAs(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class RecursiveGenericsDemo {
    public static void main(String[] args) {
        EmployeeBuilder eb = new EmployeeBuilder()
                .withName("Dmitri")
                .worksAs("Quantitative Analyst");
        System.out.println(eb.build());
    }
}