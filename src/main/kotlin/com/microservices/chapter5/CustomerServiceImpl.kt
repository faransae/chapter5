package com.microservices.chapter5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerServiceImpl : CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int): Mono<Customer> =
        customerRepository.findById(id)


    override fun createCustomer(customer: Mono<Customer>) =
            customerRepository.create(customer)

    override fun searchCustomers(nameFilter: String) =
            customerRepository.findCustomer(nameFilter)
}