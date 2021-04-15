package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ReadMap {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Book book = new Book();
        book.setIsbn("ISBN:98797979798");
        book.setTitle("Jack Sparrow");
        book.setAuthor("me");

        Map<String, Book> booksMap = new HashMap<>();
        booksMap.put(book.getIsbn(), book);

        String json = mapper.writeValueAsString(booksMap);
        System.out.println(json);

        Map<String, Book> newMap = mapper.readValue(json, booksMap.getClass());

        System.out.println(newMap);
    }
}
