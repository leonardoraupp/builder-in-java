package pattern.creational.builder.exercise;

import java.util.ArrayList;
import java.util.List;

class ClassElement {
    private String name;
    private String type;
    private List<ClassElement> elements = new ArrayList<>();

    public ClassElement() {
    }

    public ClassElement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<ClassElement> getElements() {
        return elements;
    }

    public void addElements(ClassElement e) {
        elements.add(e);
    }


    @Override
    public String toString() {
        return "CodeChunk{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class CodeBuilder {
    private final String className;
    private ClassElement classElement = new ClassElement();
    private String lineSeparator = System.lineSeparator();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        ClassElement field = new ClassElement(name, type);
        classElement.addElements(field);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("public class ")
                .append(className)
                .append(lineSeparator)
                .append("{")
                .append(lineSeparator);
        for (ClassElement e : classElement.getElements()) {
            sb
                    .append(e.getType())
                    .append(" ")
                    .append(e.getName())
                    .append(";")
                    .append(lineSeparator);
        }
        sb.append("}");
        return sb.toString();
    }
}

class DemoCodeBuilder {
    public static void main(String[] args) {
        CodeBuilder cb =
                new CodeBuilder("Person")
                        .addField("name", "String")
                        .addField("age", "int");
        System.out.println(cb);
    }
}