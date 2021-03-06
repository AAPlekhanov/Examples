package gson;

import com.google.gson.*;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * Gson
 */
public class Main {

    public static void main(String[] args) {

        //primitives();

        jsonObjects();

        gsonBuilder();

        jsonElementValue();

        jsonElementValue2();

    }


    /**
     * Получение значения из json
     */
    private static void jsonElementValue() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        Gson gson = new Gson();
        //сериализация
        String json = gson.toJson(person);
        System.out.println("json = " + json);

        // Дессериализация
        // Получаем jsonElement. Это по сути атрибут в json
        // Из jsonElement можно получить примитив, коллекцию, jsonObject
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);

        // Получаем jsonObject. Это по сути сам json (структура)
        // Из jsonObject можно получить jsonObject, коллекцию jsonObject, jsonElement
        JsonObject jsonObject = jsonElement.getAsJsonObject().get("address").getAsJsonObject();
        JsonElement countryElement = jsonObject.get("country");

        System.out.println("country = " + countryElement);
    }


    /**
     * Получение значения из json (Плохой способ)
     */
    private static void jsonElementValue2() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        Gson gson = new Gson();
        //сериализация
        String json = gson.toJson(person);
        System.out.println("json = " + json);

        // Дессериализация
        // Получаем jsonElement. Это по сути атрибут в json
        JsonElement jsonElement = gson.toJsonTree(new Gson().fromJson(json, Map.class).get("address"));

        // Получаем jsonObject. Это по сути сам json (структура)
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement countryElement = jsonObject.get("country");

        System.out.println("country = " + countryElement);
    }


    /**
     * Кастомный объект gson
     */
    private static void gsonBuilder() {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.SHORT, DateFormat.SHORT)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        //Сериализация
        String json = gson.toJson(person);
        System.out.println("Custom json = " + json);
    }

    /**
     * Маппинг json на Класс
     */
    private static void jsonObjects() {
        Address address = new Address("Russia", "Moscow", "Tverskaya", 10);
        Person person = new Person("AtagaN", 24, 43453, address, new Date());

        Gson gson = new Gson();
        //Сериализация
        String json = gson.toJson(person);

        System.out.println("json = " + json);

        //Десериализация
        Person person2 = gson.fromJson(json, Person.class);
        System.out.println("person2 = " + person2);
    }


    private static void primitives() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(123));    // 123
        System.out.println(gson.toJson("hello")); // "hello"
        System.out.println(gson.toJson(10L));    // 10

        System.out.println(gson.fromJson("1", int.class));
        System.out.println(gson.fromJson("\"world\"", String.class));
        System.out.println(gson.fromJson("true", Boolean.class));

        System.out.println(gson.toJson(new int[]{10, 100})); // [10,100]

        int[] array = gson.fromJson("[10,100]", int[].class);
        Arrays.stream(array).forEach(str -> {
            System.out.print(str + " ");
        });

        System.out.println();
    }


}
