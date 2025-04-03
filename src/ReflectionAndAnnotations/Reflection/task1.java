package ReflectionAndAnnotations.Reflection;

import java.lang.reflect.InvocationTargetException;

public class task1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflection = task1.class;

        System.out.println(reflection);
        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);
        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Object object = reflection.getDeclaredConstructor().newInstance();
        System.out.println(object);
    }
}
