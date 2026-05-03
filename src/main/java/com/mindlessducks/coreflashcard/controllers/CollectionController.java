package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CollectionResponse;
import com.mindlessducks.coreflashcard.dto.CreateCollectionRequest;
import com.mindlessducks.coreflashcard.entities.Collection;
import com.mindlessducks.coreflashcard.services.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/collection")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @PostMapping
    public ResponseEntity<CollectionResponse> create(@RequestBody CreateCollectionRequest request) {
        return ResponseEntity.ok(collectionService.createCollection(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CollectionResponse>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(collectionService.getCollectionsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(collectionService.getCollection(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionResponse> update(@PathVariable UUID id, @RequestBody String name) {
        // Note: Simple implementation, normally name would be in a DTO
        return ResponseEntity.ok(collectionService.updateCollection(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        collectionService.deleteCollection(id);
        return ResponseEntity.noContent().build();
    }
}
