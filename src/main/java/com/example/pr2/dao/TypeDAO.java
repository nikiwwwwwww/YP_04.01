package com.example.pr2.dao;

import com.example.pr2.Repository.TypeRepository;
import com.example.pr2.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeDAO {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeDAO(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    public List<Type> index() {
        return typeRepository.findAll();
    }
    public Type show(int id) {
        return typeRepository.findById(id).orElse(null);
    }

    public void save(Type type) {
        typeRepository.save(type);
    }
    public void update(int id, Type updatedtype) {
        Type typeToBeUpdated = show(id);
        if (typeToBeUpdated != null) {
            typeToBeUpdated.setName(updatedtype.getName());
            typeToBeUpdated.setDescription(updatedtype.getDescription());
            typeToBeUpdated.setCategory(updatedtype.getCategory());
            typeRepository.save(updatedtype);
        }
    }
    public void delete(int id) {
        typeRepository.deleteById(id);
    }
}