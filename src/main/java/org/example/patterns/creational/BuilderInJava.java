package org.example.patterns.creational;

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
