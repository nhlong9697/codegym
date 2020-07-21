package com.phone.service;

import com.phone.model.Smartphone;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone smartphone);
    Smartphone remove(Long id);
}
