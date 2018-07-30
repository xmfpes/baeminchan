package codesquad.service;

import codesquad.domain.Category;
import codesquad.domain.CategoryRepository;
import codesquad.dto.CategoryDto;
import codesquad.support.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("해당 카테고리를 찾을 수 없습니다."));
    }

    public Category save(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDto.toEntity());
    }

    public List<Category> findByParentIsNull() {
        return categoryRepository.findByParentIsNull().orElseThrow(() -> new CategoryNotFoundException("카테고리를 찾을 수 없습니다."));
    }
}
