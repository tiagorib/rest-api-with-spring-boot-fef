package br.com.fefproject.FefProjectApplication.exception;

import java.util.HashMap;

public class ResponseGenericException {
    public static <T> Object response(T object) {
        return new HashMap<String, T>() {
            private static final long serialVersionUID = 1L;
            {
                put("result", object);
            }
        };
    }
}
