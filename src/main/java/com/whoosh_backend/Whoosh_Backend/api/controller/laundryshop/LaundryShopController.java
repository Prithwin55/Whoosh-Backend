package com.whoosh_backend.Whoosh_Backend.api.controller.laundryshop;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopCatagoryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.service.LaundryShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laundry-shops")
public class LaundryShopController {

    @Autowired
    private LaundryShopService laundryShopService;

    @GetMapping
    public List<LaundryShopResponse> getAllLaundryShops() {
        return laundryShopService.getAllLaundryShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaundryShopResponse> getLaundryShopById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(laundryShopService.getLaundryShopById(id));
    }

    @PostMapping
    public ResponseEntity<LaundryShopResponse> createLaundryShop(@RequestBody LaundryShopDto laundryShopDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(laundryShopService.createLaundryShop(laundryShopDto));
    }
    @PostMapping("/{laundryShopId}/service-categories")
    public ResponseEntity<LaundryShopResponse> upsertServiceCategory(@PathVariable Long laundryShopId, @RequestBody ServiceCategoryDto serviceCategoryDto) throws ResourceNotFoundException {

            LaundryShopResponse laundryShopResponse=laundryShopService.updateServiceCategory(laundryShopId, serviceCategoryDto);
            return ResponseEntity.ok(laundryShopResponse);

    }
    @PutMapping("/{id}")
    public ResponseEntity<LaundryShopResponse> updateLaundryShop(@PathVariable Long id, @RequestBody LaundryShopDto laundryShopDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(laundryShopService.updateLaundryShop(id, laundryShopDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaundryShop(@PathVariable Long id) {
        laundryShopService.deleteLaundryShop(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/getAllByServiceCatagory")
    public ResponseEntity<List<LaundryShopBasicDto>> getAllLaundryShopsByServiceCategory(@RequestBody LaundryShopCatagoryDto laundryShopCatagoryDto) {
        return ResponseEntity.ok(laundryShopService.getAllLaundryShopByServiceType(laundryShopCatagoryDto));
    }
    @GetMapping("/getItemsByShopIdandServiceType/{shopId}")
    public ResponseEntity<List<ItemDto>> getItemsByShopIdandServiceType(@PathVariable Long shopId, @RequestBody LaundryShopCatagoryDto laundryShopCatagoryDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(laundryShopService.getItemsByShopIdandServiceType(shopId, laundryShopCatagoryDto));
    }
}