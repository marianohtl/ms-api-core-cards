package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CreateDeckRequest;
import com.mindlessducks.coreflashcard.dto.DeckResponse;
import com.mindlessducks.coreflashcard.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @PostMapping
    public ResponseEntity<DeckResponse> createDeck(@RequestBody CreateDeckRequest request) {
        return ResponseEntity.ok(deckService.createDeck(request));
    }

    @GetMapping("/collection/{collectionId}")
    public ResponseEntity<List<DeckResponse>> getDecksByCollection(@PathVariable UUID collectionId) {
        return ResponseEntity.ok(deckService.getDecksByCollection(collectionId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getDeck(@PathVariable UUID id) {
        deckService.getDeck(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeckResponse> updateDeck(@PathVariable UUID id, @RequestParam String name) {
        return ResponseEntity.ok(deckService.updateDeck(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeck(@PathVariable UUID id) {
        deckService.deleteDeck(id);
        return ResponseEntity.noContent().build();
    }
}
