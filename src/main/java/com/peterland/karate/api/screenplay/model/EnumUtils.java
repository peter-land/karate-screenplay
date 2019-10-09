package com.peterland.karate.api.screenplay.model;

import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import com.peterland.karate.api.model.data.Variables;
import com.peterland.karate.api.screenplay.tasks.BaseScript;
import com.peterland.karate.api.screenplay.tasks.KarateVars;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.EnumSet;
import java.util.Map;

public class EnumUtils {

    public static <T, E extends Enum<E>> Function<T, E> lookupMap(Class<E> clazz, Function<E, T> mapper) {
        @SuppressWarnings("unchecked")
        E[] emptyArray = (E[]) Array.newInstance(clazz, 0);
        return lookupMap(EnumSet.allOf(clazz).toArray(emptyArray), mapper);
    }

    public static <T, E extends Enum<E>> Function<T, E> lookupMap(E[] values, Function<E, T> mapper) {
        Map<T, E> index = Maps.newHashMapWithExpectedSize(values.length);
        for (E value : values) {
            index.put(mapper.apply(value), value);
        }
        return (T key) -> index.get(key);
    }

    public static String getJsonFromFile(String filePath) {
        String str = "{}";
        try {
            File file = new File(filePath);
            str = new String(Files.readAllBytes(file.toPath()));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String setJsonPath(String json, String jsonPath, Object value) {
        return JsonPath.parse(json).set(jsonPath, value).jsonString();
    }

    public static String path(String... nodes) {
        String path = "";
        for (String node : nodes) {
            path += ".";
            path += node;
        }
        return path.substring(1);
    }

    public static Object merge(Object... objects) {
        Object src = objects[0];
        if (src == null)
            src = objects[1];
        else {
            for (Object obj : objects) {
                copyNonNullProperties(src, obj);
            }
        }
        return src;
    }

    public static void copyNonNullProperties(Object src, Object dst) {
        Field[] fields = dst.getClass().getDeclaredFields();
        for (Field f : fields) {
            Object dstValue = get(dst, f.getName());
            if (dstValue != null)
                set(src, f.getName(), dstValue);
        }
    }

    public static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static <V> V get(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (V) field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }

    public static void setRequestBodyVariable(String filePathBaseObject, String complementaryObject){
        String body = getJsonFromFile(filePathBaseObject);
        KarateVars.update("jsonStrA", body);
        KarateVars.update("jsonStrB", complementaryObject);
        Map<String, Object> result = KarateRunner.performAsAnonymous(BaseScript.MERGE_JSON);
        KarateVars.update(Variables.REQUEST_BODY_KEY, result.get("jsonMix"));
    }
}
