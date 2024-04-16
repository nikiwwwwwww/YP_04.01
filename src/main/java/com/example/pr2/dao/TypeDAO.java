package com.example.pr2.dao;

import com.example.pr2.models.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeDAO {
    private static int TYPES_COUNT;
    private final List<Type> types;

    {
        types = new ArrayList<>();

        types.add(new Type(++TYPES_COUNT, "Type1", "Description1", "Category1"));
        types.add(new Type(++TYPES_COUNT, "Type2", "Description2", "Category2"));
        types.add(new Type(++TYPES_COUNT, "Type3", "Description3", "Category3"));
    }

    public List<Type> index() {
        return types;
    }

    public Type show(int id) {
        return types.stream().filter(type -> type.getId() == id).findAny().orElse(null);
    }

    public void save(Type type) {
        type.setId(++TYPES_COUNT);
        types.add(type);
    }

    public void update(int id, Type updatedType) {
        Type typeToBeUpdated = show(id);

        if (typeToBeUpdated != null) {
            typeToBeUpdated.setName(updatedType.getName());
            typeToBeUpdated.setDescription(updatedType.getDescription());
            typeToBeUpdated.setCategory(updatedType.getCategory());
        }
    }

    public void delete(int id) {
        types.removeIf(t -> t.getId() == id);
    }
}