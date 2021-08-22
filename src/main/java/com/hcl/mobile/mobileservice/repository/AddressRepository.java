package com.hcl.mobile.mobileservice.repository;

import com.hcl.mobile.mobileservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByAddressId(final Long addressId);

    @Transactional
    @Modifying
    @Query("update address set houseNo = :#{#address.houseNo}, city = :#{#address.city} where addressId = :#{#address.addressId}")
    void updateByIdAddress(@Param("address") final Address address);
}
