package api.kindergartensb.repository;

import api.kindergartensb.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findByStreet(String street);
    List<Address> findByPlz(int plz);
    List<Address> findByHouseNumber(int houseNumber);

}
