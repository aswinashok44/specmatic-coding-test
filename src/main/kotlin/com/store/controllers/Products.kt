package com.store.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


data class Product(
    val id: Int,
    val name: String,
    val type: String,
    val inventory: Int
)

enum class ProductType {
    GADGET, // Add other types as needed
}


@RestController
class Products {
    @GetMapping("/products")
    fun getProducts(@RequestParam type: ProductType): List<Product> {
        // Sample data, replace with actual data retrieval logic
        val products = listOf(
            Product(1, "XYZ Phone", "gadget", 2),
            Product(2, "ABC Tablet", "gadget", 5)
        )
        return products.filter { it.type.equals(type.name, ignoreCase = true) }
    }
}
