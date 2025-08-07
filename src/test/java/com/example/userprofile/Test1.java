package com.example.userprofile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.userprofile.model.Category;
import com.example.userprofile.repository.CategoryRepository;
import com.example.userprofile.service.MyService;

@ExtendWith(MockitoExtension.class)
public class Test1 {

    @InjectMocks
    private MyService myService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void addCategory_NewCategory_Success() {
        // Arrange
        Category c1 = new Category();
        c1.setCategoryName("food");

        Mockito.when(categoryRepository.findByCategoryName("food")).thenReturn(null);
        Mockito.when(categoryRepository.save(c1)).thenReturn(c1);

        // Act
        Category result = myService.addCategory(c1);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals("food", result.getCategoryName());

        Mockito.verify(categoryRepository).findByCategoryName("food");
        Mockito.verify(categoryRepository).save(c1);
    }

    @Test
    public void addCategory_CategoryAlreadyExists_ThrowsException() {
        // Arrange
        Category existing = new Category();
        existing.setCategoryName("food");

        Mockito.when(categoryRepository.findByCategoryName("food")).thenReturn(existing);

        // Act & Assert
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Category c1 = new Category();
            c1.setCategoryName("food");
            myService.addCategory(c1);
        });

        Assertions.assertEquals("Category exists", exception.getMessage());

        Mockito.verify(categoryRepository).findByCategoryName("food");
        Mockito.verify(categoryRepository, Mockito.never()).save(Mockito.any());
    }
}
