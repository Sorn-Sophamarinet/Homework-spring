package kh.edu.istasd.fswdapi.mapper;

import kh.edu.istasd.fswdapi.domain.Customer;
import kh.edu.istasd.fswdapi.dto.CreateCustomerRequest;
import kh.edu.istasd.fswdapi.dto.CustomerResponse;
import kh.edu.istasd.fswdapi.dto.UpdateCustomerRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse fromCustomer(Customer customer);
    Customer toCustomer(CreateCustomerRequest createCustomerRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartially(UpdateCustomerRequest updateCustomerRequest, @MappingTarget Customer customer);
}