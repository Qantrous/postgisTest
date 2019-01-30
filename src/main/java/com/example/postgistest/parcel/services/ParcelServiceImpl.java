package com.example.postgistest.parcel.services;

import com.example.postgistest.GeometryTools.Feature;
import com.example.postgistest.GeometryTools.FeatureCollection;
import com.example.postgistest.GeometryTools.JTSGeometryConverter.JTSGeometryConverter;
import com.example.postgistest.parcel.Parcel;
import com.example.postgistest.parcel.repositories.ParcelRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepo parcelRepo;


    @Override
    public void saveExistingParcels(MultipartFile multipartFile) throws IOException {
        File file = toFile(multipartFile);
        ObjectMapper objectMapper = new ObjectMapper();
        FeatureCollection featureCollection = objectMapper.readValue(file, FeatureCollection.class);
        saveExistingParcels(featureCollection);

        file.delete();
    }

    private void saveExistingParcels(FeatureCollection featureCollection) {
        List<Feature> featuresList = featureCollection.getFeatures();
        if (featuresList.size() == 0) {
            return;
        }

        for (Feature feature: featuresList){
            Parcel parcel = new Parcel();
            parcel.setGeometry(JTSGeometryConverter.convert(feature.getGeometry()));
            parcelRepo.saveAndFlush(parcel);

        }
    }

    private File toFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @Override
    public Parcel getById(Long parcelId) {

        return parcelRepo.getOne(parcelId);
    }
}
