package com.phone.service.impl;

import com.phone.model.Smartphone;
import com.phone.repository.ISmartphoneRepository;
import com.phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
       return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone remove(Long id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.delete(id);
        return smartphone;
    }
}
