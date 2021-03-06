package spingboot.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spingboot.example.entity.Product;
import spingboot.example.service.ProductService;
import spingboot.example.validation.ProductIDExisting;
import spingboot.example.dto.ResponseDTO;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductApi {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(productService.findAll()).build();

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable @ProductIDExisting Long id) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(productService.findById(id)).build();

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody Product product) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.CREATED.toString())
                .body(productService.save(product)).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody @Valid Product product) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString())
                .body(productService.save(product)).build();

        return ResponseEntity.accepted().body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable @ProductIDExisting Long id) {
        productService.deleteById(id);

        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.ACCEPTED.toString()).build();

        return ResponseEntity.accepted().body(responseDTO);
    }
}