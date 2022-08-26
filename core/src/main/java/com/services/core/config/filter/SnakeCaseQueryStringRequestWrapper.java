package com.services.core.config.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 请求参数蛇形转驼峰
 */
public class SnakeCaseQueryStringRequestWrapper extends HttpServletRequestWrapper
{
    private final Enumeration<String> parameterNames;
    private final Map<String, String[]> parameterValues = new HashMap<>();

    public SnakeCaseQueryStringRequestWrapper(HttpServletRequest request) {
        super(request);
        Enumeration<String> parameterNames = super.getParameterNames();
        Vector<String> names = new Vector<>();
        while (parameterNames != null && parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] values = super.getParameterValues(name);
            String convertName = this.convertName(name);
            names.add(convertName);
            parameterValues.put(convertName, values);
        }
        this.parameterNames = names.elements();
    }

    private String convertName(String snakeCaseName) {
        if (!snakeCaseName.contains("_")) {
            return snakeCaseName;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] name = snakeCaseName.split("_");
        for (int i = 0; i < name.length; i++) {
            String s = name[i];
            if (i != 0) {
                s = toUpperFirstChar(s);
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    private String toUpperFirstChar(String string) {
        char[] charArray = string.toCharArray();
        charArray[0] -= 32;
        return String.valueOf(charArray);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return this.parameterNames;
    }

    @Override
    public String[] getParameterValues(String name) {
        return this.parameterValues.get(name);
    }
}