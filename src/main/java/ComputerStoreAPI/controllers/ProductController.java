package ComputerStoreAPI.controllers;

import ComputerStoreAPI.dto.*;
import ComputerStoreAPI.services.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final DesktopService desktopService;
    private final HardDriveService hardDriveService;
    private final LaptopService laptopService;
    private final MonitorService monitorService;

    @ApiOperation(value = "Add a new laptop")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added the laptop"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PostMapping("/laptops")
    public ResponseEntity<LaptopDto> addLaptop(@RequestBody LaptopDto laptopDto) {
        LaptopDto addedLaptop = laptopService.addLaptop(laptopDto);
        if (addedLaptop != null) {
            return ResponseEntity.ok(addedLaptop);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Update a laptop by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the laptop"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PutMapping("/laptops/{id}")
    public ResponseEntity<LaptopDto> updateLaptop(@PathVariable Long id, @RequestBody LaptopDto laptopDto) {
        LaptopDto updatedLaptop = laptopService.updateLaptop(id, laptopDto);
        if (updatedLaptop != null) {
            return ResponseEntity.ok(updatedLaptop);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Add a new desktop computer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added the desktop computer"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PostMapping("/desktops")
    public ResponseEntity<DesktopDto> addDesktop(@RequestBody DesktopDto desktopDto) {
        DesktopDto addedDesktop = desktopService.addDesktopComputer(desktopDto);
        if (addedDesktop != null) {
            return ResponseEntity.ok(addedDesktop);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Update a desktop computer by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the desktop computer"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PutMapping("/desktops/{id}")
    public ResponseEntity<DesktopDto> updateDesktop(@PathVariable Long id, @RequestBody DesktopDto desktopDto) {
        DesktopDto updatedDesktop = desktopService.updateDesktopComputer(id, desktopDto);
        if (updatedDesktop != null) {
            return ResponseEntity.ok(updatedDesktop);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Add a new hard drive")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added the hard drive"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PostMapping("/hard-drives")
    public ResponseEntity<HardDriveDto> addHardDrive(@RequestBody HardDriveDto hardDriveDto) {
        HardDriveDto addedHardDrive = hardDriveService.addHardDrive(hardDriveDto);
        if (addedHardDrive != null) {
            return ResponseEntity.ok(addedHardDrive);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Update a hard drive by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the hard drive"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PutMapping("/hard-drives/{id}")
    public ResponseEntity<HardDriveDto> updateHardDrive(@PathVariable Long id, @RequestBody HardDriveDto hardDriveDto) {
        HardDriveDto updatedHardDrive = hardDriveService.updateHardDrive(id, hardDriveDto);
        if (updatedHardDrive != null) {
            return ResponseEntity.ok(updatedHardDrive);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Add a new monitor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added the monitor"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PostMapping("/monitors")
    public ResponseEntity<MonitorDto> addMonitor(@RequestBody MonitorDto monitorDto) {
        MonitorDto addedMonitor = monitorService.addMonitor(monitorDto);
        if (addedMonitor != null) {
            return ResponseEntity.ok(addedMonitor);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Update a monitor by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the monitor"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    @PutMapping("/monitors/{id}")
    public ResponseEntity<MonitorDto> updateMonitor(@PathVariable Long id, @RequestBody MonitorDto monitorDto) {
        MonitorDto updatedMonitor = monitorService.updateMonitor(id, monitorDto);
        if (updatedMonitor != null) {
            return ResponseEntity.ok(updatedMonitor);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Get all products")
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @ApiOperation(value = "Get a product by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the product"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        Optional<ProductDto> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = " ")
    @GetMapping("/type/{type}")
    public ResponseEntity<List<ProductDto>> getProductsByType(@PathVariable String type) {
        List<ProductDto> products = productService.getProductsByType(type);
        return ResponseEntity.ok(products);
    }

    @ApiOperation(value = "Delete a product by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the product"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
