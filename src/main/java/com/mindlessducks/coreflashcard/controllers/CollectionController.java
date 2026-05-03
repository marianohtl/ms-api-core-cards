package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CollectionDetailResponse;
import com.mindlessducks.coreflashcard.dto.CollectionResponse;
import com.mindlessducks.coreflashcard.dto.CreateCollectionRequest;
import com.mindlessducks.coreflashcard.services.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @PostMapping
    public ResponseEntity<CollectionResponse> createCollection(@RequestBody CreateCollectionRequest request) {
        return ResponseEntity.ok(collectionService.createCollection(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CollectionResponse>> getCollectionsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(collectionService.getCollectionsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionDetailResponse> getCollection(@PathVariable UUID id) {
        return ResponseEntity.ok(collectionService.getCollection(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CollectionResponse> updateCollection(@PathVariable UUID id, @RequestParam String name) {
        return ResponseEntity.ok(collectionService.updateCollection(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable UUID id) {
        collectionService.deleteCollection(id);
        return ResponseEntity.noContent().build();
    }
}
