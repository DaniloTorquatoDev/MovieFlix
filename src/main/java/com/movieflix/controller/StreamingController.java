package com.movieflix.controller;

import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.StreamingResponse;
import com.movieflix.entity.Streaming;
import com.movieflix.mapper.StreamingMapper;
import com.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;

    @PostMapping
    public ResponseEntity<StreamingResponse> addStreaming (@RequestBody StreamingRequest streamingRequest) {
        Streaming newStreaming = StreamingMapper.toStreaming(streamingRequest);
        Streaming savedStreaming = streamingService.addStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStremingResponse(savedStreaming));
    }

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> listStreaming() {
        List<StreamingResponse> streaming = streamingService.listStreaming()
                .stream()
                .map(StreamingMapper::toStremingResponse)
                .toList();
        return ResponseEntity.ok(streaming);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> listStreamingById(@PathVariable Long id) {
        return streamingService.ListStreamingById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStremingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        streamingService.deleteStreaming(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
