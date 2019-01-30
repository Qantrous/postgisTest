package com.example.postgistest.parcel.repositories;

import com.example.postgistest.parcel.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, Long> {

}
