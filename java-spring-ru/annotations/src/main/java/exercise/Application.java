package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) {
        var address = new Address("London", 12345678);
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } if (method.getGenericReturnType().getTypeName().equals("java.lang.String")) {
                    System.out.println("Method " + method.getName() + " returns a value of type String");
                } else {
                    System.out.println("Method " + method.getName() + " returns a value of type " + method.getGenericReturnType().getTypeName());
                }

            }
        }
    }
}
