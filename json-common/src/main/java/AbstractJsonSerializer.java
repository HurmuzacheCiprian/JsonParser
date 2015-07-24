import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by churmuzache on 7/24/15.
 */
public abstract class AbstractJsonSerializer {

    /**
     * REGEX used for inner classes
     */
    private static final String skipFieldType = "this$";

    private static final String INNER_REFERENCE = "$";

    private static final Map<Class<?>, Object> excludedClasses = new HashMap<Class<?>, Object>();


    static {
        excludedClasses.put(String.class,true);
        excludedClasses.put(Date.class,true);
        excludedClasses.put(Integer.class,true);
        excludedClasses.put(Boolean.class,true);
    }

    /**
     * Method that serializes an object into JSON format.
     * This method is also safe to use on inner classes objects.
     *
     * @param entity
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> String toJson(T entity) throws IllegalAccessException {
        Class<?> clazz = entity.getClass();
            String json = "{";
            String innerClassField = "";

            for (Field f : clazz.getDeclaredFields()) {
                f.setAccessible(true);
                boolean isInnerFieldReference = f.getType().toString().indexOf(INNER_REFERENCE) > 0 ? true : false;

                String innerObject="";
                if(isInnerFieldReference) {
                    Class<?> fieldClass = f.get(entity) == null ? null :f.get(entity).getClass();

                    if(!excludedClasses.containsKey(fieldClass)) {

                        innerObject = toJson(fieldClass);
                    }else {
                        innerObject = (String)f.get(entity).toString();
                    }
                }else {

                    innerObject = f.get(entity) == null ? null : f.get(entity).toString();;
                }
                json += "\"" + f.getName() + "\":" + "\"" + innerObject + "\"";
                json += ",";
            }

            int innerClassIndex = json.lastIndexOf(skipFieldType);
            if (innerClassIndex > 0) {
                innerClassField = json.substring(innerClassIndex, json.length() - 2);
                json = json.substring(0, innerClassIndex - 2);
                json += "}";
            } else {
                json = json.substring(0, json.lastIndexOf(','));
                json += "}";
            }

            return json;
    }

    public static <T> T fromJson(String json, Class<?> clazz) {


        return null;
    }

}
