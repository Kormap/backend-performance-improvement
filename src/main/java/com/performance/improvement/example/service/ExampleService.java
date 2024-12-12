package com.performance.improvement.example.service;

import com.performance.improvement.example.model.dto.ExampleUpdateRequest;
import com.performance.improvement.example.model.entity.Example;
import com.performance.improvement.example.model.dto.ExampleCreateRequest;
import com.performance.improvement.example.model.dto.ExampleDetailResponse;
import com.performance.improvement.example.repository.ExampleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;

    @Transactional
    public String createExample(ExampleCreateRequest request) {
        String exampleTile = request.getExampleTitle();
        String exampleContent = request.getExampleContent();

        // 요청을 Entity 로 변환
        Example example = request.toEntity(exampleTile, exampleContent);
        exampleRepository.save(example);

        return example.getExampleId().toString();
    }

    public ExampleDetailResponse findExampleById(UUID exampleId) {
        Example example = exampleRepository.findById(exampleId)
                .orElseThrow(() -> new RuntimeException("Example id: " + exampleId + " not found"));

        // Entity 를 응답 DTO로 변환
        return example.toDetailResponse();
    }

    public List<ExampleDetailResponse> findExampleList() {
        List<Example> examples = exampleRepository.findAll();
        List<ExampleDetailResponse> exampleDetailResponses
                = examples.stream()
                .map(Example::toDetailResponse) //Example 엔티티 내의 toDetailResponse 메소드 참조
                .collect(Collectors.toList());

        return exampleDetailResponses;
    }

    public List<ExampleDetailResponse> findExampleByTitle(String exampleTitle) {
        List<Example> examples = exampleRepository.findExamplesByTitle(exampleTitle);
        List<ExampleDetailResponse> exampleDetailResponses
                = examples.stream()
                .map(Example::toDetailResponse) //Example 엔티티 내의 toDetailResponse 메소드 참조
                .collect(Collectors.toList());

        return exampleDetailResponses;
    }

    @Transactional
    public String updateExample(ExampleUpdateRequest request) {
        Example example = exampleRepository.findById(request.getExampleId())
                .orElseThrow(() -> new RuntimeException("Example id: " + request.getExampleId() + " not found"));

        example.updateExample(request);
        return example.getExampleId().toString();
    }

}
