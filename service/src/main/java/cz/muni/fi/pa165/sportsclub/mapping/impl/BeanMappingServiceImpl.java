package cz.muni.fi.pa165.sportsclub.mapping.impl;

import cz.muni.fi.pa165.sportsclub.mapping.BeanMappingService;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Fabian Norbert
 */

@Service
public class BeanMappingServiceImpl implements BeanMappingService{

    private Mapper dozer;

    @Override
    public  <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : objects) {
            mappedCollection.add(dozer.map(object, mapToClass));
        }
        return mappedCollection;
    }

    @Override
    public  <T> T mapTo(Object u, Class<T> mapToClass)
    {
        return dozer.map(u,mapToClass);
    }

    @Override
    public Mapper getMapper(){
        return dozer;
    }
}
