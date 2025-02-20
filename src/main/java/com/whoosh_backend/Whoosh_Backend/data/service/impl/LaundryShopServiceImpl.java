package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopCatagoryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.ItemMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.LaundryShopMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.OrderMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.ServiceCategoryMapper;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.ItemRepository;
import com.whoosh_backend.Whoosh_Backend.data.repository.LaundryShopRepository;
import com.whoosh_backend.Whoosh_Backend.data.repository.ServiceCategoryRepository;
import com.whoosh_backend.Whoosh_Backend.data.repository.UserRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.LaundryShopService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class LaundryShopServiceImpl implements LaundryShopService {

    @Autowired
    private LaundryShopRepository laundryShopRepository;
    private UserRepository userRepository;
    private ServiceCategoryRepository serviceCategoryRepository;
    private ItemRepository itemRepository;

    @Override
    public List<LaundryShopResponse> getAllLaundryShops() {
        return laundryShopRepository.findAll().stream()
                .map(LaundryShopMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LaundryShopResponse getLaundryShopById(Long id) throws ResourceNotFoundException {
        return laundryShopRepository.findById(id)
                .map(LaundryShopMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("LaundryShop not found"));
    }

    @Override
    public LaundryShopResponse createLaundryShop(LaundryShopDto laundryShopDto) throws ResourceNotFoundException {
        User user = userRepository.findById(laundryShopDto.getOwner().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found For Owner"));
        // check if the user has role LAUNDRY_SHOP
        if (!(user.getRole() == Role.LAUNDRY_SHOP)) {
            throw new ResourceNotFoundException("User is not a Laundry Shop Owner");
        }
        LaundryShop laundryShop = LaundryShopMapper.INSTANCE.toEntity(laundryShopDto);
        laundryShop.setOwner(user);
        laundryShop = laundryShopRepository.save(laundryShop);
        return LaundryShopMapper.INSTANCE.toResponse(laundryShop);
    }

    @Override
    public LaundryShopResponse updateLaundryShop(Long id, LaundryShopDto laundryShopDto) throws ResourceNotFoundException {
        LaundryShop existingLaundryShop = laundryShopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LaundryShop not found"));
        if (laundryShopDto.getStatus() != null) {
            existingLaundryShop.setStatus(laundryShopDto.getStatus());
        }
        if (laundryShopDto.getShopName() != null) {
            existingLaundryShop.setShopName(laundryShopDto.getShopName());
        }
        if (laundryShopDto.getAddress() != null) {
            existingLaundryShop.setAddress(laundryShopDto.getAddress());
        }
        if (laundryShopDto.getLocation() != null) {
            existingLaundryShop.setLocation(laundryShopDto.getLocation());
        }
        if (laundryShopDto.getOwner() != null) {
            User user = userRepository.findById(laundryShopDto.getOwner().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found For Owner"));
            existingLaundryShop.setOwner(user);
        }
        if (laundryShopDto.getOrders() != null) {
            existingLaundryShop.setOrders(laundryShopDto.getOrders().stream()
                    .map(OrderMapper.INSTANCE::toEntity)
                    .collect(Collectors.toList()));
        }
        //LaundryShopMapper.INSTANCE.updateEntityFromDto(laundryShopDto, existingLaundryShop);
        existingLaundryShop = laundryShopRepository.save(existingLaundryShop);
        return LaundryShopMapper.INSTANCE.toResponse(existingLaundryShop);
    }

    @Override
    public LaundryShopResponse updateServiceCategory(Long laundryShopId, ServiceCategoryDto serviceCategoryDto) throws ResourceNotFoundException {
        LaundryShop laundryShop = laundryShopRepository.findById(laundryShopId)
                .orElseThrow(() -> new ResourceNotFoundException("LaundryShop not found"));

        ServiceCategory serviceCategory = serviceCategoryRepository.findByLaundryShopAndServiceType(laundryShop, serviceCategoryDto.getServiceType())
                .orElseGet(() -> {
                    ServiceCategory newServiceCategory = ServiceCategoryMapper.INSTANCE.toEntity(serviceCategoryDto);
                    newServiceCategory.setLaundryShop(laundryShop);
                    return newServiceCategory;
                });

        List<Item> items = serviceCategoryDto.getItems().stream()
                .map(itemDto -> {
                    Item item = new Item();
                    item.setPrice(itemDto.getPrice());
                    item.setItemName(itemDto.getItemName());
                    item.setServiceCategory(serviceCategory);
                    return item;
                })
                .collect(Collectors.toList());


        //checking if same items exist or not
        for (Item newItem : items) {
            for (Item existingItem : serviceCategory.getItems()) {
                if (existingItem.getItemName().equals(newItem.getItemName())) {
                    throw new IllegalArgumentException("Item with name " + newItem.getItemName() + " already exists in this service category.");
                }
            }
        }
        serviceCategory.getItems().addAll(items);
        serviceCategoryRepository.save(serviceCategory);

        return LaundryShopMapper.INSTANCE.toResponse(laundryShop);
    }

    @Override
    public void deleteLaundryShop(Long id) {
        laundryShopRepository.deleteById(id);
    }

    @Override
    public List<LaundryShopBasicDto> getAllLaundryShopByServiceType(LaundryShopCatagoryDto laundryShopCatagoryDto) {
        List<LaundryShopBasicDto> laundryShops = serviceCategoryRepository.findAllByServiceType(laundryShopCatagoryDto.getServiceType())
                .stream()
                .map(e -> e.getLaundryShop()).
                map(LaundryShopMapper.INSTANCE::toBasicDto)
                .collect(Collectors.toList());
        return laundryShops;
    }

    @Override
    public List<ItemDto> getItemsByShopIdandServiceType(Long shopId, LaundryShopCatagoryDto laundryShopCatagoryDto) throws ResourceNotFoundException {
        List<ItemDto> items = serviceCategoryRepository.findAllByLaundryShopIdAndServiceType(shopId, laundryShopCatagoryDto.getServiceType())
                .stream()
                .flatMap(serviceCategory -> serviceCategory.getItems().stream())  // Flatten List<List<Item>>
                .map(ItemMapper.INSTANCE::toItemDto)  // Convert to DTO
                .collect(Collectors.toList());

        if (items.isEmpty()) {
            throw new ResourceNotFoundException("Items not found");
        }

        return items;
    }
}
