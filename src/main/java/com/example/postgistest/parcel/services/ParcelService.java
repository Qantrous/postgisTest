package com.example.postgistest.parcel.services;

import com.example.postgistest.parcel.Parcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ParcelService {

    void saveExistingParcels(MultipartFile multipartFile) throws Exception;

    Parcel getById(Long parcelId);
}
