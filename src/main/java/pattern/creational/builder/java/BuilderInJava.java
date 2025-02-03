package pattern.creational.builder.java;

// Builders in Java
class BuilderInJava {

    public static void main(String[] args) {
        String[] words = {"Apple", "Linux", "Windows"};
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<ul>\n");
        for (String word : words) {
            stringBuilder.append(String.format("  <li>%s</li>\n", word));
        }
        stringBuilder.append("</ul>");
        System.out.println(stringBuilder);
    }
}

class FluentBuilder {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Apple ");
        stringBuilder.append("is ");
        stringBuilder.append("good");
        System.out.println(stringBuilder);

//        Fluent builder basically is you can chain the operations
        StringBuilder fluentBuilder = new StringBuilder();
        fluentBuilder
                .append("Apple ")
                .append("is ")
                .append("good");
        System.out.println(stringBuilder);
    }
}


// Builder(s) for domain object(s)


