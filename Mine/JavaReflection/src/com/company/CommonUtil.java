package com.company;

public class CommonUtil {
    public static void createSetter(String fieldName, String fieldType, StringBuffer sb) {
        sb.append("public void").append(" set");
        sb.append(getFieldName(fieldName));
        sb.append("(" + fieldType + " " + fieldName + ") {\n");
        sb.append("\t" + "this." + fieldName + " = " + fieldName + ";\n");
        sb.append("}\n\n");
    }

    public static void createGetter(String fieldName, String fieldType, StringBuffer sb) {
        sb.append("public " + fieldType)
                .append((fieldType.equals("boolean") ? " is" : " get") + getFieldName(fieldName) + "() {");
        sb.append("\n\treturn " + fieldName + ";");
        sb.append("\n" + "}" + "\n\n");
    }

    public static String getFieldName(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
