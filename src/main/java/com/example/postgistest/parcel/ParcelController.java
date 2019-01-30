package com.example.postgistest.parcel;

import com.example.postgistest.GeometryTools.Geometry;
import com.example.postgistest.GeometryTools.JTSGeometryConverter.JTSGeometryConverter;
import com.example.postgistest.parcel.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/parcel")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public String uploadParcels(@RequestParam("file") MultipartFile file) throws Exception {
        parcelService.saveExistingParcels(file);
        return "Uploaded";
    }

    @GetMapping("/{parcelId}")
    public String getById(@PathVariable("parcelId") Long parcelId){
        Parcel parcel = parcelService.getById(parcelId);
        Geometry geometry = JTSGeometryConverter.convert(parcel.getGeometry());

        return parcel.getId().toString();
    }
}
