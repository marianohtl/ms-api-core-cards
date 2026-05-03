package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CreateDeckRequest;
import com.mindlessducks.coreflashcard.dto.DeckResponse;
import com.mindlessducks.coreflashcard.entities.Deck;
import com.mindlessducks.coreflashcard.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/deck")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @PostMapping
    public ResponseEntity<DeckResponse> create(@RequestBody CreateDeckRequest request) {
        return ResponseEntity.ok(deckService.createDeck(request));
    }

    @GetMapping("/collection/{collectionId}")
    public ResponseEntity<List<DeckResponse>> getByCollection(@PathVariable UUID collectionId) {
        return ResponseEntity.ok(deckService.getDecksByCollection(collectionId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(deckService.getDeck(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeckResponse> update(@PathVariable UUID id, @RequestBody String name) {
        return ResponseEntity.ok(deckService.updateDeck(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deckService.deleteDeck(id);
        return ResponseEntity.noContent().build();
    }
}
