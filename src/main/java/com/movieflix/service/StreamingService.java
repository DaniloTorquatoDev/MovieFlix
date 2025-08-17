package com.movieflix.service;

import com.movieflix.entity.Streaming;
import com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public Streaming addStreaming(Streaming streaming) {
        return streamingRepository.save(streaming);
    }

    public List<Streaming> listStreaming() {
        return streamingRepository.findAll();
    }

    public Optional<Streaming> ListStreamingById(Long id) {
        return streamingRepository.findById(id);
    }

    public void deleteStreaming(Long id){
       streamingRepository.deleteById(id);
    }
}
